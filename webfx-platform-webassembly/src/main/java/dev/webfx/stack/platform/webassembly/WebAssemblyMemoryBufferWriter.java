package dev.webfx.stack.platform.webassembly;

/**
 * @author Bruno Salmon
 */
public interface WebAssemblyMemoryBufferWriter extends WebAssemblyMemoryBufferHolder {

    void writeString(String s);

}
