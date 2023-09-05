package dev.webfx.platform.json.spi.impl.listmap;

import dev.webfx.platform.json.JsonArray;
import dev.webfx.platform.ast.impl.listmap.ListBasedAstArray;
import dev.webfx.platform.ast.impl.listmap.ListMapUtil;

import java.util.List;

/**
 * @author Bruno Salmon
 */
public abstract class ListBasedJsonArray extends ListBasedAstArray implements JsonArray, ListMapBasedJsonElement {

    protected ListBasedJsonArray() {
        recreateEmptyNativeArray();
    }

    protected ListBasedJsonArray(List<Object> list) {
        setList(list);
    }


    protected void recreateEmptyNativeArray() {
        setList((List) createNativeArray());
    }

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
    public Object getNativeElement(int index) {
        return getList().get(index);
    }

    @Override
    public int indexOfNativeElement(Object element) {
        return getList().indexOf(element);
    }

    @Override
    public ListBasedJsonArray pushNativeElement(Object element) {
        getList().add(element);
        return this;
    }

    @Override
    public ListBasedJsonArray setNativeElement(int index, Object value) {
        getList().set(index, value);
        return this;
    }

    @Override
    public <T> T remove(int index) {
        checkCopyBeforeUpdate();
        return (T) getList().remove(index);
    }

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

    /*@Override
    public String toString() {
        return toJsonString();
    }*/
}