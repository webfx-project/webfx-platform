package dev.webfx.platform.util.keyobject.util;

import dev.webfx.platform.util.Arrays;
import dev.webfx.platform.util.Strings;
import dev.webfx.platform.util.keyobject.ReadOnlyIndexedArray;
import dev.webfx.platform.util.keyobject.ReadOnlyKeyObject;
import dev.webfx.platform.util.keyobject.ReadOnlyMergedKeyObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Bruno Salmon
 */
public final class TreeUtil {

    public static ReadOnlyKeyObject lookupObject(ReadOnlyKeyObject keyObject, String path) {
        if (keyObject == null)
            return null;
        String[] paths = Strings.split(path, ".");
        return lookupObject(keyObject, paths, false);
    }

    private static ReadOnlyKeyObject lookupObject(ReadOnlyKeyObject keyObject, String[] paths, boolean ignoreLastPath) {
        int n = paths.length;
        if (ignoreLastPath)
            n--;
        for (int i = 0; i < n; i++) {
            keyObject = keyObject.getObject(paths[i]);
            if (keyObject == null)
                return null;
        }
        return keyObject;
    }

    public static String lookupString(ReadOnlyKeyObject keyObject, String path) {
        if (keyObject == null)
            return null;
        String[] paths = Strings.split(path, ".");
        keyObject = lookupObject(keyObject, paths, true);
        return keyObject == null ? null : keyObject.getString(paths[paths.length - 1]);
    }

    public static ReadOnlyKeyObject prefixObject(String prefixPath, ReadOnlyKeyObject keyObject) {
        if (prefixPath == null || prefixPath.isEmpty())
            return keyObject;
        String[] paths = Strings.split(prefixPath, ".");
        for (int i = paths.length - 1; i >= 0; i--)
            keyObject = createReadOnlySingleKeyObject(paths[i], keyObject);
        return keyObject;
    }

    public static ReadOnlyKeyObject createReadOnlyKeyObjectFromMap(Map<Object, Object> map, boolean dotKeys, boolean convertMapsToObjects) {
        Map<Object, Object> finalMap;
        if (!dotKeys)
            finalMap = map;
        else {
            finalMap = interpretDotKeys(map);
        }
        return new ReadOnlyKeyObject() {
            private ReadOnlyIndexedArray keysArray;
            @Override
            public ReadOnlyIndexedArray keys() {
                if (keysArray == null) {
                    keysArray = TreeUtil.createReadOnlyIndexedArrayFromList(new ArrayList<>(finalMap.keySet()));
                }
                return keysArray;
            }

            @Override
            public <T> T get(String key) {
                Object value = finalMap.get(key);
                if (convertMapsToObjects && value instanceof Map) {
                    finalMap.put(key, value = createReadOnlyKeyObjectFromMap((Map<Object, Object>) value, false, true));
                }
                return (T) value;
            }
        };
    }

    private static Map<Object, Object> interpretDotKeys(Map<?, ?> map) {
        Map<Object, Object> finalMap = new HashMap<>();
        // First pass: splitting simple keys and dot keys to finalMap and dotKeysMap respectively
        // Note: dotKeysMap is holding only objects (as Map) that may have several keys at the end of this first pass
        Map<String, Map<Object, Object>> dotKeysMap = null;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            String key = entry.getKey().toString();
            int dotIndex = key.indexOf('.');
            if (dotIndex < 0)
                finalMap.put(key, entry.getValue());
            else {
                String objectKey = key.substring(0, dotIndex);
                String valueKey = key.substring(dotIndex + 1);
                if (dotKeysMap == null)
                    dotKeysMap = new HashMap<>();
                Map<Object, Object> objectMap = dotKeysMap.computeIfAbsent(objectKey, k -> new HashMap<>());
                objectMap.put(valueKey, entry.getValue());
            }
        }
        // Second pass: moving back ditKeysMap objects to finalMap after recursive interpretation (necessary when the
        // map contains keys with several dots)
        if (dotKeysMap != null) {
            for (Map.Entry<String, Map<Object, Object>> entry : dotKeysMap.entrySet()) {
                finalMap.put(entry.getKey(), interpretDotKeys(entry.getValue()));
            }
        }
        return finalMap;
    }

    public static ReadOnlyKeyObject createReadOnlySingleKeyObject(String singleKey, Object singleValue) {
        return new ReadOnlyKeyObject() {
            private ReadOnlyIndexedArray keysArray;
            @Override
            public ReadOnlyIndexedArray keys() {
                if (keysArray == null) {
                    keysArray = TreeUtil.createReadOnlyIndexedArrayFromObjects(singleKey);
                }
                return keysArray;
            }

            @Override
            public <T> T get(String key) {
                return key.equals(singleKey) ? (T) singleValue : null;
            }
        };
    }

    public static ReadOnlyIndexedArray createReadOnlyIndexedArrayFromList(List<?> keys) {
        return new ReadOnlyIndexedArray() {
            @Override
            public int size() {
                return keys.size();
            }

            @Override
            public int indexOf(Object value) {
                return keys.indexOf(value);
            }

            @Override
            public <V> V getElement(int index) {
                return (V) keys.get(index);
            }
        };
    }

    public static ReadOnlyIndexedArray createReadOnlyIndexedArrayFromObjects(Object... objects) {
        return new ReadOnlyIndexedArray() {
            @Override
            public int size() {
                return objects.length;
            }

            @Override
            public int indexOf(Object value) {
                return Arrays.indexOf(objects, value);
            }

            @Override
            public <V> V getElement(int index) {
                return (V) objects[index];
            }
        };
    }

    public static ReadOnlyKeyObject mergeKeyObjects(ReadOnlyKeyObject... keyObjects) {
        if (keyObjects.length == 0)
            return null;
        if (keyObjects.length == 1)
            return keyObjects[0];
        return new ReadOnlyMergedKeyObject(true, keyObjects);
    }

}
