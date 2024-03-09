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

import java.util.Iterator;
import java.util.Objects;

/**
 * An {@link Iterable} that returns an {@link Iterator} once. It is intended to be used with for
 * each loops.
 */
final class IteratorIterable<T> implements Iterable<T> {

    /**
     * Creates a new {@link IteratorIterable}.
     */
    static <T> IteratorIterable<T> with(final Iterator<T> iterator) {
        Objects.requireNonNull(iterator, "iterator");

        return new IteratorIterable<>(iterator);
    }

    /**
     * Private constructor use factory.
     */
    private IteratorIterable(final Iterator<T> iterator) {
        super();
        this.iterator = iterator;
    }

    @Override
    public Iterator<T> iterator() {
        if (this.given) {
            throw new IllegalStateException("Iterator can only be taken once");
        }
        final Iterator<T> iterator = this.iterator;
        this.given = true;
        return iterator;
    }

    private final Iterator<T> iterator;

    private boolean given;

    /**
     * Dumps the {@link Iterator#toString()}.
     */
    @Override
    public String toString() {
        return this.iterator.toString();
    }
}
