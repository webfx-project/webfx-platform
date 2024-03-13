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

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Provides an {@link Iterator} view over an array. Note the array is copied.
 */
final class ArrayIterator<T> implements Iterator<T> {

    @SafeVarargs
    static <T> ArrayIterator<T> with(final T... items) {
        Objects.requireNonNull(items, "items");

        return new ArrayIterator<>(Arrays.copyOf(items, items.length));
    }

    /**
     * Private constructor
     */
    private ArrayIterator(final T[] items) {
        super();
        this.items = items;
        this.next = 0;
    }

    @Override
    public boolean hasNext() {
        return this.next < this.items.length;
    }

    @Override
    public T next() {
        final int next = this.next;
        final Object[] items = this.items;
        if (next >= items.length) {
            throw new NoSuchElementException();
        }
        this.next = next + 1;
        return Cast.to(items[next]);
    }

    /**
     * Always throws {@link UnsupportedOperationException}.
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    private final T[] items;

    /**
     * Points to the next item.
     */
    private int next;

    /**
     * Builds a {@link String} containing the remaining elements.
     */
    @Override
    public String toString() {
        final Object[] items = this.items;
        final int next = this.next;
        final int leftCount = items.length - next;
        final Object[] left = new Object[leftCount];
        System.arraycopy(items, next, left, 0, leftCount);
        return Arrays.toString(left);
    }
}
