package dev.webfx.platform.arch.spi.impl.gwtj2cl;

import dev.webfx.platform.arch.spi.impl.web.WebArchProvider;
import elemental2.dom.DomGlobal;
import jsinterop.base.Js;

/**
 * @author Bruno Salmon
 */
public final class GwtJ2clArchProvider extends WebArchProvider {

    public GwtJ2clArchProvider() {
        super(DomGlobal.navigator.userAgent, DomGlobal.navigator.platform, (String) Js.asPropertyMap(DomGlobal.navigator).get("cpuClass"), DomGlobal.navigator.hardwareConcurrency);
    }

}
