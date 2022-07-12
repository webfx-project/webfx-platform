package dev.webfx.platform.storage.spi.impl.gwt;

import com.google.gwt.storage.client.Storage;
import dev.webfx.platform.storage.spi.LocalStorageProvider;


/**
 * @author Bruno Salmon
 */
public final class GwtLocalStorageProvider extends GwtStorageProvider implements LocalStorageProvider {

    public GwtLocalStorageProvider() {
        super(Storage.getLocalStorageIfSupported());
    }
}
