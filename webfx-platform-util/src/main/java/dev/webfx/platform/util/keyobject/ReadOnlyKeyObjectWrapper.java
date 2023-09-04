package dev.webfx.platform.util.keyobject;

/**
 * @author Bruno Salmon
 */
public class ReadOnlyKeyObjectWrapper implements ReadOnlyKeyObject {
    
    private final ReadOnlyKeyObject wrappedObject;

    public ReadOnlyKeyObjectWrapper(ReadOnlyKeyObject wrappedObject) {
        this.wrappedObject = wrappedObject;
    }

    protected ReadOnlyKeyObject getWrappedObject() {
        return wrappedObject;
    }

    @Override
    public ReadOnlyIndexedArray keys() {
        return getWrappedObject().keys();
    }

    @Override
    public <T> T get(String key) {
        return getWrappedObject().get(key);
    }

    /*
    @Override
    public boolean isObject(String key) {
        return getDelegate().isObject(key);
    }

    @Override
    public boolean isArray(String key) {
        return getDelegate().isArray(key);
    }

    @Override
    public boolean isScalar(String key) {
        return getDelegate().isScalar(key);
    }

    @Override
    public ReadOnlyKeyObject getObject(String key) {
        return getDelegate().getObject(key);
    }

    @Override
    public ReadOnlyIndexedArray getArray(String key) {
        return getDelegate().getArray(key);
    }

    @Override
    public <T> T getScalar(String key) {
        return getDelegate().getScalar(key);
    }

    @Override
    public <T> T getScalar(String key, T defaultValue) {
        return getDelegate().getScalar(key, defaultValue);
    }

    @Override
    public boolean isTrue(String key) {
        return getDelegate().isTrue(key);
    }

    @Override
    public Boolean getBoolean(String key) {
        return getDelegate().getBoolean(key);
    }

    @Override
    public Boolean getBoolean(String key, Boolean defaultValue) {
        return getDelegate().getBoolean(key, defaultValue);
    }

    @Override
    public String getString(String key) {
        return getDelegate().getString(key);
    }

    @Override
    public String getString(String key, String defaultValue) {
        return getDelegate().getString(key, defaultValue);
    }

    @Override
    public Integer getInteger(String key) {
        return getDelegate().getInteger(key);
    }

    @Override
    public Integer getInteger(String key, Integer defaultValue) {
        return getDelegate().getInteger(key, defaultValue);
    }

    @Override
    public Long getLong(String key) {
        return getDelegate().getLong(key);
    }

    @Override
    public Long getLong(String key, Long defaultValue) {
        return getDelegate().getLong(key, defaultValue);
    }

    @Override
    public Double getDouble(String key) {
        return getDelegate().getDouble(key);
    }

    @Override
    public Double getDouble(String key, Double defaultValue) {
        return getDelegate().getDouble(key, defaultValue);
    }

    @Override
    public Instant getInstant(String key) {
        return getDelegate().getInstant(key);
    }

    @Override
    public Instant getInstant(String key, Instant defaultValue) {
        return getDelegate().getInstant(key, defaultValue);
    }
    */
}
