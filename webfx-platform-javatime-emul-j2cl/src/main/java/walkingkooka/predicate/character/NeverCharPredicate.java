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
 * A {@link CharPredicate} that always returns false.
 */
final class NeverCharPredicate implements CharPredicate,
        Andable,
        Orable,
        Notable<CharPredicate> {

    /**
     * Singleton
     */
    final static NeverCharPredicate INSTANCE = new NeverCharPredicate();

    private NeverCharPredicate() {
    }

    @Override
    public boolean test(final char c) {
        return false;
    }

    /**
     * Short circuit future requests to return false because false and anything is false.
     */
    public CharPredicate and(final CharPredicate other) {
        return this;
    }

    /**
     * The opposite of false is true.
     */
    @Override
    public CharPredicate negate() {
        return CharPredicates.always();
    }

    /**
     * Short circuit future requests to return the result of the other {@link CharPredicate} because
     * false OR other is other.
     */
    public CharPredicate or(final CharPredicate other) {
        return other;
    }

    @Override
    public String toString() {
        return "<none>";
    }
}
