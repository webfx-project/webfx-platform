package dev.webfx.platform.gwt.services.resource.spi.impl;

import dev.webfx.platform.shared.services.boot.spi.ApplicationModuleBooter;
import dev.webfx.platform.shared.services.log.Logger;
import dev.webfx.platform.shared.services.resource.ResourceService;
import dev.webfx.platform.shared.util.collection.Collections;

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
        Logger.log(gwtResourceBundles.size() + " gwt resource bundles provided");
        for (GwtResourceBundle gwtResourceBundle : gwtResourceBundles) {
            ((GwtResourceServiceProvider) ResourceService.getProvider()).register(gwtResourceBundle);
            StringBuilder sb = new StringBuilder();
            for (String resourcePath : gwtResourceBundle.resourcePathsForLogging())
                sb.append(sb.length() == 0 ? gwtResourceBundle.getClass().getName() + " registered the following resources:\n" : "\n").append(resourcePath);
            Logger.log(sb);
        }
    }
}
