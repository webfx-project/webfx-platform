package dev.webfx.platform.typedarray.spi.impl.elemental2;

import dev.webfx.platform.typedarray.ArrayBuffer;

/**
 * @author Bruno Salmon
 */
record Elemental2ArrayBuffer(elemental2.core.ArrayBuffer e2ArrayBuffer) implements ArrayBuffer { }
