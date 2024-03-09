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

import walkingkooka.predicate.Orable;

import java.util.Objects;

/**
 * A {@link CharPredicate} that returns true if any of its 2 {@link CharPredicate predicates} return
 * true.
 */
final class OrCharPredicate extends LogicalCharPredicate implements CharPredicate {

    static CharPredicate wrap(final CharPredicate left, final CharPredicate right) {
        Objects.requireNonNull(left, "left CharPredicate");
        Objects.requireNonNull(right, "right CharPredicate");

        return left.equals(right) ?
                left :
                left instanceof Orable ?
                        left.or(right) :
                        right instanceof Orable ? right.or(left) : new OrCharPredicate(left, right);
    }

    /**
     * Private constructor use factory.
     */
    private OrCharPredicate(final CharPredicate left, final CharPredicate right) {
        super(left, right);
    }

    @Override
    public boolean test(final char value) {
        return this.left.test(value) || this.right.test(value);
    }

    @Override
    boolean canBeEqualType(final Object other) {
        return other instanceof OrCharPredicate;
    }

    @Override
    public String operator() {
        return "||";
    }
}
