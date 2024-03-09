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

package walkingkooka.predicate;

import walkingkooka.predicate.character.CharPredicate;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * A {@link Predicate} that test a {@link CharSequence} using two predicates, the first requires the initial char to be
 * true and the second matches remaining characters.
 */
final class InitialAndPartCharPredicateCharSequencePredicate implements Predicate<CharSequence> {

    static Predicate<CharSequence> with(final CharPredicate initial, final CharPredicate remaining) {
        Objects.requireNonNull(initial, "initial");
        Objects.requireNonNull(remaining, "remaining");

        return initial.equals(remaining) ? Predicates.charSequence(initial) : new InitialAndPartCharPredicateCharSequencePredicate(initial, remaining);
    }

    private InitialAndPartCharPredicateCharSequencePredicate(final CharPredicate initial, final CharPredicate remaining) {
        this.initial = initial;
        this.remaining = remaining;
    }

    @Override
    public boolean test(final CharSequence chars) {
        Objects.requireNonNull(chars, "chars");

        boolean result;

        switch (chars.length()) {
            case 0:
                result = false;
                break;
            case 1:
                result = this.testInitial(chars);
                break;
            default:
                result = this.testInitial(chars) && this.testRemaining(chars);
                break;
        }

        return result;
    }

    private boolean testInitial(final CharSequence chars) {
        return this.initial.test(chars.charAt(0));
    }

    private boolean testRemaining(final CharSequence chars) {
        boolean result = true;

        final int length = chars.length();
        for (int i = 1; result && i < length; i++) {
            result &= this.remaining.test(chars.charAt(i));
        }

        return result;
    }

    private final CharPredicate initial;
    private final CharPredicate remaining;

    // Object

    @Override
    public int hashCode() {
        return Objects.hash(this.initial, this.remaining);
    }

    @Override
    public boolean equals(final Object other) {
        return this == other || other instanceof InitialAndPartCharPredicateCharSequencePredicate && equals0((InitialAndPartCharPredicateCharSequencePredicate) other);
    }

    private boolean equals0(final InitialAndPartCharPredicateCharSequencePredicate other) {
        return this.initial.equals(other.initial) && this.remaining.equals(other.remaining);
    }

    @Override
    public String toString() {
        return "(" + this.initial + ", " + this.remaining + "*)";
    }
}
