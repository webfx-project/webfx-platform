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
import java.util.Objects;

/**
 * A {@link Stack} that wraps another {@link Stack} forwarding all calls and throwing {@link
 * UnsupportedOperationException} when attempting to push.
 */
final class ReadOnlyStack<T> implements Stack<T> {

    /**
     * Wraps another {@link Stack} making it unreadable.
     */
    static <T> ReadOnlyStack<T> wrap(final Stack<T> stack) {
        Objects.requireNonNull(stack, "stack");

        return stack instanceof ReadOnlyStack ?
                Cast.to(stack) :
                new ReadOnlyStack<>(stack);
    }

    /**
     * Private constructor use factory
     */
    private ReadOnlyStack(final Stack<T> stack) {
        super();
        this.stack = stack;
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    @Override
    public int size() {
        return this.stack.size();
    }

    @Override
    public T peek() {
        return this.stack.peek();
    }

    @Override
    public Stack<T> pop() {
        final Stack<T> stack = this.stack;
        final Stack<T> popped = stack.pop();
        return stack == popped ? this : ReadOnlyStack.wrap(popped);
    }

    @Override
    public Stack<T> push(final T item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Stack<T> pushAll(final Iterator<T> items) {
        Objects.requireNonNull(items, "items");
        throw new UnsupportedOperationException();
    }

    private final Stack<T> stack;

    @Override
    public Iterator<T> iterator() {
        return this.stack.iterator();
    }

    // BasicObject

    @Override
    public int hashCode() {
        return this.stack.hashCode();
    }

    @Override
    public boolean equals(final Object object) {
        return (this == object) || ((object instanceof Stack) && this.equals(Cast.<Stack<T>>to(
                object)));
    }

    private boolean equals(final Stack<T> stack) {
        return ((stack instanceof ReadOnlyStack) && this.equals(Cast.to(stack)))
                || this.stack.equals(stack);
    }

    private boolean equals(final ReadOnlyStack<T> stack) {
        return this.stack.equals(stack.stack);
    }

    // Object

    @Override
    public String toString() {
        return this.stack.toString();
    }
}
