package dev.webfx.platform.arch.spi.impl.web;

import dev.webfx.platform.arch.spi.ArchProvider;

/**
 * @author Bruno Salmon
 */
public class WebArchProvider implements ArchProvider {

    private final String userAgent;
    private final String platform;
    private final String cpuClass;
    private final Integer hardwareConcurrency; // Note: may be undefined if privacy settings refuse to reveal it

    public WebArchProvider(String userAgent, String platform, String cpuClass, Integer hardwareConcurrency) {
        this.userAgent = userAgent;
        this.platform = platform;
        this.cpuClass = cpuClass;
        this.hardwareConcurrency = hardwareConcurrency;
    }

    @Override
    public boolean is64Bit() {
        /*
         * User agent strings that indicate a 64-bit OS.
         * See: http://stackoverflow.com/a/13709431/292185
         */
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
        if ("MacIntel".equalsIgnoreCase(platform) || "Linux x86_64".equalsIgnoreCase(platform)) {
            return true;
        }

        /*
         * CPU class strings that indicate a 64-bit OS.
         * See: http://stackoverflow.com/a/6267019/292185
         */
        if ("x64".equals(cpuClass)) {
            return true;
        }

        /*
         * If none of the above, assume the architecture is 32-bit.
         */
        return false;
    }

    @Override
    public int availableProcessors() {
        boolean defined = Character.isDigit(("" + hardwareConcurrency /* should return "null", "undefined" or "NaN" if not defined */).charAt(0));
        return defined ? hardwareConcurrency : -1; // returning -1 when undefined
    }
}
