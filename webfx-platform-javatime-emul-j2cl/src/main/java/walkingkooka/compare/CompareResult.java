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

package walkingkooka.compare;

import walkingkooka.predicate.Predicates;
import walkingkooka.text.CharSequences;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * The 6 standard {@link CompareResult}.
 */
public enum CompareResult implements Predicate<Integer> {

    EQ("=") {
        @Override
        public boolean test(final int value) {
            return 0 == value;
        }

        @Override
        public CompareResult invert() {
            return NE;
        }

        /**
         * Operand side does not affect test.
         */
        @Override
        public CompareResult swap() {
            return this;
        }
    },
    GTE(">=") {
        @Override
        public boolean test(final int value) {
            return value >= 0;
        }

        @Override
        public CompareResult invert() {
            return LT;
        }

        @Override
        public CompareResult swap() {
            return LTE;
        }
    },
    GT(">") {
        @Override
        public boolean test(final int value) {
            return value > 0;
        }

        @Override
        public CompareResult invert() {
            return LTE;
        }

        @Override
        public CompareResult swap() {
            return LT;
        }
    },
    LTE("<=") {
        @Override
        public boolean test(final int value) {
            return value <= 0;
        }

        @Override
        public CompareResult invert() {
            return GT;
        }

        @Override
        public CompareResult swap() {
            return GTE;
        }
    },
    LT("<") {
        @Override
        public boolean test(final int value) {
            return value < 0;
        }

        @Override
        public CompareResult invert() {
            return GTE;
        }

        @Override
        public CompareResult swap() {
            return GT;
        }
    },
    NE("!=") {
        @Override
        public boolean test(final int value) {
            return 0 != value;
        }

        @Override
        public CompareResult invert() {
            return EQ;
        }

        /**
         * Operand side does not affect test.
         */
        @Override
        public CompareResult swap() {
            return this;
        }
    };

    CompareResult(final String symbol) {
        this.symbol = symbol;
    }

    /**
     * Returns true if the integer satisfies the relation. The numeric values follow the {@link Comparator} return values.
     */
    @SuppressWarnings("UnnecessaryUnboxing")
    @Override
    public boolean test(final Integer integer) {
        return this.test(integer.intValue());
    }

    public abstract boolean test(final int integer);

    /**
     * The mathematical symbol for the relation, eg {@link #LTE} returns "<=".
     */
    public final String symbol() {
        return this.symbol;
    }

    private final String symbol;

    /**
     * Returns a {@link Predicate} that uses the given value as the right of a comparison.
     */
    public <C extends Comparable<C>> Predicate<C> predicate(final C right) {
        return Predicates.compareResult(this, right);
    }

    /**
     * The inverted or opposite relation.
     */
    abstract public CompareResult invert();

    /**
     * Returns the {@link CompareResult} when operands in a comparison sides are swapped.
     */
    abstract public CompareResult swap();

    /**
     * A comparison operator that selects the value given a {@link CompareResult}. Values may be null.
     */
    public final <T> T value(final T less,
                             final T equal,
                             final T greater) {
        return EQ == this ?
                equal :
                LT == this ?
                        less :
                        GT == this ?
                                greater :
                                uoe();
    }

    /**
     * Uses this to select one of the possible {@link Supplier suppliers}.
     */
    public final <T> T get(final Supplier<? extends T> less,
                           final Supplier<? extends T> equal,
                           final Supplier<? extends T> greater) {
        return EQ == this ?
                equal.get() :
                LT == this ?
                        less.get() :
                        GT == this ?
                                greater.get() :
                                uoe();
    }

    private static <T> T uoe() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the equivalent {@link CompareResult} given a {@link Comparable#compareTo(Object)} int result.
     */
    public static CompareResult intCompareResult(final int value) {
        return 0 == value ?
                EQ :
                value < 0 ?
                        LT : GT;
    }

    /**
     * Finds a {@link CompareResult} with the {@link String symbol} or throws a {@link IllegalArgumentException}.
     */
    public static CompareResult findWithSymbol(final String symbol) {
        Objects.requireNonNull(symbol);

        return Arrays.stream(CompareResult.values())
                .filter(r -> r.symbol().equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unable to find symbol " + CharSequences.quote(symbol)));
    }
}
