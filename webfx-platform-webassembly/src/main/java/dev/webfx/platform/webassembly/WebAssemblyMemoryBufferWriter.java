package dev.webfx.platform.webassembly;

/**
 * @author Bruno Salmon
 */
public interface WebAssemblyMemoryBufferWriter extends WebAssemblyMemoryBufferHolder {

    void writeString(String s);

}
