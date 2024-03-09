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

import java.util.Objects;

/**
 * A {@link CharPredicate} that returns true if both of its 2 {@link CharPredicate predicates}
 * return true.
 */
final class AndCharPredicate extends LogicalCharPredicate {

    static CharPredicate wrap(final CharPredicate left, final CharPredicate right) {
        Objects.requireNonNull(left, "left CharPredicate");
        Objects.requireNonNull(right, "right CharPredicate");

        return left.equals(right) ?
                left :
                left instanceof Andable ?
                        left.and(right) :
                        right instanceof Andable ?
                                right.and(left) :
                                new AndCharPredicate(left, right);
    }

    /**
     * Private constructor use factory.
     */
    private AndCharPredicate(final CharPredicate left, final CharPredicate right) {
        super(left, right);
    }

    @Override
    public boolean test(final char value) {
        return this.left.test(value) && this.right.test(value);
    }

    @Override
    boolean canBeEqualType(final Object other) {
        return other instanceof AndCharPredicate;
    }

    @Override
    String operator() {
        return "&&";
    }
}
