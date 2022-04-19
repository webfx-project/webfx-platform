package dev.webfx.platform.shared.services.boot.spi.impl;

import dev.webfx.platform.shared.services.boot.spi.ApplicationJob;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bruno Salmon
 */
public final class SimpleApplicationJobManager {

    private static final List<ApplicationJob> runningJobs = new ArrayList<>();

    public static void startApplicationJob(ApplicationJob applicationJob) {
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
