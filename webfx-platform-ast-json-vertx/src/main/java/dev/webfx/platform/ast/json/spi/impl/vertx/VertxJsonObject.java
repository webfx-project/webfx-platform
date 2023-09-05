package dev.webfx.platform.ast.json.spi.impl.vertx;

import dev.webfx.platform.ast.json.JsonObject;
import dev.webfx.platform.ast.json.spi.impl.listmap.MapBasedJsonObject;

import java.util.Map;

/**
 * @author Bruno Salmon
 */
public final class VertxJsonObject extends MapBasedJsonObject implements VertxJsonElement, JsonObject {

    private io.vertx.core.json.JsonObject vertxObject;

    public VertxJsonObject() { // super constructor will call recreateEmptyNativeObject() to initialize the map
    }

    VertxJsonObject(Map<String, Object> map) {
        setMap(map);
    }

    VertxJsonObject(io.vertx.core.json.JsonObject vertxObject) {
        this.vertxObject = vertxObject;
    }

    @Override
    public Map<String, Object> getMap() {
        return vertxObject.getMap();
    }

    @Override
    protected void setMap(Map<String, Object> map) {
        vertxObject = new io.vertx.core.json.JsonObject(map);
    }

    @Override
    public io.vertx.core.json.JsonObject getNativeElement() {
        return vertxObject;
    }

    @Override
    protected void deepCopyNativeObject() {
        vertxObject = vertxObject.copy();
    }

    @Override
    public String toJsonString() {
        return vertxObject.encode();
    }
}

