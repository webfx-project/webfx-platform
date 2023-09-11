package dev.webfx.platform.ast.yaml.formatter;

import dev.webfx.platform.ast.*;
import dev.webfx.platform.ast.formatter.spi.AstFormatterProvider;

/**
 * @author Bruno Salmon
 */
public class YamlFormatterProvider implements AstFormatterProvider {

    @Override
    public String format() {
        return "yaml";
    }

    @Override
    public String formatNode(ReadOnlyAstNode astNode) {
        StringBuilder sb = (StringBuilder) new YamlFormatterVisitor().visitAstNode(astNode);
        return sb.append('\n').toString();
    }

    static class YamlFormatterVisitor extends AstVisitor {
        private final static String INDENT = "  ";
        private final StringBuilder sb = new StringBuilder(/*"---\n"*/);
        private int indentLevel = -1;
        private boolean firstKeyNewLineRequired;
        private StringBuilder newIndentLine() {
            if (sb.length() > 0)
                sb.append('\n');
            // Note: String.repeat() not supported by GWT, so we just do a loop
            for (int i = 0; i < indentLevel; i++)
                sb.append(INDENT);
            return sb;
        }

        @Override
        public Object visitAstObject(ReadOnlyAstObject astObject) {
            indentLevel++;
            super.visitAstObject(astObject);
            indentLevel--;
            return sb;
        }

        @Override
        protected Object visitKeyValue(String key, Object value, int keyIndex, int keyCount, ReadOnlyAstObject astObject) {
            if (keyIndex > 0 || firstKeyNewLineRequired) {
                newIndentLine();
            }
            sb.append(key).append(": ");
            firstKeyNewLineRequired = AST.isObject(value);
            super.visitKeyValue(key, value, keyIndex, keyCount, astObject);
            return sb;
        }

        @Override
        public Object visitAstArray(ReadOnlyAstArray array) {
            indentLevel++;
            super.visitAstArray(array);
            indentLevel--;
            return sb;
        }

        @Override
        protected Object visitIndexedValue(Object value, int keyIndex, int keyCount, ReadOnlyAstArray array) {
            newIndentLine().append("- ");
            super.visitIndexedValue(value, keyIndex, keyCount, array);
            return sb;
        }

        @Override
        protected Object visitNull() {
            //return sb.append("null");
            // return sb.append("~");
            return sb;
        }

        @Override
        protected Object visitString(String text) {
            int length = text.length();
            if (length == 0)
                return sb.append("''");
            char char0 = text.charAt(0);
            boolean startsWithWhitespace = Character.isWhitespace(char0);
            if (text.contains("\n")) {
                //return sb.append('"').append(text.replace("\n", "\\n")).append('"');
                sb.append("|");
                if (startsWithWhitespace)
                    sb.append('2');
                if (!text.endsWith("\n"))
                    sb.append('-');
                else if (length >= 2 && text.charAt(length - 2) == '\n') {
                    sb.append('+');
                }
                indentLevel++;
                newIndentLine();
                for (int i = 0; i < length; i++) {
                    char c = text.charAt(i);
                    if (c != '\n')
                        sb.append(c);
                    else if (i < length - 1)
                        newIndentLine();
                }
                indentLevel--;
                return sb;
            }
            if (startsWithWhitespace || !Character.isLetter(char0))
                return sb.append('\'').append(text).append('\'');
            return sb.append(text);
        }

        @Override
        protected Object visitNumber(Number number) {
            return sb.append(number);
        }

        @Override
        protected Object visitBoolean(boolean b) {
            return sb.append(b);
        }
    }
}
