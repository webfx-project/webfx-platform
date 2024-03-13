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

import walkingkooka.Cast;

import java.util.function.Predicate;

/**
 * A {@link Predicate} that always returns true regardless of input.
 */
final class AlwaysPredicate<T> implements Predicate<T>,
        Andable,
        Orable,
        Notable<Predicate<T>> {

    /**
     * Singleton
     */
    private final static AlwaysPredicate<Object> INSTANCE = new AlwaysPredicate<>();

    /**
     * Type safe singleton getter.
     */
    static <T> AlwaysPredicate<T> instance() {
        return Cast.to(AlwaysPredicate.INSTANCE);
    }

    private AlwaysPredicate() {
    }

    @Override
    public boolean test(final T value) {
        return true;
    }

    /**
     * Short circuit future requests to simply ask the other {@link Predicate}.
     */
    @Override
    public Predicate<T> and(final Predicate<? super T> other) {
        return Cast.to(other);
    }

    /**
     * The opposite of true is false
     */
    @Override
    public Predicate<T> negate() {
        return Predicates.never();
    }

    /**
     * Short circuit the other {@link Predicate} always return true.
     */
    @Override
    public Predicate<T> or(final Predicate<? super T> other) {
        return this;
    }

    @Override
    public String toString() {
        return "*";
    }
}
