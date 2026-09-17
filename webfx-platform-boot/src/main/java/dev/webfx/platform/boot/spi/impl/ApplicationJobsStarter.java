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
        // Per-job try/catch (see runJobPhase): one job failing to start must not abort the rest.
        ApplicationJobsInitializer.runJobPhase("Starting", ApplicationBooter::startApplicationJob);
    }

    @Override
    public void exitModule() {
        // Same isolation on shutdown: one job throwing while stopping must not leave the others un-stopped.
        ApplicationJobsInitializer.runJobPhase("Stopping", ApplicationBooter::stopApplicationJob);
    }
}
