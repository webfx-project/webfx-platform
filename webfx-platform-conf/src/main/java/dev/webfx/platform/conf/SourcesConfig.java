package dev.webfx.platform.conf;

import dev.webfx.platform.resource.Resource;

/**
 * @author Bruno Salmon
 */
public final class SourcesConfig {

    /**
     * The legacy location: where the WebFX CLI generates the sources root configuration <b>today</b>, and where
     * this class therefore looks <b>second</b>.
     *
     * <p>These constants are deliberately unchanged, because the CLI derives the generated path from them. Moving
     * them would move the generated file for every CLI rebuilt against this module — including a rebuild triggered
     * by some unrelated commit — and the move must be a deliberate step taken after this fallback has propagated,
     * not a side effect of picking up a new platform snapshot.
     */
    public final static String SRC_ROOT_CONF_PACKAGE = "dev.webfx.platform.conf";
    public final static String SRC_ROOT_CONF_RESOURCE_FOLDER = SRC_ROOT_CONF_PACKAGE.replace('.', '/');

    /**
     * The new location, mirroring {@code dev.webfx.platform.meta.exe}: where the generated file <b>will</b> live,
     * and where this class looks <b>first</b>.
     *
     * <p>Why it moves at all: the generated resource sits in the same package as this class, so every executable
     * module declares {@code dev.webfx.platform.conf} too. On the module path that is a split package, and
     * {@code java.lang.LayerInstantiationException} refuses the boot layer. Executables are normally launched from
     * the classpath, where encapsulation does not apply, which is why this has gone unnoticed; it is not that the
     * shared package name grants the platform any access, and the CLI generates no {@code opens} for executables
     * ({@code ProjectModule.getOpenPackages} returns empty for them).
     *
     * <p>Nothing writes here yet. Until the CLI switches, these paths are simply absent and the lookup falls
     * through to the legacy ones.
     */
    public final static String SRC_ROOT_CONF_EXE_PACKAGE = SRC_ROOT_CONF_PACKAGE + ".exe";
    public final static String SRC_ROOT_CONF_EXE_RESOURCE_FOLDER = SRC_ROOT_CONF_EXE_PACKAGE.replace('.', '/');

    private final static String SRC_ROOT_CONF_RESOURCE_FILE_NAME_WITHOUT_EXTENSION = "src-root";
    private final static String SRC_ROOT_CONF_RESOURCE_FILE_PATH_WITHOUT_EXTENSION = SRC_ROOT_CONF_RESOURCE_FOLDER + "/" + SRC_ROOT_CONF_RESOURCE_FILE_NAME_WITHOUT_EXTENSION;
    public final static String PROPERTIES_SRC_ROOT_CONF_RESOURCE_FILE_PATH = SRC_ROOT_CONF_RESOURCE_FILE_PATH_WITHOUT_EXTENSION + ".properties";
    public final static String JSON_SRC_ROOT_CONF_RESOURCE_FILE_PATH = SRC_ROOT_CONF_RESOURCE_FILE_PATH_WITHOUT_EXTENSION + ".json";

    private final static String SRC_ROOT_CONF_EXE_RESOURCE_FILE_PATH_WITHOUT_EXTENSION = SRC_ROOT_CONF_EXE_RESOURCE_FOLDER + "/" + SRC_ROOT_CONF_RESOURCE_FILE_NAME_WITHOUT_EXTENSION;
    public final static String PROPERTIES_SRC_ROOT_CONF_EXE_RESOURCE_FILE_PATH = SRC_ROOT_CONF_EXE_RESOURCE_FILE_PATH_WITHOUT_EXTENSION + ".properties";
    public final static String JSON_SRC_ROOT_CONF_EXE_RESOURCE_FILE_PATH = SRC_ROOT_CONF_EXE_RESOURCE_FILE_PATH_WITHOUT_EXTENSION + ".json";

    /**
     * Lookup order, and the whole safety property of the move: <b>the new location is tried first</b>.
     *
     * <p>The CLI writes the generated file but does not delete it from its previous location, so an executable
     * updated by a CLI that has moved it keeps a stale copy at the legacy path — frozen at the moment of the move,
     * and silently missing every configuration key added afterwards. Reading the new location first means such an
     * executable is correct as soon as it is rebuilt against a CLI that writes there, and the stale file is merely
     * ignored. Reversing this order would let the stale copy win permanently, for everyone.
     *
     * <p>Within each location, {@code .properties} precedes {@code .json}: the CLI emits one or the other
     * ({@code ConfigMerge.mergeConfigs} selects JSON only when a merged config contains an array) and deletes the
     * unselected one, so the two are never both present for the same location.
     */
    private final static String[] SRC_ROOT_CONF_RESOURCE_FILE_PATHS = {
            PROPERTIES_SRC_ROOT_CONF_EXE_RESOURCE_FILE_PATH,
            JSON_SRC_ROOT_CONF_EXE_RESOURCE_FILE_PATH,
            PROPERTIES_SRC_ROOT_CONF_RESOURCE_FILE_PATH,
            JSON_SRC_ROOT_CONF_RESOURCE_FILE_PATH
    };

    private static Config sourcesRootConfig;

    public static Config getSourcesRootConfig() {
        if (sourcesRootConfig == null) {
            String foundResourcePath = null, configText = null;
            for (String resourcePath : SRC_ROOT_CONF_RESOURCE_FILE_PATHS) {
                configText = Resource.getText(resourcePath);
                if (configText != null) {
                    foundResourcePath = resourcePath;
                    break;
                }
            }
            if (foundResourcePath == null)
                throw new RuntimeException("❌ No sources route configuration found! Looked for "
                        + listSearchedResourcePaths()
                        + ". Run `webfx update` on this executable module to generate it. If the module was"
                        + " generated by a WebFX CLI newer than this platform version, the file is at a location"
                        + " this version does not know; updating the platform resolves it.");
            sourcesRootConfig = ConfigParser.parseConfigFile(configText, foundResourcePath);
        }
        return sourcesRootConfig;
    }

    private static String listSearchedResourcePaths() { // String.join() avoided: not all WebFX JRE emulations provide it
        StringBuilder sb = new StringBuilder();
        for (String resourcePath : SRC_ROOT_CONF_RESOURCE_FILE_PATHS) {
            if (sb.length() > 0)
                sb.append(", ");
            sb.append(resourcePath);
        }
        return sb.toString();
    }

}
