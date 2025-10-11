package dev.webfx.platform.storage.spi.impl.java;

import dev.webfx.platform.console.Console;
import dev.webfx.platform.scheduler.Scheduled;
import dev.webfx.platform.scheduler.Scheduler;
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
    private Scheduled saveScheduled;

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
        } catch (FileNotFoundException ignored) {
        } catch (Exception e) {
            Console.log("Exception while loading local storage file: " + e.getMessage());
        }
    }

    private void storeProperties() {
        if (hasUnsavedChanges) {
            try {
                locateStorageFile.getParentFile().mkdirs();
                locateStorageFile.createNewFile();
            } catch (IOException e) {
                Console.log("Exception while creating local storage file: " + e.getMessage());
            }
            try (OutputStream os = new FileOutputStream(locateStorageFile)) {
                Console.log("Saving local storage file");
                properties.store(os, null);
                markAsSaved();
            } catch (Exception e) {
                Console.log("Exception while saving local storage file: " + e.getMessage());
            }
        }
    }

    @Override
    protected void markAsChanged() {
        super.markAsChanged();
        if (saveScheduled == null) {
            saveScheduled = Scheduler.runOnIdle(this::storeProperties);
        }
    }

    @Override
    protected void markAsSaved() {
        super.markAsSaved();
        if (saveScheduled != null) {
            saveScheduled.cancel();
            saveScheduled = null;
        }
    }
}
