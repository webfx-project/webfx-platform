package dev.webfx.platform.shared.services.boot.spi.impl;

import dev.webfx.platform.shared.services.boot.spi.ApplicationModuleBooter;
import dev.webfx.platform.shared.services.log.Logger;
import dev.webfx.platform.shared.util.collection.Collections;

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
        int n = moduleBooters.size();
        logInFrame((boot ? "Booting " : "Exiting ") + n + " application modules");
        for (int i = 0; i < n; i++) {
            int moduleIndex = boot ? i : n - i - 1;
            ApplicationModuleBooter module = moduleBooters.get(moduleIndex);
            Logger.log((moduleIndex + 1) + ") " + module.getModuleName() + " (boot level " + module.getBootLevel() + ")");
        }
        for (int i = 0; i < n; i++) {
            int moduleIndex = boot ? i : n - i - 1;
            ApplicationModuleBooter module = moduleBooters.get(moduleIndex);
            Logger.log(">>>>> " + (boot ? "Booting " : "Exiting ") + (moduleIndex + 1) + ") " + module.getModuleName() + " with " + module.getClass().getSimpleName() + " <<<<<");
            if (boot)
                module.bootModule();
            else
                module.exitModule();
        }
        logInFrame(n + " application modules " + (boot ? "booted" : "exited"));
    }

    private static void logInFrame(String s) {
        s = "***** " + s + " *****";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) // String.repeat() not emulated by GWT
            sb.append('*');
        Logger.log(sb + "\n" + s + "\n" + sb);
    }
}
