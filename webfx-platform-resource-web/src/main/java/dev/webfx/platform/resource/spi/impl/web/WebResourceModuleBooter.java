package dev.webfx.platform.resource.spi.impl.web;

import dev.webfx.platform.boot.spi.ApplicationModuleBooter;
import dev.webfx.platform.resource.Resource;
import dev.webfx.platform.util.collection.Collections;

import java.util.List;
import java.util.ServiceLoader;

/**
 * @author Bruno Salmon
 */
public class WebResourceModuleBooter implements ApplicationModuleBooter {

    @Override
    public String getModuleName() {
        return "webfx-platform-resource-web";
    }

    @Override
    public int getBootLevel() {
        return ApplicationModuleBooter.RESOURCE_BUNDLE_BOOT_LEVEL;
    }

    @Override
    public void bootModule() {
        List<WebResourceBundle> bundles = Collections.listOf(ServiceLoader.load(WebResourceBundle.class));
        int count = bundles.size();
        log((count == 0 ? "No" : count) + " web resource bundle" + (count > 1 ? "s" : "") + " provided");
        for (WebResourceBundle bundle : bundles) {
            ((WebResourceProvider) Resource.getProvider()).register(bundle);
            StringBuilder sb = new StringBuilder();
            for (String resourcePath : bundle.resourcePathsForLogging())
                sb.append(sb.length() == 0 /* isEmpty() not supported by GWT */ ? bundle.getClass().getName() + " registered the following resources:\n" : "\n").append(resourcePath);
            log(sb.toString());
        }
    }
}
