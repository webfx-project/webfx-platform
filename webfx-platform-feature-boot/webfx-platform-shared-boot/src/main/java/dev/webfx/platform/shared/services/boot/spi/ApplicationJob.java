package dev.webfx.platform.shared.services.boot.spi;

import dev.webfx.platform.shared.util.async.AsyncUtil;
import dev.webfx.platform.shared.util.async.Future;

/**
 * @author Bruno Salmon
 */
public interface ApplicationJob {

    default Future<Void> onStartAsync() { return AsyncUtil.runAsync(this::onStart); }

    default Future<Void> onStopAsync() { return AsyncUtil.runAsync(this::onStop); }

    default void onStart() {}

    default void onStop() {}

}
