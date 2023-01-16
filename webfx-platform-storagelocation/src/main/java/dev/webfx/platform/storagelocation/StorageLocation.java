package dev.webfx.platform.storagelocation;

import dev.webfx.platform.storagelocation.spi.StorageLocationProvider;
import dev.webfx.platform.util.serviceloader.SingleServiceProvider;

import java.util.ServiceLoader;

/**
 * @author Bruno Salmon
 */
public final class StorageLocation {

    private static StorageLocationProvider getProvider() {
        return SingleServiceProvider.getProvider(StorageLocationProvider.class, () -> ServiceLoader.load(StorageLocationProvider.class));
    }

    public static String getInternalStorageLocation() {
        return getProvider().getInternalStorageLocation();
    }

}