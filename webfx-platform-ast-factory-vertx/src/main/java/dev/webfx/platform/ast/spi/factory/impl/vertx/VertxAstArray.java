package dev.webfx.platform.ast.spi.factory.impl.vertx;


import dev.webfx.platform.ast.spi.factory.impl.generic.ListBasedAstArray;
import dev.webfx.platform.ast.spi.factory.nativeast.NativeAstArray;
import dev.webfx.platform.ast.spi.factory.nativeast.NativeAstFactoryProvider;
import io.vertx.core.json.JsonArray;

import java.util.List;

/**
 * @author Bruno Salmon
 */
final class VertxAstArray extends ListBasedAstArray implements NativeAstArray {

    private JsonArray vertxArray;

    VertxAstArray(JsonArray vertxArray) {
        this.vertxArray = vertxArray;
    }

    public VertxAstArray(List<Object> list) {
        super(list);
    }

    JsonArray getVertxArray() {
        return vertxArray;
    }

    @Override
    public NativeAstFactoryProvider getProvider() {
        return VertxAstFactoryProvider.INSTANCE;
    }

    @Override
    public List<Object> getList() {
        return vertxArray.getList();
    }

    @Override
    protected void setList(List<Object> list) {
        vertxArray = new JsonArray(list);
    }

    @Override
    protected void deepCopyNativeArray() {
        vertxArray = vertxArray.copy();
    }

    @Override
    protected void recreateEmptyNativeArray() {
        vertxArray = new JsonArray();
    }

    @Override
    public int indexOfNativeElement(Object element) {
        return vertxArray.getList().indexOf(element);
    }

    @Override
    public Object getNativeElement(int index) {
        return vertxArray.getList().get(index);
    }

    @Override
    public void pushNativeElement(Object element) {
        vertxArray.add(element);
    }

    @Override
    public void setNativeElement(int index, Object value) {
        vertxArray.set(index, value);
    }

}
