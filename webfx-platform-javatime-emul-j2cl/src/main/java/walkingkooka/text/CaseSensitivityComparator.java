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

import walkingkooka.compare.Comparators;

import java.util.Comparator;
import java.util.Objects;

/**
 * A {@link Comparator} for comparing two {@link CharSequence} character by character, regardless
 * of type using a {@link CaseSensitivity} of the char comparison strategy.
 */
final class CaseSensitivityComparator<C extends CharSequence> implements Comparator<C> {

    /**
     * Type safe getter.
     */
    static <C extends CharSequence> CaseSensitivityComparator<C> sensitive() {
        return CaseSensitivityComparator.cast(CaseSensitivityComparator.SENSITIVE);
    }

    private final static CaseSensitivityComparator<CharSequence> SENSITIVE
            = new CaseSensitivityComparator<>(CaseSensitivity.SENSITIVE);

    /**
     * Type safe getter.
     */
    static <C extends CharSequence> CaseSensitivityComparator<C> insensitive() {
        return CaseSensitivityComparator.cast(CaseSensitivityComparator.INSENSITIVE);
    }

    private final static CaseSensitivityComparator<CharSequence> INSENSITIVE
            = new CaseSensitivityComparator<>(CaseSensitivity.INSENSITIVE);

    /**
     * Hides the horrible cast.
     */
    @SuppressWarnings("unchecked")
    private static <C extends CharSequence> CaseSensitivityComparator<C> cast(
            final CaseSensitivityComparator<?> comparator) {
        return (CaseSensitivityComparator<C>) comparator;
    }

    /**
     * Private ctor use of of the two singleton getters.
     */
    private CaseSensitivityComparator(final CaseSensitivity sensitivity) {
        this.sensitivity = sensitivity;
    }

    /**
     * First tests the lengths and then compares character by character using {@link
     * CaseSensitivity#compare(char, char)} aborting both cases when a non equal/zero value is
     * returned.
     */
    @Override
    public int compare(final C chars, final C otherChars) {
        Objects.requireNonNull(chars, "chars");
        Objects.requireNonNull(otherChars, "otherChars");

        final int length = chars.length();
        final int otherLength = otherChars.length();
        final int shorter = Math.min(length, otherLength);
        final CaseSensitivity sensitivity = this.sensitivity;

        int value = 0;

        // give up when a mis-match is encountered
        for (int i = 0; i < shorter; i++) {
            value = sensitivity.compare(chars.charAt(i), otherChars.charAt(i));
            if (0 != value) {
                break;
            }
        }

        if (Comparators.EQUAL == value) {
            value = length - otherLength;
        }

        return value;
    }

    private final CaseSensitivity sensitivity;

    @Override
    public String toString() {
        return this.sensitivity.toString();
    }
}
