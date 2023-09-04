package dev.webfx.platform.util.keyobject.parser;

import dev.webfx.platform.util.keyobject.ReadOnlyIndexedArray;
import dev.webfx.platform.util.keyobject.ReadOnlyKeyObject;
import dev.webfx.platform.util.keyobject.ReadOnlyAstNode;
import dev.webfx.platform.util.keyobject.parser.spi.AstParserProvider;
import dev.webfx.platform.util.keyobject.parser.spi.impl.properties.PropertiesAstParserProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * @author Bruno Salmon
 */
public final class AstParser {

    private final static Map<String, AstParserProvider> PROVIDERS = new HashMap<>();

    static {
        registerProvider(new PropertiesAstParserProvider());
        ServiceLoader.load(AstParserProvider.class).forEach(AstParser::registerProvider);
    }

    public static void registerProvider(AstParserProvider astParserProvider) {
        PROVIDERS.put(astParserProvider.format(), astParserProvider);
    }

    private static AstParserProvider getProvider(String format) {
        return PROVIDERS.get(format);
    }

    // TODO: add ability to pass a TreeNodeFactory to the parser => ex: parsing Yaml directly into Vert.x Json

    public static ReadOnlyKeyObject parseObject(String text, String format) {
        return getProvider(format).parseObject(text);
    }

    public static ReadOnlyIndexedArray parseArray(String text, String format) {
        return getProvider(format).parseArray(text);
    }

    public static ReadOnlyAstNode parseNode(String text, String format) {
        return getProvider(format).parseNode(text);
    }

}
