package dev.webfx.platform.boot.spi.impl;

import dev.webfx.platform.boot.spi.ApplicationModuleBooter;
import dev.webfx.platform.console.Console;
import dev.webfx.platform.meta.Meta;
import dev.webfx.platform.util.Strings;
import dev.webfx.platform.util.collection.Collections;

import java.util.Comparator;
import java.util.List;
import java.util.ServiceLoader;

import static dev.webfx.platform.boot.spi.ApplicationModuleBooter.RESOURCE_BUNDLE_BOOT_LEVEL;

/**
 * @author Bruno Salmon
 */
public final class ApplicationModuleBooterManager {

    private static final List<ApplicationModuleBooter> moduleBooters = Collections.listOf(ServiceLoader.load(ApplicationModuleBooter.class));

    public static void initialize() {
        // We first sort the modules by boot level
        sortModulesByBootLevel();
        // And then we boot them
        bootModules();
    }

    public static void shutdown() {
        stopModules();
    }

    private static void sortModulesByBootLevel() {
        moduleBooters.sort(Comparator.comparingInt(ApplicationModuleBooter::getBootLevel));
    }

    private static void bootModules() {
        callModules(true);
    }

    private static void stopModules() {
        callModules(false);
    }

    /* Note regarding log: we will log the header later, so we start by buffering the logs of the first module booter.
       The reason is that the header starts with a frame saying *** Booting xxx *** where xxx is the executable
       module name that we get from the meta-resource file. But when running with GWT, we can't read that resource
       file before GwtResourceModuleBooter has been executed. GwtResourceModuleBooter, if present, should be the
       first module booter to be executed as its boot level is RESOURCE_BUNDLE_BOOT_LEVEL = 1. So we buffer all logs
       until we reach a module booter with a higher level, ensuring that GwtResourceModuleBooter has been executed.
       Then we call logHeaderAndBuffer() which actually logs the header with the executable module name (we can read
       the meta file with no pb at this point), and then append the module booter logs buffered so far. */

    private static StringBuilder logBuffer = new StringBuilder();

    public static void log(String message) {
        // First stage: we buffer the logs
        if (logBuffer != null) { // non-null at the beginning until logHeaderAndBuffer() is called (=> set logBuffer to null)
            if (logBuffer.length() > 0) // !isEmpty() not supported by GWT
                logBuffer.append("\n");
            logBuffer.append(message);
        } else // Second stage: we print the logs directly to the console
            Console.log(message);
    }

    private static void callModules(boolean boot) {
        // Getting start time for boot duration measurement
        long t0 = System.currentTimeMillis();

        // Calling all registered application modules
        if (!boot)
            logHeaderAndBuffer(false);
        int n = moduleBooters.size();
        for (int i = 0; i < n; i++) {
            int moduleIndex = boot ? i : n - i - 1;
            ApplicationModuleBooter module = moduleBooters.get(moduleIndex);
            // We log the header and the buffer after RESOURCE_BUNDLE_BOOT_LEVEL has been executed
            if (boot && logBuffer != null && module.getBootLevel() > RESOURCE_BUNDLE_BOOT_LEVEL)
                logHeaderAndBuffer(true);
            log(">>>>> " + (boot ? "Booting " : "Exiting ") + (moduleIndex + 1) + ") " + module.getModuleName() + " with " + module.getClass().getSimpleName() + " <<<<<");
            if (boot)
                module.bootModule();
            else
                module.exitModule();
        }
        if (logBuffer != null)
            logHeaderAndBuffer(boot);
        long t1 = System.currentTimeMillis();
        logInFrame(Meta.getExecutableModuleName() + (boot ? " booted" : " exited") + " in " + (t1 - t0) + " ms");
    }

    private static void logHeaderAndBuffer(boolean boot) {
        // We convert the buffer into a String and set the buffer to null
        String logBufferString = Strings.toString(logBuffer);
        logBuffer = null; // So from now, log() will redirect directly to the console
        // We first log the header
        int n = moduleBooters.size();
        String bootingOrExiting = boot ? "Booting " : "Exiting ";
        logInFrame(bootingOrExiting + Meta.getExecutableModuleName());
        if (boot)
            log("Environment: " + Meta.getEnvironment() + ", Maven build timestamp: " + Meta.getMavenBuildTimestamp());
        log(bootingOrExiting + n + " application modules in the following order:");
        for (int i = 0; i < n; i++) {
            int moduleIndex = boot ? i : n - i - 1;
            ApplicationModuleBooter module = moduleBooters.get(moduleIndex);
            log((moduleIndex + 1) + ") " + module.getModuleName() + " (boot level " + module.getBootLevel() + ")");
        }
        // And then we log the buffer
        if (logBufferString != null)
            log(logBufferString);
    }

    private static void logInFrame(String s) {
        s = "***** " + s + " *****";
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        sb.append("*".repeat(length));
        log(sb + "\n" + s + "\n" + sb);
    }

}
