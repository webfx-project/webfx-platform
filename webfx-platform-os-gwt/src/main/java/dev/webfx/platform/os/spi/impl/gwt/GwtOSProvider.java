package dev.webfx.platform.os.spi.impl.gwt;


import dev.webfx.platform.os.spi.impl.OSProviderBase;
import elemental2.dom.DomGlobal;

/**
 * @author Bruno Salmon
 */
public final class GwtOSProvider extends OSProviderBase {

    public GwtOSProvider() {
        super(DomGlobal.navigator.userAgent);
    }
}


