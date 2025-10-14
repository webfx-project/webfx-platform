package dev.webfx.platform.arch.spi.impl.elemental2;

import dev.webfx.platform.arch.spi.impl.web.WebArchProvider;
import elemental2.dom.DomGlobal;
import jsinterop.base.Js;

/**
 * @author Bruno Salmon
 */
public final class Elemental2ArchProvider extends WebArchProvider {

    public Elemental2ArchProvider() {
        super(DomGlobal.navigator.userAgent, DomGlobal.navigator.platform, (String) Js.asPropertyMap(DomGlobal.navigator).get("cpuClass"), DomGlobal.navigator.hardwareConcurrency);
    }

}
