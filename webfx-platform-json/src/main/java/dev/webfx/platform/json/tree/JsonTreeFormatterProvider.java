package dev.webfx.platform.json.tree;

import dev.webfx.platform.json.JsonFormatter;
import dev.webfx.platform.util.keyobject.ReadOnlyIndexedArray;
import dev.webfx.platform.util.keyobject.ReadOnlyKeyObject;
import dev.webfx.platform.util.keyobject.ReadOnlyAstNode;
import dev.webfx.platform.util.keyobject.formatter.spi.AstFormatterProvider;
import dev.webfx.platform.util.keyobject.AstVisitor;

/**
 * @author Bruno Salmon
 */
public class JsonTreeFormatterProvider implements AstFormatterProvider {

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
        public Object visitTreeObject(ReadOnlyKeyObject keyObject) {
            sb.append('{');
            super.visitTreeObject(keyObject);
            return sb.append('}');
        }

        @Override
        protected Object visitKeyValue(String key, Object value, int keyIndex, int keyCount, ReadOnlyKeyObject keyObject) {
            if (keyIndex > 0)
                sb.append(',');
            JsonFormatter.appendQuoted(key, sb).append(':');
            return super.visitKeyValue(key, value, keyIndex, keyCount, keyObject);
        }

        @Override
        public Object visitTreeArray(ReadOnlyIndexedArray array) {
            sb.append('[');
            super.visitTreeArray(array);
            return sb.append(']');
        }

        @Override
        protected Object visitIndexedValue(Object value, int keyIndex, int keyCount, ReadOnlyIndexedArray array) {
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
