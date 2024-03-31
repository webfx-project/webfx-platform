package dev.webfx.platform.substitution;

import dev.webfx.platform.substitution.spi.SubstitutorProvider;
import dev.webfx.platform.service.SingleServiceProvider;

import java.util.ServiceLoader;

/**
 * @author Bruno Salmon
 */
public final class Substitutor {

    private static SubstitutorProvider getProvider() {
        return SingleServiceProvider.getProvider(SubstitutorProvider.class, () -> ServiceLoader.load(SubstitutorProvider.class), SingleServiceProvider.NotFoundPolicy.RETURN_NULL);
    }

    public static String substitute(String text) {
        SubstitutorProvider provider = getProvider();
        return provider == null ? text : provider.substitute(text);
    }

}
