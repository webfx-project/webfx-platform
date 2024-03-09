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
 * Wraps another {@link Stack} with only the {@link #push(Object)} method working with all other
 * methods throwing {@link UnsupportedOperationException}.
 */
final class UnreadableStack<T> implements Stack<T> {

    /**
     * Wraps another {@link Stack} making it unreadable.
     */
    static <T> UnreadableStack<T> wrap(final Stack<T> stack) {
        Objects.requireNonNull(stack, "stack");

        return stack instanceof UnreadableStack ?
                Cast.to(stack) :
                new UnreadableStack<>(stack);
    }

    /**
     * Private constructor use factory
     */
    private UnreadableStack(final Stack<T> stack) {
        super();
        this.stack = stack;
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    /**
     * It is not possible to read the size or test if the stack is empty.
     */
    @Override
    public int size() {
        throw new UnsupportedOperationException();
    }

    @Override
    public T peek() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Stack<T> pop() {
        throw new UnsupportedOperationException();
    }

    /**
     * Creates another {@link UnreadableStack} with the new returned {@link Stack}.
     */
    @Override
    public UnreadableStack<T> push(final T item) {
        final Stack<T> stack = this.stack;
        return this.wrapIfDifferent(stack, stack.push(item));
    }

    @Override
    public Stack<T> pushAll(final Iterator<T> items) {
        final Stack<T> stack = this.stack;
        return this.wrapIfDifferent(stack, stack.pushAll(items));
    }

    /**
     * Returns this or wraps if the new wrapped {@link Stack} is different.
     */
    private UnreadableStack<T> wrapIfDifferent(final Stack<T> old, final Stack<T> after) {
        return old == after ? this : UnreadableStack.wrap(after);
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    private final Stack<T> stack;

    // BasicObject

    @Override
    public int hashCode() {
        return this.stack.hashCode();
    }

    @Override
    public boolean equals(final Object object) {
        return (this == object) ||
                ((object instanceof Stack) && this.equals0((Cast.to(object))));
    }

    private boolean equals0(final Stack<?> stack) {
        return stack instanceof UnreadableStack ?
                this.equals1(Cast.to(stack)) :
                this.stack.equals(stack);
    }

    private boolean equals1(final UnreadableStack<?> stack) {
        return this.stack.equals(stack.stack);
    }

    // Object

    @Override
    public String toString() {
        return this.stack.toString();
    }
}
