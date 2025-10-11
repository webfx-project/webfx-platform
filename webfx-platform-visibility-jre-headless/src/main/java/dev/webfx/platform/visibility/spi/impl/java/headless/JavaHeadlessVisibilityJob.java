package dev.webfx.platform.visibility.spi.impl.java.headless;

import dev.webfx.platform.boot.spi.ApplicationJob;

/**
 * @author Bruno Salmon
 */
public final class JavaHeadlessVisibilityJob implements ApplicationJob {

    @Override
    public void onStart() {
        JavaHeadlessVisibilityProvider.onStart();
    }

    @Override
    public void onStop() {
        JavaHeadlessVisibilityProvider.onStop();
    }
}
