package dev.webfx.platform.console.spi.impl.java;

import dev.webfx.platform.console.spi.ConsoleProvider;

/**
 * @author Bruno Salmon
 */
public class JavaConsoleProvider implements ConsoleProvider {

/*
    private static ExecutorService threadPool = Executors.newSingleThreadExecutor();

    @Override
    public void log(String message, Throwable error) {
        threadPool.submit(() -> {
            if (message != null)
                System.out.println(message);
            if (error != null)
                error.printStackTrace(System.err);
        });
    }
*/
}
