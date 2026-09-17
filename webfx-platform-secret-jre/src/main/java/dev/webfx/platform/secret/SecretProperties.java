package dev.webfx.platform.secret;

import java.io.IOException;
import java.io.StringReader;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Reads and edits the decrypted text of a properties file, keeping its comments, its blank lines and
 * the order of its entries - so that adding one secret doesn't rewrite the file around it.
 *
 * <p>Values are read with {@link Properties}, which is what the configuration machinery uses too, and
 * written with the escaping that reads back identically.
 *
 * @author Bruno Salmon
 */
public final class SecretProperties {

    private SecretProperties() {}

    /** The keys, once each, in the order they first appear in the file. */
    public static List<String> keys(String text) {
        List<String> keys = new ArrayList<>();
        for (String[] entry : logicalLines(text)) {
            String key = parseKey(entry[0]);
            if (!keys.contains(key))
                keys.add(key);
        }
        return keys;
    }

    public static String get(String text, String key) {
        Properties properties = new Properties();
        try {
            properties.load(new StringReader(text));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return properties.getProperty(key);
    }

    /**
     * Adds the entry, or replaces the existing one in place.
     *
     * <p>A key written twice in the same file is legal, and {@link Properties} then keeps the LAST one - so a
     * duplicate is rewritten as a single entry here, rather than leaving an older value as the one that counts.
     */
    public static String set(String text, String key, String value) {
        String entryLine = escape(key, true) + " = " + escape(value, false);
        String[] lines = text.isEmpty() ? new String[0] : text.split("\n", -1);
        List<int[]> entries = findEntries(lines, key);
        String newText;
        if (entries.isEmpty()) {
            StringBuilder sb = new StringBuilder(text);
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) != '\n')
                sb.append('\n');
            newText = sb.append(entryLine).append('\n').toString();
        } else {
            int[] first = entries.get(0);
            if (first[1] > first[0])
                throw new SecretException("The entry " + key + " spans several lines, which this command doesn't rewrite."
                                          + " Use export/import to edit it.");
            newText = rewrite(lines, entries, first[0], entryLine);
        }
        // The file is read back by Properties, so what it will say there is what decides whether this worked
        if (!value.equals(get(newText, key)))
            throw new SecretException("Setting " + key + " didn't take effect - leaving the file untouched."
                                      + " Edit it with export/import.");
        return newText;
    }

    /** Removes the entry - every occurrence of it - returning the text unchanged if there was none. */
    public static String remove(String text, String key) {
        String[] lines = text.split("\n", -1);
        List<int[]> entries = findEntries(lines, key);
        if (entries.isEmpty())
            return text;
        String newText = rewrite(lines, entries, -1, null);
        if (get(newText, key) != null)
            throw new SecretException("Removing " + key + " didn't take effect - leaving the file untouched."
                                      + " Edit it with export/import.");
        return newText;
    }

    /** Drops the lines of every given entry, except that the entry starting at keptFirstLine becomes replacementLine. */
    private static String rewrite(String[] lines, List<int[]> entries, int keptFirstLine, String replacementLine) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            int[] entry = entryAt(entries, i);
            if (entry != null) {
                if (entry[0] != keptFirstLine) // a duplicate, or a removal: drop the whole entry
                    continue;
                line = replacementLine;
            }
            if (!first)
                sb.append('\n');
            sb.append(line);
            first = false;
        }
        return sb.toString();
    }

    private static int[] entryAt(List<int[]> entries, int lineIndex) {
        for (int[] entry : entries)
            if (lineIndex >= entry[0] && lineIndex <= entry[1])
                return entry;
        return null;
    }

    /** The first and last line index of every entry with that key, in file order. */
    private static List<int[]> findEntries(String[] lines, String key) {
        List<int[]> entries = new ArrayList<>();
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            if (isBlankOrComment(line))
                continue;
            int last = i;
            StringBuilder logicalLine = new StringBuilder(line);
            while (endsWithContinuation(lines[last]) && last + 1 < lines.length) {
                last++;
                logicalLine.append('\n').append(lines[last]);
            }
            if (key.equals(parseKey(logicalLine.toString())))
                entries.add(new int[] { i, last });
            i = last;
        }
        return entries;
    }

    /** The logical lines holding an entry, as {text, firstLineIndex} pairs, comments and blanks skipped. */
    private static List<String[]> logicalLines(String text) {
        List<String[]> entries = new ArrayList<>();
        String[] lines = text.split("\n", -1);
        for (int i = 0; i < lines.length; i++) {
            if (isBlankOrComment(lines[i]))
                continue;
            StringBuilder logicalLine = new StringBuilder(lines[i]);
            int first = i;
            while (endsWithContinuation(lines[i]) && i + 1 < lines.length) {
                i++;
                logicalLine.append('\n').append(lines[i]);
            }
            entries.add(new String[] { logicalLine.toString(), String.valueOf(first) });
        }
        return entries;
    }

    private static boolean isBlankOrComment(String line) {
        String trimmed = line.trim();
        return trimmed.isEmpty() || trimmed.startsWith("#") || trimmed.startsWith("!");
    }

    private static boolean endsWithContinuation(String line) {
        // Ignoring a trailing carriage return, as a file written on Windows has one on every line, and the
        // continuation backslash sits before it
        String withoutLineEnd = line.endsWith("\r") ? line.substring(0, line.length() - 1) : line;
        int backslashes = 0;
        for (int i = withoutLineEnd.length() - 1; i >= 0 && withoutLineEnd.charAt(i) == '\\'; i--)
            backslashes++;
        return backslashes % 2 == 1;
    }

    /** The key of a logical line, unescaped, ex: "a\ b = c" -> "a b". */
    private static String parseKey(String logicalLine) {
        StringBuilder key = new StringBuilder();
        String line = logicalLine.stripLeading();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '\\' && i + 1 < line.length()) {
                if (line.charAt(i + 1) == 'u' && i + 5 < line.length()) { // \\uXXXX, as java.util.Properties reads it
                    try {
                        key.append((char) Integer.parseInt(line.substring(i + 2, i + 6), 16));
                        i += 5;
                        continue;
                    } catch (NumberFormatException e) {
                        // not a valid escape: fall through and take the character after the backslash literally
                    }
                }
                key.append(unescape(line.charAt(++i)));
            } else if (c == '=' || c == ':' || Character.isWhitespace(c)) {
                break;
            } else
                key.append(c);
        }
        return key.toString();
    }

    private static char unescape(char escaped) {
        switch (escaped) {
            case 'n': return '\n';
            case 'r': return '\r';
            case 't': return '\t';
            case 'f': return '\f';
            default: return escaped;
        }
    }

    /** Escapes what {@link Properties} would otherwise read differently. */
    private static String escape(String value, boolean isKey) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            switch (c) {
                case '\\': sb.append("\\\\"); break;
                case '\n': sb.append("\\n"); break;
                case '\r': sb.append("\\r"); break;
                case '\t': sb.append("\\t"); break;
                case '\f': sb.append("\\f"); break;
                case ' ': sb.append(isKey || i == 0 ? "\\ " : " "); break; // a leading space would be dropped
                case '=': case ':': sb.append(isKey ? "\\" + c : String.valueOf(c)); break;
                case '#': case '!': sb.append(i == 0 ? "\\" + c : String.valueOf(c)); break;
                default: sb.append(c);
            }
        }
        return sb.toString();
    }
}
