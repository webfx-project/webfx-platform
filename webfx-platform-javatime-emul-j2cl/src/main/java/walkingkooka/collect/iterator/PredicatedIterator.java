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
import java.util.Objects;
import java.util.function.Predicate;

/**
 * A {@link Iterator} that wraps another {@link Iterator} lazily filtering elements using the provided {@link Predicate}.
 */
final class PredicatedIterator<E> implements Iterator<E> {

    /**
     * Creates a new {@link PredicatedIterator}
     */
    static <E> PredicatedIterator<E> with(final Iterator<E> iterator,
                                          final Predicate<E> predicate) {
        Objects.requireNonNull(iterator, "iterator");
        Objects.requireNonNull(predicate, "predicate");

        return new PredicatedIterator<>(
                iterator,
                predicate
        );
    }

    private PredicatedIterator(final Iterator<E> iterator,
                               final Predicate<E> predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
    }

    @Override
    public boolean hasNext() {
        if (false == this.hasNext) {
            this.tryNext();
        }

        return this.hasNext;
    }

    @Override
    public E next() {
        if (false == this.hasNext) {
            this.tryNext();
        }

        if (false == this.hasNext) {
            throw new NoSuchElementException();
        }

        final E next = this.next;
        this.hasNext = false;
        this.next = null;
        return next;
    }

    private void tryNext() {
        this.hasNext = false;
        this.next = null;

        final Iterator<E> iterator = this.iterator;
        while (iterator.hasNext()) {
            final E next = iterator.next();
            if (this.predicate.test(next)) {
                this.hasNext = true;
                this.next = next;
                break;
            }
        }
    }

    /**
     * The wrapped {@link Iterator} being predicateed.
     */
    private final Iterator<E> iterator;

    /**
     * Used to match wrapped {@link Iterator} to return.
     */
    private final Predicate<E> predicate;

    /**
     * When true the {@link #next} has the cached predicate matched element.
     */
    private boolean hasNext;

    /**
     * Cached next element.
     */
    private E next;

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return this.iterator.toString();
    }
}
