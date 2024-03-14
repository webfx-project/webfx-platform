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

import java.util.Arrays;
import java.util.Objects;

/**
 * A possible line ending. Note it is not possible to create instances only the available constants
 * or singletons may be used. Identity checking is always safe.
 */
public enum LineEnding implements CharSequence {

    /**
     * Carriage return
     */
    CR("\r"),

    /**
     * Carriage return new line
     */
    CRNL("\r\n"),

    /**
     * New line
     */
    NL("\n"),

    /**
     * None
     */
    NONE("");

    /**
     * The actual system line ending.
     */
    //public final static LineEnding SYSTEM = from(SystemProperty.LINE_SEPARATOR.requiredPropertyValue());
    // j2cl SystemProperty is not supported due to AccessController usage. https://github.com/mP1/walkingkooka/issues/2438
    // default required because property will be absent https://github.com/mP1/walkingkooka/issues/2445
    public final static LineEnding SYSTEM = from(System.getProperty("line.separator", "\n"));

    /**
     * Returns the {@link LineEnding} for the given {@link String line ending}.
     */
    public static LineEnding from(final String lineEnding) {
        Objects.requireNonNull(lineEnding, "lineEnding");

        return Arrays.stream(values())
                .filter(le -> le.value.equals(lineEnding))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown line endings=" + CharSequences.quoteAndEscape(lineEnding)));
    }

    /**
     * Private constructor
     */
    LineEnding(final String value) {
        this.value = value;
    }

    // CharSequences....................................................................................................

    @Override
    public int length() {
        return this.value.length();
    }

    @Override
    public char charAt(final int index) {
        return this.value.charAt(index);
    }

    @Override
    public CharSequence subSequence(final int start, final int end) {
        final String value = this.value;
        return (start == 0) && (end == value.length()) ? this : this.value.subSequence(start, end);
    }

    private final String value;

    /**
     * Dumps the actual {@link String} holding the line ending characters.
     */
    @Override
    public String toString() {
        return this.value;
    }
}
