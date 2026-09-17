package dev.webfx.platform.boot;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Registry of application readiness gates. A module doing critical boot-time work (such as applying database
 * migrations) can register a gate during its {@link dev.webfx.platform.boot.spi.ApplicationJob#onInit() onInit()}
 * (which runs before the HTTP server starts) and complete it once that work has succeeded. Readiness probes
 * (such as the /health endpoint used by load balancers) must report the application as not ready while any
 * gate is still pending, so that a failed gate keeps a blue/green deployment from switching traffic to this
 * instance.
 *
 * @author Bruno Salmon
 */
public final class ApplicationReadiness {

    private static final Map<String, Boolean> GATES = new ConcurrentHashMap<>();

    private ApplicationReadiness() {
    }

    /**
     * Registers a pending readiness gate under the given name, and returns the callback to invoke once the
     * gated work has completed successfully. A gate that is never completed keeps the application not ready
     * forever, which is the intended behavior on failure.
     */
    public static Runnable registerPendingReadinessGate(String name) {
        GATES.put(name, Boolean.FALSE);
        return () -> GATES.put(name, Boolean.TRUE);
    }

    public static boolean areAllGatesReady() {
        return !GATES.containsValue(Boolean.FALSE);
    }

    public static String pendingGateNames() {
        return GATES.entrySet().stream()
            .filter(entry -> !entry.getValue())
            .map(Map.Entry::getKey)
            .sorted()
            .collect(Collectors.joining(", "));
    }
}
