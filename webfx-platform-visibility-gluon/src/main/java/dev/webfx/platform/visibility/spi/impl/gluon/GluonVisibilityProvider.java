package dev.webfx.platform.visibility.spi.impl.gluon;

import com.gluonhq.attach.lifecycle.LifecycleEvent;
import com.gluonhq.attach.lifecycle.LifecycleService;
import dev.webfx.platform.visibility.VisibilityState;
import dev.webfx.platform.visibility.spi.impl.VisibilityProviderBase;


/**
 * @author Bruno Salmon
 */
public final class GluonVisibilityProvider extends VisibilityProviderBase {

    private VisibilityState visibilityState = VisibilityState.VISIBLE;

    public GluonVisibilityProvider() {
        LifecycleService lifecycleService = LifecycleService.create().orElseThrow();
        lifecycleService.addListener(LifecycleEvent.PAUSE, this::onPause);
        lifecycleService.addListener(LifecycleEvent.RESUME, this::onResume);
    }

    @Override
    public VisibilityState getVisibilityState() {
        return visibilityState;
    }

    private void onPause() {
        visibilityState = VisibilityState.HIDDEN;
        fireVisibilityChanged();
    }

    private void onResume() {
        visibilityState = VisibilityState.VISIBLE;
        fireVisibilityChanged();
    }

}
