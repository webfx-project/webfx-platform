package dev.webfx.platform.storage.spi.impl.gwt;

import com.google.gwt.storage.client.Storage;
import dev.webfx.platform.storage.spi.SessionStorageProvider;


/**
 * @author Bruno Salmon
 */
public final class GwtSessionStorageProvider extends GwtStorageProvider implements SessionStorageProvider {

    public GwtSessionStorageProvider() {
        super(Storage.getSessionStorageIfSupported());
    }
}
