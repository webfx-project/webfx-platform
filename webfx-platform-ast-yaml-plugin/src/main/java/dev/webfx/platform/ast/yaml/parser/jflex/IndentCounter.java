package dev.webfx.platform.ast.yaml.parser.jflex;

import java.util.ArrayDeque;

import static dev.webfx.platform.ast.yaml.parser.javacup.YamlSymbols.*;

/**
 * @author Bruno Salmon
 */
final class IndentCounter {

    private final ArrayDeque<Integer> indentDeque = new ArrayDeque<>();
    private int lastIndentCausingIndentClose;

    Integer currentIndent() {
        return indentDeque.peekFirst();
    }

    /**
     *
     * @param indent the indent of the new line
     * @return INDENT_OPEN if this new indent is higher than the previous one
     * or INDENT_SAME if this new indent is the same as the previous one
     * or INDENT_CLOSE if this new indent is lower than the previous one
     */
    int indentSymbolOnNewLine(int indent) {
        Integer lastIndent = currentIndent();
        if (lastIndent == null || indent > lastIndent) {
            indentDeque.push(indent);
            return INDENT_OPEN;
        }
        if (indent == lastIndent)
            return INDENT_SAME;
        indentDeque.removeFirst();
        lastIndentCausingIndentClose = indent;
        return INDENT_CLOSE;
    }

    int nextIndentSymbolAfterClose() {
        int nextIndentToPotentiallyClose = currentIndent();
        if (nextIndentToPotentiallyClose == lastIndentCausingIndentClose)
            return INDENT_SAME;
        indentDeque.removeFirst();
        return INDENT_CLOSE;
    }

    int openIndentCount() {
        return indentDeque.size();
    }

    boolean isSubsequentUnquotedStringLine(String line) {
        int currentIndent = currentIndent();
        if (line.length() <= currentIndent)
            return false;
        for (int i = 0; i <= currentIndent; i++)
            if (!Character.isWhitespace(line.charAt(i)))
                return false;
        return true;
    }


    int jsonOpenCurlyBracketCount;

    boolean isInsideJsonSequence() {
        return jsonOpenCurlyBracketCount > 0;
    }

    int getJsonOpenCurlyBracketCount() {
        return jsonOpenCurlyBracketCount;
    }

    int incJsonOpenCurlyBracketCount() {
        return ++jsonOpenCurlyBracketCount;
    }

    int decJsonOpenCurlyBracketCount() {
        return --jsonOpenCurlyBracketCount;
    }

}
