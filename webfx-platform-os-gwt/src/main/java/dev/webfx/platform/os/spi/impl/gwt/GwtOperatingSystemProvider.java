package dev.webfx.platform.os.spi.impl.gwt;


import dev.webfx.platform.os.spi.impl.OperatingSystemProviderBase;
import elemental2.dom.DomGlobal;

/**
 * @author Bruno Salmon
 */
public final class GwtOperatingSystemProvider extends OperatingSystemProviderBase {

    public GwtOperatingSystemProvider() {
        super(DomGlobal.navigator.userAgent);
    }
}


