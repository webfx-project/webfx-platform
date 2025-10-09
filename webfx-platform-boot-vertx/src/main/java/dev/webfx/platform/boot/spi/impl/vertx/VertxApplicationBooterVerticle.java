package dev.webfx.platform.boot.spi.impl.vertx;

import dev.webfx.platform.boot.ApplicationBooter;
import dev.webfx.platform.boot.spi.ApplicationBooterProvider;
import dev.webfx.platform.boot.spi.impl.ApplicationModuleBooterManager;
import dev.webfx.platform.reflect.RArray;
import dev.webfx.platform.shutdown.Shutdown;
import dev.webfx.platform.util.vertx.VertxInstance;
import io.vertx.core.AbstractVerticle;

import java.lang.reflect.Array;

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

    private boolean entryPoint1;

    @Override
    public void boot() { // Entry point 1) called from the main Java application thread
        entryPoint1 = true;
        // What to do on shutdown (in addition to entry point 2):
        Shutdown.addShutdownHook(e -> {
            // Undeploy all verticles
            for (String deploymentId : VertxInstance.getVertx().deploymentIDs())
                VertxInstance.getVertx().undeploy(deploymentId);
        });
        // Starting this verticle. This will create a second instance of this class and call entry point 2.
        VertxRunner.runVerticle(VertxApplicationBooterVerticle.class); // Uncomment to avoid trace when debugging: , new VertxOptions().setBlockedThreadCheckInterval(9999999999L));
    }

    @Override
    public void start() { // Entry point 2) called from the main event loop thread
        // Passing vertx to the VertxInstance for further use by other modules
        VertxInstance.setVertx(vertx);
        // Asking the ApplicationModuleBooterManager to initialize all the modules
        ApplicationModuleBooterManager.initialize();
        // What to do on shutdown:
        Shutdown.addShutdownHook(e -> {
            // Asking the ApplicationModuleBooterManager to shut down all the modules
            ApplicationModuleBooterManager.shutdown();
            // Closing the vertx instance
            VertxInstance.getVertx().close();
        });
    }

    @Override
    public void stop() {
        if (entryPoint1 && !Shutdown.isShuttingDown())
            Shutdown.suspend();
    }

    public static void main(String[] args) {
        ApplicationBooter.main(args);
    }
}
