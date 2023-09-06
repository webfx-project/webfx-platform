package dev.webfx.platform.ast;

/**
 * @author Bruno Salmon
 */
public class ReadOnlyAstArrayWrapper implements ReadOnlyAstArray {

    private final ReadOnlyAstArray wrappedArray;

    public ReadOnlyAstArrayWrapper(ReadOnlyAstArray wrappedArray) {
        this.wrappedArray = wrappedArray;
    }

    protected ReadOnlyAstArray getWrappedArray() {
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
