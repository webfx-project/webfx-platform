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

package walkingkooka;

import walkingkooka.text.CharSequences;
import walkingkooka.text.Whitespace;

import java.util.Objects;

/**
 * An {@link IllegalArgumentException} that reports an {@link String} with an invalid length.
 */
public class InvalidTextLengthException extends InvalidTextException {

    public InvalidTextLengthException(final String label,
                                      final String text,
                                      final int min,
                                      final int max) {
        super();
        checkText(label, text, min, max);
        this.label = label;
        this.text = text;
        this.min = min;
        this.max = max;
    }

    public InvalidTextLengthException(final String label,
                                      final String text,
                                      final int min,
                                      final int max,
                                      final Throwable cause) {
        super(cause);
        checkText(label, text, min, max);
        this.label = label;
        this.text = text;
        this.min = min;
        this.max = max;
    }

    private static void checkText(final String label,
                                  final String text,
                                  final int min,
                                  final int max) {
        Whitespace.failIfNullOrEmptyOrWhitespace(label, "label");
        Objects.requireNonNull(text, "text");

        if (min < 0) {
            throw new IllegalArgumentException("Invalid min " + min + " < 0");
        }

        if (max < min) {
            throw new IllegalArgumentException("Invalid max " + max + " < " + min);
        }
    }

    public String text() {
        return this.text;
    }

    private final String text;

    public int min() {
        return this.min;
    }

    private final int min;

    public int max() {
        return this.max;
    }

    private final int max;

    @Override
    public String getMessage() {
        return "Length " + this.text.length() +
                " of " + CharSequences.quoteAndEscape(this.label) +
                " not between " + this.min + ".." + this.max +
                " = " + CharSequences.quote(this.text);
    }

    public String label() {
        return this.label;
    }

    private final String label;

    private static final long serialVersionUID = 1L;

    // Object...........................................................................................................

    @Override
    public int hashCode() {
        return Objects.hash(this.getMessage());
    }

    @Override
    public boolean equals(final Object other) {
        return this == other || other instanceof InvalidTextLengthException && this.equals0((InvalidTextLengthException) other);
    }

    private boolean equals0(final InvalidTextLengthException other) {
        return this.label.equals(other.label) &&
                this.text().equals(other.text()) &&
                this.min() == other.min() &&
                this.max() == other.max();
    }
}
