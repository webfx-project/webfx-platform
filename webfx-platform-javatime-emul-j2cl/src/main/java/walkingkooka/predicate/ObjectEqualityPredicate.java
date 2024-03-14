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

import walkingkooka.text.CharSequences;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * A {@link Predicate} that test any value using {@link Object#equals(Object)}.
 */
final class ObjectEqualityPredicate<T> implements Predicate<T> {

    /**
     * Creates a {@link ObjectEqualityPredicate}
     */
    static <T, U extends T> ObjectEqualityPredicate<T> with(final U value) {
        Objects.requireNonNull(value, "value");

        return new ObjectEqualityPredicate<>(value);
    }

    /**
     * Private constructor.
     */
    private ObjectEqualityPredicate(final T value) {
        this.value = value;
    }

    /**
     * If a <code>null</code> is passed no {@link NullPointerException} is thrown but a
     * <code>false</code> is returned instead.
     */
    @Override
    public boolean test(final T value) {
        return this.value.equals(value);
    }

    private final T value;

    // bject
    @Override
    public int hashCode() {
        return this.value.hashCode();
    }

    @Override
    public boolean equals(final Object other) {
        return (this == other) || ((other instanceof ObjectEqualityPredicate)
                && this.equals((ObjectEqualityPredicate<?>) other));
    }

    private boolean equals(final ObjectEqualityPredicate<?> other) {
        return this.value.equals(other.value);
    }

    @Override
    public String toString() {
        return CharSequences.quoteIfChars(this.value).toString();
    }
}
