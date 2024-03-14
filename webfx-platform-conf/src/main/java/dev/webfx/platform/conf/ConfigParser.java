package dev.webfx.platform.conf;

import dev.webfx.platform.ast.AST;
import dev.webfx.platform.ast.ReadOnlyAstObject;
import dev.webfx.platform.conf.impl.RootConfig;

/**
 * @author Bruno Salmon
 */
public class ConfigParser {

    public static Config parseConfig(String configText, String format) {
        return parsePrefixedConfig(null, configText, format);
    }

    public static Config parsePrefixedConfig(String prefixPath, String configText, String format) {
        // Parsing the object with the format given by the extension
        ReadOnlyAstObject astObject = AST.parseObject(configText, format);
        if (prefixPath != null) {
            astObject = AST.prefixObject(prefixPath, astObject);
        }
        return new RootConfig(astObject);
    }

    public static Config parseConfigFile(String fileContent, String filePath) {
        // We determine the format and the prefixPath from the filePath and then call parsePrefixedConfig()
        // So, first, we just keep the short file name
        int lastSlashIndex = filePath.lastIndexOf('/');
        if (lastSlashIndex > 0) {
            filePath = filePath.substring(lastSlashIndex + 1);
        }
        // Then we get the format from the file extension
        int lastDotIndex = filePath.lastIndexOf('.');
        String format = filePath.substring(lastDotIndex + 1);
        // Now removing the extension from the short file name
        filePath = filePath.substring(0, lastDotIndex);
        // Also, ignoring possible annotations such as override@
        int atIndex = filePath.lastIndexOf('@');
        if (atIndex >= 0)
            filePath = filePath.substring(atIndex + 1);
        // Now this short file name without extension will act as the prefix path, unless it contains "-" (like for
        // "src-root") where in that case, it's considered to be a root configuration path (no prefix)
        String prefixPath = filePath.contains("-") ? null : filePath;
        return parsePrefixedConfig(prefixPath, fileContent, format);
    }

}
