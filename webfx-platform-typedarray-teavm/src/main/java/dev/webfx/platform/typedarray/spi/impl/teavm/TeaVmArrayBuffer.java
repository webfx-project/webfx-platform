package dev.webfx.platform.typedarray.spi.impl.teavm;

import dev.webfx.platform.typedarray.ArrayBuffer;

/**
 * @author Bruno Salmon
 */
record TeaVmArrayBuffer(org.teavm.jso.typedarrays.ArrayBuffer tvArrayBuffer) implements ArrayBuffer { }
