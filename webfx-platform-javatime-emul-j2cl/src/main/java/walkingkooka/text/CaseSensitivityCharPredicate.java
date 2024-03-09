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

import walkingkooka.predicate.character.CharPredicate;

/**
 * A {@link CharPredicate} that test the character given to it at create time.
 */
final class CaseSensitivityCharPredicate implements CharPredicate {

    /**
     * Creates a {@link CaseSensitivityCharPredicate}
     */
    static CaseSensitivityCharPredicate with(final char c, final CaseSensitivity sensitivity) {
        return new CaseSensitivityCharPredicate(c, sensitivity);
    }

    /**
     * Private constructor
     */
    private CaseSensitivityCharPredicate(final char c, final CaseSensitivity sensitivity) {
        this.c = c;
        this.sensitivity = sensitivity;
    }

    @Override
    public boolean test(final char c) {
        return this.sensitivity.isEqual(this.c, c);
    }

    private final char c;

    private final CaseSensitivity sensitivity;

    // Object

    @Override
    public int hashCode() {
        return this.c;
    }

    @Override
    public boolean equals(final Object other) {
        return (this == other) || ((other instanceof CaseSensitivityCharPredicate)
                && this.equals0((CaseSensitivityCharPredicate) other));
    }

    private boolean equals0(final CaseSensitivityCharPredicate other) {
        return (this.c == other.c) && //
                (this.sensitivity == other.sensitivity);
    }

    @Override
    public String toString() {
        return this.sensitivity.toString(this.c);
    }
}
