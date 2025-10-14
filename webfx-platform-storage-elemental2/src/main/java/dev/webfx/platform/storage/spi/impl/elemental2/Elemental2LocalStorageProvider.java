package dev.webfx.platform.storage.spi.impl.elemental2;


import dev.webfx.platform.storage.spi.LocalStorageProvider;
import elemental2.dom.DomGlobal;
import elemental2.webstorage.WebStorageWindow;


/**
 * @author Bruno Salmon
 */
public final class Elemental2LocalStorageProvider extends Elemental2StorageProvider implements LocalStorageProvider {

    public Elemental2LocalStorageProvider() {
        super(WebStorageWindow.of(DomGlobal.window).localStorage);
    }
}
