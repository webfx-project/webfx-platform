package dev.webfx.platform.substitution.var.spi.impl;

import dev.webfx.platform.console.Console;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bruno Salmon
 */
public final class SkipRepeatLogger {
    private static final List<String> LOGS = new ArrayList<>();

    public static void skipRepeatLog(String message) {
        if (!LOGS.contains(message)) {
            Console.log(message);
            LOGS.add(message);
        }
    }
}
