package dev.webfx.platform.substitution.var.spi.impl.sysprop;

import dev.webfx.platform.substitution.var.spi.impl.VariablesResolverBase;

import java.util.Optional;

/**
 * @author Bruno Salmon
 */
public class SystemPropertiesVariablesResolver extends VariablesResolverBase {

    @Override
    public Optional<String> resolveVariable(String variableName) {
        String value = System.getProperty(variableName);
        return passVariableSearchResult(variableName, value, "system properties");
    }
}
