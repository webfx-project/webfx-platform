package dev.webfx.platform.substitution.var.spi.impl;

import dev.webfx.platform.substitution.var.spi.VariablesResolver;

import java.util.Optional;

/**
 * @author Bruno Salmon
 */
public abstract class VariablesResolverBase implements VariablesResolver {

    protected static Optional<String> passVariableSearchResult(String variableName, String value, String origin) {
        if (value != null)
            SkipRepeatLogger.skipRepeatLog("✓ ‹ " + variableName + " › was resolved from " + origin);
        return value != null ? Optional.of(value) : Optional.empty();
    }

}
