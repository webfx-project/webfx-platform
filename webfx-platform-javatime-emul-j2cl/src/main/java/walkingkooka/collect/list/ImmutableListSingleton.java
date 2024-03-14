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

package walkingkooka.collect.list;

import walkingkooka.collect.iterator.Iterators;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * A {@link List} known to be immutable and holds a copy of any {@link List} given to it.
 */
final class ImmutableListSingleton<T> extends ImmutableList<T> {

    /**
     * Returns a {@link List} which is immutable.
     */
    static <T> ImmutableListSingleton<T> withElement(final T element) {
        return new ImmutableListSingleton<>(element);
    }

    /**
     * Private ctor use factory
     */
    private ImmutableListSingleton(final T element) {
        super();
        this.element = element;
    }

    @Override
    public boolean contains(final Object other) {
        return Objects.equals(
                this.element,
                other
        );
    }

    @Override
    public T get(final int index) {
        if(index != 0) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds size=1");
        }
        return this.element;
    }

    @Override
    public Iterator<T> iterator() {
        return Iterators.one(this.element);
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public String toString() {
        return "[" + this.element + "]";
    }

    private final T element;
}
