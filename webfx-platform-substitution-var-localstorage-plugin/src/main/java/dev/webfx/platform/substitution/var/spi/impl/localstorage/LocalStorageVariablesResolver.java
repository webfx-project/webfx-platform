package dev.webfx.platform.substitution.var.spi.impl.localstorage;

import dev.webfx.platform.storage.LocalStorage;
import dev.webfx.platform.substitution.var.spi.impl.VariablesResolverBase;

import java.util.Optional;

/**
 * @author Bruno Salmon
 */
public class LocalStorageVariablesResolver extends VariablesResolverBase {

    @Override
    public Optional<String> resolveVariable(String variableName) {
        String value = LocalStorage.getItem(variableName);
        return passVariableSearchResult(variableName, value, "local storage");
    }
}
