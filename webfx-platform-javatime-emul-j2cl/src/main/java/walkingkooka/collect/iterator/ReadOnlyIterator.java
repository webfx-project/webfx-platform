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

package walkingkooka.collect.iterator;

import walkingkooka.Cast;

import java.util.Iterator;
import java.util.Objects;

/**
 * An unmodifiable {@link Iterator}. All attempts to call {@link #remove()} will throw a {@link
 * UnsupportedOperationException}.
 */
final class ReadOnlyIterator<T> implements Iterator<T> {

    /**
     * Wraps the given {@link Iterator} only if it is not already a {@link ReadOnlyIterator}
     */
    static <T> ReadOnlyIterator<T> wrap(final Iterator<T> iterator) {
        Objects.requireNonNull(iterator, "iterator");

        return iterator instanceof ReadOnlyIterator ?
                Cast.to(iterator) :
                new ReadOnlyIterator<>(iterator);
    }

    private ReadOnlyIterator(final Iterator<T> iterator) {
        super();
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override
    public T next() {
        return this.iterator.next();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    // properties

    final Iterator<T> iterator;

    /**
     * Simply dumps the wrapped {@link Iterator#toString()}.
     */
    @Override
    public String toString() {
        return this.iterator.toString();
    }
}
