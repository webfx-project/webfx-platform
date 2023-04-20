package dev.webfx.platform.util;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * @author Bruno Salmon
 */
public final class Objects {

    private static Map<Class, Predicate> INSTANCE_OF_PREDICATES = null; // used by registerInstanceOf() and InstanceOf()

    public static <T> T coalesce(T... ts) {
        for (T t : ts)
            if (t != null)
                return t;
        return null;
    }

    public static boolean nonNull(Object obj) {
        return obj != null;
    }

    public static <T> boolean allNulls(T... ts) {
        return coalesce(ts) == null;
    }

    public static <T> boolean anyNotNull(T... ts) {
        return !allNulls(ts);
    }

    public static boolean areEquals(Object o1, Object o2) {
        if (o1 == o2)
            return true;
        if (o1 == null || o2 == null)
            return false;
        if (o1 instanceof Object[] && o2 instanceof Object[]) {
            Object[] a1 = (Object[]) o1;
            Object[] a2 = (Object[]) o2;
            if (a1.length != a2.length)
                return false;
            for (int i = 0; i < a1.length; i++)
                if (!areEquals(a1[i], a2[i]))
                    return false;
            return true;
        }
        return o1.equals(o2);
    }

    // isAssignableFrom() is a GWT compatible version but simplified version of Class.isAssignableFrom() as it considers
    // only super classes (doesn't work with interfaces).

    public static boolean isAssignableFrom(Class<?> leftClass, Class<?> rightClass) {
        if (leftClass != null)
            while (rightClass != null) {
                if (leftClass.equals(rightClass))
                    return true;
                rightClass = rightClass.getSuperclass();
            }
        return false;
    }

    // isInstanceOf() is a GWT compatible version but simplified version of Class.isInstance() as it considers
    // only super classes (doesn't work with interfaces). However, it's possible to register instanceOf predicates
    // make it work with interfaces.

    public static boolean isInstanceOf(Object object, Class<?> clazz) {
        if (object == null)
            return false;
        Predicate<Object> predicate = INSTANCE_OF_PREDICATES.get(clazz);
        if (predicate != null)
            return predicate.test(object);
        return isAssignableFrom(clazz, object.getClass());
    }

    // Usage: Objects.registerInstanceOf(MyInterface.class, o -> o instanceof MyInterface);

    public static <T> void registerInstanceOf(Class<T> clazz, Predicate predicate) {
        if (INSTANCE_OF_PREDICATES == null)
            INSTANCE_OF_PREDICATES = new HashMap<>();
        INSTANCE_OF_PREDICATES.put(clazz, predicate);
    }
}
