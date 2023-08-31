package dev.webfx.platform.util.keyobject.parser.spi.impl.properties;

import dev.webfx.platform.util.keyobject.ReadOnlyIndexedArray;
import dev.webfx.platform.util.keyobject.ReadOnlyKeyObject;
import dev.webfx.platform.util.keyobject.util.TreeUtil;
import dev.webfx.platform.util.keyobject.parser.spi.TreeParserProvider;

import java.io.ByteArrayInputStream;
import java.util.Properties;

/**
 * @author Bruno Salmon
 */
public class PropertiesTreeParserProvider implements TreeParserProvider {

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
    public ReadOnlyKeyObject parseObject(String text) {
        Properties properties = parseProperties(text);
        return TreeUtil.createReadOnlyKeyObjectFromMap(properties, true, true);
    }

    @Override
    public ReadOnlyIndexedArray parseArray(String text) {
        return null;
    }
}
