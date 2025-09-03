package dev.webfx.platform.boot.spi.impl.vertx;

import dev.webfx.platform.boot.ApplicationBooter;
import dev.webfx.platform.boot.spi.ApplicationBooterProvider;
import dev.webfx.platform.boot.spi.ApplicationJob;
import dev.webfx.platform.boot.spi.impl.ApplicationModuleBooterManager;
import dev.webfx.platform.reflect.RArray;
import dev.webfx.platform.shutdown.Shutdown;
import dev.webfx.platform.util.vertx.VertxInstance;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Context;
import io.vertx.core.Vertx;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

/**
 * There are 2 possible entry points:
 *   1) one initiated by the ApplicationBooter (eventually through the main() method of this class)
 *   2) one initiated by Vertx when deploying this verticle
 *
 *   In case 1), the verticle is not yet deployed, so the container needs to deploy it (the container will actually create a second instance of this class)
 *   In case 2), the verticle is deployed, but the container is not started
 *
 * @author Bruno Salmon
 */
public final class VertxApplicationBooterVerticle extends AbstractVerticle implements ApplicationBooterProvider {

    static {
        RArray.injectJavaArrayNewInstanceMethod(Array::newInstance);
    }

    private static VertxApplicationBooterVerticle containerInstance;
    private static VertxApplicationBooterVerticle verticleInstance;

    private final Collection<ApplicationJobVerticle> applicationJobVerticles = new ArrayList<>();

    @Override
    public void boot() { // Entry point 1)
        containerInstance = this;
        if (verticleInstance == null)
            VertxRunner.runVerticle(VertxApplicationBooterVerticle.class); // Uncomment to avoid trace when debugging: , new VertxOptions().setBlockedThreadCheckInterval(9999999999L));
        ApplicationModuleBooterManager.initialize();
        Shutdown.addShutdownHook(e -> {
            for (String deploymentId : VertxInstance.getVertx().deploymentIDs())
                VertxInstance.getVertx().undeploy(deploymentId);
            ApplicationModuleBooterManager.shutdown();
            VertxInstance.getVertx().close();
        });
    }

    @Override
    public void start() { // Entry point 2)
        // Passing vertx to the VertxInstance for further use by other modules
        VertxInstance.setVertx(vertx);
        verticleInstance = this;
        if (containerInstance == null)
            ApplicationBooter.main(null);
    }

    @Override
    public void stop() {
        if (this == containerInstance && !Shutdown.isShuttingDown())
            Shutdown.suspend();
    }

    @Override
    public void initApplicationJob(ApplicationJob applicationJob) {
        // Nothing to do as the onBoot() method will be called during Verticle.init() when starting the application job
    }

    @Override
    public void startApplicationJob(ApplicationJob applicationJob) {
        ApplicationJobVerticle applicationJobVerticle = new ApplicationJobVerticle(applicationJob);
        applicationJobVerticles.add(applicationJobVerticle);
        VertxInstance.getVertx().deployVerticle(applicationJobVerticle)
            .onComplete(ar -> applicationJobVerticle.deploymentId = ar.result());
    }

    @Override
    public void stopApplicationJob(ApplicationJob applicationJob) {
        applicationJobVerticles.stream()
                .filter(v -> v.applicationJob == applicationJob)
                .findFirst()
                .ifPresent(v -> VertxInstance.getVertx().undeploy(v.deploymentId));
    }

    private static final class ApplicationJobVerticle extends AbstractVerticle {

        private final ApplicationJob applicationJob;
        private String deploymentId;

        public ApplicationJobVerticle(ApplicationJob applicationJob) {
            this.applicationJob = applicationJob;
        }

        @Override
        public void init(Vertx vertx, Context context) {
            super.init(vertx, context);
            applicationJob.onInit();
        }

        @Override
        public void start(io.vertx.core.Promise<Void> startPromise) throws Exception {
            applicationJob.onStart();
            super.start(startPromise);
        }

        @Override
        public void stop(io.vertx.core.Promise<Void> stopPromise) throws Exception {
            applicationJob.onStop();
            super.stop(stopPromise);
        }

    }

    public static void main(String[] args) {
        ApplicationBooter.main(args);
    }
}
