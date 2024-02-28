package dev.webfx.platform.ast.spi.factory.impl.generic;

import dev.webfx.platform.ast.AST;
import dev.webfx.platform.ast.AstObject;

import java.util.Map;

/**
 * @author Bruno Salmon
 */
public class MapAstObject extends MapBasedAstObject {

    protected Map<String, Object> map;

    public MapAstObject() {
    }

    protected MapAstObject(Map map) {
        super(map);
    }

    @Override
    public Map<String, Object> getMap() {
        return map;
    }

    @Override
    protected void setMap(Map<String, Object> map) {
        this.map = map;
    }

    @Override
    public void clear() {
        getMap().clear();
    }


    @Override
    public <T extends AstObject> T set(String key, Object value) {
        map.put(key, value);
        return (T) this;
    }

    @Override
    public <T> T get(String key) {
        return (T) map.get(key);
    }

    @Override
    public String toString() {
        return AST.formatObject(this, "json");
    }
}
