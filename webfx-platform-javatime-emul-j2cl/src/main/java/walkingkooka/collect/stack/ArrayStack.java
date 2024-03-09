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
import java.util.Iterator;
import java.util.Objects;

/**
 * An {@link ArrayStack} is a true immutable {@link Stack}.
 */
final class ArrayStack<T> implements Stack<T> {
    /**
     * Creates a new {@link ArrayStack} with a single item.
     */
    static <T> ArrayStack<T> with(final T item) {
        return ArrayStack.with(new Object[]{item});
    }

    /**
     * Creates a new {@link ArrayStack} with an array. The last it set to the end of the array
     */
    static <T> ArrayStack<T> with(final Object[] items) {
        return new ArrayStack<>(items, items.length);
    }

    private ArrayStack(final Object[] array, final int last) {
        super();
        this.array = array;
        this.last = last;
    }

    // Stack

    @Override
    public T peek() {
        final Object[] array = this.array;
        return Cast.to(array[this.last - 1]);
    }

    /**
     * If the array contains of element return an {@link EmptyArrayStack} otherwise create a new
     * {@link ArrayStack} sharing the array
     */
    @Override
    public Stack<T> pop() {
        Stack<T> stack;
        final int newLast = this.last - 1;
        if (0 == newLast) {
            stack = EmptyArrayStack.instance();
        } else {
            // share array but decrement last
            stack = new ArrayStack<>(this.array, newLast);
        }

        return stack;
    }

    /**
     * Copies the old array into a new of appends the item and returns a new {@link ArrayStack}.
     */
    @Override
    public ArrayStack<T> push(final T item) {
        final int last = this.last;
        final int newLast = last + 1;

        // copy the old array into the first slots
        final Object[] newArray = new Object[newLast];
        System.arraycopy(this.array, 0, newArray, 0, last);

        // save the new item in the last slot
        newArray[last] = item;

        return new ArrayStack<>(newArray, newLast);
    }

    /**
     * If the {@link Iterator} is empty this will be returned otherwise the items are added and a
     * new {@link ArrayStack} is created.
     */
    @Override
    public ArrayStack<T> pushAll(final Iterator<T> items) {
        Objects.requireNonNull(items, "items");

        ArrayStack<T> stack = this;
        if (items.hasNext()) {
            // iterator is not empty
            final Collection<T> pushing = Lists.array();
            do {
                pushing.add(items.next());
            } while (items.hasNext());

            final int last = this.last;
            final int pushed = pushing.size();
            final int newLast = last + pushed;

            // copy the old array into the first slots
            final Object[] newArray = new Object[newLast];
            System.arraycopy(this.array, 0, newArray, 0, last);

            // append the iterator items onto the $newArray
            int i = last;
            for (final T item : pushing) {
                newArray[i] = item;
                i++;
            }

            stack = new ArrayStack<>(newArray, newLast);
        }

        return stack;
    }

    /**
     * Is never empty
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Returns the true count of elements in the array.
     */
    @Override
    public int size() {
        return this.last;
    }

    @Override
    public Iterator<T> iterator() {
        return ArrayStackIterator.with(this);
    }

    final Object[] array;

    /**
     * The true number of elements in the array
     */
    final int last;

    // Object...........................................................................................................

    @Override
    public int hashCode() {
        int hash = this.hash;
        if (0 == hash) {
            final Object[] array = this.array;
            final int last = this.last;

            hash = 1;
            for (int i = 0; i < last; i++) {
                hash = 31 * hash + Objects.hashCode(array[i]);
            }
            this.hash = hash;
        }
        return hash;
    }

    /**
     * A cached copy of the last computed hashcode
     */
    private int hash;

    @Override
    public boolean equals(final Object object) {
        boolean equals = false;

        BigLoop:
        //
        for (; ; ) {
            if (this == object) {
                equals = true;
                break;
            }

            if (false == (object instanceof Stack)) {
                break;
            }

            // special case if other stack is a JdkStackStack
            final int last = this.last;
            final Stack<T> stack = Cast.to(object);
            if (last != stack.size()) {
                break;
            }

            // if an ArrayStack compare arrays
            if (object instanceof ArrayStack) {
                final ArrayStack<T> arrayStack = Cast.to(object);
                if (last != arrayStack.last) {
                    break;
                }
                final Object[] array = this.array;
                final Object[] otherArray = arrayStack.array;
                equals = true;

                for (int i = 0; i < last; i++) {
                    if (false == Objects.equals(array[i], otherArray[i])) {
                        equals = false;
                        break BigLoop;
                    }
                }
                break;
            }

            // different type of stack copy and check items while popping
            final Object[] array = this.array;
            final Iterator<T> stackIterator = stack.iterator();

            for (int i = 0; i < last; i++) {
                if (false == Objects.equals(array[i], stackIterator.next())) {
                    break BigLoop;
                }
            }
            // the $stack iterator must also be equal
            equals = true;
            break;
        }

        return equals;
    }

    // Object

    @Override
    public String toString() {
        final int last = this.last;
        final Object[] array = this.array;
        String separator = "";

        final StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; i < last; i++) {
            b.append(separator);
            b.append(array[i]);
            separator = ",";
        }

        b.append(']');
        return b.toString();
    }
}
