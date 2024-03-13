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
import walkingkooka.text.Whitespace;

import java.util.Objects;

/**
 * Forwards all match requests to another wrapped {@link CharPredicate} but returns the given {@link
 * String}.
 */
final class ToStringCharPredicate implements CharPredicate {

    /**
     * Creates a new {@link ToStringCharPredicate}
     */
    static CharPredicate wrap(final CharPredicate predicate, final String toString) {
        Objects.requireNonNull(predicate, "predicate");
        Whitespace.failIfNullOrEmptyOrWhitespace(toString, "toString");

        return predicate.toString().equals(toString) ?
                predicate :
                new ToStringCharPredicate(unwrapIfNecessary(predicate), toString);
    }

    /**
     * Returns the wrapped {@link CharPredicate}.
     */
    private static CharPredicate unwrapIfNecessary(final CharPredicate predicate) {
        return predicate instanceof ToStringCharPredicate ?
                unwrap(Cast.to(predicate)) :
                predicate;
    }

    private static CharPredicate unwrap(final ToStringCharPredicate predicate) {
        return predicate.predicate;
    }

    /**
     * Private constructor
     */
    private ToStringCharPredicate(final CharPredicate predicate, final String toString) {
        super();
        this.predicate = predicate;
        this.toString = toString;
    }

    @Override
    public boolean test(final char c) {
        return this.predicate.test(c);
    }

    /**
     * Package private for testing
     */
    final CharPredicate predicate;

    // Object
    @Override
    public int hashCode() {
        return this.predicate.hashCode() ^ this.toString.hashCode();
    }

    @Override
    public boolean equals(final Object other) {
        return (this == other) || ((other instanceof ToStringCharPredicate)
                && this.equals((ToStringCharPredicate) other));
    }

    private boolean equals(final ToStringCharPredicate other) {
        return this.predicate.equals(other.predicate) && this.toString.equals(other.toString);
    }

    @Override
    public String toString() {
        return this.toString;
    }

    final String toString;
}
