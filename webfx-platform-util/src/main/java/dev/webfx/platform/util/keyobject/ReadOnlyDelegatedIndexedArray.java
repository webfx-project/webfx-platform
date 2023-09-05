package dev.webfx.platform.util.keyobject;

/**
 * @author Bruno Salmon
 */
public class ReadOnlyDelegatedIndexedArray implements ReadOnlyIndexedArray {

    private final ReadOnlyIndexedArray delegate;

    public ReadOnlyDelegatedIndexedArray(ReadOnlyIndexedArray delegate) {
        this.delegate = delegate;
    }

    protected ReadOnlyIndexedArray getDelegate() {
        return delegate;
    }

    @Override
    public int size() {
        return getDelegate().size();
    }

    @Override
    public int indexOf(Object value) {
        return getDelegate().indexOf(value);
    }

    @Override
    public <V> V getElement(int index) {
        return getDelegate().getElement(index);
    }
}
