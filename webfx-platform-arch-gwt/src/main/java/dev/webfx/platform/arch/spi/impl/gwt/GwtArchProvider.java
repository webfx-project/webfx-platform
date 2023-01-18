package dev.webfx.platform.arch.spi.impl.gwt;

import dev.webfx.platform.arch.spi.ArchProvider;
import elemental2.dom.DomGlobal;

/**
 * @author Bruno Salmon
 */
public final class GwtArchProvider implements ArchProvider {

    @Override
    public int availableProcessors() {
        int hardwareConcurrency = DomGlobal.navigator.hardwareConcurrency; // Note: may be undefined if privacy settings refuse to reveal it
        boolean defined = Character.isDigit(("" + hardwareConcurrency /* should return "undefined" or "NaN" if not defined */).charAt(0));
        return defined ? hardwareConcurrency : -1; // returning -1 when undefined
    }
}
