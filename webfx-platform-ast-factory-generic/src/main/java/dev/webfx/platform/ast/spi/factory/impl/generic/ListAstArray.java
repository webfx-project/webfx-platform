package dev.webfx.platform.ast.spi.factory.impl.generic;

import dev.webfx.platform.ast.AstArray;

import java.util.List;

/**
 * @author Bruno Salmon
 */
public final class ListAstArray extends ListBasedAstArray {

    protected List<Object> list;

    protected ListAstArray() {
    }

    protected ListAstArray(List<Object> list) {
        super(list);
    }

    @Override
    public List<Object> getList() {
        return list;
    }

    @Override
    public void clear() {
        getList().clear();
    }

    @Override
    protected void setList(List<Object> list) {
        this.list = list;
    }

    @Override
    public <T extends AstArray> T push(Object element) {
        list.add(element);
        return (T) this;
    }

    @Override
    public <T extends AstArray> T set(int index, Object value) {
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
