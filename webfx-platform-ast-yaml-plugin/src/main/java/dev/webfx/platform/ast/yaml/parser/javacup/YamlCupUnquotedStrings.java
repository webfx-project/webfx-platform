package dev.webfx.platform.ast.yaml.parser.javacup;

import dev.webfx.platform.util.Strings;

/**
 * @author Bruno Salmon
 */
final class YamlCupUnquotedStrings {

    static String format(String s) {
        return Strings.removeSuffix(s, "\n");
    }

    static String formatPipe(String s) {
        int indent = -1;
        StringBuilder sb = new StringBuilder();
        String[] lines = s.split("\n");
        for (String line : lines) {
            int start;
            if (indent == -1) {
                if (line.isEmpty())
                    continue;
                for (indent = 0; indent < line.length(); indent++)
                    if (line.charAt(indent) != ' ')
                        break;
                start = indent;
            } else {
                for (start = 0; start < line.length() && start < indent; start++) {
                    if (line.charAt(start) != ' ')
                        break;
                }
            }
            sb.append(line.substring(start)).append('\n');
        }
        return sb.toString();
    }

}
