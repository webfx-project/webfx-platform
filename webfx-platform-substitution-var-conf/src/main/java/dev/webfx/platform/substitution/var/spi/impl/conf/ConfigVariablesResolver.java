package dev.webfx.platform.substitution.var.spi.impl.conf;

import dev.webfx.platform.conf.ConfigLoader;
import dev.webfx.platform.console.Console;
import dev.webfx.platform.substitution.var.spi.VariablesResolver;

import java.util.Optional;

/**
 * @author Bruno Salmon
 */
public class ConfigVariablesResolver implements VariablesResolver {

    @Override
    public Optional<String> resolveVariable(String variableName) {
        String value = ConfigLoader.getRootConfig().getString(variableName);
        if (value != null)
            Console.log("INFO: " + variableName + " was resolved from configuration");
        return value != null ? Optional.of(value) : Optional.empty();
    }
}
