package dev.webfx.platform.os.spi.impl.gwtj2cl;


import dev.webfx.platform.os.spi.impl.OperatingSystemProviderBase;
import elemental2.dom.DomGlobal;

/**
 * @author Bruno Salmon
 */
public final class GwtJ2clOperatingSystemProvider extends OperatingSystemProviderBase {

    public GwtJ2clOperatingSystemProvider() {
        super(DomGlobal.navigator.userAgent);
    }
}


