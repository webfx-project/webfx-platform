package dev.webfx.platform.ast.impl.listmap;

import dev.webfx.platform.ast.AstArray;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bruno Salmon
 */
public abstract class ListBasedAstArray implements AstArray {
    protected boolean isShallowCopy;

    protected ListBasedAstArray() {
        this(new ArrayList<>());
    }

    protected ListBasedAstArray(List<Object> list) {
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

        ListBasedAstArray that = (ListBasedAstArray) o;

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