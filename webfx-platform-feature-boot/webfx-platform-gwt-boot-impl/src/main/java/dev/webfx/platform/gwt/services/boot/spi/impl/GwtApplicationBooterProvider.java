package dev.webfx.platform.gwt.services.boot.spi.impl;

import com.google.gwt.core.client.EntryPoint;
import dev.webfx.platform.shared.services.boot.ApplicationBooter;
import dev.webfx.platform.shared.services.boot.spi.ApplicationBooterProvider;

/**
 * @author Bruno Salmon
 */
public final class GwtApplicationBooterProvider implements ApplicationBooterProvider, EntryPoint {

    @Override
    public void onModuleLoad() {
        ApplicationBooter.start(this, null);
    }
}
