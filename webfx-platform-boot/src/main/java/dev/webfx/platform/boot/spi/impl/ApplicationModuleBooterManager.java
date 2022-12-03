package dev.webfx.platform.boot.spi.impl;

import dev.webfx.platform.boot.spi.ApplicationModuleBooter;
import dev.webfx.platform.console.Console;
import dev.webfx.platform.util.collection.Collections;

import java.util.Comparator;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @author Bruno Salmon
 */
public final class ApplicationModuleBooterManager {

    private static final List<ApplicationModuleBooter> moduleBooters = Collections.listOf(ServiceLoader.load(ApplicationModuleBooter.class));

    public static void initialize() {
        sortModulesByBootLevel();
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

    private static void callModules(boolean boot) {
        // Calling all registered application modules
        long t0 = System.currentTimeMillis();
        int n = moduleBooters.size();
        logInFrame((boot ? "Booting " : "Exiting ") + n + " application modules");
        for (int i = 0; i < n; i++) {
            int moduleIndex = boot ? i : n - i - 1;
            ApplicationModuleBooter module = moduleBooters.get(moduleIndex);
            Console.log((moduleIndex + 1) + ") " + module.getModuleName() + " (boot level " + module.getBootLevel() + ")");
        }
        for (int i = 0; i < n; i++) {
            int moduleIndex = boot ? i : n - i - 1;
            ApplicationModuleBooter module = moduleBooters.get(moduleIndex);
            Console.log(">>>>> " + (boot ? "Booting " : "Exiting ") + (moduleIndex + 1) + ") " + module.getModuleName() + " with " + module.getClass().getSimpleName() + " <<<<<");
            if (boot)
                module.bootModule();
            else
                module.exitModule();
        }
        long t1 = System.currentTimeMillis();
        logInFrame(n + " application modules " + (boot ? "booted" : "exited") + " in " + (t1 - t0) + " ms");
    }

    private static void logInFrame(String s) {
        s = "***** " + s + " *****";
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) // String.repeat() not emulated by GWT
            sb.append('*');
        Console.log(sb + "\n" + s + "\n" + sb);
    }
}
