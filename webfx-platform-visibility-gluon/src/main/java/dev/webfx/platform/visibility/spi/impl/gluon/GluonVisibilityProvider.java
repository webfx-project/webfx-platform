package dev.webfx.platform.visibility.spi.impl.gluon;

import com.gluonhq.attach.lifecycle.LifecycleEvent;
import com.gluonhq.attach.lifecycle.LifecycleService;
import dev.webfx.platform.console.Console;
import dev.webfx.platform.uischeduler.UiScheduler;
import dev.webfx.platform.visibility.VisibilityState;
import dev.webfx.platform.visibility.spi.impl.VisibilityProviderBase;


/**
 * @author Bruno Salmon
 */
public final class GluonVisibilityProvider extends VisibilityProviderBase {

    private VisibilityState visibilityState = VisibilityState.VISIBLE;

    public GluonVisibilityProvider() {
        // Note: All Gluon servies must be created in the UI thread, otherwise the application crashes
        UiScheduler.runInUiThread(() -> {
            LifecycleService lifecycleService = LifecycleService.create().orElse(null);
            if (lifecycleService == null) // It seems the audio service is implemented only for Android, so this happens on other platforms
                Console.log("WARNING [WebFX Platform]: Unable to load Gluon lifecycle Service");
            else {
                lifecycleService.addListener(LifecycleEvent.PAUSE,  this::onPause);
                lifecycleService.addListener(LifecycleEvent.RESUME, this::onResume);
            }
        });

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
