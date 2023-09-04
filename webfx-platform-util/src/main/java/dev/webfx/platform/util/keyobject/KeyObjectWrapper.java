package dev.webfx.platform.util.keyobject;

/**
 * @author Bruno Salmon
 */
public class KeyObjectWrapper extends ReadOnlyKeyObjectWrapper implements KeyObject {
    
    public KeyObjectWrapper(KeyObject delegate) {
        super(delegate);
    }

    @Override
    public KeyObject getWrappedObject() {
        return (KeyObject) super.getWrappedObject();
    }

    @Override
    public <V> V remove(String key) {
        return getWrappedObject().remove(key);
    }

    @Override
    public <T extends KeyObject> T set(String key, Object value) {
        return getWrappedObject().set(key, value);
    }
/*
    @Override
    public <T extends KeyObject> T setObject(String key, ReadOnlyKeyObject object) {
        return getDelegate().setObject(key, object);
    }

    @Override
    public <T extends KeyObject> T setArray(String key, ReadOnlyIndexedArray array) {
        return getDelegate().setArray(key, array);
    }

    @Override
    public <T extends KeyObject> T setScalar(String key, Object scalar) {
        return getDelegate().setScalar(key, scalar);
    }

    @Override
    public <T extends KeyObject> T set(String key, Boolean value) {
        return getDelegate().set(key, value);
    }

    @Override
    public <T extends KeyObject> T set(String key, Integer value) {
        return getDelegate().set(key, value);
    }

    @Override
    public <T extends KeyObject> T set(String key, Long value) {
        return getDelegate().set(key, value);
    }

    @Override
    public <T extends KeyObject> T set(String key, Double value) {
        return getDelegate().set(key, value);
    }

    @Override
    public <T extends KeyObject> T set(String key, String value) {
        return getDelegate().set(key, value);
    }

    @Override
    public <T extends KeyObject> T set(String key, Instant value) {
        return getDelegate().set(key, value);
    }
    */
}
