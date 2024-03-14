package dev.webfx.platform.ast;

/**
 * @author Bruno Salmon
 */
public abstract class AstVisitor {

    public Object visitAstElement(Object element) {
        if (AST.isNode(element))
            return visitAstNode((ReadOnlyAstNode) element);
        else
            return visitScalar(element);
    }

    public Object visitAstNode(ReadOnlyAstNode astNode) {
        if (astNode != null) {
            if (astNode.isObject()) {
                return visitAstObject((ReadOnlyAstObject) astNode);
            } else if (astNode.isArray()) {
                return visitAstArray((ReadOnlyAstArray) astNode);
            }
        }
        return null;
    }

    public Object visitAstObject(ReadOnlyAstObject astObject) {
        ReadOnlyAstArray keys = astObject.keys();
        for (int i = 0, size = keys.size(); i < size; i++) {
            String key = keys.getString(i);
            visitKeyValue(key, astObject.get(key), i, size, astObject);
        }
        return astObject;
    }

    protected Object visitKeyValue(String key, Object value, int keyIndex, int keyCount, ReadOnlyAstObject astObject) {
        return visitAstElement(value);
    }

    public Object visitAstArray(ReadOnlyAstArray array) {
        for (int i = 0, size = array.size(); i < size; i++) {
            Object element = array.getElement(i);
            visitIndexedValue(element, i, size, array);
        }
        return array;
    }

    protected Object visitIndexedValue(Object value, int keyIndex, int keyCount, ReadOnlyAstArray array) {
        return visitAstElement(value);
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
