package dev.webfx.platform.resource.spi.impl.gwt;

import dev.webfx.platform.boot.spi.ApplicationModuleBooter;
import dev.webfx.platform.console.Console;
import dev.webfx.platform.resource.Resource;
import dev.webfx.platform.util.collection.Collections;

import java.util.List;
import java.util.ServiceLoader;

/**
 * @author Bruno Salmon
 */
public class GwtResourceModuleBooter implements ApplicationModuleBooter {

    @Override
    public String getModuleName() {
        return "webfx-platform-gwt-resource-impl";
    }

    @Override
    public int getBootLevel() {
        return RESOURCE_BUNDLE_BOOT_LEVEL;
    }

    @Override
    public void bootModule() {
        List<GwtResourceBundle> gwtResourceBundles = Collections.listOf(ServiceLoader.load(GwtResourceBundle.class));
        Console.log(gwtResourceBundles.size() + " gwt resource bundles provided");
        for (GwtResourceBundle gwtResourceBundle : gwtResourceBundles) {
            ((GwtResourceProvider) Resource.getProvider()).register(gwtResourceBundle);
            StringBuilder sb = new StringBuilder();
            for (String resourcePath : gwtResourceBundle.resourcePathsForLogging())
                sb.append(sb.length() == 0 ? gwtResourceBundle.getClass().getName() + " registered the following resources:\n" : "\n").append(resourcePath);
            Console.log(sb);
        }
    }
}
