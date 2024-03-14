package dev.webfx.platform.ast;

import dev.webfx.platform.ast.spi.factory.AstFactoryProvider;
import dev.webfx.platform.ast.spi.factory.nativeast.NativeAstFactoryProvider;
import dev.webfx.platform.ast.spi.formatter.AstFormatterProvider;
import dev.webfx.platform.ast.spi.parser.AstParserProvider;
import dev.webfx.platform.ast.spi.parser.impl.properties.PropertiesAstParserProvider;
import dev.webfx.platform.util.Arrays;
import dev.webfx.platform.util.Strings;
import dev.webfx.platform.util.serviceloader.SingleServiceProvider;

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
        return PARSER_PROVIDERS.get(format);
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

    public static AstObject cloneObject(ReadOnlyAstObject astObject, AstFactoryProvider factory) {
        return (AstObject) new AstCloneVisitor(factory, false).visitAstObject(astObject);
    }

    public static AstArray cloneArray(ReadOnlyAstArray array, AstFactoryProvider factory) {
        return (AstArray) new AstCloneVisitor(factory, false).visitAstArray(array);
    }

    public static AstObject nativeObject(ReadOnlyAstObject astObject, NativeAstFactoryProvider factory) {
        return (AstObject) new AstCloneVisitor(factory, true).visitAstObject(astObject);
    }

    public static AstArray nativeArray(ReadOnlyAstArray array, NativeAstFactoryProvider factory) {
        return (AstArray) new AstCloneVisitor(factory, true).visitAstArray(array);
    }

    public static Object unwrapNativeObject(ReadOnlyAstObject astObject, NativeAstFactoryProvider factory) {
        if (!factory.isAstObjectFromThisFactory(astObject)) {
            astObject = nativeObject(astObject, factory);
        }
        return factory.astToNativeObject(astObject);
    }

    public static Object unwrapNativeArray(ReadOnlyAstArray array, NativeAstFactoryProvider factory) {
        if (!factory.isAstArrayFromThisFactory(array)) {
            array = nativeArray(array, factory);
        }
        return factory.astToNativeArray(array);
    }

    public static Object nativePlatformObject(ReadOnlyAstObject astObject, NativeAstFactoryProvider factory) {
        return null;
    }

    public static Object nativePlatformArray(ReadOnlyAstArray array, NativeAstFactoryProvider factory) {
        return null;
    }

    public static <T> AstArray fromJavaArray(T[] javaArray) {
        if (javaArray == null)
            return null;
        AstArray valuesArray = createArray();
        for (Object javaValue : javaArray)
            valuesArray.push(javaValue);
        return valuesArray;
    }

    public static Object[] toJavaArray(ReadOnlyAstArray jsonArray) {
        if (jsonArray == null)
            return null;
        int length = jsonArray.size();
        Object[] javaArray = new Object[length];
        for (int i = 0; i < length; i++)
            javaArray[i] = jsonArray.getElement(i);
        return javaArray;
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
