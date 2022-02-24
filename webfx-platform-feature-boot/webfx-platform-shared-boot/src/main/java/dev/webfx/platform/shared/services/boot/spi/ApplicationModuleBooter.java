package dev.webfx.platform.shared.services.boot.spi;

/**
 * @author Bruno Salmon
 */
public interface ApplicationModuleBooter {

    int RESOURCE_BUNDLE_BOOT_LEVEL = 1;
    int SERIAL_CODEC_BOOT_LEVEL = 2;
    int JOBS_START_BOOT_LEVEL = 3;
    int APPLICATION_BOOT_LEVEL = 4;
    int APPLICATION_LAUNCH_LEVEL = 5;

    String getModuleName();

    int getBootLevel();

    void bootModule();

    default void exitModule() {}

}
