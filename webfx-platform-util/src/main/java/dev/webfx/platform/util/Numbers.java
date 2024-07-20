package dev.webfx.platform.util;

/**
 * @author Bruno Salmon
 */
public final class Numbers {

    public static final Double ZERO_DOUBLE = 0d;
    public static final Float ZERO_FLOAT = 0f;
    public static final Long ZERO_LONG = 0L;
    public static final Integer ZERO_INTEGER = 0;
    public static final Short ZERO_SHORT = 0;
    public static final Byte ZERO_BYTE = 0;

    public static boolean isZero(Object value) {
        return value != null && (
                value.equals(ZERO_DOUBLE) ||
                value.equals(ZERO_FLOAT) ||
                value == ZERO_LONG ||
                value == ZERO_INTEGER ||
                value == ZERO_SHORT ||
                value == ZERO_BYTE);
    }

    public static boolean isNotZero(Object value) {
        return !isZero(value);
    }

    public static boolean isPositive(Number number) {
        return number != null && number.intValue() >= 0;
    }

    public static boolean isNegative(Number number) {
        return number != null && number.intValue() < 0;
    }

    public static Object negate(Object value) {
        return negate((Number) value);
    }

    public static Number negate(Number value) {
        if (value == null)
            return null;
        if (value instanceof Double)
            return -(Double) value;
        if (value instanceof Float)
            return -(Float) value;
        if (value instanceof Long)
            return -(Long) value;
        if (value instanceof Integer)
            return -(Integer) value;
        if (value instanceof Short)
            return -(Short) value;
        if (value instanceof Byte)
            return -(Byte) value;
        return null;
    }

    public static boolean isNumber(Object value) {
        return value instanceof Number;
    }

    public static boolean isMathematicalInteger(float value) {
        return Float.isFinite(value) && value % 1 == 0;
    }

    public static boolean isMathematicalInteger(double value) {
        return Double.isFinite(value) && value % 1 == 0;
    }

    public static boolean isMathematicalInteger(Number value) {
        if (value == null)
            return false;
        if (value instanceof Double)
            return isMathematicalInteger(value.doubleValue());
        if (value instanceof Float)
            return isMathematicalInteger(value.floatValue());
        return true; // for Long, Integer, Short & Byte
    }

    public static Double asDouble(Object value) {
        return value == null ? null : value instanceof Double ? (Double) value : value instanceof Number ? ((Number) value).doubleValue() : null;
    }

    public static Float asFloat(Object value) {
        return value == null ? null : value instanceof Float ? (Float) value : value instanceof Number ? ((Number) value).floatValue() : null;
    }

    public static Long asLong(Object value) {
        return value == null ? null : value instanceof Long ? (Long) value : value instanceof Number ? ((Number) value).longValue() : null;
    }

    public static Short asShort(Object value){
        return value == null ? null : value instanceof Short ? (Short) value : value instanceof Number ? ((Number) value).shortValue() : null;
    }

    public static Integer asInteger(Object value) {
        return value == null ? null : value instanceof Integer ? (Integer) value : value instanceof Number ? ((Number) value).intValue() : null;
    }

    public static Byte asByte(Object value){
        return value == null ? null : value instanceof Byte ? (Byte) value : value instanceof Number ? ((Number) value).byteValue() : null;
    }

    public static Double parseDouble(String s) {
        if (s == null)
            return null;
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Float parseFloat(String s) {
        if (s == null)
            return null;
        try {
            return Float.parseFloat(s);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Long parseLong(String s) {
        if (s == null)
            return null;
        try {
            return Long.parseLong(s);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Integer parseInteger(String s) {
        if (s == null)
            return null;
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Short parseShort(String s) {
        if (s == null)
            return null;
        try {
            return Short.parseShort(s);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Byte parseByte(String s) {
        if (s == null)
            return null;
        try {
            return Byte.parseByte(s);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Number parseShortestNumber(String s) {
        Long longValue = parseLong(s);
        if (longValue == null)
            return Double.valueOf(s);
        return toShortestNumber(longValue);
    }


    public static Double toDouble(Object value) {
        Double number = asDouble(value);
        if (number != null || value == null)
            return number;
        return parseDouble(value.toString());
    }

    public static Float toFloat(Object value) {
        Float number = asFloat(value);
        if (number != null || value == null)
            return number;
        return parseFloat(value.toString());
    }

    public static Integer toInteger(Object value) {
        Integer number = asInteger(value);
        if (number != null || value == null)
            return number;
        return parseInteger(value.toString());
    }

    public static Long toLong(Object value) {
        Long number = asLong(value);
        if (number != null || value == null)
            return number;
        return parseLong(value.toString());
    }

    public static Short toShort(Object value) {
        Short number = asShort(value);
        if (number != null || value == null)
            return number;
        return parseShort(value.toString());
    }

    public static Byte toByte(Object value) {
        Byte number = asByte(value);
        if (number != null || value == null)
            return number;
        return parseByte(value.toString());
    }


    public static Number toShortestNumber(Double value) {
        if (value == null)
            return null;
        if (isMathematicalInteger(value)) {
            long l = value.longValue();
            if (value == l)
                return toShortestNumber(l);
        }
        return value;
    }

    public static Number toShortestNumber(Float value) {
        if (value == null)
            return null;
        if (isMathematicalInteger(value)) {
            long l = value.longValue();
            if (value == l)
                return toShortestNumber(l);
        }
        return value;
    }

    public static Number toShortestNumber(Long value) {
        if (value == null)
            return null;
        long v = value;
        if (v >= Integer.MIN_VALUE && v <= Integer.MAX_VALUE)
            return toShortestNumber(value.intValue());
        return value;
    }

    public static Number toShortestNumber(Integer value) {
        if (value == null)
            return null;
        int v = value;
        if (v >= Short.MIN_VALUE && v <= Short.MAX_VALUE)
            return toShortestNumber(value.shortValue());
        return value;
    }

    public static Number toShortestNumber(Short value) {
        if (value == null)
            return null;
        short v = value;
        if (v >= Byte.MIN_VALUE && v <= Byte.MAX_VALUE)
            return toShortestNumber(value.byteValue());
        return value;
    }

    public static Number toShortestNumber(Byte value) {
        return value;
    }

    public static Number toShortestNumber(Number value) {
        if (value instanceof Double)
            return toShortestNumber((Double) value);
        if (value instanceof Float)
            return toShortestNumber((Float) value);
        if (value instanceof Long)
            return toShortestNumber((Long) value);
        if (value instanceof Integer)
            return toShortestNumber((Integer) value);
        if (value instanceof Short)
            return toShortestNumber((Short) value);
        return value;
    }

    public static Number toShortestNumber(Object value) {
        if (value == null)
            return null;
        if (value instanceof Number)
            return toShortestNumber((Number) value);
        return parseShortestNumber(value.toString());
    }

    public static double doubleValue(Object value) {
        Double number = toDouble(value);
        return number == null ? 0 : number;
    }

    public static float floatValue(Object value) {
        Float number = toFloat(value);
        return number == null ? 0 : number;
    }

    public static long longValue(Object value) {
        Long number = toLong(value);
        return number == null ? 0 : number;
    }

    public static int intValue(Object value) {
        Integer number = toInteger(value);
        return number == null ? 0 : number;
    }

    public static short shortValue(Object value) {
        Short number = toShort(value);
        return number == null ? 0 : number;
    }

    public static byte byteValue(Object value) {
        Byte number = toByte(value);
        return number == null ? 0 : number;
    }

    public static boolean identicalObjectsOrNumberValues(Object o1, Object o2) {
        if (java.util.Objects.equals(o1, o2))
            return true;
        if (o1 instanceof Number && o2 instanceof Number)
            return identicalNumberValues((Number) o1, (Number) o2);
        return false;
    }

    public static boolean identicalNumberValues(Number n1, Number n2) {
        if (java.util.Objects.equals(n1, n2))
            return true;
        if (!isMathematicalInteger(n1) || !isMathematicalInteger(n2))
            return false;
        return java.util.Objects.equals(toShortestNumber(n1), toShortestNumber(n2));
    }

    public static String twoDigits(int i) {
        return i < 10 ? "0" + i : Integer.toString(i);
    }
}
