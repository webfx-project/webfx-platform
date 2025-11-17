package dev.webfx.platform.typedarray.spi.impl.teavm;

import dev.webfx.platform.typedarray.SharedArrayBuffer;

/**
 * @author Bruno Salmon
 */
record TeaVmSharedArrayBuffer(org.teavm.jso.typedarrays.SharedArrayBuffer tvSharedArrayBuffer) implements SharedArrayBuffer { }
