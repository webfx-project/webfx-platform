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
 * A {@link Stack} that delegates all method calls to a {@link java.util.Stack}. When modified the
 * same {@link Stack} is returned.
 */
final class JdkStackStack<T> implements Stack<T> {

    /**
     * Factory that creates an empty {@link JdkStackStack}
     */
    static <T> JdkStackStack<T> create() {
        return new JdkStackStack<>(new java.util.Stack<>());
    }

    /**
     * Private constructor that does not copy the given {@link java.util.Stack}.
     */
    private JdkStackStack(final java.util.Stack<T> stack) {
        super();
        this.stack = stack;
    }

    @Override
    public T peek() {
        return this.stack.peek();
    }

    /**
     * After popping returns this.
     */
    @Override
    public Stack<T> pop() {
        this.stack.pop();
        return this;
    }

    @Override
    public Stack<T> push(final T item) {
        this.stack.push(item);
        return this;
    }

    @Override
    public Stack<T> pushAll(final Iterator<T> items) {
        Objects.requireNonNull(items, "items");

        final java.util.Stack<T> stack = this.stack;
        while (items.hasNext()) {
            stack.push(items.next());
        }
        return this;
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    @Override
    public int size() {
        return this.stack.size();
    }

    /**
     * Returns an {@link Iterator} which supports the removal of elements.
     */
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
    public boolean equals(final Object other) {
        return (this == other) || ((other instanceof Stack)
                && this.equals0(Cast.to(other)));
    }

    private boolean equals0(final Stack<T> stack) {
        boolean equals = false;

        do {
            // if stacks have different sizes they cannot be equal
            final java.util.Stack<T> items = this.stack;
            if (items.size() != stack.size()) {
                break;
            }

            // special case if other stack is a JdkStackStack
            if (stack instanceof JdkStackStack) {
                equals = this.equals(Cast.to(stack));
                break;
            }

            // different type of stack copy and check items while popping
            final Iterator<T> iterator1 = this.iterator();
            final Iterator<T> iterator2 = stack.iterator();

            // if first is empty second must also be empty
            for (; ; ) {
                if (false == iterator1.hasNext()) {
                    equals = !iterator2.hasNext();
                    break;
                }

                // first is not empty and second is...cant be equal.
                if (false == iterator2.hasNext()) {
                    break;
                }
                if (false == Objects.equals(iterator1.next(), iterator2.next())) {
                    break;
                }
            }
        } while (false);

        return equals;
    }

    private boolean equals(final JdkStackStack<T> stack) {
        return this.stack.equals(stack.stack);
    }

    /**
     * The wrapped {@link java.util.Stack}
     */
    final java.util.Stack<T> stack;

    // Object

    /**
     * Dumps the wrapped {@link java.util.Stack#toString()}.
     */
    @Override
    public String toString() {
        return this.stack.toString();
    }
}
