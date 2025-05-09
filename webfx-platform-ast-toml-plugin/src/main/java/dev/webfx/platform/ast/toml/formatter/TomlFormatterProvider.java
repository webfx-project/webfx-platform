package dev.webfx.platform.ast.toml.formatter;

import dev.webfx.platform.ast.*;
import dev.webfx.platform.ast.spi.formatter.AstFormatterProvider;
import dev.webfx.platform.util.Numbers;
import dev.webfx.platform.util.Strings;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Bruno Salmon
 */
public class TomlFormatterProvider implements AstFormatterProvider {

    public static TomlFormatterProvider INSTANCE;

    public TomlFormatterProvider() {
        INSTANCE = this;
    }

    @Override
    public String format() {
        return "toml";
    }

    @Override
    public String formatNode(ReadOnlyAstNode astNode) {
        if (astNode.isObject())
            return formatObject((ReadOnlyAstObject) astNode);
        return formatArray((ReadOnlyAstArray) astNode);
    }

    @Override
    public String formatObject(ReadOnlyAstObject astObject) {
        return appendTomlObject(astObject, new StringBuilder(), "").toString();
    }

    @Override
    public String formatArray(ReadOnlyAstArray astArray) {
        return appendTomlArray(astArray, new StringBuilder()).toString();
    }

    public String formatElement(Object e) {
        return appendNativeElement(e, new StringBuilder()).toString();
    }

    static StringBuilder appendTomlObject(ReadOnlyAstObject tomlObject, StringBuilder sb, String prefix) {
        ReadOnlyAstArray keys = tomlObject.keys();
        for (int i = 0, size = keys.size(); i < size; i++) {
            String key = keys.getString(i);
            Object value = tomlObject.get(key);
            
            if (value instanceof ReadOnlyAstObject) {
                String newPrefix = prefix.isEmpty() ? key : prefix + "." + key;
                sb.append("[").append(newPrefix).append("]\n");
                appendTomlObject((ReadOnlyAstObject) value, sb, newPrefix);
            } else if (value instanceof ReadOnlyAstArray) {
                sb.append(key).append(" = ");
                appendTomlArray((ReadOnlyAstArray) value, sb);
                sb.append("\n");
            } else {
                sb.append(key).append(" = ");
                appendNativeElement(value, sb);
                sb.append("\n");
            }
        }
        return sb;
    }

    static StringBuilder appendTomlArray(ReadOnlyAstArray array, StringBuilder sb) {
        sb.append("[");
        boolean first = true;
        for (int i = 0; i < array.size(); i++) {
            if (!first)
                sb.append(", ");
            appendNativeElement(array.getElement(i), sb);
            first = false;
        }
        return sb.append("]");
    }

    static StringBuilder appendNativeElement(Object element, StringBuilder sb) {
        if (AST.NATIVE_FACTORY != null) {
            switch (AST.NATIVE_FACTORY.getNativeElementAstType(element)) {
                case NULL:    return sb.append("null");
                case OBJECT:  return appendTomlObject(AST.NATIVE_FACTORY.nativeToReadOnlyAstObject(element), sb, "");
                case ARRAY:   return appendTomlArray(AST.NATIVE_FACTORY.nativeToReadOnlyAstArray(element), sb);
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
            if (element instanceof Boolean)
                return sb.append(element);
            if (element instanceof LocalDate)
                return sb.append(((LocalDate) element).format(DateTimeFormatter.ISO_LOCAL_DATE));
            if (element instanceof LocalTime)
                return sb.append(((LocalTime) element).format(DateTimeFormatter.ISO_LOCAL_TIME));
            if (element instanceof LocalDateTime)
                return sb.append(((LocalDateTime) element).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            if (element instanceof Instant)
                return sb.append(DateTimeFormatter.ISO_INSTANT.format((Instant) element));
            if (element instanceof ReadOnlyAstNode) {
                ReadOnlyAstNode node = (ReadOnlyAstNode) element;
                if (node.isObject())
                    return appendTomlObject((ReadOnlyAstObject) node, sb, "");
                return appendTomlArray((ReadOnlyAstArray) node, sb);
            }
            return sb.append(element);
        }
    }

    static String numberToString(Object n) throws IllegalArgumentException {
        if (n == null)
            throw new IllegalArgumentException("Null pointer");
        testValidity(n);
        return trimNumber(n.toString());
    }

    static String trimNumber(String s) {
        if (s.indexOf('.') > 0 && s.indexOf('e') < 0 && s.indexOf('E') < 0) {
            while (s.endsWith("0"))
                s = s.substring(0, s.length() - 1);
            if (s.endsWith("."))
                s = s.substring(0, s.length() - 1);
        }
        return s;
    }

    static void testValidity(Object o) throws IllegalArgumentException {
        if (o != null) {
            if (o instanceof Double) {
                if (Numbers.ZERO_DOUBLE.equals(o)) {
                    // workaround for xmlvm bug that returns true to new Double(0.0).isInfinite()
                } else if (((Double) o).isInfinite() || ((Double) o).isNaN()) {
                    throw new IllegalArgumentException(
                            "TOML does not allow non-finite numbers");
                }
            } else if (o instanceof Float) {
                if (Numbers.ZERO_FLOAT.equals(o)) {
                    // workaround for xmlvm bug that returns true to new Float(0.0).isInfinite()
                } else if (((Float) o).isInfinite() || ((Float) o).isNaN()) {
                    throw new IllegalArgumentException(
                            "TOML does not allow non-finite numbers.");
                }
            }
        }
    }

    static StringBuilder appendQuoted(String string, StringBuilder sb) {
        if (Strings.isEmpty(string))
            return sb.append("\"\"");

        char b;
        char c = 0;
        int i;
        int len = string.length();

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
                        String t = "000" + Integer.toHexString(c);
                        sb.append("\\u").append(t.substring(t.length() - 4));
                    } else {
                        sb.append(c);
                    }
            }
        }
        return sb.append('"');
    }
}