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

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An {@link Iterator} that is always empty.
 */
final class EmptyIterator<E> implements Iterator<E> {

    /**
     * Type safe getter.
     */
    static <E> EmptyIterator<E> instance() {
        return Cast.to(EmptyIterator.INSTANCE);
    }

    /**
     * Singleton
     */
    @SuppressWarnings("rawtypes")
    private final static EmptyIterator INSTANCE = new EmptyIterator();

    private EmptyIterator() {
        super();
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public E next() {
        throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        throw new IllegalStateException();
    }

    @Override
    public String toString() {
        return "<empty>";
    }
}
