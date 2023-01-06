package dev.webfx.platform.storage.spi.impl.java;

import dev.webfx.platform.storage.spi.LocalStorageProvider;
import dev.webfx.platform.storagelocation.StorageLocation;
import dev.webfx.platform.visibility.Visibility;
import dev.webfx.platform.visibility.VisibilityState;

import java.io.*;
import java.nio.file.Paths;

/**
 * @author Bruno Salmon
 */
public final class JavaLocalStorageProvider extends JavaStorageProvider implements LocalStorageProvider {

    private final File locateStorageFile = Paths.get(StorageLocation.getInternalStorageLocation() , "localStorage.properties").toFile();

    public JavaLocalStorageProvider() {
        loadProperties();
        Visibility.addVisibilityListener(visibilityState -> {
            if (visibilityState == VisibilityState.HIDDEN)
                storeProperties();
        });
        //Runtime.getRuntime().addShutdownHook(new Thread(this::storeProperties));
    }

    private void loadProperties() {
        try (InputStream is = new FileInputStream(locateStorageFile)) {
            properties.load(is);
        } catch (FileNotFoundException e) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void storeProperties() {
        try {
            locateStorageFile.getParentFile().mkdirs();
            locateStorageFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (OutputStream os = new FileOutputStream(locateStorageFile)) {
            properties.store(os, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
