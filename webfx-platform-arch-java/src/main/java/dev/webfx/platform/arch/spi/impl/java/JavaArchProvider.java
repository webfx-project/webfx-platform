package dev.webfx.platform.arch.spi.impl.java;

import dev.webfx.platform.arch.spi.ArchProvider;

/**
 * @author Bruno Salmon
 */
public final class JavaArchProvider implements ArchProvider {

    @Override
    public int availableProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }
}
