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

    /**
     * Whether the boot sequence is printed. Null until it is decided, which happens at the moment the buffer is
     * flushed — see {@link #logHeaderAndBuffer}, and note that this is exactly what the buffering above was
     * already for: the decision needs {@link Meta}, and on GWT the meta resource cannot be read until
     * {@code GwtResourceModuleBooter} has run.
     *
     * <p>Not final, because {@link #setBootLogging} may settle it earlier. Deliberately NOT read from a system
     * property here: this class is compiled into the browser, where {@code System.getProperty} is not something
     * to rely on, so the override arrives from the JRE booter instead.
     */
    private static Boolean bootLogging;

    /**
     * Overrides whether the boot sequence is printed, before the boot starts.
     *
     * <p>For a platform that has a way for an operator to ask — {@code webfx-platform-boot-java} reads a system
     * property and calls this. Without it, a command-line executable could never be made to show its own boot,
     * which is precisely what one needs when a boot is what is going wrong.
     */
    public static void setBootLogging(boolean logging) {
        bootLogging = logging;
    }

    /**
     * Whether this executable prints platform progress — the boot sequence, and anything else of that kind.
     *
     * <p>Exposed so that progress chatter outside the boot can follow the same decision instead of inventing a
     * second switch. {@code VariablesResolverBase} is the first caller: its "‹ VAR › was resolved from …" lines
     * are the same category of message, and in a one-shot command they arrive before every invocation while
     * saying nothing an operator asked for.
     *
     * <p>Answers the settled value when there is one — {@link #setBootLogging} has run, or the boot has already
     * decided — and otherwise makes the same default the boot would: a command-line executable is quiet. It does
     * not SETTLE the field, because an operator's {@code -Dwebfx.boot.log} arrives before the boot starts and
     * must still win.
     */
    public static boolean isProgressLogging() {
        return bootLogging != null ? bootLogging : !Meta.isCLI();
    }

    public static void log(String message) {
        // First stage: we buffer the logs
        if (logBuffer != null) { // non-null at the beginning until logHeaderAndBuffer() is called (=> set logBuffer to null)
            if (logBuffer.length() > 0) // !isEmpty() not supported by GWT
                logBuffer.append("\n");
            logBuffer.append(message);
        } else if (Boolean.TRUE.equals(bootLogging)) // Second stage: we print the logs directly to the console
            Console.log(message);
        // Third possibility: the boot sequence is not being printed at all (a command-line executable), and the
        // message is dropped. Only PROGRESS comes through here; a failure is reported with Console.error by
        // whoever hit it (see ApplicationJobsInitializer.runJobPhase and ApplicationJobFailures), so a boot
        // that goes wrong still says so even when a boot that goes right says nothing.
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
        // This is the first moment Meta can be asked (see the note on bootLogging), so it is where the
        // decision is made when nothing has made it already.
        if (bootLogging == null)
            bootLogging = !Meta.isCLI();
        if (!bootLogging) // The buffered progress is dropped with the rest of the sequence
            return;
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
