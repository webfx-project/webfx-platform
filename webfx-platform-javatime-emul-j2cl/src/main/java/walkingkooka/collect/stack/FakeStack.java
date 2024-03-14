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

import walkingkooka.test.Fake;

import java.util.Iterator;
import java.util.Objects;

/**
 * A {@link Stack} where all methods throw {@link UnsupportedOperationException}
 */
public class FakeStack<T> implements Stack<T>, Fake {

    static <T> FakeStack<T> create() {
        return new FakeStack<>();
    }

    /**
     * Protected for sub classing.
     */
    protected FakeStack() {
        super();
    }

    @Override
    public T peek() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Stack<T> pop() {
        throw new UnsupportedOperationException();
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

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }
}
