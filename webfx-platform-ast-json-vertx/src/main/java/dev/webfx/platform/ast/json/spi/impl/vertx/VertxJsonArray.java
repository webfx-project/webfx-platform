package dev.webfx.platform.ast.json.spi.impl.vertx;

import dev.webfx.platform.ast.json.JsonArray;
import dev.webfx.platform.ast.json.spi.impl.listmap.ListBasedJsonArray;

import java.util.List;

/**
 * @author Bruno Salmon
 */
public final class VertxJsonArray extends ListBasedJsonArray implements VertxJsonElement, JsonArray {

    private io.vertx.core.json.JsonArray vertxArray;

    VertxJsonArray() {  // super constructor will call recreateEmptyNativeArray() to initialize the array
    }

    VertxJsonArray(List<Object> list) {
        setList(list);
    }

    VertxJsonArray(io.vertx.core.json.JsonArray vertxArray) {
        this.vertxArray = vertxArray;
    }

    @Override
    public List<Object> getList() {
        return vertxArray.getList();
    }

    @Override
    protected void setList(List<Object> list) {
        vertxArray = new io.vertx.core.json.JsonArray(list);
    }

    @Override
    public io.vertx.core.json.JsonArray getNativeElement() {
        return vertxArray;
    }

    @Override
    protected void deepCopyNativeArray() {
        vertxArray = vertxArray.copy();
    }

    @Override
    public String toJsonString() {
        return vertxArray.encode();
    }
}
