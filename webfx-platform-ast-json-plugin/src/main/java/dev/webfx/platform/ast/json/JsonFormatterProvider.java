package dev.webfx.platform.ast.json;

import dev.webfx.platform.ast.AstVisitor;
import dev.webfx.platform.ast.ReadOnlyAstArray;
import dev.webfx.platform.ast.ReadOnlyAstNode;
import dev.webfx.platform.ast.ReadOnlyAstObject;
import dev.webfx.platform.ast.formatter.spi.AstFormatterProvider;

/**
 * @author Bruno Salmon
 */
public class JsonFormatterProvider implements AstFormatterProvider {

    @Override
    public String format() {
        return "json";
    }

    @Override
    public String formatNode(ReadOnlyAstNode treeNode) {
        // For native Json elements
        //if (treeNode instanceof JsonElement)
        //    return ((JsonElement) treeNode).toJsonString();
        // For Java Json elements
        return new FormatterVisitor().visitTreeNode(treeNode).toString();
    }

    static class FormatterVisitor extends AstVisitor {
        private final StringBuilder sb = new StringBuilder();

        @Override
        public Object visitTreeObject(ReadOnlyAstObject astObject) {
            sb.append('{');
            super.visitTreeObject(astObject);
            return sb.append('}');
        }

        @Override
        protected Object visitKeyValue(String key, Object value, int keyIndex, int keyCount, ReadOnlyAstObject astObject) {
            if (keyIndex > 0)
                sb.append(',');
            JsonFormatter.appendQuoted(key, sb).append(':');
            return super.visitKeyValue(key, value, keyIndex, keyCount, astObject);
        }

        @Override
        public Object visitTreeArray(ReadOnlyAstArray array) {
            sb.append('[');
            super.visitTreeArray(array);
            return sb.append(']');
        }

        @Override
        protected Object visitIndexedValue(Object value, int keyIndex, int keyCount, ReadOnlyAstArray array) {
            if (keyIndex > 0)
                sb.append(',');
            return super.visitIndexedValue(value, keyIndex, keyCount, array);
        }

        @Override
        protected Object visitNull() {
            return sb.append("null");
        }

        @Override
        protected Object visitString(String text) {
            return JsonFormatter.appendQuoted(text, sb);
        }

        @Override
        protected Object visitNumber(Number number) {
            return sb.append(JsonFormatter.numberToString(number));
        }

        @Override
        protected Object visitBoolean(boolean b) {
            return sb.append(b);
        }
    }
}
