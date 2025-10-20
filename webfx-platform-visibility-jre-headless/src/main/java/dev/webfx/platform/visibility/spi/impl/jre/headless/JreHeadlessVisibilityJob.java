package dev.webfx.platform.visibility.spi.impl.jre.headless;

import dev.webfx.platform.boot.spi.ApplicationJob;

/**
 * @author Bruno Salmon
 */
public final class JreHeadlessVisibilityJob implements ApplicationJob {

    @Override
    public void onStart() {
        JreHeadlessVisibilityProvider.onStart();
    }

    @Override
    public void onStop() {
        JreHeadlessVisibilityProvider.onStop();
    }
}
