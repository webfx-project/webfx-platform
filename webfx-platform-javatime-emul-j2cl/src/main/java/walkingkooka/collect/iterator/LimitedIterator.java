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
import java.util.Objects;

/**
 * An {@link Iterator} that includes an element limit for a wrapped {@link Iterator}.
 */
final class LimitedIterator<E> implements Iterator<E> {

    /**
     * Factory that creates a {@link LimitedIterator} skipping the with if the wrapped has a lesser
     * count.
     */
    static <E> LimitedIterator<E> wrap(final Iterator<E> iterator, final int count) {
        Objects.requireNonNull(iterator, "iterator");
        if (count < 0) {
            throw new IllegalArgumentException("Count " + count + " must be greater than 0");
        }

        LimitedIterator<E> result;

        do {
            Iterator<E> wrapped = iterator;
            if (iterator instanceof LimitedIterator) {
                final LimitedIterator<E> limited = Cast.to(iterator);
                if (count >= limited.countdown) {
                    result = limited;
                    break;
                }
                wrapped = limited.iterator;
            }
            result = new LimitedIterator<>(wrapped, count);
        } while (false);

        return result;
    }

    /**
     * Private constructor use factory.
     */
    private LimitedIterator(final Iterator<E> iterator, final int count) {
        super();
        this.iterator = iterator;
        this.countdown = count;
    }

    @Override
    public boolean hasNext() {
        return (this.countdown > 0) && this.iterator.hasNext();
    }

    @Override
    public E next() {
        final int countdown = this.countdown;
        if (countdown <= 0) {
            throw new NoSuchElementException();
        }
        final E next = this.iterator.next();
        this.countdown = countdown - 1;
        return next;
    }

    @Override
    public void remove() {
        if (this.countdown < 0) {
            throw new NoSuchElementException();
        }
        this.iterator.remove();
    }

    final Iterator<E> iterator;

    int countdown;

    @Override
    public String toString() {
        return "at most " + this.countdown + " " + this.iterator.toString();
    }
}
