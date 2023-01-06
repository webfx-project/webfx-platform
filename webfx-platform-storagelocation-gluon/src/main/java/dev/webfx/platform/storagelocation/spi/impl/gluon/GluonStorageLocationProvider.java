package dev.webfx.platform.storagelocation.spi.impl.gluon;

import com.gluonhq.attach.storage.StorageService;
import dev.webfx.platform.storagelocation.spi.StorageLocationProvider;

/**
 * @author Bruno Salmon
 */
public final class GluonStorageLocationProvider implements StorageLocationProvider {

    public String appInternalStoragePath;

    @Override
    public String getInternalStorageLocation() {
        if (appInternalStoragePath == null)
            appInternalStoragePath = StorageService.create()
                    .flatMap(StorageService::getPrivateStorage)
                    .orElseThrow(() -> new IllegalStateException("Could not get Gluon private storage."))
                    .getAbsolutePath();
        return appInternalStoragePath;
    }

}
