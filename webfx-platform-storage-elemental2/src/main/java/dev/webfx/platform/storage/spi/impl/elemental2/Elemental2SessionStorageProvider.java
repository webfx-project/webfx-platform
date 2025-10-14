package dev.webfx.platform.storage.spi.impl.elemental2;

import dev.webfx.platform.storage.spi.SessionStorageProvider;
import elemental2.dom.DomGlobal;
import elemental2.webstorage.WebStorageWindow;


/**
 * @author Bruno Salmon
 */
public final class Elemental2SessionStorageProvider extends Elemental2StorageProvider implements SessionStorageProvider {

    public Elemental2SessionStorageProvider() {
        super(WebStorageWindow.of(DomGlobal.window).sessionStorage);
    }
}
