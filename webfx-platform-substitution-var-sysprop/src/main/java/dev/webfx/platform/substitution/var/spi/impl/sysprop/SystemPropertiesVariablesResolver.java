package dev.webfx.platform.substitution.var.spi.impl.sysprop;

import dev.webfx.platform.console.Console;
import dev.webfx.platform.substitution.var.spi.VariablesResolver;

import java.util.Optional;

/**
 * @author Bruno Salmon
 */
public class SystemPropertiesVariablesResolver implements VariablesResolver {

    @Override
    public Optional<String> resolveVariable(String variableName) {
        String value = System.getProperty(variableName);
        if (value != null)
            Console.log("INFO: " + variableName + " was resolved from system properties");
        return value != null ? Optional.of(value) : Optional.empty();
    }
}
