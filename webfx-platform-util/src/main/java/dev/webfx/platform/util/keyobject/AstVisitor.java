package dev.webfx.platform.util.keyobject;

/**
 * @author Bruno Salmon
 */
public abstract class AstVisitor {

    public Object visitTreeElement(Object element) {
        if (element instanceof ReadOnlyAstNode)
            return visitTreeNode((ReadOnlyAstNode) element);
        else
            return visitScalar(element);
    }

    public Object visitTreeNode(ReadOnlyAstNode treeNode) {
        if (treeNode != null) {
            if (treeNode.isObject()) {
                return visitTreeObject((ReadOnlyKeyObject) treeNode);
            } else if (treeNode.isArray()) {
                return visitTreeArray((ReadOnlyIndexedArray) treeNode);
            }
        }
        return null;
    }

    public Object visitTreeObject(ReadOnlyKeyObject keyObject) {
        ReadOnlyIndexedArray keys = keyObject.keys();
        for (int i = 0, size = keys.size(); i < size; i++) {
            String key = keys.getString(i);
            visitKeyValue(key, keyObject.get(key), i, size, keyObject);
        }
        return keyObject;
    }

    protected Object visitKeyValue(String key, Object value, int keyIndex, int keyCount, ReadOnlyKeyObject keyObject) {
        return visitTreeElement(value);
    }

    public Object visitTreeArray(ReadOnlyIndexedArray array) {
        for (int i = 0, size = array.size(); i < size; i++) {
            Object element = array.getElement(i);
            visitIndexedValue(element, i, size, array);
        }
        return array;
    }

    protected Object visitIndexedValue(Object value, int keyIndex, int keyCount, ReadOnlyIndexedArray array) {
        return visitTreeElement(value);
    }

    protected Object visitScalar(Object scalar) {
        if (scalar == null)
            return visitNull();
        else if (scalar instanceof String)
            return visitString((String) scalar);
        else if (scalar instanceof Number)
            return visitNumber((Number) scalar);
        else if (scalar instanceof Boolean)
            return visitBoolean((Boolean) scalar);
        else
            return visitOther(scalar);
    }

    protected Object visitNull() {
        return null;
    }

    protected Object visitString(String text) {
        return text;
    }

    protected Object visitNumber(Number number) {
        return number;
    }

    protected Object visitBoolean(boolean b) {
        return b;
    }

    protected Object visitOther(Object other) {
        return other;
    }

}
