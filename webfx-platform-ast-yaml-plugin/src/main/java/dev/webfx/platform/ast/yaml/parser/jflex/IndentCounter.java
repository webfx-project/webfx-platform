package dev.webfx.platform.ast.yaml.parser.jflex;

import java_cup.runtime.Symbol;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static dev.webfx.platform.ast.yaml.parser.javacup.YamlSymbols.*;

/**
 * @author Bruno Salmon
 */
public final class IndentCounter {

    private final Deque<Integer> indentDeque = new ArrayDeque<>();
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

    List<Symbol> closingAndFurtherIndentsForNewLine() {
        List<Symbol> symbols = new ArrayList<>();
        symbols.add(new Symbol(INDENT_CLOSE));
        while (!indentDeque.isEmpty()) {
            int currentIndent = currentIndent();
            if (currentIndent == lastIndentCausingIndentClose) {
                symbols.add(new Symbol(INDENT_SAME));
                break;
            }
            symbols.add(new Symbol(INDENT_CLOSE));
            indentDeque.removeFirst();
        }
        return symbols;
    }

    public int openIndentCount() {
        return indentDeque.size();
    }

    void clear() {
        indentDeque.clear();
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


    private int jsonOpenCurlyBracketCount;

    boolean isInsideJsonSequence() {
        return jsonOpenCurlyBracketCount > 0;
    }

    int incJsonOpenCurlyBracketCount() {
        return ++jsonOpenCurlyBracketCount;
    }

    int decJsonOpenCurlyBracketCount() {
        return --jsonOpenCurlyBracketCount;
    }

}
