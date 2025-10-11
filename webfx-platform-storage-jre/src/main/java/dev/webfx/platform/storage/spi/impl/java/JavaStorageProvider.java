package dev.webfx.platform.storage.spi.impl.java;

import dev.webfx.platform.storage.spi.StorageProvider;

import java.util.Iterator;
import java.util.Properties;

/**
 * @author Bruno Salmon
 */
class JavaStorageProvider implements StorageProvider {

    protected final Properties properties = new Properties();
    protected boolean hasUnsavedChanges;

    @Override
    public void setItem(String key, String value) {
        properties.setProperty(key, value);
        markAsChanged();
    }

    @Override
    public String getItem(String key) {
        return properties.getProperty(key);
    }

    @Override
    public void removeItem(String key) {
        if (properties.remove(key) != null)
            markAsChanged();
    }

    @Override
    public Iterator<String> getKeys() {
        return properties.stringPropertyNames().iterator();
    }

    @Override
    public int getLength() {
        return properties.size();
    }

    @Override
    public void clear() {
        if (!properties.isEmpty()) {
            properties.clear();
            markAsChanged();
        }
    }

    protected void markAsChanged() {
        hasUnsavedChanges = true;
    }

    protected void markAsSaved() {
        hasUnsavedChanges = true;
    }

}
