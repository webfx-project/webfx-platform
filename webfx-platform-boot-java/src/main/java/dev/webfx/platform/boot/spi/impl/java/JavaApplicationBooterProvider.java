package dev.webfx.platform.boot.spi.impl.java;

import dev.webfx.platform.boot.spi.impl.ApplicationModuleBooterManager;
import dev.webfx.platform.boot.spi.impl.SimpleApplicationBooterProvider;
import dev.webfx.platform.reflect.RArray;

import java.lang.reflect.Array;

/**
 * @author Bruno Salmon
 */
public class JavaApplicationBooterProvider extends SimpleApplicationBooterProvider {

    /**
     * Whether to print the boot sequence, overriding what the executable's kind implies.
     *
     * <p>A command-line executable does not print it (see {@code Meta.isCLI}), which is what one wants until
     * the boot itself is what is going wrong — and then one wants it badly. {@code -Dwebfx.boot.log=true}
     * turns it back on; {@code false} turns it off for anything else.
     *
     * <p>Read HERE rather than in {@code ApplicationModuleBooterManager} because that class is compiled into
     * the browser too, and system properties are not something to rely on there. This provider is the JRE's
     * own boot wiring, which is where a JRE-only mechanism belongs.
     */
    public static final String BOOT_LOG_SYSTEM_PROPERTY = "webfx.boot.log";

    public JavaApplicationBooterProvider() {
        RArray.injectJavaArrayNewInstanceMethod(Array::newInstance);
        // Before boot() runs: ApplicationBooter.start() resolves this provider, and therefore runs this
        // constructor, before it calls boot(). So the override is in place by the time the first module boots.
        String bootLog = System.getProperty(BOOT_LOG_SYSTEM_PROPERTY);
        if (bootLog != null)
            ApplicationModuleBooterManager.setBootLogging(Boolean.parseBoolean(bootLog));
    }
}