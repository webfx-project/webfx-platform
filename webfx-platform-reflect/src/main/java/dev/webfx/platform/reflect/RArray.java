package dev.webfx.platform.reflect;

import dev.webfx.platform.console.Console;

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
        Console.warn("No array constructor found for " + componentType + ", using new Object[] instead");
        return new Object[length];
    }

    static {
        // Registering array constructors for primitive types for GWT/J2CL (not necessary for Java but doesn't matter)
        register(Object.class,  Object[]::new);
        register(String.class,  String[]::new);
        register(Boolean.class, Boolean[]::new);
        register(Integer.class, Integer[]::new);
        register(Long.class,    Long[]::new);
        register(Short.class,   Short[]::new);
        register(Byte.class,    Byte[]::new);
        register(Double.class,  Double[]::new);
        register(Float.class,   Float[]::new);
    }
}
