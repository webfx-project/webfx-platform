package dev.webfx.platform.substitution.var.spi.impl.windowlocation;

import dev.webfx.platform.console.Console;
import dev.webfx.platform.substitution.var.spi.VariablesResolver;
import dev.webfx.platform.windowlocation.WindowLocation;

import java.util.Optional;

/**
 * @author Bruno Salmon
 */
public class WindowLocationVariablesResolver implements VariablesResolver {

    @Override
    public Optional<String> resolveVariable(String variableName) {
        String value = null;
        switch (variableName) {
            case "WINDOW_LOCATION_HOST":
                value = WindowLocation.getHost();
                break;
            case "WINDOW_LOCATION_HOSTNAME":
                value = WindowLocation.getHostname();
                break;
            case "WINDOW_LOCATION_PORT":
                value = WindowLocation.getPort();
                break;
            case "WINDOW_LOCATION_PROTOCOL":
                value = WindowLocation.getProtocol();
                break;
            case "WINDOW_LOCATION_ORIGIN":
                value = WindowLocation.getOrigin();
                break;
            case "WINDOW_LOCATION_SSL":
                value = String.valueOf(WindowLocation.getProtocol().equalsIgnoreCase("https"));
                break;
        }
        if (value != null)
            Console.log("INFO: " + variableName + " was resolved from window location");
        return value != null ? Optional.of(value) : Optional.empty();
    }

}
