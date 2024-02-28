package dev.webfx.platform.storage.spi.impl.gwtj2cl;

import dev.webfx.platform.storage.spi.SessionStorageProvider;
import elemental2.dom.DomGlobal;
import elemental2.webstorage.WebStorageWindow;


/**
 * @author Bruno Salmon
 */
public final class GwtJ2clSessionStorageProvider extends GwtJ2clStorageProvider implements SessionStorageProvider {

    public GwtJ2clSessionStorageProvider() {
        super(WebStorageWindow.of(DomGlobal.window).sessionStorage);
    }
}
