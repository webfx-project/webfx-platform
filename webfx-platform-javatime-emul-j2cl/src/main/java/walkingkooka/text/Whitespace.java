/*
 * Copyright 2019 Miroslav Pokorny (github.com/mP1)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package walkingkooka.text;

import java.util.Objects;

/**
 * A {@link CharSequence} that contains only contain whitespace.
 */
final public class Whitespace implements CharSequence {

    /**
     * Fails if the given {@link CharSequences} is null, empty or only whitespace.
     */
    public static <C extends CharSequence> C failIfNullOrEmptyOrWhitespace(final C chars,
                                                                           final String label) {
        Objects.requireNonNull(chars, label);
        if (onlyWhitespace(chars)) {
            throw new IllegalArgumentException(
                    label + " contains only whitespace=" + CharSequences.quoteAndEscape(chars));
        }
        return chars;
    }

    /**
     * Internal helper that checks if the given {@link CharSequence} is only filled with whitespace
     * without a null check.
     */
    @SuppressWarnings("deprecation")
    private static boolean onlyWhitespace(final CharSequence chars) {
        boolean onlyWhitespace = true;

        final int length = chars.length();
        for (int i = 0; i < length; i++) {
            if (false == Character.isSpace(chars.charAt(i))) {
                onlyWhitespace = false;
                break;
            }
        }

        return onlyWhitespace;
    }

    /**
     * Tests if the given chars has whitespace, returning true if a whitespace char of any sort was
     * found.
     */
    @SuppressWarnings("deprecation")
    public static boolean has(final CharSequence chars) {
        boolean found = false;

        if (null != chars) {
            final int length = chars.length();
            for (int i = 0; i < length; i++) {
                final char c = chars.charAt(i);
                if (Character.isSpace(c)) {
                    found = true;
                    break;
                }
            }
        }
        return found;
    }

    /**
     * An empty {@link Whitespace}.
     */
    public final static Whitespace EMPTY = new Whitespace("");

    /**
     * Creates a {@link Whitespace} with the given content which may not contain a single whitespace
     * character.
     */
    public static Whitespace with(final String content) {
        Objects.requireNonNull(content, "content");

        Whitespace whitespace = Whitespace.EMPTY;
        final int length = content.length();
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                final char c = content.charAt(i);
                if (false == Character.isWhitespace(c)) {
                    throw new IllegalArgumentException(
                            "Found non whitespace character at " + i + "="
                                    + CharSequences.quoteAndEscape(String.valueOf(c)));
                }
            }
            whitespace = new Whitespace(content);
        }

        return whitespace;
    }

    /**
     * Private constructor use factory
     */
    private Whitespace(final String content) {
        super();
        this.content = content;
    }

    // CharSequence

    @Override
    public int length() {
        return this.content.length();
    }

    @Override
    public char charAt(final int index) {
        return this.content.charAt(index);
    }

    @Override
    public CharSequence subSequence(final int start, final int end) {
        final String content = this.content;
        final int length = content.length();
        return (start == 0) && (end == length) ? this //
                : (start == end) && (start < length) ? Whitespace.EMPTY //
                : new Whitespace(content.subSequence(start, end).toString());
    }

    /**
     * A {@link String} filled with only whitespace.
     */
    private final String content;

    // Object

    @Override
    public int hashCode() {
        return this.content.hashCode();
    }

    @Override
    public boolean equals(final Object other) {
        return (this == other) || ((other instanceof Whitespace)
                && this.equals((Whitespace) other));
    }

    private boolean equals(final Whitespace other) {
        return this.content.equals(other.content);
    }

    /**
     * Dumps the string with whitespace without quotes.
     */
    @Override
    public String toString() {
        return this.content;
    }
}
