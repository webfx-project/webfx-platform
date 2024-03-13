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

import walkingkooka.Cast;
import walkingkooka.predicate.Notable;

import java.util.Objects;

/**
 * Inverts the results returned by the wrapped {@link CharPredicate}.
 */
final class NotCharPredicate implements CharPredicate,
        Notable<CharPredicate> {

    static CharPredicate wrap(final CharPredicate predicate) {
        Objects.requireNonNull(predicate, "predicate");

        return predicate instanceof Notable ? not(predicate) : new NotCharPredicate(predicate);
    }

    private static CharPredicate not(final CharPredicate predicate) {
        final Notable<?> not = Cast.to(predicate);
        return Cast.to(not.negate());
    }

    /**
     * Private constructor
     */
    private NotCharPredicate(final CharPredicate predicate) {
        super();
        this.predicate = predicate;
    }

    // CharPredicate

    @Override
    public boolean test(final char c) {
        return false == this.predicate.test(c);
    }

    @Override
    public CharPredicate negate() {
        return this.predicate;
    }

    private final CharPredicate predicate;

    @Override
    public int hashCode() {
        return this.predicate.hashCode();
    }

    @Override
    public boolean equals(final Object other) {
        return this == other
                || other instanceof NotCharPredicate && equals0((NotCharPredicate) other);
    }

    private boolean equals0(final NotCharPredicate other) {
        return this.predicate.equals(other.predicate);
    }

    @Override
    public String toString() {
        return "!" + this.predicate;
    }
}
