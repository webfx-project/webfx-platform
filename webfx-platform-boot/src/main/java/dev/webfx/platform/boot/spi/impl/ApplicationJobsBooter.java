package dev.webfx.platform.boot.spi.impl;

import dev.webfx.platform.boot.ApplicationBooter;
import dev.webfx.platform.console.Console;
import dev.webfx.platform.boot.spi.ApplicationJob;
import dev.webfx.platform.boot.spi.ApplicationModuleBooter;
import dev.webfx.platform.util.collection.Collections;

import java.util.List;
import java.util.ServiceLoader;

/**
 * @author Bruno Salmon
 */
public class ApplicationJobsBooter implements ApplicationModuleBooter {

    private List<ApplicationJob> providedJobs; // Not initialized here as it's not the good time (calling lower module initializer before)

    @Override
    public String getModuleName() {
        return "webfx-platform-boot (jobs starter)";
    }

    @Override
    public int getBootLevel() {
        return JOBS_START_BOOT_LEVEL;
    }

    @Override
    public void bootModule() {
        providedJobs = Collections.listOf(ServiceLoader.load(ApplicationJob.class));
        Console.log(providedJobs.size() + " provided application jobs:");
        providedJobs.forEach(job -> {
            Console.log("- Starting " + job.getClass().getSimpleName());
            ApplicationBooter.startApplicationJob(job);
        });
    }

    @Override
    public void exitModule() {
        providedJobs.forEach(job -> {
            Console.log("Stopping " + job.getClass().getSimpleName());
            ApplicationBooter.stopApplicationJob(job);
        });
    }
}
