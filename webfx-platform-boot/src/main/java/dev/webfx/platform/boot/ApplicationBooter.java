package dev.webfx.platform.boot;

import dev.webfx.platform.boot.spi.ApplicationBooterProvider;
import dev.webfx.platform.boot.spi.ApplicationJob;
import dev.webfx.platform.service.SingleServiceProvider;

import java.util.ServiceLoader;

/**
 * @author Bruno Salmon
 */
public final class ApplicationBooter {

    private static ApplicationBooterProvider getProvider() {
        return SingleServiceProvider.getProvider(ApplicationBooterProvider.class, () -> ServiceLoader.load(ApplicationBooterProvider.class));
    }

    public static void startApplicationJob(ApplicationJob applicationJob) {
        getProvider().startApplicationJob(applicationJob);
    }

    public static void stopApplicationJob(ApplicationJob applicationJob) {
        getProvider().stopApplicationJob(applicationJob);
    }

    private static String[] mainArgs;

    public static String[] getMainArgs() {
        return mainArgs;
    }

    public static void start(ApplicationBooterProvider provider, String[] mainArgs) {
        // Caching this instance to make the ApplicationBooter work
        SingleServiceProvider.registerServiceProvider(ApplicationBooterProvider.class, provider);
        start(mainArgs);
    }

    public static void start(String[] mainArgs) {
        ApplicationBooter.mainArgs = mainArgs;
        getProvider().boot();
    }

    public static void main(String[] args) {
        start(mainArgs);
    }
}
