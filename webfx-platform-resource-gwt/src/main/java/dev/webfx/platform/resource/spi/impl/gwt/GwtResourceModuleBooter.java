package dev.webfx.platform.resource.spi.impl.gwt;

import dev.webfx.platform.boot.spi.ApplicationModuleBooter;
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
        return "webfx-platform-resource-gwt";
    }

    @Override
    public int getBootLevel() {
        return RESOURCE_BUNDLE_BOOT_LEVEL;
    }

    @Override
    public void bootModule() {
        List<GwtResourceBundle> bundles = Collections.listOf(ServiceLoader.load(GwtResourceBundle.class));
        int count = bundles.size();
        log((count == 0 ? "No" : count) + " gwt resource bundle" + (count > 1 ? "s" : "") + " provided");
        for (GwtResourceBundle bundle : bundles) {
            ((GwtResourceProvider) Resource.getProvider()).register(bundle);
            StringBuilder sb = new StringBuilder();
            for (String resourcePath : bundle.resourcePathsForLogging())
                sb.append(sb.length() == 0 ? bundle.getClass().getName() + " registered the following resources:\n" : "\n").append(resourcePath);
            log(sb.toString());
        }
    }
}
