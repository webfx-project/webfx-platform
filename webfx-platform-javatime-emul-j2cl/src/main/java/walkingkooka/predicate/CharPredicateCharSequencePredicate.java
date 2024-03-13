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
 * A {@link Predicate} that only returns true if all characters in any {@link CharSequence}
 * are matched by the {@link CharPredicate}.
 */
final class CharPredicateCharSequencePredicate implements Predicate<CharSequence> {

    static Predicate<CharSequence> with(final CharPredicate predicate) {
        Objects.requireNonNull(predicate, "predicate");

        return new CharPredicateCharSequencePredicate(predicate);
    }

    private CharPredicateCharSequencePredicate(final CharPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public boolean test(final CharSequence charSequence) {
        Objects.requireNonNull(charSequence, "charSequence");

        boolean test = false;

        for (int i = 0; i < charSequence.length(); i++) {
            test = this.predicate.test(charSequence.charAt(i));
            if (!test) {
                break;
            }
        }

        return test;
    }

    private final CharPredicate predicate;

    // Object

    @Override
    public int hashCode() {
        return this.predicate.hashCode();
    }

    @Override
    public boolean equals(final Object other) {
        return this == other || other instanceof CharPredicateCharSequencePredicate && equals0((CharPredicateCharSequencePredicate) other);
    }

    private boolean equals0(final CharPredicateCharSequencePredicate other) {
        return this.predicate.equals(other.predicate);
    }

    @Override
    public String toString() {
        return this.predicate.toString();
    }
}
