package dev.webfx.platform.ast.formatter;

import dev.webfx.platform.ast.ReadOnlyAstNode;
import dev.webfx.platform.ast.ReadOnlyAstArray;
import dev.webfx.platform.ast.ReadOnlyAstObject;
import dev.webfx.platform.ast.formatter.spi.AstFormatterProvider;

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

    public static String formatObject(ReadOnlyAstObject astObject, String format) {
        return getProvider(format).formatObject(astObject);
    }

    public static String formatArray(ReadOnlyAstArray astArray, String format) {
        return getProvider(format).formatArray(astArray);
    }

    public static String formatNode(ReadOnlyAstNode formatNode, String format) {
        return getProvider(format).formatNode(formatNode);
    }

}
