package dev.webfx.platform.util.keyobject.impl.listmap;

import dev.webfx.platform.util.keyobject.IndexedArray;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bruno Salmon
 */
public abstract class ListBasedIndexedArray implements IndexedArray {
    protected boolean isShallowCopy;

    protected ListBasedIndexedArray() {
        this(new ArrayList<>());
    }

    protected ListBasedIndexedArray(List<Object> list) {
        setList(list);
    }

    public abstract List<Object> getList();

    protected abstract void setList(List<Object> list);

    protected void deepCopyNativeArray() {
        setList(ListMapUtil.convertList(getList()));
    }

    protected void checkCopyBeforeUpdate() {
        if (isShallowCopy) {
            // deep copy the list lazily if the object is mutated
            deepCopyNativeArray();
            isShallowCopy = false;
        }
    }

    @Override
    public int size() {
        return getList().size();
    }

    @Override
    public <T> T remove(int index) {
        checkCopyBeforeUpdate();
        return (T) getList().remove(index);
    }

/*
    @Override
    public void clear() {
        if (isShallowCopy) {
            recreateEmptyNativeArray();
            isShallowCopy = false;
        } else
            getList().clear();
    }

    @Override
    public ListBasedJsonArray copy() {
        ListBasedJsonArray copy = (ListBasedJsonArray) nativeToJavaJsonArray(getNativeElement());
        // We actually do the copy lazily if the object is subsequently mutated
        copy.isShallowCopy = isShallowCopy = true;
        return copy;
    }
*/


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        ListBasedIndexedArray that = (ListBasedIndexedArray) o;

        List<?> thisList = this.getList();
        List<?> thatList = that.getList();
        if (thisList.size() != thatList.size())
            return false;

        java.util.Iterator<?> iter = thatList.iterator();
        for (Object entry : thisList) {
            Object other = iter.next();
            if (entry == null) {
                if (other != null)
                    return false;
            } else if (!entry.equals(other))
                return false;
        }
        return true;
    }
}