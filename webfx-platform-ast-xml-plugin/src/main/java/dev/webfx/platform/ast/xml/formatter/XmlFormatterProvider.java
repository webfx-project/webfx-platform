package dev.webfx.platform.ast.xml.formatter;

import dev.webfx.platform.ast.ReadOnlyAstArray;
import dev.webfx.platform.ast.ReadOnlyAstNode;
import dev.webfx.platform.ast.ReadOnlyAstObject;
import dev.webfx.platform.ast.spi.formatter.AstFormatterProvider;
import dev.webfx.platform.util.Numbers;

/**
 * @author Bruno Salmon
 */
public class XmlFormatterProvider implements AstFormatterProvider {

    public static XmlFormatterProvider INSTANCE;

    public XmlFormatterProvider() {
        INSTANCE = this;
    }

    @Override
    public String format() {
        return "xml";
    }

    @Override
    public String formatNode(ReadOnlyAstNode astNode) {
        if (astNode.isObject())
            return formatObject((ReadOnlyAstObject) astNode);
        return formatArray((ReadOnlyAstArray) astNode);
    }

    @Override
    public String formatObject(ReadOnlyAstObject astObject) {
        StringBuilder sb = new StringBuilder();
        appendXmlObject(astObject, sb, 0);
        return sb.toString();
    }

    @Override
    public String formatArray(ReadOnlyAstArray astArray) {
        StringBuilder sb = new StringBuilder();
        appendXmlArray(astArray, sb, 0);
        return sb.toString();
    }

    public String formatElement(Object element) {
        StringBuilder sb = new StringBuilder();
        appendElement(element, sb, 0);
        return sb.toString();
    }

    private void appendXmlObject(ReadOnlyAstObject astObject, StringBuilder sb, int indentLevel) {
        ReadOnlyAstArray keys = astObject.keys();
        if (keys.isEmpty()) {
            // Empty object
            return;
        }

        // For each key in the object
        for (int i = 0, size = keys.size(); i < size; i++) {
            String key = keys.getString(i);
            Object value = astObject.get(key);

            // Indent
            indent(sb, indentLevel);

            // Start tag
            sb.append('<').append(key);

            if (value instanceof ReadOnlyAstObject) {
                ReadOnlyAstObject valueObj = (ReadOnlyAstObject) value;
                
                // Check if there's a "value" property that should be treated as content
                Object contentValue = valueObj.get("value");
                if (contentValue != null && !(contentValue instanceof ReadOnlyAstObject) && !(contentValue instanceof ReadOnlyAstArray)) {
                    // Add attributes
                    appendAttributes(valueObj, sb, "value");
                    
                    // Close start tag
                    sb.append('>');
                    
                    // Add content
                    appendScalarValue(contentValue, sb);
                    
                    // End tag
                    sb.append("</").append(key).append('>');
                } else if (valueObj.keys().isEmpty()) {
                    // Empty object, self-closing tag
                    sb.append("/>");
                } else {
                    // Add attributes (if any)
                    appendAttributes(valueObj, sb, null);
                    
                    // Close start tag
                    sb.append('>');
                    
                    // Add nested elements with increased indentation
                    sb.append('\n');
                    appendXmlObject(valueObj, sb, indentLevel + 1);
                    
                    // Indent for end tag
                    indent(sb, indentLevel);
                    
                    // End tag
                    sb.append("</").append(key).append('>');
                }
            } else if (value instanceof ReadOnlyAstArray) {
                // Close start tag
                sb.append('>');
                
                // Add array elements with increased indentation
                sb.append('\n');
                appendXmlArray((ReadOnlyAstArray) value, sb, indentLevel + 1);
                
                // Indent for end tag
                indent(sb, indentLevel);
                
                // End tag
                sb.append("</").append(key).append('>');
            } else if (value == null) {
                // Null value, self-closing tag
                sb.append("/>");
            } else {
                // Scalar value
                sb.append('>');
                appendScalarValue(value, sb);
                sb.append("</").append(key).append('>');
            }
            
            // Add newline after each element
            sb.append('\n');
        }
    }

    private void appendAttributes(ReadOnlyAstObject astObject, StringBuilder sb, String excludeKey) {
        ReadOnlyAstArray keys = astObject.keys();
        for (int i = 0, size = keys.size(); i < size; i++) {
            String key = keys.getString(i);
            if (key.equals(excludeKey)) {
                continue;
            }
            
            Object value = astObject.get(key);
            if (!(value instanceof ReadOnlyAstObject) && !(value instanceof ReadOnlyAstArray)) {
                sb.append(' ').append(key).append('=').append('"');
                appendScalarValue(value, sb);
                sb.append('"');
            }
        }
    }

    private void appendXmlArray(ReadOnlyAstArray astArray, StringBuilder sb, int indentLevel) {
        for (int i = 0, size = astArray.size(); i < size; i++) {
            Object element = astArray.getElement(i);
            appendElement(element, sb, indentLevel);
            if (i < size - 1) {
                sb.append('\n');
            }
        }
    }

    private void appendElement(Object element, StringBuilder sb, int indentLevel) {
        if (element == null) {
            indent(sb, indentLevel);
            sb.append("<null/>");
        } else if (element instanceof ReadOnlyAstObject) {
            appendXmlObject((ReadOnlyAstObject) element, sb, indentLevel);
        } else if (element instanceof ReadOnlyAstArray) {
            appendXmlArray((ReadOnlyAstArray) element, sb, indentLevel);
        } else {
            indent(sb, indentLevel);
            sb.append('<').append("value").append('>');
            appendScalarValue(element, sb);
            sb.append("</").append("value").append('>');
        }
    }

    private void appendScalarValue(Object value, StringBuilder sb) {
        if (value == null) {
            sb.append("null");
        } else if (value instanceof String) {
            appendEscapedXml((String) value, sb);
        } else if (value instanceof Number) {
            sb.append(formatNumber(value));
        } else if (value instanceof Boolean) {
            sb.append(value);
        } else {
            sb.append(value);
        }
    }

    private void appendEscapedXml(String text, StringBuilder sb) {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            switch (c) {
                case '<': sb.append("&lt;"); break;
                case '>': sb.append("&gt;"); break;
                case '&': sb.append("&amp;"); break;
                case '"': sb.append("&quot;"); break;
                case '\'': sb.append("&apos;"); break;
                default: sb.append(c);
            }
        }
    }

    private String formatNumber(Object n) {
        if (n == null)
            throw new IllegalArgumentException("Null pointer");
        testValidity(n);
        return trimNumber(n.toString());
    }

    private String trimNumber(String s) {
        if (s.indexOf('.') > 0 && s.indexOf('e') < 0 && s.indexOf('E') < 0) {
            while (s.endsWith("0"))
                s = s.substring(0, s.length() - 1);
            if (s.endsWith("."))
                s = s.substring(0, s.length() - 1);
        }
        return s;
    }

    private void testValidity(Object o) throws IllegalArgumentException {
        if (o != null) {
            if (o instanceof Double) {
                if (Numbers.ZERO_DOUBLE.equals(o)) {
                    // workaround for xmlvm bug that returns true to new Double(0.0).isInfinite()
                } else if (((Double) o).isInfinite() || ((Double) o).isNaN()) {
                    throw new IllegalArgumentException(
                            "XML does not allow non-finite numbers");
                }
            } else if (o instanceof Float) {
                if (Numbers.ZERO_FLOAT.equals(o)) {
                    // workaround for xmlvm bug that returns true to new Float(0.0).isInfinite()
                } else if (((Float) o).isInfinite() || ((Float) o).isNaN()) {
                    throw new IllegalArgumentException(
                            "XML does not allow non-finite numbers.");
                }
            }
        }
    }

    private void indent(StringBuilder sb, int level) {
        sb.append("  ".repeat(Math.max(0, level))); // Two spaces per level
    }
}