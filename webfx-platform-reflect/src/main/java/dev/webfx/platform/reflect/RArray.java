package dev.webfx.platform.reflect;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author Bruno Salmon
 */
public class RArray {

    private static BiFunction<Class, Integer, Object> JAVA_ARRAY_NEW_INSTANCE_METHOD; // = Array.newInstance() when supported

    private static final Map<Class<?>, Function<Integer, Object>> ARRAY_CONSTRUCTORS = new HashMap<>();

    public static void injectJavaArrayNewInstanceMethod(BiFunction<Class, Integer, Object> javaArrayInstanceSupplier) {
        JAVA_ARRAY_NEW_INSTANCE_METHOD = javaArrayInstanceSupplier;
    }

    public static <T> void register(Class<T> componentType, Function<Integer, T[]> arrayConstructor) {
        ARRAY_CONSTRUCTORS.put(componentType, arrayConstructor::apply);
    }

    public static Object newInstance(Class<?> componentType, int length) {
        if (JAVA_ARRAY_NEW_INSTANCE_METHOD != null)
            return JAVA_ARRAY_NEW_INSTANCE_METHOD.apply(componentType, length);
        Function<Integer, Object> arrayConstructor = ARRAY_CONSTRUCTORS.get(componentType);
        if (arrayConstructor != null)
            return arrayConstructor.apply(length);
        return new Object[length];
    }
}
