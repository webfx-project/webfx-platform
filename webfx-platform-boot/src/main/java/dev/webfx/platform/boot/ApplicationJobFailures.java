package dev.webfx.platform.boot;

import dev.webfx.platform.console.Console;

import java.util.ArrayList;
import java.util.List;

/**
 * Process-wide record of the application jobs that failed during a boot lifecycle phase
 * (init / start / stop). It is populated by {@code ApplicationJobsInitializer.runJobPhase}'s per-job
 * try/catch — which otherwise only logs each failure and moves on.
 *
 * Retaining the failures (rather than only logging them) lets an admin surface — e.g. the back-office
 * /monitor page — report long after the startup logs have scrolled away that "this server task didn't
 * fully boot". That matters because a half-booted server fails <em>far from the cause</em>: the
 * per-job isolation means one throwing job no longer aborts the others, but the failed job is still
 * missing, so the visible symptom (say, every DQL write failing because the submit-interceptor job
 * never registered) points nowhere near the job that actually threw.
 *
 * Boot runs once per process and the job count is small, so in practice the list stays tiny; a
 * defensive cap only guards a pathological re-boot loop. Every method is synchronized (the boot phases
 * are single-threaded, but the snapshot is read from the bus thread) and swallow-safe: recording a
 * failure must never itself throw out of the boot catch block that calls it.
 *
 * @author Bruno Salmon
 */
public final class ApplicationJobFailures {

    /**
     * One job's failure during a boot phase — the wire-agnostic source a monitor/report maps from.
     */
    public static final class Failure {
        private final long epochMillis;  // wall-clock time of the failure
        private final String phase;      // "Initializing" / "Starting" / "Stopping"
        private final String jobName;    // the ApplicationJob's simple class name
        private final String message;    // the throwable's message (or its class name when message is null)
        private final String stackTrace; // full captured stack trace, for the drill-down (may be null)

        Failure(long epochMillis, String phase, String jobName, String message, String stackTrace) {
            this.epochMillis = epochMillis;
            this.phase = phase;
            this.jobName = jobName;
            this.message = message;
            this.stackTrace = stackTrace;
        }

        public long getEpochMillis() { return epochMillis; }
        public String getPhase() { return phase; }
        public String getJobName() { return jobName; }
        public String getMessage() { return message; }
        public String getStackTrace() { return stackTrace; }
    }

    private static final int MAX_FAILURES = 200; // far above any real job count — only a runaway-reboot backstop
    private static final List<Failure> FAILURES = new ArrayList<>();

    private ApplicationJobFailures() {}

    /**
     * Records one job failure. Never throws: it is called from the boot loop's catch block, so a
     * problem while capturing the stack trace or appending the entry must not turn a single job's
     * failure into a whole-boot failure.
     *
     * @param phase   the phase during which the job failed ("Initializing" / "Starting" / "Stopping")
     * @param jobName the failing job's simple class name
     * @param error   the throwable it failed with (may be null)
     */
    public static synchronized void record(String phase, String jobName, Throwable error) {
        try {
            if (FAILURES.size() >= MAX_FAILURES)
                return;
            String message = error == null ? null
                    : error.getMessage() != null ? error.getMessage() : error.getClass().getName();
            String stackTrace = null;
            // Capture the trace in its own guard: if capturing it fails on some platform we still keep
            // the failure record (message) rather than losing the whole entry.
            try {
                if (error != null)
                    stackTrace = Console.captureStackTrace(error);
            } catch (Throwable ignored) { /* keep a null stack trace */ }
            FAILURES.add(new Failure(System.currentTimeMillis(), phase, jobName, message, stackTrace));
        } catch (Throwable ignored) { /* recording a failure must never fail the boot */ }
    }

    /** Defensive copy of the recorded failures, oldest first (i.e. boot order). */
    public static synchronized List<Failure> snapshot() {
        return new ArrayList<>(FAILURES);
    }

    /** How many failures have been recorded — for a card's count/severity without copying the list. */
    public static synchronized int count() {
        return FAILURES.size();
    }
}
