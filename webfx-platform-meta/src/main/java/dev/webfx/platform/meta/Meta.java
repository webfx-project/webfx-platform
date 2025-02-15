package dev.webfx.platform.meta;

import dev.webfx.platform.console.Console;
import dev.webfx.platform.resource.Resource;

import java.io.StringReader;
import java.util.Properties;

/**
 * @author Bruno Salmon
 */
public final class Meta {

    public final static String META_EXE_PACKAGE = "dev.webfx.platform.meta.exe";
    public final static String META_EXE_RESOURCE_FOLDER = META_EXE_PACKAGE.replace('.', '/');
    public final static String META_EXE_RESOURCE_FILE_NAME = "exe.properties";
    public final static String META_EXE_RESOURCE_FILE_PATH = META_EXE_RESOURCE_FOLDER + "/" + META_EXE_RESOURCE_FILE_NAME;
    public final static String META_EXE_EXECUTABLE_MODULE_NAME_KEY = "executableModuleName";
    public final static String META_EXE_EXECUTABLE_MODULE_VERSION_KEY = "executableModuleVersion";
    public final static String META_EXE_APPLICATION_MODULE_NAME_KEY = "applicationModuleName";
    public final static String META_EXE_MAVEN_BUILD_TIMESTAMP_NAME_KEY = "mavenBuildTimestamp";
    public final static String META_EXE_BACKOFFICE_NAME_KEY = "backoffice";

    private static Properties META_PROPERTIES;

    private static Properties getMetaProperties() {
        if (META_PROPERTIES == null) {
            META_PROPERTIES = new Properties();
            try {
                String content = Resource.getText(META_EXE_RESOURCE_FILE_PATH);
                if (content != null)
                    META_PROPERTIES.load(new StringReader(content));
                else
                    Console.log("[WARNING] Absent meta resource file " + META_EXE_RESOURCE_FILE_PATH);
            } catch (Exception e) {
                Console.log("[ERROR] Failed to read meta resource file " + META_EXE_RESOURCE_FILE_PATH, e);
            }
        }
        return META_PROPERTIES;
    }

    private static String getMetaProperty(String key) {
        return getMetaProperties().getProperty(key);
    }

    public static String getExecutableModuleName() {
        return getMetaProperty(META_EXE_EXECUTABLE_MODULE_NAME_KEY);
    }

    public static String getExecutableModuleVersion() {
        return getMetaProperty(META_EXE_EXECUTABLE_MODULE_VERSION_KEY);
    }

    public static String getApplicationModuleName() {
        return getMetaProperty(META_EXE_APPLICATION_MODULE_NAME_KEY);
    }

    public static String getMavenBuildTimestamp() {
        return getMetaProperty(META_EXE_MAVEN_BUILD_TIMESTAMP_NAME_KEY);
    }

    public static Boolean getBackoffice() {
        // Note: the WebFX CLI doesn't generate the backoffice property in the exe.properties file at this time, but
        // it will eventually (when specified in webfx.xml).
        String backofficeProperty = getMetaProperty(META_EXE_BACKOFFICE_NAME_KEY);
        if (backofficeProperty != null)
            return "true".equalsIgnoreCase(backofficeProperty);
        // If not specified in the exe.properties file, we can guess it from the application module name
        String applicationModuleName = getApplicationModuleName();
        if (applicationModuleName != null && applicationModuleName.toLowerCase().contains("backoffice"))
            return true;
        return null; // meaning unspecified
    }

    public static boolean isBackoffice() {
        return Boolean.TRUE.equals(getBackoffice());
    }

}
