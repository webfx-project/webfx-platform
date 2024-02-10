package dev.webfx.platform.arch.spi.impl.gwt;

import dev.webfx.platform.arch.spi.ArchProvider;
import elemental2.dom.DomGlobal;
import jsinterop.base.Js;

/**
 * @author Bruno Salmon
 */
public final class GwtArchProvider implements ArchProvider {

    @Override
    public boolean is64Bit() {
        /*
         * User agent strings that indicate a 64-bit OS.
         * See: http://stackoverflow.com/a/13709431/292185
         */
        var userAgent = DomGlobal.navigator.userAgent;
        if (userAgent.contains("x86_64") ||
            userAgent.contains("Win64") ||
            userAgent.contains("x64;") ||
            userAgent.contains("amd64") ||
            userAgent.contains("AMD64") ||
            userAgent.contains("WOW64") ||
            userAgent.contains("x64_64")) {
            return true;
        }

        /*
         * Platform strings that indicate a 64-bit OS.
         * See: http://stackoverflow.com/a/19883965/292185
         */
        var platform = DomGlobal.navigator.platform;
        if ("MacIntel".equalsIgnoreCase(platform) || "Linux x86_64".equalsIgnoreCase(platform)) {
            return true;
        }

        /*
         * CPU class strings that indicate a 64-bit OS.
         * See: http://stackoverflow.com/a/6267019/292185
         */
        if ("x64".equals(getCpuClass())) {
            return true;
        }

        /*
         * If none of the above, assume the architecture is 32-bit.
         */
        return false;
    }

    private static String getCpuClass() {
        return (String) Js.asPropertyMap(DomGlobal.navigator).get("cpuClass");
    }

    @Override
    public int availableProcessors() {
        int hardwareConcurrency = DomGlobal.navigator.hardwareConcurrency; // Note: may be undefined if privacy settings refuse to reveal it
        boolean defined = Character.isDigit(("" + hardwareConcurrency /* should return "undefined" or "NaN" if not defined */).charAt(0));
        return defined ? hardwareConcurrency : -1; // returning -1 when undefined
    }
}
