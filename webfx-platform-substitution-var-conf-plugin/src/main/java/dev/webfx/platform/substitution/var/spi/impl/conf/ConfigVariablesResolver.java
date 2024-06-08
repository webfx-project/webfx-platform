package dev.webfx.platform.substitution.var.spi.impl.conf;

import dev.webfx.platform.conf.Config;
import dev.webfx.platform.conf.ConfigLoader;
import dev.webfx.platform.conf.impl.ThreadLocalConfigContext;
import dev.webfx.platform.substitution.var.spi.impl.VariablesResolverBase;

import java.util.Optional;

/**
 * @author Bruno Salmon
 */
public class ConfigVariablesResolver extends VariablesResolverBase {

    @Override
    public Optional<String> resolveVariable(String variableName) {
        Config config = ThreadLocalConfigContext.getThreadLocalConfig();
        if (config == null)
            config = ConfigLoader.getRootConfig();
        String value = null;
        while (config != null) {
            value = config.getString(variableName);
            if (value != null)
                break;
            config = config.parentConfig();
        }
        return passVariableSearchResult(variableName, value, "configuration");
    }
}
