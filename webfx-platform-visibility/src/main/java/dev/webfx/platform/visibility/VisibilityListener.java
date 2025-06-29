package dev.webfx.platform.visibility;

/**
 * Interface for listening to visibility state changes.
 *
 * @author Bruno Salmon
 */
public interface VisibilityListener {

    /**
     * Called when the visibility state of the application changes.
     *
     * @param visibilityState the new visibility state (VISIBLE or HIDDEN)
     */
    void onVisibilityStateChanged(VisibilityState visibilityState);

}
