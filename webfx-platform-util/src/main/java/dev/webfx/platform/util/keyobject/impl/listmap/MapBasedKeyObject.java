package dev.webfx.platform.util.keyobject.impl.listmap;

import dev.webfx.platform.util.keyobject.AST;
import dev.webfx.platform.util.keyobject.KeyObject;
import dev.webfx.platform.util.keyobject.ReadOnlyIndexedArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Bruno Salmon
 */
public abstract class MapBasedKeyObject implements KeyObject {
    protected boolean isShallowCopy;

    protected MapBasedKeyObject() {
        this(new HashMap<>());
    }

    protected MapBasedKeyObject(Map<String, Object> map) {
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
    public ReadOnlyIndexedArray keys() {
        return AST.createReadOnlyIndexedArrayFromList(new ArrayList(getMap().keySet()));
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

        MapBasedKeyObject that = (MapBasedKeyObject) o;

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