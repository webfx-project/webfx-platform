package dev.webfx.platform.ast;

import dev.webfx.platform.ast.spi.factory.AstFactoryProvider;
import dev.webfx.platform.ast.spi.factory.nativeast.NativeAstFactoryProvider;
import dev.webfx.platform.ast.spi.formatter.AstFormatterProvider;
import dev.webfx.platform.ast.spi.parser.AstParserProvider;
import dev.webfx.platform.ast.spi.parser.impl.properties.PropertiesAstParserProvider;
import dev.webfx.platform.util.Arrays;
import dev.webfx.platform.util.Strings;
import dev.webfx.platform.service.SingleServiceProvider;

import java.util.*;

/**
 * @author Bruno Salmon
 */
public final class AST {

    private AST() {}

    /*==================================================================================================================
     *=============================================== Factory methods ==================================================
     *================================================================================================================*/

    public static NativeAstFactoryProvider NATIVE_FACTORY = getFactoryProvider() instanceof NativeAstFactoryProvider ? (NativeAstFactoryProvider) getFactoryProvider() : null;

    private static AstFactoryProvider getFactoryProvider() {
        return SingleServiceProvider.getProvider(AstFactoryProvider.class, () -> ServiceLoader.load(AstFactoryProvider.class));
    }

    public static AstObject createObject() {
        return getFactoryProvider().createObject();
    }

    public static AstObject createObject(Object nativeObject) {
        if (NATIVE_FACTORY != null)
            return NATIVE_FACTORY.nativeToAstObject(nativeObject);
        return createObject();
    }

    public static AstArray createArray() {
        return getFactoryProvider().createArray();
    }

    public static AstArray createArray(Object nativeObject) {
        if (NATIVE_FACTORY != null)
            return NATIVE_FACTORY.nativeToAstArray(nativeObject);
        return createArray();
    }

    public static boolean isNode(Object value) {
        return value instanceof ReadOnlyAstNode;
    }

    public static boolean isObject(Object value) {
        return isNode(value) && isObject((ReadOnlyAstNode) value);
    }

    public static boolean isObject(ReadOnlyAstNode value) {
        return value.isObject();
    }

    public static boolean isArray(Object value) {
        return isNode(value) && isArray((ReadOnlyAstNode) value);
    }

    public static boolean isArray(ReadOnlyAstNode value) {
        return value.isArray();
    }

    /*==================================================================================================================
     *=============================================== Parser methods ===================================================
     *================================================================================================================*/

    private final static Map<String, AstParserProvider> PARSER_PROVIDERS = new HashMap<>();

    static {
        registerParserProvider(new PropertiesAstParserProvider());
        ServiceLoader.load(AstParserProvider.class).forEach(AST::registerParserProvider);
    }

    private static void registerParserProvider(AstParserProvider astParserProvider) {
        PARSER_PROVIDERS.put(astParserProvider.format(), astParserProvider);
    }

    private static AstParserProvider getParserProvider(String format) {
        AstParserProvider parserProvider = PARSER_PROVIDERS.get(format);
        if (parserProvider == null) {
            String error = "No AST parser registered for format: " + format;
            if ("json".equals(format) || "yaml".equals(format))
                error += ". Please add <plugin-module>webfx-platform-ast-" + format + "-plugin</plugin-module> under <dependencies/> in your webfx.xml";
            throw new IllegalArgumentException(error);
        }
        return parserProvider;
    }

    public static ReadOnlyAstObject parseObject(String text, String format) {
        return getParserProvider(format).parseObject(text);
    }

    public static <T> T parseAny(String text, String format) {
        return getParserProvider(format).parseAny(text);
    }

    public static ReadOnlyAstArray parseArray(String text, String format) {
        return getParserProvider(format).parseArray(text);
    }

    public static ReadOnlyAstNode parseNode(String text, String format) {
        return getParserProvider(format).parseNode(text);
    }

    public static ReadOnlyAstObject parseObjectSilently(String text, String format) {
        try {
            return parseObject(text, format);
        } catch (Exception e) {
            return null;
        }
    }

    public static <T> T parseAnySilently(String text, String format) {
        try {
            return parseAny(text, format);
        } catch (Exception e) {
            return null;
        }
    }

    public static ReadOnlyAstArray parseArraySilently(String text, String format) {
        try {
            return parseArray(text, format);
        } catch (Exception e) {
            return null;
        }
    }

    public static ReadOnlyAstNode parseNodeSilently(String text, String format) {
        try {
            return parseNode(text, format);
        } catch (Exception e) {
            return null;
        }
    }

    /*==================================================================================================================
     *=============================================== Format methods ===================================================
     *================================================================================================================*/

    private final static Map<String, AstFormatterProvider> FORMATTER_PROVIDERS = new HashMap<>();

    static {
        //registerProvider(new PropertiesTreeFormatterProvider());
        ServiceLoader.load(AstFormatterProvider.class).forEach(AST::registerFormatterProvider);
    }

    private static void registerFormatterProvider(AstFormatterProvider provider) {
        FORMATTER_PROVIDERS.put(provider.format(), provider);
    }

    private static AstFormatterProvider getFormatterProvider(String format) {
        AstFormatterProvider provider = FORMATTER_PROVIDERS.get(format);
        if (provider == null) {
            throw new IllegalArgumentException("Unknown or unloaded format: " + format);
        }
        return provider;
    }

    public static String formatObject(ReadOnlyAstObject astObject, String format) {
        return getFormatterProvider(format).formatObject(astObject);
    }

    public static String formatArray(ReadOnlyAstArray astArray, String format) {
        return getFormatterProvider(format).formatArray(astArray);
    }

    public static String formatNode(ReadOnlyAstNode formatNode, String format) {
        return getFormatterProvider(format).formatNode(formatNode);
    }

    /*==================================================================================================================
     *============================================ Other utility methods ===============================================
     *================================================================================================================*/

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

    public static ReadOnlyAstObject createReadOnlySingleKeyAstObject(String singleKey, Object singleValue) {
        return new ReadOnlyAstObject() {
            private ReadOnlyAstArray keysArray;
            @Override
            public ReadOnlyAstArray keys() {
                if (keysArray == null) {
                    keysArray = AST.objectsToReadOnlyAstArray(singleKey);
                }
                return keysArray;
            }

            @Override
            public <T> T get(String key) {
                return key.equals(singleKey) ? (T) singleValue : null;
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
        // Second pass: moving back dotKeysMap objects to `finalMap` after recursive interpretation (necessary when the
        // map contains keys with several dots)
        if (dotKeysMap != null) {
            for (Map.Entry<String, Map<Object, Object>> entry : dotKeysMap.entrySet()) {
                String key = entry.getKey();
                Map<Object, Object> values = interpretDotKeys(entry.getValue());
                // If there is already a String value registered, we move it to the "text" key. This is a bit of a hack
                // for I18n dictionaries where you can have, for example,
                // SuperAdmin = Super Admin <= Considered as SuperAdmin.text = Super Admin
                // SuperAdmin.graphic = ...
                Object previousValue = finalMap.get(key);
                if (previousValue instanceof String) {
                    values.put("text", previousValue);
                }
                finalMap.put(key, values);
            }
        }
        return finalMap;
    }

    public static ReadOnlyAstObject mapToReadOnlyAstObject(Map<Object, Object> map, boolean dotKeys, boolean convertMapsToObjects) {
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
                    keysArray = AST.listToReadOnlyAstArray(new ArrayList<>(finalMap.keySet()));
                }
                return keysArray;
            }

            @Override
            public <T> T get(String key) {
                Object value = finalMap.get(key);
                if (convertMapsToObjects && value instanceof Map) {
                    finalMap.put(key, value = mapToReadOnlyAstObject((Map<Object, Object>) value, false, true));
                }
                return (T) value;
            }
        };
    }

    public static Map astObjectToMap(ReadOnlyAstObject o) {
        Map map = new HashMap();
        for (Object key : o.keys()) {
            Object value = o.get((String) key);
            map.put(key, astValueToMapList(value));
        }
        return map;
    }

    private static Object astValueToMapList(Object value) {
        if (isObject(value))
            return astObjectToMap((ReadOnlyAstObject) value);
        if (isArray(value))
            return astArrayToList((ReadOnlyAstArray) value);
        return value;
    }

    public static List astArrayToList(ReadOnlyAstArray a) {
        List list = new ArrayList();
        for (Object value : a) {
            list.add(astValueToMapList(value));
        }
        return list;
    }

    public static ReadOnlyAstArray listToReadOnlyAstArray(List<?> keys) {
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

    public static ReadOnlyAstArray objectsToReadOnlyAstArray(Object... objects) {
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

    public static AstObject cloneObject(ReadOnlyAstObject astObject) {
        return cloneObject(astObject, getFactoryProvider());
    }

    public static AstObject cloneObject(ReadOnlyAstObject astObject, AstFactoryProvider factory) {
        return (AstObject) new AstCloneVisitor(factory, false).visitAstObject(astObject);
    }

    public static AstArray cloneArray(ReadOnlyAstArray array) {
        return cloneArray(array, getFactoryProvider());
    }

    public static AstArray cloneArray(ReadOnlyAstArray array, AstFactoryProvider factory) {
        return (AstArray) new AstCloneVisitor(factory, false).visitAstArray(array);
    }

    public static AstObject mergeInto(ReadOnlyAstObject src, AstObject dst) {
        return mergeInto(src, dst, src.keys());
    }

    public static AstObject mergeInto(ReadOnlyAstObject src, AstObject dst, ReadOnlyAstArray keys) {
        for (int i = 0, size = keys.size(); i < size; i++) {
            String key = keys.getString(i);
            Object value = src.get(key);
            dst.set(key, value);
        }
        return dst;
    }

}
