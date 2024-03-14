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

package walkingkooka.compare;

import walkingkooka.predicate.character.CharPredicate;

import java.util.Comparator;
import java.util.Objects;

/**
 * A {@link Comparator} that uses a {@link CharPredicate} to test if a string of characters exist
 * and should be normalized for purposes of comparison. This {@link Comparator} is particularly
 * useful for comparing {@link CharSequence} while ignoring redundant whitespace.
 */
final class NormalizingCharSequenceComparator<S extends CharSequence> implements Comparator<S> {

    /**
     * Creates a {@link NormalizingCharSequenceComparator}
     */
    static <S extends CharSequence> NormalizingCharSequenceComparator<S> with(
            final CharPredicate predicate) {
        Objects.requireNonNull(predicate, "predicate");

        return new NormalizingCharSequenceComparator<>(predicate);
    }

    /**
     * Private constructor use static factory.
     */
    private NormalizingCharSequenceComparator(final CharPredicate predicate) {
        super();
        this.predicate = predicate;
    }

    // Comparator

    @Override
    public int compare(final S chars1, final S chars2) {
        int value;

        final CharPredicate predicate = this.predicate;

        final int length1 = chars1.length();
        final int length2 = chars2.length();

        int i1 = 0;
        int i2 = 0;

        for (; ; ) {
            if (i1 == length1) {
                value = i2 == length2 ? Comparators.EQUAL : Comparators.LESS;
                break;
            }
            if (i2 == length2) {
                value = Comparators.MORE;
                break;
            }

            final char c1 = chars1.charAt(i1);
            final char c2 = chars2.charAt(i2);

            i1++;
            i2++;
            if (predicate.test(c1) && predicate.test(c2)) {
                i1 = NormalizingCharSequenceComparator.advanceWhileMatching(i1, chars1, predicate);
                i2 = NormalizingCharSequenceComparator.advanceWhileMatching(i2, chars2, predicate);
                continue;
            }
            value = c1 - c2;
            if (0 == value) {
                continue;
            }
            break;
        }

        return value;
    }

    /**
     * Advances and returns the index pointing to the next non matching character.
     */
    private static int advanceWhileMatching(final int index, final CharSequence chars,
                                            final CharPredicate predicate) {
        final int length = chars.length();
        int i = index;

        for (; ; ) {
            if (i == length) {
                break;
            }
            if (false == predicate.test(chars.charAt(i))) {
                break;
            }
            i++;
        }
        return i;
    }

    /**
     * The {@link CharPredicate} that normalizes.
     */
    private final CharPredicate predicate;

    // Object

    @Override
    public int hashCode() {
        return this.predicate.hashCode();
    }

    @Override
    public boolean equals(final Object other) {
        return (this == other) || ((other instanceof NormalizingCharSequenceComparator)
                && this.equals0((NormalizingCharSequenceComparator<?>) other));
    }

    private boolean equals0(final NormalizingCharSequenceComparator<?> other) {
        return this.predicate.equals(other.predicate);
    }

    /**
     * Dumps <code>normalizing </code> and the {@link CharPredicate}.
     */
    @Override
    public String toString() {
        return "normalizing " + this.predicate;
    }
}
