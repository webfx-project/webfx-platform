package dev.webfx.platform.boot.spi.impl;

import dev.webfx.platform.boot.spi.ApplicationJob;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bruno Salmon
 */
public final class SimpleApplicationJobManager {

    private static final List<ApplicationJob> runningJobs = new ArrayList<>();

    public static void initApplicationJob(ApplicationJob applicationJob) {
        runningJobs.add(applicationJob);
        applicationJob.onInit();
    }

    public static void startApplicationJob(ApplicationJob applicationJob) {
        if (!runningJobs.contains(applicationJob))
            runningJobs.add(applicationJob);
        applicationJob.onStart();
    }

    public static void stopApplicationJob(ApplicationJob applicationJob) {
        applicationJob.onStop();
        runningJobs.remove(applicationJob);
    }

    public static void shutdown() {
        while (!runningJobs.isEmpty())
            stopApplicationJob(runningJobs.get(0));
    }
}
