package dev.webfx.platform.util.keyobject;

/**
 * @author Bruno Salmon
 */
public class ReadOnlyIndexedArrayWrapper implements ReadOnlyIndexedArray {

    private final ReadOnlyIndexedArray wrappedArray;

    public ReadOnlyIndexedArrayWrapper(ReadOnlyIndexedArray wrappedArray) {
        this.wrappedArray = wrappedArray;
    }

    protected ReadOnlyIndexedArray getWrappedArray() {
        return wrappedArray;
    }

    @Override
    public int size() {
        return getWrappedArray().size();
    }

    @Override
    public int indexOf(Object value) {
        return getWrappedArray().indexOf(value);
    }

    @Override
    public <V> V getElement(int index) {
        return getWrappedArray().getElement(index);
    }
}
