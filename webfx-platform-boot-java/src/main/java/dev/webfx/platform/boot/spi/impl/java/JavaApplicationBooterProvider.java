package dev.webfx.platform.boot.spi.impl.java;

import dev.webfx.platform.boot.spi.impl.SimpleApplicationBooterProvider;
import dev.webfx.platform.reflect.RArray;

import java.lang.reflect.Array;

/**
 * @author Bruno Salmon
 */
public class JavaApplicationBooterProvider extends SimpleApplicationBooterProvider {

    public JavaApplicationBooterProvider() {
        RArray.injectJavaArrayNewInstanceMethod(Array::newInstance);
    }
}