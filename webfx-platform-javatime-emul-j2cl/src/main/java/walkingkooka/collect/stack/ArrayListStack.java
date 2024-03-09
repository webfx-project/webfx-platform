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

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Stack} backed by an {@link ArrayList}. This stack is mutable. All operations
 * always return this.
 */
final class ArrayListStack<T> implements Stack<T> {
    /**
     * Creates an empty {@link ArrayListStack}.
     */
    static <T> ArrayListStack<T> create() {
        return new ArrayListStack<>();
    }

    /**
     * Private constructor use static factory.
     */
    private ArrayListStack() {
        super();
    }

    /**
     * Peeks at the item at the top of the stack without removing it.
     */
    @Override
    public T peek() {
        final List<T> items = this.items;
        if (items.isEmpty()) {
            throw new EmptyStackException();
        }
        return items.get(items.size() - 1);
    }

    @Override
    public Stack<T> pop() {
        final List<T> items = this.items;
        if (items.isEmpty()) {
            throw new EmptyStackException();
        }
        items.remove(items.size() - 1);
        return this;
    }

    @Override
    public ArrayListStack<T> push(final T item) {
        this.items.add(item);
        return this;
    }

    @Override
    public Stack<T> pushAll(final Iterator<T> items) {
        Objects.requireNonNull(items, "items");

        final List<T> list = this.items;
        while (items.hasNext()) {
            list.add(items.next());
        }
        return this;
    }

    /**
     * Tests if this stack is empty.
     */
    @Override
    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    /**
     * Returns the number of items in the backing {@link List}.
     */
    @Override
    public int size() {
        return this.items.size();
    }

    /**
     * Returns an iterator that supports remove.
     */
    @Override
    public Iterator<T> iterator() {
        return this.items.iterator();
    }

    // Object...........................................................................................................

    @Override
    public int hashCode() {
        int hash = this.hash;
        if (0 == hash) {
            hash = 1;
            for (T element : this.items) {
                hash = 31 * hash + Objects.hashCode(element);
            }
            this.hash = hash;
        }
        return hash;
    }

    private int hash = 0;

    @Override
    public boolean equals(final Object object) {
        return (this == object) || //
                ((object instanceof Stack) && this.equals(Cast.to(object)));
    }

    /**
     * Tests two {@link Stack} for equality only if their sizes are equal
     */
    private boolean equals(final Stack<T> stack) {
        return (this.items.size() == stack.size()) && //
                (stack instanceof ArrayListStack ?
                        this.equals0(Cast.to(stack)) :
                        this.equals1(stack));
    }

    /**
     * Tests two {@link ArrayListStack} for equality.
     */
    private boolean equals0(final ArrayListStack<T> stack) {
        return this.items.equals(stack.items);
    }

    private boolean equals1(final Stack<?> stack) {
        boolean equals = true;

        final Iterator<?> stackIterator = stack.iterator();
        for (final T item : this.items) {
            equals = Objects.equals(item, stackIterator.next());
            if (false == equals) {
                break;
            }
        }
        return equals;
    }

    // properties

    /**
     * The wrapped {@link List} containing the items.
     */
    final List<T> items = Lists.array();

    @Override
    public String toString() {
        return this.items.toString();
    }
}
