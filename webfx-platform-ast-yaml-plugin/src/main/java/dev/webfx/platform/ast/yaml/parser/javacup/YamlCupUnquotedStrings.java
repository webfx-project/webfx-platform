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
        // Check for indentation and chomping indicators
        char indentIndicator = '\0';
        char chompIndicator = '\0';

        if (!s.isEmpty() && Character.isDigit(s.charAt(0))) {
            indentIndicator = s.charAt(0);
            s = s.substring(1);
        }

        if (!s.isEmpty() && (s.charAt(0) == '-' || s.charAt(0) == '+')) {
            chompIndicator = s.charAt(0);
            s = s.substring(1);
        }

        int additionalIndent = indentIndicator == '\0' ? 0 : Character.getNumericValue(indentIndicator);

        int indent = -1;
        StringBuilder sb = new StringBuilder();
        String[] lines = s.split("\n");

        // Skip empty lines at the beginning
        int startLine = 0;
        while (startLine < lines.length && lines[startLine].trim().isEmpty()) {
            startLine++;
        }

        for (int i = startLine; i < lines.length; i++) {
            String line = lines[i];
            int start;

            if (indent == -1) {
                if (line.isEmpty())
                    continue;
                for (indent = 0; indent < line.length(); indent++)
                    if (line.charAt(indent) != ' ')
                        break;
                start = indent + additionalIndent;
            } else {
                for (start = 0; start < line.length() && start < indent; start++) {
                    if (line.charAt(start) != ' ')
                        break;
                }
            }

            // Handle empty lines
            if (line.trim().isEmpty()) {
                sb.append('\n');
                continue;
            }

            sb.append(line.substring(start)).append('\n');
        }

        // Handle chomping indicator
        String result = sb.toString();
        if (chompIndicator == '-') {
            // Strip: remove all trailing newlines
            result = Strings.removeSuffix(result, "\n");
        } else if (chompIndicator != '+') {
            // Clip (default): keep one trailing newline
            while (result.endsWith("\n\n")) {
                result = result.substring(0, result.length() - 1);
            }
        }
        // Keep: keep all trailing newlines (nothing to do for '+')

        return result;
    }

    static String formatFolded(String s) {
        // Check for indentation and chomping indicators
        char indentIndicator = '\0';
        char chompIndicator = '\0';

        if (!s.isEmpty() && Character.isDigit(s.charAt(0))) {
            indentIndicator = s.charAt(0);
            s = s.substring(1);
        }

        if (!s.isEmpty() && (s.charAt(0) == '-' || s.charAt(0) == '+')) {
            chompIndicator = s.charAt(0);
            s = s.substring(1);
        }

        int additionalIndent = indentIndicator == '\0' ? 0 : Character.getNumericValue(indentIndicator);

        int indent = -1;
        StringBuilder sb = new StringBuilder();
        String[] lines = s.split("\n");
        String previousLine = null;

        // Skip empty lines at the beginning
        int startLine = 0;
        while (startLine < lines.length && lines[startLine].trim().isEmpty()) {
            startLine++;
        }

        for (int i = startLine; i < lines.length; i++) {
            String line = lines[i];
            int start;

            if (indent == -1) {
                if (line.isEmpty())
                    continue;
                for (indent = 0; indent < line.length(); indent++)
                    if (line.charAt(indent) != ' ')
                        break;
                start = indent + additionalIndent;
            } else {
                for (start = 0; start < line.length() && start < indent; start++) {
                    if (line.charAt(start) != ' ')
                        break;
                }
            }

            String processedLine = line.substring(Math.min(start, line.length()));

            // Handle folding: replace newlines with spaces except in special cases
            if (previousLine != null && !previousLine.isEmpty()) {
                // If current line is empty, preserve the newline and add another one
                // This creates a line break in the output
                if (processedLine.isEmpty()) {
                    sb.append("\n\n");
                }
                // If current line has more indentation than base indent, preserve the newline
                // This preserves the line break for more indented content
                else if (start > indent) {
                    sb.append('\n').append(processedLine);
                }
                // Otherwise, replace newline with space (folding)
                else {
                    sb.append(' ').append(processedLine);
                }
            } else {
                sb.append(processedLine);
            }

            previousLine = processedLine;
        }

        // Handle chomping indicator
        String result = sb.toString();
        if (chompIndicator == '-') {
            // Strip: remove all trailing newlines
            result = Strings.removeSuffix(result, "\n");
        } else if (chompIndicator != '+') {
            // Clip (default): ensure exactly one trailing newline
            result = Strings.removeSuffix(result, "\n") + "\n";
        }
        // Keep: keep all trailing newlines (nothing to do for '+')

        return result;
    }

}
