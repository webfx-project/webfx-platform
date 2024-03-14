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

/**
 * A {@link CharPredicate} that only test carriage returns or newlines.
 */
final class EndOfLineCharPredicate implements CharPredicate {

    /**
     * Singleton
     */
    final static EndOfLineCharPredicate INSTANCE = new EndOfLineCharPredicate();

    /**
     * Private constructor use singleton
     */
    private EndOfLineCharPredicate() {
        super();
    }

    @Override
    public boolean test(final char c) {
        return ('\r' == c) || ('\n' == c);
    }

    @Override
    public String toString() {
        return "cr/nl";
    }
}
