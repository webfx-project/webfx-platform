package dev.webfx.platform.util.keyobject.impl.listmap;

import dev.webfx.platform.util.keyobject.KeyObject;

import java.util.Map;

/**
 * @author Bruno Salmon
 */
public class MapKeyObject extends MapBasedKeyObject {

    protected Map<String, Object> map;

    public MapKeyObject() {
    }

    protected MapKeyObject(Map map) {
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
    public <T extends KeyObject> T set(String key, Object value) {
        map.put(key, value);
        return (T) this;
    }

    @Override
    public <T> T get(String key) {
        return (T) map.get(key);
    }
}
