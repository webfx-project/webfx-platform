package dev.webfx.platform.ast;

/**
 * @author Bruno Salmon
 */
public class AstObjectWrapper extends ReadOnlyAstObjectWrapper implements AstObject {
    
    public AstObjectWrapper(AstObject delegate) {
        super(delegate);
    }

    @Override
    public AstObject getWrappedObject() {
        return (AstObject) super.getWrappedObject();
    }

    @Override
    public void clear() {
        getWrappedObject().clear();
    }

    @Override
    public <V> V remove(String key) {
        return getWrappedObject().remove(key);
    }

    @Override
    public <T extends AstObject> T set(String key, Object value) {
        return getWrappedObject().set(key, value);
    }
/*
    @Override
    public <T extends AstObject> T setObject(String key, ReadOnlyAstObject object) {
        return getDelegate().setObject(key, object);
    }

    @Override
    public <T extends AstObject> T setArray(String key, ReadOnlyAstArray array) {
        return getDelegate().setArray(key, array);
    }

    @Override
    public <T extends AstObject> T setScalar(String key, Object scalar) {
        return getDelegate().setScalar(key, scalar);
    }

    @Override
    public <T extends AstObject> T set(String key, Boolean value) {
        return getDelegate().set(key, value);
    }

    @Override
    public <T extends AstObject> T set(String key, Integer value) {
        return getDelegate().set(key, value);
    }

    @Override
    public <T extends AstObject> T set(String key, Long value) {
        return getDelegate().set(key, value);
    }

    @Override
    public <T extends AstObject> T set(String key, Double value) {
        return getDelegate().set(key, value);
    }

    @Override
    public <T extends AstObject> T set(String key, String value) {
        return getDelegate().set(key, value);
    }

    @Override
    public <T extends AstObject> T set(String key, Instant value) {
        return getDelegate().set(key, value);
    }
    */
}
