package dev.webfx.platform.substitution.var.spi.impl.prompt;

import dev.webfx.platform.conf.Config;
import dev.webfx.platform.conf.impl.ThreadLocalConfigContext;
import dev.webfx.platform.console.Console;
import dev.webfx.platform.secret.SecretPrompt;
import dev.webfx.platform.substitution.var.spi.impl.VariablesResolverBase;

import java.util.*;

/**
 * Resolves a configuration variable by asking the developer to type its value when the application starts, so that a
 * secret such as a database password doesn't have to be stored on disk - neither in a conf file nor in the environment
 * variables of an IDE run configuration (which the IDE also stores in plain text).
 *
 * <p>It is opt-in: it only resolves the variable names written with the {@code prompt:} prefix, for example:
 * <pre>
 * password = ${{ DB_PASSWORD | prompt:DB_PASSWORD }}
 * password = ${{ DB_PASSWORD | prompt:DB_PASSWORD(username, host, databaseName) }}
 * </pre>
 * The alternatives are tried from left to right, so a system property or environment variable still wins when it is
 * set (servers, CI), and the developer is asked only when nothing else resolved the value. The optional keys in
 * parentheses are sibling keys of the config being read, whose values are displayed in the prompt so the developer can
 * tell which target the value is asked for. List only non-secret keys there, as their values are displayed in clear.
 *
 * <p>The typed value (or the refusal to type it) is kept in memory for the lifetime of the JVM, because the
 * substitution is re-evaluated each time the config key is read, and the developer should be asked only once.
 *
 * <p>Where nobody can answer (ex: a container), the variable is simply not resolved - this never blocks. Note that the
 * startup is paused while the developer types, so an event loop resolving the config at that time (ex: Vert.x) may
 * report itself as blocked. See {@link SecretPrompt} for how the value is asked for.
 *
 * @author Bruno Salmon
 */
public final class PromptVariablesResolver extends VariablesResolverBase {

    private static final String PREFIX = "prompt:";

    // Guarded by ANSWERS. An empty Optional records a refusal (cancelled or impossible prompt), so it's not asked again.
    private static final Map<String, Optional<String>> ANSWERS = new HashMap<>();
    // Variables being prompted, to break the loop if their context keys lead back to them
    private static final Set<String> PROMPTING = new HashSet<>();

    @Override
    public Optional<String> resolveVariable(String variableName) {
        if (!variableName.startsWith(PREFIX))
            return Optional.empty();
        String spec = variableName.substring(PREFIX.length()).trim();
        int openingParenthesis = spec.indexOf('(');
        String name = (openingParenthesis < 0 ? spec : spec.substring(0, openingParenthesis)).trim();
        List<String> contextKeys = openingParenthesis < 0 || !spec.endsWith(")") ? List.of() :
            Arrays.stream(spec.substring(openingParenthesis + 1, spec.length() - 1).split(","))
                .map(String::trim)
                .filter(key -> !key.isEmpty())
                .toList();
        // Synchronized, so that concurrent reads wait for the single prompt rather than asking again
        synchronized (ANSWERS) {
            Optional<String> answer = ANSWERS.get(name);
            if (answer == null) {
                if (!PROMPTING.add(name))
                    return Optional.empty();
                try {
                    answer = Optional.ofNullable(prompt(name, readContext(contextKeys)));
                } finally {
                    PROMPTING.remove(name);
                }
                ANSWERS.put(name, answer);
            }
            return passVariableSearchResult(name, answer.orElse(null), "prompt");
        }
    }

    private static List<String> readContext(List<String> contextKeys) {
        List<String> context = new ArrayList<>();
        Config config = ThreadLocalConfigContext.getThreadLocalConfig();
        if (config != null) {
            for (String key : contextKeys) {
                String value = config.getString(key);
                if (value != null)
                    context.add(key + " = " + value);
            }
        }
        return context;
    }

    private static String prompt(String name, List<String> context) {
        if (!SecretPrompt.isPossible()) {
            Console.log("⚠️ ‹ " + name + " › can't be prompted, as neither a desktop nor a terminal is available");
            return null;
        }
        Console.log("🔑 Waiting for ‹ " + name + " › to be typed (the startup is paused until then)");
        char[] typed = SecretPrompt.ask(name, context, SecretPrompt.Preference.DIALOG_FIRST);
        if (typed == null)
            return null;
        try {
            return new String(typed);
        } finally {
            Arrays.fill(typed, '\0');
        }
    }
}
