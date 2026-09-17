package dev.webfx.platform.boot.spi.impl;

import dev.webfx.platform.boot.ApplicationBooter;
import dev.webfx.platform.boot.ApplicationJobFailures;
import dev.webfx.platform.boot.spi.ApplicationJob;
import dev.webfx.platform.boot.spi.ApplicationModuleBooter;
import dev.webfx.platform.console.Console;
import dev.webfx.platform.util.collection.Collections;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;
import java.util.function.Consumer;

/**
 * @author Bruno Salmon
 */
public class ApplicationJobsInitializer implements ApplicationModuleBooter {

    static List<ApplicationJob> PROVIDED_JOBS; // Not initialized here as it's not the good time (calling lower module initializer before)

    @Override
    public String getModuleName() {
        return "webfx-platform-boot (jobs initializer)";
    }

    @Override
    public int getBootLevel() {
        return JOBS_INIT_BOOT_LEVEL;
    }

    @Override
    public void bootModule() {
        PROVIDED_JOBS = Collections.listOf(ServiceLoader.load(ApplicationJob.class));
        log(PROVIDED_JOBS.size() + " provided application jobs:");
        runJobPhase("Initializing", ApplicationBooter::initApplicationJob);
    }

    /**
     * Runs one lifecycle phase (init / start / stop) over every provided application job, isolating each
     * job in its own try/catch. This isolation is deliberate: the jobs are independent, so one job that
     * throws (or fails to link) must NOT abort the phase for the jobs after it.
     *
     * Before this guard the loop was a bare {@code forEach} with no try/catch, so a single broken job
     * silently prevented every job later in ServiceLoader/classpath order from initializing. Because that
     * order differs between IDE runs and deployed fat-jars, the same code could half-boot in one
     * environment and boot cleanly in another, surfacing as failures far from the cause — e.g. every DQL
     * write failing with a raw-DQL Postgres error because the submit-interceptor job never registered,
     * while an unrelated earlier job (an unconfigured mailer, say) was the one that actually threw.
     *
     * We now log each failure loudly (with its stack trace) and carry on, so the rest of the server still
     * boots. Jobs that must genuinely block the server (e.g. DB migration) do so through their own
     * {@link dev.webfx.platform.boot.ApplicationReadiness ApplicationReadiness} gate, which holds
     * /health at 503 independently of this loop — so a truly critical failure still prevents the
     * blue/green swap even though we continue here.
     *
     * @param verb   present-participle label for the boot log line ("Initializing" / "Starting" / "Stopping")
     * @param action the lifecycle operation to apply to each job
     */
    static void runJobPhase(String verb, Consumer<ApplicationJob> action) {
        List<String> failedJobs = new ArrayList<>();
        for (ApplicationJob job : PROVIDED_JOBS) {
            String jobName = job.getClass().getSimpleName();
            ApplicationModuleBooterManager.log("- " + verb + " " + jobName);
            try {
                action.accept(job);
            } catch (Throwable t) { // Throwable, not Exception: classpath/linkage failures (NoClassDefFoundError,
                                    // ExceptionInInitializerError) are exactly the kind that used to abort the loop.
                failedJobs.add(jobName);
                Console.error("!!! Application job " + jobName + " FAILED while " + verb.toLowerCase()
                        + " — skipping it and continuing with the remaining jobs", t);
                // Retain the failure so an admin surface (e.g. the /monitor page) can report it long
                // after these startup logs have scrolled away. record() never throws.
                ApplicationJobFailures.record(verb, jobName, t);
            }
        }
        // A single greppable summary line so a partially-booted server announces itself at the end of the
        // phase instead of being diagnosed later from write failures far from the cause.
        if (!failedJobs.isEmpty())
            Console.error("!!! " + failedJobs.size() + " application job(s) FAILED while " + verb.toLowerCase()
                    + ": " + failedJobs + " — the server may be only partially functional");
    }

}
