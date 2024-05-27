package dev.webfx.platform.boot.spi.impl;

import dev.webfx.platform.boot.ApplicationBooter;
import dev.webfx.platform.boot.spi.ApplicationModuleBooter;

/**
 * @author Bruno Salmon
 */
public class ApplicationJobsStarter implements ApplicationModuleBooter {

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
        ApplicationJobsInitializer.PROVIDED_JOBS.forEach(job -> {
            log("- Starting " + job.getClass().getSimpleName());
            ApplicationBooter.startApplicationJob(job);
        });
    }

    @Override
    public void exitModule() {
        ApplicationJobsInitializer.PROVIDED_JOBS.forEach(job -> {
            log("Stopping " + job.getClass().getSimpleName());
            ApplicationBooter.stopApplicationJob(job);
        });
    }
}
