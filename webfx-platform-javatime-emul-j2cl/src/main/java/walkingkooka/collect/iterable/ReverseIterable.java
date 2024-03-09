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

package walkingkooka.collect.iterable;

import walkingkooka.Cast;
import walkingkooka.collect.iterator.Iterators;

import java.util.Iterator;
import java.util.Objects;

/**
 * An {@link Iterable} that wraps another returning an {@link Iterable} that returns items in
 * reverse order.
 */
final class ReverseIterable<T> implements Iterable<T> {

    static <T> Iterable<T> wrap(final Iterable<T> iterable) {
        Objects.requireNonNull(iterable, "iterable");

        Iterable<T> result;
        if (iterable instanceof ReverseIterable) {
            final ReverseIterable<T> reverseIterable = Cast.to(iterable);
            result = reverseIterable.iterable;
        } else {
            result = new ReverseIterable<>(iterable);
        }

        return result;
    }

    /**
     * Private constructor use factory.
     */
    private ReverseIterable(final Iterable<T> iterable) {
        super();
        this.iterable = iterable;
    }

    @Override
    public Iterator<T> iterator() {
        return Iterators.reverse(this.iterable.iterator());
    }

    private final Iterable<T> iterable;

    @Override
    public String toString() {
        return this.iterable.toString();
    }
}
