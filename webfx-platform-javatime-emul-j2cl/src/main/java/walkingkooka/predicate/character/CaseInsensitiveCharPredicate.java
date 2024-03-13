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
 * Wraps another {@link CharPredicate} and has some test by passing the lower case and upper case of
 * a letter to the wrapped {@link CharPredicate}.
 */
final class CaseInsensitiveCharPredicate implements CharPredicate {

    static CharPredicate with(final CharPredicate predicate) {
        Objects.requireNonNull(predicate, "predicate");

        return new CaseInsensitiveCharPredicate(predicate);
    }

    /**
     * Private constructor
     */
    private CaseInsensitiveCharPredicate(final CharPredicate predicate) {
        super();
        this.predicate = predicate;
    }

    @Override
    public boolean test(final char c) {
        final CharPredicate predicate = this.predicate;

        boolean matches = false;
        do {
            // try of is
            if (predicate.test(c)) {
                matches = true;
                break;
            }
            // try in upper case form.
            final char upper = Character.toUpperCase(c);
            if (upper != c) {
                // was lower try upper
                if (predicate.test(upper)) {
                    matches = true;
                }
                break;
            }
            final char lower = Character.toLowerCase(c);
            if (lower != c) {
                // was upper try lower
                if (predicate.test(lower)) {
                    matches = true;
                }
            }
        } while (false);

        return matches;
    }

    private final CharPredicate predicate;

    // Object

    @Override
    public int hashCode() {
        return this.predicate.hashCode();
    }

    @Override
    public boolean equals(final Object other) {
        return (this == other) || ((other instanceof CaseInsensitiveCharPredicate)
                && this.equals((CaseInsensitiveCharPredicate) other));
    }

    private boolean equals(final CaseInsensitiveCharPredicate other) {
        return this.predicate.equals(other.predicate);
    }

    @Override
    public String toString() {
        return this.predicate + " (CaseInsensitive)";
    }
}
