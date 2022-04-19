package dev.webfx.platform.shared.services.boot.spi;

/**
 * @author Bruno Salmon
 */
public interface ApplicationJob {

    default void onStart() {}

    default void onStop() {}

}
