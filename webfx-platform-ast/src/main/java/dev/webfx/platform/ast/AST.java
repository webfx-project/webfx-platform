package dev.webfx.platform.ast;

import dev.webfx.platform.ast.formatter.AstFormatter;
import dev.webfx.platform.ast.impl.AstCloneVisitor;
import dev.webfx.platform.ast.parser.AstParser;
import dev.webfx.platform.util.Arrays;
import dev.webfx.platform.util.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Bruno Salmon
 */
public final class AST {

    public static AstObject createObject() {
        return AstFactory.get().createObject();
    }

    public static AstArray createArray() {
        return AstFactory.get().createArray();
    }

    public static ReadOnlyAstObject parseObject(String text, String format) {
        return AstParser.parseObject(text, format);
    }

    public static ReadOnlyAstArray parseArray(String text, String format) {
        return AstParser.parseArray(text, format);
    }

    public static ReadOnlyAstNode parseNode(String text, String format) {
        return AstParser.parseNode(text, format);
    }

    public static String formatObject(ReadOnlyAstObject astObject, String format) {
        return AstFormatter.formatObject(astObject, format);
    }

    public static String formatArray(ReadOnlyAstArray astArray, String format) {
        return AstFormatter.formatArray(astArray, format);
    }

    public static String formatNode(ReadOnlyAstNode formatNode, String format) {
        return AstFormatter.formatNode(formatNode, format);
    }

    public static ReadOnlyAstObject lookupObject(ReadOnlyAstObject astObject, String path) {
        if (astObject == null)
            return null;
        String[] paths = Strings.split(path, ".");
        return lookupObject(astObject, paths, false);
    }

    private static ReadOnlyAstObject lookupObject(ReadOnlyAstObject astObject, String[] paths, boolean ignoreLastPath) {
        int n = paths.length;
        if (ignoreLastPath)
            n--;
        for (int i = 0; i < n; i++) {
            astObject = astObject.getObject(paths[i]);
            if (astObject == null)
                return null;
        }
        return astObject;
    }

    public static String lookupString(ReadOnlyAstObject astObject, String path) {
        if (astObject == null)
            return null;
        String[] paths = Strings.split(path, ".");
        astObject = lookupObject(astObject, paths, true);
        return astObject == null ? null : astObject.getString(paths[paths.length - 1]);
    }

    public static ReadOnlyAstObject prefixObject(String prefixPath, ReadOnlyAstObject astObject) {
        if (prefixPath == null || prefixPath.isEmpty())
            return astObject;
        String[] paths = Strings.split(prefixPath, ".");
        for (int i = paths.length - 1; i >= 0; i--)
            astObject = createReadOnlySingleKeyAstObject(paths[i], astObject);
        return astObject;
    }

    public static ReadOnlyAstObject createReadOnlyAstObjectFromMap(Map<Object, Object> map, boolean dotKeys, boolean convertMapsToObjects) {
        Map<Object, Object> finalMap;
        if (!dotKeys)
            finalMap = map;
        else {
            finalMap = interpretDotKeys(map);
        }
        return new ReadOnlyAstObject() {
            private ReadOnlyAstArray keysArray;
            @Override
            public ReadOnlyAstArray keys() {
                if (keysArray == null) {
                    keysArray = AST.createReadOnlyAstArrayFromList(new ArrayList<>(finalMap.keySet()));
                }
                return keysArray;
            }

            @Override
            public <T> T get(String key) {
                Object value = finalMap.get(key);
                if (convertMapsToObjects && value instanceof Map) {
                    finalMap.put(key, value = createReadOnlyAstObjectFromMap((Map<Object, Object>) value, false, true));
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

    public static ReadOnlyAstObject createReadOnlySingleKeyAstObject(String singleKey, Object singleValue) {
        return new ReadOnlyAstObject() {
            private ReadOnlyAstArray keysArray;
            @Override
            public ReadOnlyAstArray keys() {
                if (keysArray == null) {
                    keysArray = AST.createReadOnlyAstArrayFromObjects(singleKey);
                }
                return keysArray;
            }

            @Override
            public <T> T get(String key) {
                return key.equals(singleKey) ? (T) singleValue : null;
            }
        };
    }

    public static ReadOnlyAstArray createReadOnlyAstArrayFromList(List<?> keys) {
        return new ReadOnlyAstArray() {
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

    public static ReadOnlyAstArray createReadOnlyAstArrayFromObjects(Object... objects) {
        return new ReadOnlyAstArray() {
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

    public static ReadOnlyAstObject mergeAstObjects(ReadOnlyAstObject... astObjects) {
        if (astObjects.length == 0)
            return null;
        if (astObjects.length == 1)
            return astObjects[0];
        return new ReadOnlyMergedAstObject(true, astObjects);
    }

    public static AstObject cloneObject(ReadOnlyAstObject astObject, AstFactory factory) {
        return (AstObject) new AstCloneVisitor(factory, false).visitTreeObject(astObject);
    }

    public static AstArray cloneArray(ReadOnlyAstArray array, AstFactory factory) {
        return (AstArray) new AstCloneVisitor(factory, false).visitTreeArray(array);
    }

    public static AstObject nativeObject(ReadOnlyAstObject astObject, NativeAstFactory factory) {
        return (AstObject) new AstCloneVisitor(factory, true).visitTreeObject(astObject);
    }

    public static AstArray nativeArray(ReadOnlyAstArray array, NativeAstFactory factory) {
        return (AstArray) new AstCloneVisitor(factory, true).visitTreeArray(array);
    }

    public static Object unwrapNativeObject(ReadOnlyAstObject astObject, NativeAstFactory factory) {
        if (!factory.isNativeObject(astObject)) {
            astObject = nativeObject(astObject, factory);
        }
        return factory.unwrapNativeObject(astObject);
    }

    public static Object unwrapNativeArray(ReadOnlyAstArray array, NativeAstFactory factory) {
        if (!factory.isNativeArray(array)) {
            array = nativeArray(array, factory);
        }
        return factory.unwrapNativeArray(array);
    }

    public static Object nativePlatformObject(ReadOnlyAstObject astObject, NativeAstFactory factory) {
        return null;
    }

    public static Object nativePlatformArray(ReadOnlyAstArray array, NativeAstFactory factory) {
        return null;
    }

}
