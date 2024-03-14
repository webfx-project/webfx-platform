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

import java.util.Iterator;

/**
 * A pure stack without the legacy of {@link java.util.Stack} which extends {@link
 * java.util.Vector}.
 */
public interface Stack<T> extends Iterable<T> {

    /**
     * Peeks without removing the item at the top of the stack.
     */
    T peek();

    /**
     * Pops the top most item from this {@link Stack}.
     */
    Stack<T> pop();

    /**
     * Pushes an item onto the stack.
     */
    Stack<T> push(T item);

    /**
     * A batch operation that adds all the items returned by the {@link Iterator}.
     */
    Stack<T> pushAll(Iterator<T> items);

    /**
     * Tests if this stack is empty.
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in the stack.
     */
    int size();

    /**
     * Returns a read only {@link Iterator} that starts with the first or bottom most and ends with
     * the last or top most item.
     */
    @Override
    Iterator<T> iterator();
}
