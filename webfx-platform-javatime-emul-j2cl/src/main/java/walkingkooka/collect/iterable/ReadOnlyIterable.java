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

import walkingkooka.collect.iterator.Iterators;

import java.util.Iterator;
import java.util.Objects;

/**
 * A {@link Iterable} that wraps another {@link Iterable} blocking attempts to call {@link
 * Iterator#remove()}.
 */
final class ReadOnlyIterable<T> implements Iterable<T> {

    /**
     * Wraps the given {@link Iterable}
     */
    static <T> ReadOnlyIterable<T> wrap(final Iterable<T> iterable) {
        Objects.requireNonNull(iterable, "iterable");

        return new ReadOnlyIterable<>(iterable);
    }

    /**
     * Private constructor use factory
     */
    private ReadOnlyIterable(final Iterable<T> iterable) {
        super();
        this.iterable = iterable;
    }

    /**
     * Wraps the {@link Iterator} so it is read only before returning it.
     */
    @Override
    public Iterator<T> iterator() {
        return Iterators.readOnly(this.iterable.iterator());
    }

    /**
     * The wrapped {@link Iterable}.
     */
    private final Iterable<T> iterable;

    @Override
    public String toString() {
        return this.iterable.toString();
    }
}
