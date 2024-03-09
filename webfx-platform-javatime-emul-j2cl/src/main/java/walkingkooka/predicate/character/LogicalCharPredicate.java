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
 * A base class for any {@link CharPredicate} that includes a method to help possibly combine both
 * parameters.
 */
abstract class LogicalCharPredicate implements CharPredicate {

    final CharPredicate left;

    final CharPredicate right;

    /**
     * Package private to limit sub classing.
     */
    LogicalCharPredicate(final CharPredicate left, final CharPredicate right) {
        super();
        this.left = left;
        this.right = right;
    }

    // Object

    @Override
    final public int hashCode() {
        return Objects.hash(this.left, this.right);
    }

    @Override
    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    final public boolean equals(final Object other) {
        return other == this ||
                (this.canBeEqualType(other) && this.equals0((LogicalCharPredicate) other));
    }

    /**
     * Sub classes should do a implements this type here
     */
    abstract boolean canBeEqualType(final Object other);

    private boolean equals0(final LogicalCharPredicate other) {
        return this.left.equals(other.left) && this.right.equals(other.right);
    }

    @Override
    final public String toString() {
        return this.left + " " + this.operator() + " " + this.right;
    }

    abstract String operator();
}
