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

import walkingkooka.predicate.Predicates;

import java.util.function.Predicate;

/**
 * Accepts char and returns true if they match some condition.
 */
public interface CharPredicate {
    /**
     * Returns true if the given character is matched.
     */
    boolean test(char c);

    default CharPredicate and(final CharPredicate other) {
        return CharPredicates.and(this, other);
    }

    default CharPredicate andNot(final CharPredicate other) {
        return CharPredicates.andNot(this, other);
    }

    default CharPredicate negate() {
        return CharPredicates.not(this);
    }

    default CharPredicate or(final CharPredicate other) {
        return CharPredicates.or(this, other);
    }

    default Predicate<Character> asPredicate() {
        return Predicates.charPredicate(this);
    }

    default CharPredicate setToString(final String toString) {
        return CharPredicates.toString(this, toString);
    }
}
