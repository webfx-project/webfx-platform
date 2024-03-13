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

package walkingkooka.collect.iterable;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The lazy {@link Iterator} used by {@link walkingkooka.collect.iterable.ChainIterable}
 */
final class ChainIterableIterator<E> implements Iterator<E> {

    /**
     * Creates an {@link ChainIterableIterator} from the given {@link Iterator iterables.}
     */
    @SuppressWarnings("unchecked")
    static <E> ChainIterableIterator<E> with(final Iterable<E>... iterables) {
        return new ChainIterableIterator<>(iterables);
    }

    /**
     * Private constructor use static factory.
     */
    private ChainIterableIterator(final Iterable<E>[] iterables) {
        super();
        this.iterables = iterables;
        this.next = 0;
        this.loadNext();
    }

    /**
     * Tests if another element is available. If the current iterator is empty then the next {@link Iterator} is used.
     */
    @Override
    public boolean hasNext() {
        boolean hasNext = false;

        Iterator<E> current = this.current;

        for (; ; ) {
            if (null == current) {
                break;
            }
            hasNext = current.hasNext();
            if (hasNext) {
                break;
            }
            current = this.loadNext();
        }

        return hasNext;
    }

    /**
     * Attempts to fetch an element from the current element or if that is empty from the next until
     * none.
     */
    @Override
    public E next() {
        Iterator<E> current = this.current;
        this.remove = null;

        for (; ; ) {
            if (null == current) {
                throw new NoSuchElementException();
            }
            // current is not empty next!.
            if (current.hasNext()) {
                break;
            }
            current = this.loadNext();
        }
        final E next = current.next();
        this.remove = current; // save this for remove(
        return next;
    }

    /**
     * The current {@link Iterator}. This will become null when exhausted.
     */
    private Iterator<E> current;

    /**
     * All the iterables
     */
    private final Iterable<E>[] iterables;

    /**
     * The index that points to the next {@link Iterator}.
     */
    private int next;

    /**
     * Advances to the next {@link Iterator} if possible setting {@link #current}.
     */
    private Iterator<E> loadNext() {
        final Iterable<E>[] iterables = this.iterables;
        final int next = this.next;

        Iterator<E> current = null;
        if (next < iterables.length) {
            this.next = next + 1;
            current = iterables[next].iterator();
            this.remove = null;
        }
        this.current = current;
        return current;
    }

    @Override
    public void remove() {
        final Iterator<E> remove = this.remove;
        if (null == remove) {
            throw new IllegalStateException("remove without next");
        }
        this.remove = null;
        remove.remove();
    }

    /**
     * The {@link Iterator} that is called when removed. This is set after each next but cleared by remove.
     */
    private Iterator<E> remove;

    /**
     * Dumps the current {@link Iterator} with trailing ellipses if it is not the last.
     */
    @Override
    public String toString() {
        final Iterator<E> current = this.current;
        return null == current ?
                "" :
                this.next == this.iterables.length ? current.toString() : current + "...";
    }
}
