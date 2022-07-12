package dev.webfx.platform.boot.spi;

/**
 * @author Bruno Salmon
 */
public interface ApplicationJob {

    default void onStart() {}

    default void onStop() {}

}
