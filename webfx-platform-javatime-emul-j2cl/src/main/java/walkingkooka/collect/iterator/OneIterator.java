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

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An {@link Iterator} with a single element which may be null. The {@link #remove()} always throws
 * {@link UnsupportedOperationException}.
 */
final class OneIterator<E> implements Iterator<E> {

    static <E> OneIterator<E> with(final E value) {
        return new OneIterator<>(value);
    }

    /**
     * Private constructor use factory.
     */
    private OneIterator(final E value) {
        super();
        this.value = value;
        this.empty = false;
    }

    @Override
    public boolean hasNext() {
        return false == this.empty;
    }

    @Override
    public E next() {
        if (this.empty) {
            throw new NoSuchElementException();
        }
        this.empty = true;
        return this.value;
    }

    /**
     * Will be true when the iterator is exhausted.
     */
    private boolean empty;

    private final E value;

    /**
     * Always throws {@link UnsupportedOperationException}
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return this.empty ? "<empty>" : String.valueOf(this.value);
    }
}
