package dev.webfx.platform.storagelocation.spi.impl.jre;

import dev.webfx.platform.meta.Meta;
import dev.webfx.platform.storagelocation.spi.StorageLocationProvider;

import java.io.File;

/**
 * @author Bruno Salmon
 */
public class JreStorageLocationProvider implements StorageLocationProvider {

    public String appInternalStoragePath;

    @Override
    public String getInternalStorageLocation() {
        if (appInternalStoragePath == null)
            appInternalStoragePath = getDesktopInternalStorageDirectory().getAbsolutePath();
        return appInternalStoragePath;
    }

    private static File getDesktopInternalStorageDirectory() {
        File file = new File(System.getProperty("user.home") + "/.webfx/apps/" + getAppName() + "/internalStorage");
        file.mkdirs();
        return file;
    }

    private static String getAppName() {
        String name = Meta.getApplicationModuleName();
        return name != null ? name : "Unknown";
    }

}
