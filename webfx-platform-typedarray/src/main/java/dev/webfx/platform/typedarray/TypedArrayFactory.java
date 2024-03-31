package dev.webfx.platform.typedarray;

import dev.webfx.platform.typedarray.spi.TypedArrayFactoryProvider;
import dev.webfx.platform.service.SingleServiceProvider;

import java.util.ServiceLoader;

/**
 * @author Bruno Salmon
 */
public final class TypedArrayFactory {

    private static TypedArrayFactoryProvider getProvider() {
        return SingleServiceProvider.getProvider(TypedArrayFactoryProvider.class, () -> ServiceLoader.load(TypedArrayFactoryProvider.class));
    }

    public static TypedArray createFloat32Array(double... array) {
        return getProvider().createFloat32Array(array);
    }

    public static TypedArray createUint16Array(double... array) {
        return getProvider().createUint16Array(array);
    }

    public static TypedArray createUint8Array(double... array) {
        return getProvider().Uint8Array(array);
    }

}
