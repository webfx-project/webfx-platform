package dev.webfx.platform.storage.spi.impl.gwtj2cl;


import dev.webfx.platform.storage.spi.LocalStorageProvider;
import elemental2.dom.DomGlobal;
import elemental2.webstorage.WebStorageWindow;


/**
 * @author Bruno Salmon
 */
public final class GwtJ2clLocalStorageProvider extends GwtJ2clStorageProvider implements LocalStorageProvider {

    public GwtJ2clLocalStorageProvider() {
        super(WebStorageWindow.of(DomGlobal.window).localStorage);
    }
}
