package dev.webfx.platform.util.keyobject;

import dev.webfx.platform.util.collection.HashList;
import dev.webfx.platform.util.keyobject.util.TreeUtil;

import java.util.*;

/**
 * @author Bruno Salmon
 */
public final class ReadOnlyMergedKeyObject implements ReadOnlyKeyObject {

    private final boolean deepMerge;
    private final ReadOnlyKeyObject[] originalKeyObjects;
    private final HashList<Object> keysList = new HashList<>();
    private final ReadOnlyIndexedArray keys;
    private final Map<String, Object> lazyNewValues = new HashMap<>();

    public ReadOnlyMergedKeyObject(boolean deepMerge, ReadOnlyKeyObject... keyObjectsToMerge) {
        this.deepMerge = deepMerge;
        this.originalKeyObjects = keyObjectsToMerge;
        Arrays.stream(keyObjectsToMerge).forEach(keyObjects -> keysList.add(keyObjects.keys()));
        this.keys = TreeUtil.createReadOnlyIndexedArrayFromList(keysList);
    }

    @Override
    public boolean has(String key) {
        return keysList.contains(key);
    }

    @Override
    public ReadOnlyIndexedArray keys() {
        return keys;
    }

    @Override
    public <T> T get(String key) {
        Object value = lazyNewValues.get(key);
        if (value == null && !lazyNewValues.containsKey(key)) {
            ReadOnlyKeyObject childKeyObject = null;
            List<ReadOnlyKeyObject> childKeyObjects = null;
            for (ReadOnlyKeyObject keyObject : originalKeyObjects) {
                value = keyObject.get(key);
                if (value != null) {
                    if (!deepMerge || !(value instanceof ReadOnlyKeyObject))
                        break;
                    if (childKeyObject == null)
                        childKeyObject = (ReadOnlyKeyObject) value;
                    else {
                        if (childKeyObjects == null) {
                            childKeyObjects = new ArrayList<>();
                            childKeyObjects.add(childKeyObject);
                        }
                        childKeyObjects.add((ReadOnlyKeyObject) value);
                    }
                }
            }
            if (childKeyObjects != null) {
                value = new ReadOnlyMergedKeyObject(true, childKeyObjects.toArray(new ReadOnlyKeyObject[0]));
            } else if (childKeyObject != null)
                value = childKeyObject;
            lazyNewValues.put(key, value);
        }
        return (T) value;
    }

}
