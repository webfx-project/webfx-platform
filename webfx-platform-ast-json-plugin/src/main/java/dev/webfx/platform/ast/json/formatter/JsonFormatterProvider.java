package dev.webfx.platform.ast.json.formatter;

import dev.webfx.platform.ast.*;
import dev.webfx.platform.ast.spi.formatter.AstFormatterProvider;
import dev.webfx.platform.util.Numbers;
import dev.webfx.platform.util.Strings;

/**
 * @author Bruno Salmon
 */
public class JsonFormatterProvider implements AstFormatterProvider {

    public static JsonFormatterProvider INSTANCE;

    public JsonFormatterProvider() {
        INSTANCE = this;
    }

    @Override
    public String format() {
        return "json";
    }

    @Override
    public String formatNode(ReadOnlyAstNode astNode) {
        if (astNode.isObject())
            return appendJsonObject((ReadOnlyAstObject) astNode, new StringBuilder()).toString();
        return appendJsonArray((ReadOnlyAstArray) astNode, new StringBuilder()).toString();
    }


    @Override
    public String formatObject(ReadOnlyAstObject astNode) {
        return appendJsonObject(astNode, new StringBuilder()).toString();
    }

    @Override
    public String formatArray(ReadOnlyAstArray ca) {
        return appendJsonArray(ca, new StringBuilder()).toString();
    }

    public String formatElement(Object e) {
        return appendNativeElement(e, new StringBuilder()).toString();
    }

    static StringBuilder appendJsonObject(ReadOnlyAstObject json, StringBuilder sb) {
        sb.append('{');
        boolean first = true;
        ReadOnlyAstArray keys = json.keys();
        for (int i = 0, size = keys.size(); i < size; i++) {
            String key = keys.getString(i);
            if (!first)
                sb.append(',');
            appendQuoted(key, sb);
            sb.append(':');
            appendNativeElement(json.get(key), sb);
            first = false;
        }
        return sb.append('}');
    }

    static StringBuilder appendJsonArray(ReadOnlyAstArray ca, StringBuilder sb) {
        return join(ca, ",", sb.append('[')).append(']');
    }
    /**
     * Make a string from the contents of this JSONArray. The
     * <code>separator</code> string is inserted between each element.
     * Warning: This method assumes that the data structure is acyclical.
     * @param separator A string that will be inserted between the elements.
     * @return a string.
     * @throws IllegalArgumentException If the array contains an invalid number.
     */
    static StringBuilder join(ReadOnlyAstArray ca, String separator, StringBuilder sb) {
        int len = ca.size();
        for (int i = 0; i < len; i += 1) {
            if (i > 0)
                sb.append(separator);
            appendNativeElement(ca.getElement(i), sb);
        }
        return sb;
    }

    /**
     * Make a JSON text of an Object element. If the object has an
     * element.toJSONString() method, then that method will be used to produce
     * the JSON text. The method is required to produce a strictly
     * conforming text. If the object does not contain a toJSONString
     * method (which is the most common case), then a text will be
     * produced by the rules.
     * <p>
     * Warning: This method assumes that the data structure is acyclical.
     *
     * @param element The element to be serialized.
     * @return a printable, displayable, transmittable
     * representation of the object, beginning
     * with <code>{</code>&nbsp;<small>(left brace)</small> and ending
     * with <code>}</code>&nbsp;<small>(right brace)</small>.
     * @throws IllegalArgumentException If the element is or contains an invalid number.
     */
    static StringBuilder appendNativeElement(Object element, StringBuilder sb) {
        if (AST.NATIVE_FACTORY != null) {
            switch (AST.NATIVE_FACTORY.getNativeElementAstType(element)) {
                case NULL:    return sb.append("null");
                case OBJECT:  return appendJsonObject(AST.NATIVE_FACTORY.nativeToReadOnlyAstObject(element), sb);
                case ARRAY:   return appendJsonArray(AST.NATIVE_FACTORY.nativeToReadOnlyAstArray(element), sb);
                case NUMBER:  return sb.append(numberToString(AST.NATIVE_FACTORY.nativeScalarToJavaScalar(element)));
                case BOOLEAN: return sb.append((Boolean) AST.NATIVE_FACTORY.nativeScalarToJavaScalar(element));
                case STRING:  return appendQuoted(AST.NATIVE_FACTORY.nativeScalarToJavaScalar(element), sb);
                default:      return sb.append(element); // ignored when undefined
            }
        } else {
            if (element == null)
                return sb.append("null");
            if (element instanceof String)
                return appendQuoted((String) element, sb);
            if (element instanceof Number)
                return sb.append(numberToString(element));
            if (element instanceof ReadOnlyAstNode) {
                ReadOnlyAstNode node = (ReadOnlyAstNode) element;
                if (node.isObject())
                    return appendJsonObject((ReadOnlyAstObject) node, sb);
                return appendJsonArray((ReadOnlyAstArray) node, sb);
            }
            return sb.append(element);
        }
    }

    /**
     * Shave off trailing zeros and decimal point, if possible.
     */
    static String trimNumber(String s) {
        if (s.indexOf('.') > 0 && s.indexOf('e') < 0 && s.indexOf('E') < 0) {
            while (s.endsWith("0"))
                s = s.substring(0, s.length() - 1);
            if (s.endsWith("."))
                s = s.substring(0, s.length() - 1);
        }
        return s;
    }

    /**
     * Produce a string from a Number.
     * @param  n A Number
     * @return A String.
     * @throws IllegalArgumentException If n is a non-finite number.
     */
    static String numberToString(Object n) throws IllegalArgumentException {
        if (n == null)
            throw new IllegalArgumentException("Null pointer");
        testValidity(n);
        return trimNumber(n.toString());
    }

    /**
     * Throw an exception if the object is an NaN or infinite number.
     * @param o The object to test.
     * @throws IllegalArgumentException If o is a non-finite number.
     */
    static void testValidity(Object o) throws IllegalArgumentException {
        if (o != null) {
            if (o instanceof Double) {
                if ( Numbers.ZERO_DOUBLE.equals(o)){
                    // workaround for xmlvm bug that returns true to new Double(0.0).isInfinite()
                } else if (((Double)o).isInfinite() || ((Double)o).isNaN()) {
                    throw new IllegalArgumentException(
                            "JSON does not allow non-finite numbers");
                }
            } else if (o instanceof Float) {
                if ( Numbers.ZERO_FLOAT.equals(o) ){
                    // workaround for xmlvm bug that returns true to new Float(0.0).isInfinite()
                } else if (((Float)o).isInfinite() || ((Float)o).isNaN()) {
                    throw new IllegalArgumentException(
                            "JSON does not allow non-finite numbers.");
                }
            }
        }
    }

    /**
     * Produce a string in double quotes with backslash sequences in all the
     * right places. A backslash will be inserted within HTML tags, allowing JSON
     * text to be delivered in HTML. In JSON text, a string cannot contain a
     * control character or an unescaped quote or backslash.
     * @param string A String
     * @return  A String correctly formatted for insertion in a JSON text.
     */
    static StringBuilder appendQuoted(String string, StringBuilder sb) {
        if (Strings.isEmpty(string))
            return sb.append("\"\"");

        char         b;
        char         c = 0;
        int          i;
        int          len = string.length();
        String       t;

        sb.append('"');
        for (i = 0; i < len; i += 1) {
            b = c;
            c = string.charAt(i);
            switch (c) {
                case '\\':
                case '"':
                    sb.append('\\');
                    sb.append(c);
                    break;
                case '/':
                    // Only escape '/' when it follows '<' (for HTML safety)
                    if (b == '<') {
                        sb.append('\\');
                    }
                    sb.append(c);
                    break;
                case '\b':
                    sb.append("\\b");
                    break;
                case '\t':
                    sb.append("\\t");
                    break;
                case '\n':
                    sb.append("\\n");
                    break;
                case '\f':
                    sb.append("\\f");
                    break;
                case '\r':
                    sb.append("\\r");
                    break;
                default:
                    if (c < ' ') {
                        // Control characters (0x00-0x1F) need to be escaped with Unicode notation
                        t = "000" + Integer.toHexString(c);
                        sb.append("\\u").append(t.substring(t.length() - 4));
                    } else if (c >= '\uD800' && c <= '\uDBFF' && i + 1 < len) {
                        // Handle surrogate pairs for characters outside the BMP
                        // High surrogate is between 0xD800 and 0xDBFF
                        char next = string.charAt(i + 1);
                        // Low surrogate is between 0xDC00 and 0xDFFF
                        if (next >= '\uDC00' && next <= '\uDFFF') {
                            // This is a valid surrogate pair, append both characters
                            sb.append(c);
                            sb.append(next);
                            i++; // Skip the next character as we've already processed it
                        } else {
                            // Invalid surrogate pair, just append the current character
                            sb.append(c);
                        }
                    } else {
                        // Regular character, append as-is
                        sb.append(c);
                    }
            }
        }
        return sb.append('"');
    }
}
