package dev.webfx.platform.ast.spi.factory.impl.generic;

import dev.webfx.platform.ast.AST;
import dev.webfx.platform.ast.AstObject;
import dev.webfx.platform.ast.ReadOnlyAstArray;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Bruno Salmon
 */
public abstract class MapBasedAstObject implements AstObject {
    protected boolean isShallowCopy;

    protected MapBasedAstObject() {
        this(new LinkedHashMap<>());
    }

    protected MapBasedAstObject(Map<String, Object> map) {
        setMap(map);
    }

    public abstract Map<String, Object> getMap();

    protected abstract void setMap(Map<String, Object> map);

    protected void deepCopyNativeObject() {
        setMap(ListMapUtil.convertMap(getMap()));
    }

    @Override
    public int size() {
        return getMap().size();
    }

    @Override
    public boolean has(String key) {
        return getMap().containsKey(key);
    }

    @Override
    public ReadOnlyAstArray keys() {
        return AST.listToReadOnlyAstArray(new ArrayList(getMap().keySet()));
    }

    public Object getNativeElement(String key) {
        return getMap().get(key);
    }

    @Override
    public <T> T remove(String key) {
        checkCopyBeforeUpdate();
        return (T) getMap().remove(key);
    }

    protected void checkCopyBeforeUpdate() {
        if (isShallowCopy) {
            // deep copy the list lazily if the object is mutated
            deepCopyNativeObject();
            isShallowCopy = false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        MapBasedAstObject that = (MapBasedAstObject) o;

        Map<String, Object> thisMap = getMap();
        Map<String, Object> thatMap = that.getMap();
        if (thisMap.size() != thatMap.size())
            return false;

        for (Map.Entry<String, Object> entry : thisMap.entrySet()) {
            Object val = entry.getValue();
            if (val == null) {
                if (thatMap.get(entry.getKey()) != null)
                    return false;
            } else if (!entry.getValue().equals(thatMap.get(entry.getKey())))
                return false;
        }
        return true;
    }
}