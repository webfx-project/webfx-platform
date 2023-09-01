package dev.webfx.platform.substitution.var.spi.impl.localstorage;

import dev.webfx.platform.console.Console;
import dev.webfx.platform.storage.LocalStorage;
import dev.webfx.platform.substitution.var.spi.VariablesResolver;

import java.util.Optional;

/**
 * @author Bruno Salmon
 */
public class LocalStorageVariablesResolver implements VariablesResolver {

    @Override
    public Optional<String> resolveVariable(String variableName) {
        String value = LocalStorage.getItem(variableName);
        if (value != null)
            Console.log("INFO: " + variableName + " was resolved from local storage");
        return value != null ? Optional.of(value) : Optional.empty();
    }
}
