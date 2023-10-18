package dev.webfx.platform.ast.spi.factory.impl.vertx;

import dev.webfx.platform.ast.AST;
import dev.webfx.platform.ast.spi.factory.impl.generic.MapBasedAstObject;
import dev.webfx.platform.ast.spi.factory.nativeast.NativeAstFactoryProvider;
import dev.webfx.platform.ast.spi.factory.nativeast.NativeAstObject;
import io.vertx.core.json.JsonObject;

import java.util.Map;

/**
 * @author Bruno Salmon
 */
final class VertxAstObject extends MapBasedAstObject implements NativeAstObject {

    private JsonObject vertxObject;

    VertxAstObject(JsonObject vertxObject) {
        setVertxObject(vertxObject);
    }

    VertxAstObject(Map map) {
        super(map);
    }

    @Override
    public NativeAstFactoryProvider getProvider() {
        return VertxAstFactoryProvider.INSTANCE;
    }

    @Override
    public void setNativeElement(String key, Object element) {
        vertxObject.put(key, element);
    }

    JsonObject getVertxObject() {
        return vertxObject;
    }

    private void setVertxObject(JsonObject vertxObject) {
        this.vertxObject = vertxObject;
    }

    @Override
    protected void setMap(Map<String, Object> map) {
        vertxObject = new JsonObject(map);
    }

    @Override
    public Map<String, Object> getMap() {
        return vertxObject.getMap();
    }

    @Override
    public void clear() {
        vertxObject.clear();
    }

    @Override
    protected void deepCopyNativeObject() {
        setVertxObject(vertxObject.copy());
    }

    @Override
    public String toString() {
        return AST.formatObject(this, "json");
    }
}

