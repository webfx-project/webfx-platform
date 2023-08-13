package dev.webfx.platform.console;

import dev.webfx.platform.console.spi.ConsoleProvider;
import dev.webfx.platform.util.serviceloader.SingleServiceProvider;

import java.util.ServiceLoader;

/**
 * @author Bruno Salmon
 */
public final class Console {

    private Console() {}

    private static ConsoleProvider getProvider() {
        return SingleServiceProvider.getProvider(ConsoleProvider.class, () -> ServiceLoader.load(ConsoleProvider.class));
    }

    public static void log(Object message) {
        getProvider().log(message);
    }

    public static void log(String message) {
        getProvider().log(message);
    }

    public static void log(String message, Throwable error) {
        getProvider().log(message, error);
    }

    public static void logNative(Object nativeObject) {
        getProvider().logNative(nativeObject);
    }

    public static String captureStackTrace(Throwable exception) {
/* Not GWT compatible
        StringWriter sw = new StringWriter();
        exception.printStackTrace(new PrintWriter(sw));
        return sw.toString();
*/
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement element : exception.getStackTrace())
            sb.append(sb.length() == 0 ? "" : "\n").append("    ").append(element);
        return sb.toString();
    }
}
