package dev.webfx.platform.substitution.var.spi.impl.env;

import dev.webfx.platform.console.Console;
import dev.webfx.platform.substitution.var.spi.VariablesResolver;

import java.util.Optional;

/**
 * @author Bruno Salmon
 */
public class EnvironmentVariablesResolver implements VariablesResolver {

    @Override
    public Optional<String> resolveVariable(String variableName) {
        String value = System.getenv(variableName);
        if (value != null)
            Console.log("INFO: " + variableName + " was resolved from environment");
        return value != null ? Optional.of(value) : Optional.empty();
    }
}
