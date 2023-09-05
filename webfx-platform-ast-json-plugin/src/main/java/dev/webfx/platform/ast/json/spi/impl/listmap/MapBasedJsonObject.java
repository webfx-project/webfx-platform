package dev.webfx.platform.ast.json.spi.impl.listmap;

import dev.webfx.platform.ast.json.JsonObject;
import dev.webfx.platform.ast.json.ReadOnlyJsonArray;
import dev.webfx.platform.ast.impl.listmap.MapBasedAstObject;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author Bruno Salmon
 */
public abstract class MapBasedJsonObject extends MapBasedAstObject implements JsonObject, ListMapBasedJsonElement {

    protected MapBasedJsonObject() {
        recreateEmptyNativeObject();
    }

    protected MapBasedJsonObject(Map<String, Object> map) {
        setMap(map);
    }

    protected void recreateEmptyNativeObject() {
        setMap((Map) createNativeObject());
    }

    @Override
    public ReadOnlyJsonArray keys() {
        return nativeToJavaJsonArray(new ArrayList(getMap().keySet()));
    }

    @Override
    public <T> T remove(String key) {
        checkCopyBeforeUpdate();
        return (T) getMap().remove(key);
    }

    @Override
    public MapBasedJsonObject setNativeElement(String key, Object element) {
        checkCopyBeforeUpdate();
        getMap().put(key, element);
        return this;
    }

    protected void checkCopyBeforeUpdate() {
        if (isShallowCopy) {
            // deep copy the list lazily if the object is mutated
            deepCopyNativeObject();
            isShallowCopy = false;
        }
    }

    @Override
    public void clear() {
        if (isShallowCopy) {
            recreateEmptyNativeObject();
            isShallowCopy = false;
        } else
            getMap().clear();
    }

    @Override
    public MapBasedJsonObject copy() {
        MapBasedJsonObject copy = (MapBasedJsonObject) nativeToJavaJsonObject(getNativeElement());
        // We actually do the copy lazily if the object is subsequently mutated
        copy.isShallowCopy = isShallowCopy = true;
        return copy;
    }

    @Override
    public String toString() {
        return toJsonString();
    }

}