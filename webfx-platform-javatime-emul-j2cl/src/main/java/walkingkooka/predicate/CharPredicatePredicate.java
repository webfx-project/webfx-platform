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
 * A {@link Predicate} adaptor that unwraps the {@link Character} and passes that char to a {@link
 * CharPredicate}.
 */
final class CharPredicatePredicate implements Predicate<Character> {

    /**
     * Creates a new {@link CharPredicatePredicate}
     */
    static CharPredicatePredicate adapt(final CharPredicate predicate) {
        Objects.requireNonNull(predicate, "predicate");
        return new CharPredicatePredicate(predicate);
    }

    /**
     * Private constructor use static factory
     */
    private CharPredicatePredicate(final CharPredicate predicate) {
        super();
        this.predicate = predicate;
    }

    // Predicate

    @Override
    public boolean test(final Character value) {
        Objects.requireNonNull(value, "value");
        return this.predicate.test(value);
    }

    /**
     * The wrapped {@link CharPredicate}.
     */
    private final CharPredicate predicate;

    // Object

    @Override
    public int hashCode() {
        return this.predicate.hashCode();
    }

    @Override
    public boolean equals(final Object other) {
        return (this == other) || ((other instanceof CharPredicatePredicate)
                && this.equals((CharPredicatePredicate) other));
    }

    private boolean equals(final CharPredicatePredicate other) {
        return this.predicate.equals(other.predicate);
    }

    /**
     * Dumps the wrapped {@link CharPredicate#toString()}.
     */
    @Override
    public String toString() {
        return this.predicate.toString();
    }
}
