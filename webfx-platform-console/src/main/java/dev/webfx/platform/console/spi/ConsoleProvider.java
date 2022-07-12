package dev.webfx.platform.console.spi;

import java.io.PrintStream;

/**
 * @author Bruno Salmon
 */
public interface ConsoleProvider {

    default void log(Object message) {
        if (message instanceof Throwable)
            log(null, (Throwable) message);
        else
            log(message == null ? "null" : message.toString());
    }

    default void log(String message) {
        log(message, null);
    }

    default void log(String message, Throwable error) {
        PrintStream printStream = error == null ? System.out : System.err;
        if (message != null)
            printStream.println(message);
        if (error != null)
            error.printStackTrace(printStream);
    }

    default void logNative(Object nativeObject) {
        System.out.println(nativeObject);
    }

}
