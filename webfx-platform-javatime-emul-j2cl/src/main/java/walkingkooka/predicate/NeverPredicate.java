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
 * A {@link Predicate} that always returns false.
 */
final class NeverPredicate<T> implements Predicate<T>,
        Andable,
        Orable,
        Notable<Predicate<T>> {

    /**
     * Singleton
     */
    private final static NeverPredicate<Object> INSTANCE = new NeverPredicate<>();

    /**
     * Type safe singleton getter.
     */
    static <T> NeverPredicate<T> instance() {
        return Cast.to(NeverPredicate.INSTANCE);
    }

    private NeverPredicate() {
    }

    @Override
    public boolean test(final T value) {
        return false;
    }

    /**
     * Short circuit future requests to return false because false and anything is false.
     */
    @Override
    public Predicate<T> and(final Predicate<? super T> other) {
        return this;
    }

    /**
     * The opposite of false is true.
     */
    @Override
    public Predicate<T> negate() {
        return Predicates.always();
    }

    /**
     * Short circuit future requests to return the result of the other {@link Predicate} because
     * false OR other is other.
     */
    @Override
    public Predicate<T> or(final Predicate<? super T> other) {
        return Cast.to(other);
    }

    @Override
    public String toString() {
        return "<none>";
    }
}
