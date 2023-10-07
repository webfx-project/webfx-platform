package dev.webfx.platform.util.keyobject.parser.spi.impl.properties;

import dev.webfx.platform.util.keyobject.AST;
import dev.webfx.platform.util.keyobject.ReadOnlyAstNode;
import dev.webfx.platform.util.keyobject.ReadOnlyIndexedArray;
import dev.webfx.platform.util.keyobject.ReadOnlyKeyObject;
import dev.webfx.platform.util.keyobject.parser.spi.AstParserProvider;

import java.io.StringReader;
import java.util.Properties;

/**
 * @author Bruno Salmon
 */
public class PropertiesAstParserProvider implements AstParserProvider {

    @Override
    public String format() {
        return "properties";
    }

    private Properties parseProperties(String text) {
        Properties properties = new Properties();
        try {
            properties.load(new StringReader(text));
        } catch (Exception e) {
            //Console.log("WARNING: Ignoring wrong format configuration file " + filePath, e);
        }
        return properties;
    }

    @Override
    public ReadOnlyKeyObject parseObject(String text) {
        Properties properties = parseProperties(text);
        return AST.createReadOnlyKeyObjectFromMap(properties, true, true);
    }

    @Override
    public ReadOnlyIndexedArray parseArray(String text) {
        return null;
    }

    @Override
    public ReadOnlyAstNode parseNode(String text) {
        return parseObject(text);
    }
}
