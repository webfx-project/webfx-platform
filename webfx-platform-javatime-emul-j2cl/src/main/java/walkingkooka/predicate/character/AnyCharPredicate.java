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

package walkingkooka.predicate.character;

import walkingkooka.text.CharSequences;

import java.util.Arrays;
import java.util.Objects;

/**
 * A {@link CharPredicate} that test any characters that appear in the provided {@link
 * CharSequence}.
 */
final class AnyCharPredicate implements CharPredicate {

    /**
     * Creates a new {@link AnyCharPredicate} using the {@link String#length()} to select the best
     * {@link CharPredicate}.
     */
    static CharPredicate with(final String chars) {
        Objects.requireNonNull(chars, "chars");

        CharPredicate predicate;
        final int length = chars.length();
        switch (length) {
            case 0:
                predicate = CharPredicates.never();
                break;
            case 1:
                predicate = CharPredicates.is(chars.charAt(0));
                break;
            default:
                predicate
                        = AnyCharPredicate.sortCheckAndRemoveDuplicatesThenCreate(chars.toCharArray(),
                        length);
                break;
        }

        return predicate;
    }

    /**
     * Optimizes the array by left removing duplicates and then sorting. Sorting is necessary of a
     * binary search is performed on the array when match is called.
     */
    private static CharPredicate sortCheckAndRemoveDuplicatesThenCreate(char[] array,
                                                                        final int length) {
        Arrays.sort(array);

        // remove duplicates
        int duplicates = 0;
        int previous = AnyCharPredicate.IMPOSSIBLE_CHAR;
        for (int i = 0; i < length; i++) {
            final char c = array[i];
            if (c == previous) {
                duplicates++;
            }
            previous = c;
        }

        // if any duplicates create a new array and remove the duplicates.
        if (duplicates > 0) {
            array = AnyCharPredicate.removeDuplicates(array, length, duplicates);
        }

        return new AnyCharPredicate(array);
    }

    /**
     * Creates a new array without the duplicates.
     */
    private static char[] removeDuplicates(final char[] array, final int length,
                                           final int duplicates) {
        final char[] without = new char[length - duplicates];
        int previous = AnyCharPredicate.IMPOSSIBLE_CHAR;
        int i = 0;

        for (int j = 0; j < length; j++) {
            final char c = array[j];
            if (c != previous) {
                without[i] = c;
                i++;
            }
            previous = c;
        }
        return without;
    }

    private final static int IMPOSSIBLE_CHAR = Integer.MIN_VALUE;

    /**
     * Private constructor use factory.
     */
    private AnyCharPredicate(final char[] array) {
        super();
        this.array = array;
    }

    @Override
    public boolean test(final char c) {
        return Arrays.binarySearch(this.array, c) >= 0;
    }

    /**
     * The sorted array that uses a binary search to test any given chars.
     */
    final char[] array;

    // Object

    @Override
    public int hashCode() {
        return Arrays.hashCode(this.array);
    }

    @Override
    public boolean equals(final Object other) {
        return (this == other) || ((other instanceof AnyCharPredicate)
                && this.equals((AnyCharPredicate) other));
    }

    private boolean equals(final AnyCharPredicate predicate) {
        return Arrays.equals(this.array, predicate.array);
    }

    /**
     * Returns a {@link String} with the characters in quotes and escaped.
     */
    @Override
    public String toString() {
        return CharSequences.quoteIfChars(this.array).toString();
    }
}
