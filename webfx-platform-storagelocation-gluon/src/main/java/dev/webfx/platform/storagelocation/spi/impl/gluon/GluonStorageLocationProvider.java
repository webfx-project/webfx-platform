package dev.webfx.platform.storagelocation.spi.impl.gluon;

import com.gluonhq.attach.storage.StorageService;
import com.gluonhq.attach.util.Services;
import dev.webfx.platform.storagelocation.spi.StorageLocationProvider;

/**
 * @author Bruno Salmon
 */
public class GluonStorageLocationProvider implements StorageLocationProvider {

    public String appInternalStoragePath;

    @Override
    public String getInternalStorageLocation() {
        if (appInternalStoragePath == null)
            appInternalStoragePath = Services.get(StorageService.class)
                    .flatMap(StorageService::getPrivateStorage)
                    .orElseThrow(() -> new IllegalStateException("Could not access private storage."))
                    .getAbsolutePath();
        return appInternalStoragePath;
    }

}
