package dev.webfx.platform.util.collection;

/**
 * @author Bruno Salmon
 */
public class ToStringOptionsBuilder {

    private CharSequence opening; // no opening sequence by default
    private CharSequence separator = ", "; // default separator
    private boolean lineFeeds = false; // no line feeds by default
    private CharSequence stringQuote; // no string quotes by default
    private CharSequence arrayOpening = "[";
    private CharSequence arrayClosing = "]";
    private CharSequence closing; // no closing sequence by default

    public ToStringOptionsBuilder setOpening(CharSequence opening) {
        this.opening = opening;
        return this;
    }

    public ToStringOptionsBuilder setSeparator(CharSequence separator) {
        this.separator = separator;
        return this;
    }

    public ToStringOptionsBuilder setLineFeeds(boolean lineFeeds) {
        this.lineFeeds = lineFeeds;
        return this;
    }

    public ToStringOptionsBuilder setStringQuote(CharSequence stringQuote) {
        this.stringQuote = stringQuote;
        return this;
    }

    public ToStringOptionsBuilder setArrayOpening(CharSequence arrayOpening) {
        this.arrayOpening = arrayOpening;
        return this;
    }

    public ToStringOptionsBuilder setArrayClosing(CharSequence arrayClosing) {
        this.arrayClosing = arrayClosing;
        return this;
    }

    public ToStringOptionsBuilder setClosing(CharSequence closing) {
        this.closing = closing;
        return this;
    }

    public ToStringOptionsBuilder applyOpeningClosingBrackets() {
        return setOpening("[").setClosing("]");
    }

    public ToStringOptionsBuilder applyOpeningClosingCurlies() {
        return setOpening("{").setClosing("}");
    }

    public ToStringOptionsBuilder applySingleQuoteOnStrings() {
        return setStringQuote("'");
    }

    public ToStringOptionsBuilder applyDoubleQuoteOnStrings() {
        return setStringQuote("\"");
    }

    public ToStringOptionsBuilder applylineFeeds() {
        return setLineFeeds(true);
    }

    public ToStringOptions build() {
        return new ToStringOptions(opening, separator, lineFeeds, stringQuote, arrayOpening, arrayClosing, closing);
    }
}
