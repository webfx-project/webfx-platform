package dev.webfx.platform.storagelocation.spi.impl.java;

import com.gluonhq.attach.storage.StorageService;
import com.gluonhq.attach.util.Services;
import dev.webfx.platform.storagelocation.spi.StorageLocationProvider;
import dev.webfx.platform.util.serviceloader.SingleServiceProvider;
import javafx.application.Application;

import java.io.File;
import java.util.ServiceLoader;

/**
 * @author Bruno Salmon
 */
public class JavaStorageLocationProvider implements StorageLocationProvider {

    public String appInternalStoragePath;

    @Override
    public String getInternalStorageLocation() {
        if (appInternalStoragePath == null)
            appInternalStoragePath = Services.get(StorageService.class)
                    .flatMap(StorageService::getPrivateStorage)
                    .orElseGet(JavaStorageLocationProvider::getDesktopInternalStorageDirectory)
                    .getAbsolutePath();
        return appInternalStoragePath;
    }

    private static File getDesktopInternalStorageDirectory() {
        File file = new File(System.getProperty("user.home") + "/.webfx/apps/" + getAppName() + "/internalStorage");
        file.mkdirs();
        return file;
    }

    private static String getAppName() {
        //String jarPath = JavaFileLocationProvider.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        // Returning the javafx application class name as
        Application application = SingleServiceProvider.getProvider(Application.class, () -> ServiceLoader.load(Application.class), SingleServiceProvider.NotFoundPolicy.RETURN_NULL);
        return application.getClass().getName();
    }

}
