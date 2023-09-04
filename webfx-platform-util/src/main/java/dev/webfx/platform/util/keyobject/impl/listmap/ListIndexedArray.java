package dev.webfx.platform.util.keyobject.impl.listmap;

import dev.webfx.platform.util.keyobject.IndexedArray;

import java.util.List;

/**
 * @author Bruno Salmon
 */
public final class ListIndexedArray extends ListBasedIndexedArray {

    protected List<Object> list;

    protected ListIndexedArray() {
    }

    protected ListIndexedArray(List<Object> list) {
        super(list);
    }

    @Override
    public List<Object> getList() {
        return list;
    }

    @Override
    protected void setList(List<Object> list) {
        this.list = list;
    }

    @Override
    public <T extends IndexedArray> T push(Object element) {
        list.add(element);
        return (T) this;
    }

    @Override
    public <T extends IndexedArray> T set(int index, Object value) {
        list.set(index, value);
        return (T) this;
    }

    @Override
    public int indexOf(Object value) {
        return list.indexOf(value);
    }

    @Override
    public <V> V getElement(int index) {
        return (V) list.get(index);
    }
}
