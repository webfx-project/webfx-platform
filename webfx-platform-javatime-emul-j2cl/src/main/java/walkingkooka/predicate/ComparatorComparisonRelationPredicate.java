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

package walkingkooka.predicate;

import walkingkooka.compare.CompareResult;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * A {@link Predicate} that compares a fixed {@link Comparable} with the test value, returning true if the
 * {@link CompareResult} is satisfied.
 */
final class ComparableCompareResultPredicate<C extends Comparable<C>> implements Predicate<C> {

    /**
     * Factory that creates a new {@link ComparableCompareResultPredicate}
     */
    static <C extends Comparable<C>> ComparableCompareResultPredicate<C> with(final CompareResult compareResult,
                                                                              final C right) {
        Objects.requireNonNull(compareResult, "compareResult");
        Objects.requireNonNull(right, "right");

        return new ComparableCompareResultPredicate<>(compareResult, right);
    }

    /**
     * Private ctor use factory
     */
    private ComparableCompareResultPredicate(final CompareResult compareResult, final C right) {
        super();
        this.compareResult = compareResult;
        this.right = right;
    }

    @Override
    public boolean test(final C left) {
        return compareResult.test(left.compareTo(this.right));
    }

    /**
     * The {@link CompareResult} that tests the {@link Comparable#compareTo(Object)}.
     */
    private final CompareResult compareResult;

    /**
     * The right or first of the {@link Comparable#compareTo(Object)}
     */
    private final C right;

    @Override
    public String toString() {
        return this.compareResult + " " + this.right;
    }
}
