package dev.webfx.platform.boot.spi.impl.gwt;

import com.google.gwt.core.client.EntryPoint;
import dev.webfx.platform.boot.ApplicationBooter;
import dev.webfx.platform.boot.spi.ApplicationBooterProvider;

/**
 * @author Bruno Salmon
 */
public final class GwtApplicationBooterProvider implements ApplicationBooterProvider, EntryPoint {

    @Override
    public void onModuleLoad() {
        ApplicationBooter.start(this, null);
    }
}
