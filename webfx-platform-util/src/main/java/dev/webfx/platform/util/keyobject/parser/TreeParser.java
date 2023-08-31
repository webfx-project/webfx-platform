package dev.webfx.platform.util.keyobject.parser;

import dev.webfx.platform.util.keyobject.ReadOnlyIndexedArray;
import dev.webfx.platform.util.keyobject.ReadOnlyKeyObject;
import dev.webfx.platform.util.keyobject.parser.spi.TreeParserProvider;
import dev.webfx.platform.util.keyobject.parser.spi.impl.properties.PropertiesTreeParserProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * @author Bruno Salmon
 */
public final class TreeParser {

    private final static Map<String, TreeParserProvider> PROVIDERS = new HashMap<>();

    static {
        registerProvider(new PropertiesTreeParserProvider());
        ServiceLoader.load(TreeParserProvider.class).forEach(TreeParser::registerProvider);
    }

    public static void registerProvider(TreeParserProvider treeParserProvider) {
        PROVIDERS.put(treeParserProvider.format(), treeParserProvider);
    }

    public static TreeParserProvider getParser(String format) {
        return PROVIDERS.get(format);
    }

    public static ReadOnlyKeyObject parseObject(String text, String format) {
        return getParser(format).parseObject(text);
    }

    public static ReadOnlyIndexedArray parseArray(String text, String format) {
        return getParser(format).parseArray(text);
    }

}
