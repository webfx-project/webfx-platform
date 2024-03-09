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

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Objects;

/**
 * Adaptor that presents an {@link Iterator} view of an {@link Enumeration}.
 */
final class EnumerationIterator<E> implements Iterator<E> {

    static <E> EnumerationIterator<E> adapt(final Enumeration<E> enumeration) {
        Objects.requireNonNull(enumeration, "enumeration");

        return new EnumerationIterator<>(enumeration);
    }

    private EnumerationIterator(final Enumeration<E> enumeration) {
        super();
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return this.enumeration.hasMoreElements();
    }

    @Override
    public E next() {
        return this.enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    private final Enumeration<E> enumeration;

    @Override
    public String toString() {
        return this.enumeration.toString();
    }
}
