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

/**
 * A {@link CharSequence} that is filled with a single character. Note it may be empty.
 */
final class RepeatingCharSequence extends CharSequence2<RepeatingCharSequence> {

    static CharSequence with(final char c, final int length) {
        if (length < 0) {
            throw new IllegalArgumentException("Length " + length + " must not be negative");
        }

        return 0 == length ? CharSequences.empty() : new RepeatingCharSequence(c, length);
    }

    /**
     * Private constructor use static factory.
     */
    private RepeatingCharSequence(final char c, final int length) {
        super();
        this.c = c;
        this.length = length;
    }

    @Override
    public int length() {
        return this.length;
    }

    /**
     * Ignores the index and returns the repeated character.
     */
    @Override
    char charAtIndex(final int index) {
        return this.c;
    }

    /**
     * Returns another {@link RepeatingCharSequence} with a new length but the same repeated
     * character.
     */
    @Override
    CharSequence subSequence0(final int start, final int end) {
        return RepeatingCharSequence.with(this.c, end - start);
    }

    @Override
    int calculateHashCode() {
        return this.c ^ (this.c << 16) ^ this.length;
    }

    @Override
    boolean canBeEqual(final Object other) {
        return other instanceof RepeatingCharSequence;
    }

    @Override
    boolean equals0(final RepeatingCharSequence repeating) {
        return (this.c == repeating.c) && (this.length == repeating.length);
    }

    // properties

    // both are shared with Indentation

    final char c;

    final int length;

    @Override
    String buildToString() {
        final char[] array = new char[this.length];
        Arrays.fill(array, this.c);
        return new String(array);
    }
}
