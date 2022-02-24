package dev.webfx.platform.shared.services.boot.spi.impl;

import dev.webfx.platform.shared.services.boot.ApplicationBooter;
import dev.webfx.platform.shared.services.log.Logger;
import dev.webfx.platform.shared.services.boot.spi.ApplicationJob;
import dev.webfx.platform.shared.services.boot.spi.ApplicationModuleBooter;
import dev.webfx.platform.shared.util.collection.Collections;

import java.util.List;
import java.util.ServiceLoader;

/**
 * @author Bruno Salmon
 */
public class ApplicationJobsBooter implements ApplicationModuleBooter {

    private List<ApplicationJob> providedJobs; // Not initialized here as it's not the good time (calling lower module initializer before)

    @Override
    public String getModuleName() {
        return "webfx-platform-shared-appcontainer (jobs starter)";
    }

    @Override
    public int getBootLevel() {
        return JOBS_START_BOOT_LEVEL;
    }

    @Override
    public void bootModule() {
        providedJobs = Collections.listOf(ServiceLoader.load(ApplicationJob.class));
        Logger.log(providedJobs.size() + " provided application jobs:");
        providedJobs.forEach(job -> {
            Logger.log("- Starting " + job.getClass().getSimpleName());
            ApplicationBooter.startApplicationJob(job);
        });
    }

    @Override
    public void exitModule() {
        providedJobs.forEach(job -> {
            Logger.log("Stopping " + job.getClass().getSimpleName());
            ApplicationBooter.stopApplicationJob(job);
        });
    }
}
