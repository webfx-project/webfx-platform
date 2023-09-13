package dev.webfx.platform.ast.yaml.formatter;

import dev.webfx.platform.util.keyobject.ReadOnlyIndexedArray;
import dev.webfx.platform.util.keyobject.ReadOnlyKeyObject;
import dev.webfx.platform.util.keyobject.ReadOnlyAstNode;
import dev.webfx.platform.util.keyobject.AstVisitor;
import dev.webfx.platform.util.keyobject.formatter.spi.AstFormatterProvider;

/**
 * @author Bruno Salmon
 */
public class YamlFormatterProvider implements AstFormatterProvider {

    @Override
    public String format() {
        return "yaml";
    }

    @Override
    public String formatNode(ReadOnlyAstNode treeNode) {
        return new FormatterVisitor().visitTreeNode(treeNode).toString();
    }

    static class FormatterVisitor extends AstVisitor {
        private final StringBuilder sb = new StringBuilder();

        @Override
        public Object visitTreeObject(ReadOnlyKeyObject keyObject) {
            boolean rootObject = sb.length() == 0;
            if (!rootObject)
                sb.append('{');
            super.visitTreeObject(keyObject);
            if (!rootObject)
                sb.append('}');
            return sb;
        }

        @Override
        protected Object visitKeyValue(String key, Object value, int keyIndex, int keyCount, ReadOnlyKeyObject keyObject) {
            if (keyIndex > 0)
                sb.append(',');
            sb.append(key).append(':');
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
    }}