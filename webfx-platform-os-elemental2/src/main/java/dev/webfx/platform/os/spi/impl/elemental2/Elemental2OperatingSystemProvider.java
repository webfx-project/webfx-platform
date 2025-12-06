package dev.webfx.platform.os.spi.impl.elemental2;


import dev.webfx.platform.os.spi.impl.OperatingSystemProviderBase;
import elemental2.dom.DomGlobal;

/**
 * @author Bruno Salmon
 */
public final class Elemental2OperatingSystemProvider extends OperatingSystemProviderBase {

    public Elemental2OperatingSystemProvider() {
        super(DomGlobal.navigator.userAgent, DomGlobal.navigator.maxTouchPoints);
    }
}


