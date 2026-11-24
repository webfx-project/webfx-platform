package dev.webfx.platform.substitution.var.spi.impl;

import dev.webfx.platform.boot.spi.impl.ApplicationModuleBooterManager;
import dev.webfx.platform.substitution.var.spi.VariablesResolver;

import java.util.Optional;

/**
 * @author Bruno Salmon
 */
public abstract class VariablesResolverBase implements VariablesResolver {

    /**
     * Reports where a variable was resolved from, and answers it.
     *
     * <p>The report follows the executable's progress-logging decision rather than printing unconditionally:
     * these lines are diagnostic progress, like the boot sequence, and a one-shot command-line program would
     * otherwise preface every single invocation with one per variable. {@code -Dwebfx.boot.log=true} brings them
     * back, which matters because an unresolved variable usually fails as something ELSE — a configuration that
     * quietly fell back to a default — and these lines are how one sees which resolver answered.
     */
    protected static Optional<String> passVariableSearchResult(String variableName, String value, String origin) {
        if (value != null && ApplicationModuleBooterManager.isProgressLogging())
            SkipRepeatLogger.skipRepeatLog("✓ ‹ " + variableName + " › was resolved from " + origin);
        return value != null ? Optional.of(value) : Optional.empty();
    }

}
