package dev.webfx.platform.storage.spi.impl.gwt;


import dev.webfx.platform.storage.spi.LocalStorageProvider;
import elemental2.dom.DomGlobal;
import elemental2.webstorage.WebStorageWindow;


/**
 * @author Bruno Salmon
 */
public final class GwtLocalStorageProvider extends GwtStorageProvider implements LocalStorageProvider {

    public GwtLocalStorageProvider() {
        super(WebStorageWindow.of(DomGlobal.window).localStorage);
    }
}
