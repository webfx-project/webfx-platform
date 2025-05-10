package dev.webfx.platform.storage.spi.impl.teavm;

import dev.webfx.platform.storage.spi.StorageProvider;
import org.teavm.jso.browser.Storage;

import java.util.Iterator;

/**
 * @author Bruno Salmon
 */
abstract class TeaVmStorageProvider implements StorageProvider {

    private final Storage storage;

    public TeaVmStorageProvider(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void setItem(String key, String value) {
        storage.setItem(key, value);
    }

    @Override
    public String getItem(String key) {
        return storage.getItem(key);
    }

    @Override
    public void removeItem(String key) {
        storage.removeItem(key);
    }

    @Override
    public Iterator<String> getKeys() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < storage.getLength();
            }

            @Override
            public String next() {
                return storage.key(index++);
            }
        };
    }

    @Override
    public int getLength() {
        return storage.getLength();
    }

    @Override
    public void clear() {
        storage.clear();
    }
}