package dev.webfx.platform.substitution.var.spi.impl.windowlocation;

import dev.webfx.platform.substitution.var.spi.impl.VariablesResolverBase;
import dev.webfx.platform.windowlocation.WindowLocation;

import java.util.Optional;

/**
 * @author Bruno Salmon
 */
public class WindowLocationVariablesResolver extends VariablesResolverBase {

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
                value = String.valueOf("https".equalsIgnoreCase(WindowLocation.getProtocol()));
                break;
        }
        return passVariableSearchResult(variableName, value, "window location");
    }

}
