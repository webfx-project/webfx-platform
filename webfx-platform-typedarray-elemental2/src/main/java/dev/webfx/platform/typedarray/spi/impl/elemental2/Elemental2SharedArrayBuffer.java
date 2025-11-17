package dev.webfx.platform.typedarray.spi.impl.elemental2;

import dev.webfx.platform.typedarray.SharedArrayBuffer;

/**
 * @author Bruno Salmon
 */
record Elemental2SharedArrayBuffer(elemental2.core.SharedArrayBuffer e2SharedArrayBuffer) implements SharedArrayBuffer { }
