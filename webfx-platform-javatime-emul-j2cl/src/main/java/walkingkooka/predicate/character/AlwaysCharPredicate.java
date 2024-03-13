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

import walkingkooka.predicate.Andable;
import walkingkooka.predicate.Notable;
import walkingkooka.predicate.Orable;

/**
 * A {@link CharPredicate} that always returns true regardless of input.
 */
final class AlwaysCharPredicate
        implements CharPredicate, Andable, Orable, Notable<CharPredicate> {
    /**
     * Singleton
     */
    final static AlwaysCharPredicate INSTANCE = new AlwaysCharPredicate();

    /**
     * Private constructor use singleton
     */
    private AlwaysCharPredicate() {
    }

    @Override
    public boolean test(final char c) {
        return true;
    }

    /**
     * Short circuit future requests to simply ask the other {@link CharPredicate}.
     */
    public CharPredicate and(final CharPredicate other) {
        return other;
    }

    /**
     * The opposite of true is false
     */
    @Override
    public CharPredicate negate() {
        return CharPredicates.never();
    }

    /**
     * Short circuit the other {@link CharPredicate} always return true.
     */
    public CharPredicate or(final CharPredicate other) {
        return this;
    }

    @Override
    public String toString() {
        return "*";
    }
}
