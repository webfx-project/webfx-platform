package dev.webfx.platform.console.spi.impl.elemental2;

import dev.webfx.platform.console.spi.ConsoleProvider;
import elemental2.dom.DomGlobal;

/**
 * @author Bruno Salmon
 */
public class E2ConsoleProvider implements ConsoleProvider {

    @Override
    public void log(String message, Throwable throwable) {
        if (message != null)
            logConsole(message);
        if (throwable != null)
            logConsole(throwable);
    }

    @Override
    public void logNative(Object nativeObject) {
        logConsole(nativeObject);
    }

    private static void logConsole(Object message) {
        DomGlobal.console.log(message);
    }

}
