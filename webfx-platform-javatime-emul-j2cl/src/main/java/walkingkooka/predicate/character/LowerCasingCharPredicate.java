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

import java.util.Objects;

/**
 * Wraps another {@link CharPredicate} and lower casing the incoming character before delegating to
 * the wrapped {@link CharPredicate predicate}.
 */
final class LowerCasingCharPredicate implements CharPredicate {

    /**
     * Wraps the given {@link CharPredicate}
     */
    static CharPredicate wrap(final CharPredicate predicate) {
        Objects.requireNonNull(predicate, "predicate");

        return predicate instanceof LowerCasingCharPredicate ?
                predicate :
                LowerCasingCharPredicate.wrapUnconditionally(predicate);
    }

    private static CharPredicate wrapUnconditionally(final CharPredicate predicate) {
        return new LowerCasingCharPredicate(predicate);
    }

    /**
     * Private constructor
     */
    private LowerCasingCharPredicate(final CharPredicate predicate) {
        super();
        this.predicate = predicate;
    }

    @Override
    public boolean test(final char c) {
        return this.predicate.test(Character.toLowerCase(c));
    }

    private final CharPredicate predicate;

    // Object
    @Override
    public int hashCode() {
        return this.predicate.hashCode();
    }

    @Override
    public boolean equals(final Object other) {
        return (this == other) || ((other instanceof LowerCasingCharPredicate)
                && this.equals((LowerCasingCharPredicate) other));
    }

    private boolean equals(final LowerCasingCharPredicate other) {
        return this.predicate.equals(other.predicate);
    }

    @Override
    public String toString() {
        return "lowercase then " + this.predicate;
    }
}
