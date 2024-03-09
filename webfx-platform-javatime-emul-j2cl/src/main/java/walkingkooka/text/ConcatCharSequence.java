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
 * A {@link CharSequence} that combines two char sequences into a single unit.
 */
final class ConcatCharSequence extends CharSequence2<ConcatCharSequence> {

    /**
     * Factory that creates a new {@link ConcatCharSequence} or handles empty.
     */
    static CharSequence with(final CharSequence first,
                             final CharSequence second) {
        Objects.requireNonNull(first, "first");
        Objects.requireNonNull(second, "second");

        return with0(first, second);
    }

    private static CharSequence with0(final CharSequence first,
                                      final CharSequence second) {
        return first.length() == 0 ?
                second :
                second.length() == 0 ?
                        first :
                        new ConcatCharSequence(first, second);
    }

    /**
     * Private constructor use static factory.
     */
    private ConcatCharSequence(final CharSequence first,
                               final CharSequence second) {
        super();
        this.first = first;
        this.second = second;
    }

    @Override
    public int length() {
        return this.first.length() + this.second.length();
    }

    // assumes index is valid
    @Override
    char charAtIndex(final int index) {
        final CharSequence first = this.first;
        final int firstEnd = first.length();

        return index < firstEnd ?
                first.charAt(index) :
                this.second.charAt(index - firstEnd);
    }

    /**
     * Depending on the indices could return either of the properties or a new {@link ConcatCharSequence}
     */
    @Override
    CharSequence subSequence0(final int start, final int end) {
        final CharSequence first = this.first;
        final int firstEnd = first.length();

        return end <= firstEnd ?
                first.subSequence(start, end) :
                start >= firstEnd ?
                        this.second.subSequence(start - firstEnd, end - firstEnd) :
                        with0(first.subSequence(start, firstEnd), this.second.subSequence(0, end - firstEnd));
    }

    @Override
    int calculateHashCode() {
        return Objects.hash(this.first, this.second);
    }

    @Override
    boolean canBeEqual(final Object other) {
        return other instanceof ConcatCharSequence;
    }

    @Override
    boolean equals0(final ConcatCharSequence other) {
        boolean equals = false;

        final int length = this.first.length() + this.second.length();

        if (length == other.first.length() + other.second.length()) {
            equals = true;

            // test character by character...
            for (int i = 0; equals && i < length; i++) {
                equals = this.charAtIndex(i) == other.charAtIndex(i);
            }
        }

        return equals;
    }

    // properties

    final CharSequence first;
    final CharSequence second;

    @Override
    String buildToString() {
        return String.valueOf(this.first) +
                this.second;
    }
}
