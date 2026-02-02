package dev.webfx.platform.console.spi;

/**
 * @author Bruno Salmon
 */
public interface ConsoleProvider {

    default void log(String message) {
        System.out.println(message);
    }

    default void error(String message) {
        error(message, null);
    }

    default void error(Throwable error) {
        error(null, error);
    }

    default void error(String message, Throwable error) {
        if (message != null)
            System.err.println("⛔️ " + message);
        if (error != null)
            error.printStackTrace(System.err);
    }

    default void logNative(Object nativeObject) {
        System.out.println(nativeObject);
    }

    default void info(String message) {
        log("[INFO] " + message);
    }

    default void debug(String message) {
        log("[DEBUG] " + message);
    }

    default void warn(String message) {
        log("[WARN] ⚠️ " + message);
    }

}
