package dev.webfx.platform.arch;

import dev.webfx.platform.arch.spi.ArchProvider;
import dev.webfx.platform.util.serviceloader.SingleServiceProvider;

import java.util.ServiceLoader;

/**
 * @author Bruno Salmon
 */
public final class Arch {

    private Arch() {}

    private static ArchProvider getProvider() {
        return SingleServiceProvider.getProvider(ArchProvider.class, () -> ServiceLoader.load(ArchProvider.class));
    }

    public static int availableProcessors() {
        return getProvider().availableProcessors();
    }
}
