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

import walkingkooka.reflect.PublicStaticHelper;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.BiPredicate;

final public class Iterables implements PublicStaticHelper {

    /**
     * Tests if the elements belonging to the two {@link Iterables} are all equal in the order given.
     */
    public static <T> boolean equals(final Iterable<T> iterable, final Iterable<T> other, final BiPredicate<? super T, ? super T> equivalency) {
        Objects.requireNonNull(iterable, "iterable");
        Objects.requireNonNull(other, "other");
        Objects.requireNonNull(equivalency, "equivalency");

        boolean equals = true;

        final Iterator<T> iterator = iterable.iterator();
        final Iterator<T> otherIterator = other.iterator();
        while (equals && iterator.hasNext() && otherIterator.hasNext()) {
            equals = equals && equivalency.test(iterator.next(), otherIterator.next());
        }

        return equals && !iterator.hasNext() && !otherIterator.hasNext();
    }

    /**
     * {@see ChainIterable}
     */
    public static <T> Iterable<T> chain(final Iterable<T>... iterables) {
        return ChainIterable.with(iterables);
    }

    /**
     * {@see EmptyIterable}
     */
    public static <T> Iterable<T> empty() {
        return EmptyIterable.instance();
    }
    
    /**
     * {@see FakeIterable}
     */
    public static <T> Iterable<T> fake() {
        return FakeIterable.create();
    }

    /**
     * {@see IteratorIterable}
     */
    public static <T> Iterable<T> iterator(final Iterator<T> iterator) {
        return IteratorIterable.with(iterator);
    }

    /**
     * {@see ReadOnlyIterable}
     */
    public static <T> Iterable<T> readOnly(final Iterable<T> iterable) {
        return ReadOnlyIterable.wrap(iterable);
    }

    /**
     * {@see ReverseIterable}
     */
    public static <T> Iterable<T> reverse(final Iterable<T> iterable) {
        return ReverseIterable.wrap(iterable);
    }

    /**
     * Stop creation
     */
    private Iterables() {
        throw new UnsupportedOperationException();
    }
}
