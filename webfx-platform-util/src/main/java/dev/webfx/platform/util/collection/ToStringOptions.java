package dev.webfx.platform.util.collection;

/**
 * @author Bruno Salmon
 */
public class ToStringOptions {

    public static final ToStringOptions COMMA_SEPARATED_TO_STRING_OPTIONS = new ToStringOptions(null, ", ", false, null, null);
    public static final ToStringOptions SPACE_SEPARATED_TO_STRING_OPTIONS = new ToStringOptions(null, " ", false, null, null);
    public static final ToStringOptions AMPERSAND_SEPARATED_TO_STRING_OPTIONS = new ToStringOptions(null, "&", false, null, null);
    public static final ToStringOptions SINGLE_QUOTE_TO_STRING_OPTIONS = new ToStringOptions(null, ", ", false, "'", null);
    public static final ToStringOptions BRACKETS_TO_STRING_OPTIONS = new ToStringOptions("[", ", ", false, null, "]");
    public static final ToStringOptions BRACKETS_SINGLE_QUOTE_TO_STRING_OPTIONS = new ToStringOptions("[", ", ", false, "'", "]");
    public static final ToStringOptions BRACKETS_LINE_FEEDS_TO_STRING_OPTIONS = new ToStringOptions("[", ", ", true, null, "]");
    public static final ToStringOptions BRACKETS_SINGLE_QUOTE_LINE_FEEDS_TO_STRING_OPTIONS = new ToStringOptions("[", ", ", true, "'", "]");

    private final CharSequence opening;
    private final CharSequence separator;
    private final boolean lineFeeds;
    private final CharSequence stringQuote;
    private final CharSequence arrayOpening;
    private final CharSequence arrayClosing;
    private final CharSequence closing;

    public ToStringOptions(CharSequence opening, CharSequence separator, boolean lineFeeds, CharSequence stringQuote, CharSequence closing) {
        this(opening, separator, lineFeeds, stringQuote, "[", "]", closing);
    }

    public ToStringOptions(CharSequence opening, CharSequence separator, boolean lineFeeds, CharSequence stringQuote, CharSequence arrayOpening, CharSequence arrayClosing, CharSequence closing) {
        this.opening = opening;
        this.separator = separator;
        this.lineFeeds = lineFeeds;
        this.stringQuote = stringQuote;
        this.arrayOpening = arrayOpening;
        this.arrayClosing = arrayClosing;
        this.closing = closing;
    }

    public CharSequence getOpening() {
        return opening;
    }

    public CharSequence getSeparator() {
        return separator;
    }

    public boolean isLineFeeds() {
        return lineFeeds;
    }

    public CharSequence getStringQuote() {
        return stringQuote;
    }

    public CharSequence getArrayOpening() {
        return arrayOpening;
    }

    public CharSequence getArrayClosing() {
        return arrayClosing;
    }

    public CharSequence getClosing() {
        return closing;
    }
}
