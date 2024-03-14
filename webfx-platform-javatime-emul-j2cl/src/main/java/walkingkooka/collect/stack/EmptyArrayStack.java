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
import walkingkooka.collect.list.Lists;

import java.util.Collection;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Objects;

/**
 * An immutable empty {@link Stack}
 */
final class EmptyArrayStack<T> implements Stack<T> {

    /**
     * Type safe getter
     */
    static <T> EmptyArrayStack<T> instance() {
        return Cast.to(EmptyArrayStack.INSTANCE);
    }

    private final static EmptyArrayStack<?> INSTANCE = new EmptyArrayStack<>();

    private EmptyArrayStack() {
        super();
    }

    // Stack

    @Override
    public T peek() {
        throw new EmptyStackException();
    }

    @Override
    public Stack<T> pop() {
        throw new EmptyStackException();
    }

    @Override
    public Stack<T> push(final T item) {
        return ArrayStack.with(item);
    }

    /**
     * If the {@link Iterator items} is empty this will be returned otherwise creates a new {@link
     * ArrayStack}
     */
    @Override
    public Stack<T> pushAll(final Iterator<T> items) {
        Objects.requireNonNull(items, "items");

        return items.hasNext() ? this.pushAllNotEmpty(items) : this;
    }

    private Stack<T> pushAllNotEmpty(final Iterator<T> items) {
        // empty the iterator into a Collection
        final Collection<T> pushing = Lists.array();
        do {
            pushing.add(items.next());
        } while (items.hasNext());

        // copy the Collection into an array
        final int size = pushing.size();
        final Object[] array = new Object[size];
        pushing.toArray(array);

        return ArrayStack.with(array);
    }

    /**
     * Empty stacks are empty.
     */
    @Override
    public boolean isEmpty() {
        return true;
    }

    /**
     * Empty stacks always have 0 elements
     */
    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return Collections.emptyIterator();
    }

    // Object...........................................................................................................

    @Override
    public int hashCode() {
        return 1;
    }

    /**
     * Equal if the other stack is also empty.
     */
    @Override
    public boolean equals(final Object other) {
        return (this == other) || ((other instanceof Stack)
                && this.equals0(Cast.to(other)));
    }

    private boolean equals0(final Stack<T> stack) {
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        return "[]";
    }
}
