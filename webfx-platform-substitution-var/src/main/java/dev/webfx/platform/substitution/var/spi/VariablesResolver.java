package dev.webfx.platform.substitution.var.spi;

import java.util.Optional;

public interface VariablesResolver {

    Optional<String> resolveVariable(String variableName);

}
