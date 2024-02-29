package dev.webfx.platform.boot.spi.impl.j2cl;

import dev.webfx.platform.boot.ApplicationBooter;
import dev.webfx.platform.boot.spi.ApplicationBooterProvider;
import jsinterop.annotations.JsMethod;

/**
 * J2CL entry point, instantiated and started by J2clApplicationBooterProvider.native.js
 *
 * @author Bruno Salmon
 */
public final class J2clApplicationBooterProvider implements ApplicationBooterProvider {

    @JsMethod(name = "onModuleLoad")
    public void onModuleLoad() {
        ApplicationBooter.start(this, null);
    }

}
