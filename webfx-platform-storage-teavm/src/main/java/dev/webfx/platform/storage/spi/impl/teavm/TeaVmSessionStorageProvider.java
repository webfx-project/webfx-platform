package dev.webfx.platform.storage.spi.impl.teavm;

import dev.webfx.platform.storage.spi.SessionStorageProvider;
import org.teavm.jso.browser.Window;

/**
 * @author Bruno Salmon
 */
public final class TeaVmSessionStorageProvider extends TeaVmStorageProvider implements SessionStorageProvider {

    public TeaVmSessionStorageProvider() {
        super(Window.current().getSessionStorage());
    }
}