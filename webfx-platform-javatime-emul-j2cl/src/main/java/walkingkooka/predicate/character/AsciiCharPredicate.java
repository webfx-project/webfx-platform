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

import walkingkooka.text.Ascii;

/**
 * A {@link CharPredicate} that only test ascii characters using {@link Ascii#is(char)}
 */
final class AsciiCharPredicate implements CharPredicate {

    /**
     * Singleton
     */
    final static AsciiCharPredicate INSTANCE = new AsciiCharPredicate();

    /**
     * Private constructor use singleton
     */
    private AsciiCharPredicate() {
        super();
    }

    @Override
    public boolean test(final char c) {
        return Ascii.is(c);
    }

    @Override
    public String toString() {
        return "ASCII";
    }
}
