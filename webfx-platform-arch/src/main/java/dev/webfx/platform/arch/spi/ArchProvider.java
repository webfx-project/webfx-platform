package dev.webfx.platform.arch.spi;

public interface ArchProvider {

    default boolean is32Bit() {
        return !is64Bit();
    }

    boolean is64Bit();

    int availableProcessors();
}
