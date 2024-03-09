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
import walkingkooka.collect.stack.Stack;
import walkingkooka.collect.stack.Stacks;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * An {@link Iterator} that provides a view of all items but in reversed order. This is achieved by
 * copying all items from the source into a buffer and then iterating. The {@link #remove()} always
 * throws {@link UnsupportedOperationException}.
 */
final class ReverseIterator<E> implements Iterator<E> {

    /**
     * Before copying performs a check just in case the given {@link Iterator} is a {@link
     * ReverseIterator}. If it is then the iterator is unwrapped.
     */
    static <E> Iterator<E> with(final Iterator<E> iterator) {
        Objects.requireNonNull(iterator, "iterator");

        Iterator<E> result;
        if (iterator instanceof ReverseIterator) {
            final ReverseIterator<E> reverseIterator = Cast.to(iterator);

            // return the Stack.iterator() and make it read only
            result = Iterators.readOnly(reverseIterator.stack.iterator());
        } else {
            final Stack<E> stack = Stacks.jdk();
            while (iterator.hasNext()) {
                stack.push(iterator.next());
            }
            result = new ReverseIterator<>(stack);
        }
        return result;
    }

    /**
     * Private constructor use factory
     */
    private ReverseIterator(final Stack<E> stack) {
        super();
        this.stack = stack;
    }

    @Override
    public boolean hasNext() {
        return false == this.stack.isEmpty();
    }

    @Override
    public E next() {
        final Stack<E> stack = this.stack;
        try {
            final E next = stack.peek();
            stack.pop();
            return next;
        } catch (final EmptyStackException cause) {
            throw new NoSuchElementException();
        }
    }

    /**
     * The {@link Stack} that has items popped of the iterator is consumed.
     */
    private final Stack<E> stack;

    /**
     * Always throws {@link IllegalStateException}.
     */
    @Override
    public void remove() {
        throw new IllegalStateException();
    }

    @Override
    public String toString() {
        return this.stack.toString();
    }
}
