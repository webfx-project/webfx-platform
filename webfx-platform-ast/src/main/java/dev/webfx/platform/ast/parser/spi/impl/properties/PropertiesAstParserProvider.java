package dev.webfx.platform.ast.parser.spi.impl.properties;

import dev.webfx.platform.ast.parser.spi.AstParserProvider;
import dev.webfx.platform.ast.ReadOnlyAstArray;
import dev.webfx.platform.ast.ReadOnlyAstObject;
import dev.webfx.platform.ast.ReadOnlyAstNode;
import dev.webfx.platform.ast.AST;

import java.io.ByteArrayInputStream;
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
            properties.load(new ByteArrayInputStream(text.getBytes()));
        } catch (Exception e) {
            //Console.log("WARNING: Ignoring wrong format configuration file " + filePath, e);
        }
        return properties;
    }

    @Override
    public ReadOnlyAstObject parseObject(String text) {
        Properties properties = parseProperties(text);
        return AST.createReadOnlyAstObjectFromMap(properties, true, true);
    }

    @Override
    public ReadOnlyAstArray parseArray(String text) {
        return null;
    }

    @Override
    public ReadOnlyAstNode parseNode(String text) {
        return parseObject(text);
    }
}
