package dev.webfx.platform.substitution.var.spi.impl.env;

import dev.webfx.platform.substitution.var.spi.impl.VariablesResolverBase;

import java.util.Optional;

/**
 * @author Bruno Salmon
 */
public class EnvironmentVariablesResolver extends VariablesResolverBase {

    @Override
    public Optional<String> resolveVariable(String variableName) {
        String value = System.getenv(variableName);
        return passVariableSearchResult(variableName, value, "environment");
    }
}
