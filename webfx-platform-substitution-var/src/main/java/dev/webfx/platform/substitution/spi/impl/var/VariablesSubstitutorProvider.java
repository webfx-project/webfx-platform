package dev.webfx.platform.substitution.spi.impl.var;

import dev.webfx.platform.service.MultipleServiceProviders;
import dev.webfx.platform.substitution.spi.SubstitutorProvider;
import dev.webfx.platform.substitution.var.spi.VariablesResolver;
import dev.webfx.platform.substitution.var.spi.impl.SkipRepeatLogger;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Bruno Salmon
 */
public class VariablesSubstitutorProvider implements SubstitutorProvider {

    private static final Pattern VARIABLE_PATTERN = Pattern.compile("\\$?\\{\\{(.+?(?=}}))}}");
    private static final String[] PROVIDERS_ORDER = {
            "SystemProperties",
            "Environment",
            "LocalStorage",
            "Config",
            "WindowLocation",
    };

    private static final List<VariablesResolver> PROVIDERS = MultipleServiceProviders.getProviders(VariablesResolver.class, () -> ServiceLoader.load(VariablesResolver.class));
    static {
        PROVIDERS.sort(Comparator.comparingInt(VariablesSubstitutorProvider::getProviderOrder));
    }

    private static int getProviderOrder(VariablesResolver vr) {
        String name = vr.getClass().getSimpleName();
        for (int i = 0; i < PROVIDERS_ORDER.length; i++) {
            if (name.contains(PROVIDERS_ORDER[i]))
                return i;
        }
        return PROVIDERS_ORDER.length;
    }

    @Override
    public String substitute(String text) {
        Matcher matcher = VARIABLE_PATTERN.matcher(text);
        // Using StringBuilder doesn't work with J2CL because the Java 8 API supports only StringBuffer
        // TODO: move back to StringBuilder once J2CL supports Java 11
        /*StringBuilder*/ StringBuffer sb = null;
        // Do we still have variable patterns?
        while (matcher.find()) {
            // If yes, we take the variable token, which may be a variable name (ex: SERVER_HOST) or an expression (ex: SERVER_HOST | 'localhost')
            String variableToken = matcher.group(1).trim();
            // We try to resolve that variable token (i.e. find the variable value, or evaluate the expression)
            Optional<String> variableValue = resolveVariableToken(variableToken);
            // If we can't, we don't do any replacement, but we log a warning reporting the variable couldn't be resolved
            if (!variableValue.isPresent()) // J2CL doesn't recognize isEmpty()
                SkipRepeatLogger.skipRepeatLog("⚠️ Configuration variable ‹ " + variableToken + " › couldn't be resolved");
            else {
                // The variable has been resolved. Note that the variable value may be another expression composed of
                // other variables, so we resolve it to cover this case.
                String replacement = substitute(variableValue.get());

                // You can eventually uncomment the following log for debug purpose, but never keep it in production as
                // variable values can be secret (so not a good idea to log them).
                /* DEBUG ONLY: Console.log("Resolved configuration variable " + variableToken + " = " + replacement); */

                // We are almost ready for the replacement, we just ensure first that sb is not null
                if (sb == null)
                    sb = new StringBuffer();
                // Now we do the replacement, but we pass an empty string and not the replacement yet at this stage. The
                // reason is that matcher.appendReplacement(sb, replacement) can raise an exception if replacement
                // contains again the variable pattern ${{ XXX }}, which can happen if the resolution of the variable
                // value failed.
                matcher.appendReplacement(sb, ""); // append all text before the variable pattern, and then ""
                // Now we can append the replacement without raising an exception, even if replacement contains ${{ XXX }}
                sb.append(replacement);
            }
        }
        if (sb == null) // Happens when no variable pattern was found, or none of them could be resolved,
            return text; // so we just return the original config text in this case.
        // In other cases (variable patterns were found and resolved), we append the possible remaining text
        return matcher.appendTail(sb).toString();
    }

    private Optional<String> resolveVariableToken(String variableToken) {
        Optional<String> o;
        int p1, p2 = -1;
        do {
            p1 = p2 + 1;
            p2 = variableToken.indexOf('|', p1);
            o = resolveVariable(variableToken.substring(p1, p2 == -1 ? variableToken.length() : p2).trim());
        } while (p2 != -1 && !o.isPresent()); // J2CL doesn't recognize isEmpty()
        return o;
    }

    private Optional<String> resolveVariable(String variableName) {
        // true, false and numbers are constants, not variables, and don't need resolution
        if ("true".equals(variableName) || "false".equals(variableName) || Character.isDigit(variableName.charAt(0)))
            return Optional.of(variableName);
        // Same with literal strings such as 'localhost'
        if (variableName.startsWith("'") && variableName.endsWith("'"))
            return Optional.of(variableName.substring(1, variableName.length() - 1));
        // For all other cases, we try to resolve the variable by searching in the suppliers
        return PROVIDERS.stream()
                .map(s -> s.resolveVariable(variableName))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst();
    }
}
