package dev.webfx.platform.console.spi.impl.elemental2;

import dev.webfx.platform.console.spi.ConsoleProvider;
import elemental2.dom.DomGlobal;

/**
 * @author Bruno Salmon
 */
public class Elemental2ConsoleProvider implements ConsoleProvider {

    @Override
    public void log(String message) {
        logNative(message);
    }

    @Override
    public void error(String message, Throwable throwable) {
        if (message != null)
            error(message);
        if (throwable != null)
            DomGlobal.console.trace(throwable);
    }

    @Override
    public void logNative(Object nativeObject) {
        DomGlobal.console.log(nativeObject);
    }

    @Override
    public void info(String message) {
        DomGlobal.console.info(message);
    }

    @Override
    public void debug(String message) {
        DomGlobal.console.debug(message);
    }

    @Override
    public void warn(String message) {
        DomGlobal.console.warn(message);
    }

    @Override
    public void error(String message) {
        DomGlobal.console.error(message);
    }

}
