package dev.webfx.platform.ast;

import dev.webfx.platform.util.collection.HashList;

import java.util.*;

/**
 * @author Bruno Salmon
 */
public final class ReadOnlyMergedAstObject implements ReadOnlyAstObject {

    private final boolean deepMerge;
    private final ReadOnlyAstObject[] originalAstObjects;
    private final HashList<Object> keysList = new HashList<>();
    private final ReadOnlyAstArray keys;
    private final Map<String, Object> lazyNewValues = new HashMap<>();

    public ReadOnlyMergedAstObject(boolean deepMerge, ReadOnlyAstObject... astObjectsToMerge) {
        this.deepMerge = deepMerge;
        this.originalAstObjects = astObjectsToMerge;
        Arrays.stream(astObjectsToMerge).forEach(astObjects -> astObjects.keys().forEach(keysList::add));
        this.keys = AST.createReadOnlyAstArrayFromList(keysList);
    }

    @Override
    public boolean has(String key) {
        return keysList.contains(key);
    }

    @Override
    public ReadOnlyAstArray keys() {
        return keys;
    }

    @Override
    public <T> T get(String key) {
        Object value = lazyNewValues.get(key);
        if (value == null && !lazyNewValues.containsKey(key)) {
            ReadOnlyAstObject childAstObject = null;
            List<ReadOnlyAstObject> childAstObjects = null;
            for (ReadOnlyAstObject astObject : originalAstObjects) {
                value = astObject.get(key);
                if (value != null) {
                    if (!deepMerge || !(value instanceof ReadOnlyAstObject))
                        break;
                    if (childAstObject == null)
                        childAstObject = (ReadOnlyAstObject) value;
                    else {
                        if (childAstObjects == null) {
                            childAstObjects = new ArrayList<>();
                            childAstObjects.add(childAstObject);
                        }
                        childAstObjects.add((ReadOnlyAstObject) value);
                    }
                }
            }
            if (childAstObjects != null) {
                value = new ReadOnlyMergedAstObject(true, childAstObjects.toArray(new ReadOnlyAstObject[0]));
            } else if (childAstObject != null)
                value = childAstObject;
            lazyNewValues.put(key, value);
        }
        return (T) value;
    }

}
