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

import java.util.Objects;
import java.util.function.Predicate;

/**
 * A {@link Predicate} that inverts the result of the wrapped {@link Predicate}.
 */
final class NotPredicate<T> implements Predicate<T>,
        Notable<Predicate<T>> {

    static <T> Predicate<T> wrap(final Predicate<T> predicate) {
        Objects.requireNonNull(predicate, "predicate");

        return predicate instanceof Notable ? not(predicate) : new NotPredicate<>(predicate);
    }

    private static <T> Predicate<T> not(final Predicate<T> predicate) {
        final Notable<?> not = Cast.to(predicate);
        return Cast.to(not.negate());
    }

    /**
     * Private constructor
     */
    private NotPredicate(final Predicate<T> predicate) {
        super();
        this.predicate = predicate;
    }

    // Predicate<T>

    @Override
    public boolean test(final T value) {
        return false == this.predicate.test(value);
    }

    @Override
    public Predicate<T> negate() {
        return this.predicate;
    }

    private final Predicate<T> predicate;

    @Override
    public int hashCode() {
        return this.predicate.hashCode();
    }

    public boolean equals(final Object other) {
        return this == other || other instanceof NotPredicate && equals0((NotPredicate<?>) other);
    }

    private boolean equals0(final NotPredicate<?> other) {
        return this.predicate.equals(other.predicate);
    }

    public String toString() {
        return "!" + this.predicate;
    }
}
