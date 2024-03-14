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
import walkingkooka.text.Whitespace;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * Wraps another {@link Predicate} replacing or ignoring its {@link Predicate#toString()} with the provided {@link String}.
 */
final class CustomToStringPredicate<T> implements Predicate<T> {

    static <T> Predicate<T> wrap(final Predicate<T> predicate, final String toString) {
        Objects.requireNonNull(predicate, "predicate");
        Whitespace.failIfNullOrEmptyOrWhitespace(toString, "toString");

        Predicate<T> result;

        do {
            if (predicate.toString().equals(toString)) {
                result = predicate;
                break;
            }

            Predicate<T> wrap = predicate;
            if (predicate instanceof CustomToStringPredicate) {
                // unwrap then re-wrap the predicate...
                final CustomToStringPredicate<T> custom = Cast.to(wrap);
                wrap = custom.predicate;
            }
            result = new CustomToStringPredicate<>(wrap, toString);
        } while (false);

        return result;
    }

    private CustomToStringPredicate(final Predicate<T> predicate, final String toString) {
        this.predicate = predicate;
        this.toString = toString;
    }

    @Override
    public boolean test(final T t) {
        return this.predicate.test(t);
    }

    // @VisibleForTesting
    final Predicate<T> predicate;


    // Object
    @Override
    public int hashCode() {
        return Objects.hash(this.predicate, this.toString);
    }

    @Override
    public boolean equals(final Object other) {
        return this == other || other instanceof CustomToStringPredicate && this.equals0(Cast.to(other));
    }

    private boolean equals0(final CustomToStringPredicate<?> other) {
        return this.predicate.equals(other.predicate) &&
                this.toString.equals(other.toString);
    }

    @Override
    public String toString() {
        return toString;
    }

    // @VisibleForTesting
    final String toString;
}
