package dev.webfx.platform.util.keyobject.formatter;

import dev.webfx.platform.util.keyobject.ReadOnlyIndexedArray;
import dev.webfx.platform.util.keyobject.ReadOnlyKeyObject;
import dev.webfx.platform.util.keyobject.ReadOnlyAstNode;
import dev.webfx.platform.util.keyobject.formatter.spi.AstFormatterProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * @author Bruno Salmon
 */
public final class AstFormatter {

    private final static Map<String, AstFormatterProvider> PROVIDERS = new HashMap<>();

    static {
        //registerProvider(new PropertiesTreeFormatterProvider());
        ServiceLoader.load(AstFormatterProvider.class).forEach(AstFormatter::registerProvider);
    }

    public static void registerProvider(AstFormatterProvider provider) {
        PROVIDERS.put(provider.format(), provider);
    }

    private static AstFormatterProvider getProvider(String format) {
        return PROVIDERS.get(format);
    }

    public static String formatObject(ReadOnlyKeyObject keyObject, String format) {
        return getProvider(format).formatObject(keyObject);
    }

    public static String formatArray(ReadOnlyIndexedArray indexedArray, String format) {
        return getProvider(format).formatArray(indexedArray);
    }

    public static String formatNode(ReadOnlyAstNode formatNode, String format) {
        return getProvider(format).formatNode(formatNode);
    }

}
