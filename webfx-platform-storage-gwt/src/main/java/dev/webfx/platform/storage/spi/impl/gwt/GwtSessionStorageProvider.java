package dev.webfx.platform.storage.spi.impl.gwt;

import dev.webfx.platform.storage.spi.SessionStorageProvider;
import elemental2.dom.DomGlobal;
import elemental2.webstorage.WebStorageWindow;


/**
 * @author Bruno Salmon
 */
public final class GwtSessionStorageProvider extends GwtStorageProvider implements SessionStorageProvider {

    public GwtSessionStorageProvider() {
        super(WebStorageWindow.of(DomGlobal.window).sessionStorage);
    }
}
