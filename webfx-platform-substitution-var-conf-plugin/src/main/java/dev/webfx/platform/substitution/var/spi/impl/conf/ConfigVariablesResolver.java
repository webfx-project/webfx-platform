package dev.webfx.platform.substitution.var.spi.impl.conf;

import dev.webfx.platform.conf.ConfigLoader;
import dev.webfx.platform.substitution.var.spi.impl.VariablesResolverBase;

import java.util.Optional;

/**
 * @author Bruno Salmon
 */
public class ConfigVariablesResolver extends VariablesResolverBase {

    @Override
    public Optional<String> resolveVariable(String variableName) {
        String value = ConfigLoader.getRootConfig().getString(variableName);
        return passVariableSearchResult(variableName, value, "configuration");
    }
}
