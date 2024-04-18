package dev.webfx.platform.boot.spi.impl;

import dev.webfx.platform.boot.ApplicationBooter;
import dev.webfx.platform.boot.spi.ApplicationJob;
import dev.webfx.platform.boot.spi.ApplicationModuleBooter;
import dev.webfx.platform.util.collection.Collections;

import java.util.List;
import java.util.ServiceLoader;

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
        PROVIDED_JOBS.forEach(job -> {
            log("- Initializing " + job.getClass().getSimpleName());
            ApplicationBooter.initApplicationJob(job);
        });
    }

}
