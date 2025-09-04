package dev.webfx.platform.storage.spi.impl.teavm;

import dev.webfx.platform.storage.spi.LocalStorageProvider;
import org.teavm.jso.browser.Window;

/**
 * @author Bruno Salmon
 */
public final class TeaVmLocalStorageProvider extends TeaVmStorageProvider implements LocalStorageProvider {

    public TeaVmLocalStorageProvider() {
        super(Window.current().getLocalStorage());
    }
}