package dev.webfx.platform.boot.spi.impl.vertx;

import dev.webfx.platform.boot.ApplicationBooter;
import dev.webfx.platform.boot.spi.ApplicationBooterProvider;
import dev.webfx.platform.reflect.RArray;
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

    @Override
    public void boot() { // Entry point 1) called from the main Java application thread
        // Starting this verticle. This will create a second instance of this class and call entry point 2, i.e., start()
        VertxRunner.runVerticle(VertxApplicationBooterVerticle.class); // Uncomment to avoid trace when debugging: , new VertxOptions().setBlockedThreadCheckInterval(9999999999L));
    }

    @Override
    public void start() { // Entry point 2) called from the main event loop thread
        // Passing vertx to the VertxInstance for further use by other modules
        VertxInstance.setVertx(vertx);
        // Executing the default application boot (now that vertx is set and that we are in the event loop thread)
        ApplicationBooterProvider.defaultBoot(); // boot modules and set up the shutdown hook
    }

    @Override
    public void stop() {
        VertxInstance.getVertx().close();
    }

    public static void main(String[] args) {
        ApplicationBooter.main(args);
    }
}
