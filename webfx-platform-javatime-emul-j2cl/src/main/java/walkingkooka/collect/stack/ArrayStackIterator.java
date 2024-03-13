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

package walkingkooka.collect.stack;

import walkingkooka.Cast;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The {@link Iterator} returned by {@link ArrayStack#iterator()}
 */
final class ArrayStackIterator<E> implements Iterator<E> {
    static <E> ArrayStackIterator<E> with(final ArrayStack<E> stack) {
        return new ArrayStackIterator<>(stack);
    }

    private ArrayStackIterator(final ArrayStack<E> stack) {
        super();
        this.stack = stack;
        this.next = 0;
    }

    @Override
    public boolean hasNext() {
        return this.next < this.stack.last;
    }

    @Override
    public E next() {
        final ArrayStack<E> stack = this.stack;
        final int next = this.next;
        if (next == stack.last) {
            throw new NoSuchElementException();
        }
        this.next = next + 1;
        return Cast.to(stack.array[next]);
    }

    private final ArrayStack<E> stack;

    /**
     * Points to the next element to be returned.
     */
    private int next;

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Cannot remove from Stack.iterator()");
    }

    /**
     * Dumps only the outstanding elements not visited.
     */
    @Override
    public String toString() {
        final ArrayStack<E> stack = this.stack;
        final Object[] elements = stack.array;
        final int last = stack.last;

        final StringBuilder b = new StringBuilder();
        String separator = "";
        for (int i = this.next; i < last; i++) {
            b.append(separator);
            b.append(elements[i]);
            separator = ",";
        }

        return b.toString();
    }
}
