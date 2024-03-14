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

import walkingkooka.reflect.PublicStaticHelper;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.function.Function;
import java.util.function.Predicate;

final public class Iterators implements PublicStaticHelper {

    /**
     * {@see ArrayIterator}
     */
    @SafeVarargs
    public static <E> Iterator<E> array(final E... array) {
        return ArrayIterator.with(array);
    }

    /**
     * {@see ChainIterator}
     */
    @SafeVarargs
    public static <E> Iterator<E> chain(final Iterator<E>... iterators) {
        return ChainIterator.with(iterators);
    }

    /**
     * {@see CharSequenceIterator}
     */
    public static Iterator<Character> characters(final CharSequence charSequence) {
        return CharSequenceIterator.with(charSequence);
    }

    /**
     * {@see EmptyIterator}
     */
    public static <E> Iterator<E> empty() {
        return EmptyIterator.instance();
    }

    /**
     * {@see EnumerationIterator}
     */
    public static <E> Iterator<E> enumeration(final Enumeration<E> enumeration) {
        return EnumerationIterator.adapt(enumeration);
    }

    /**
     * {@see FakeIterator}
     */
    public static <T> Iterator<T> fake() {
        return FakeIterator.create();
    }

    /**
     * {@see LimitedIterator}
     */
    public static <E> Iterator<E> limited(final Iterator<E> iterator, final int count) {
        return LimitedIterator.wrap(iterator, count);
    }

    /**
     * {@see MappingIterator}
     */
    public static <S, D> Iterator<D> mapping(final Iterator<S> iterator,
                                             final Function<S, D> mapper) {
        return MappingIterator.with(iterator, mapper);
    }

    /**
     * {@see OneIterator}
     */
    public static <E> Iterator<E> one(final E value) {
        return OneIterator.with(value);
    }

    /**
     * {@see PredicatedIterator}
     */
    public static <E> Iterator<E> predicated(final Iterator<E> iterator,
                                             final Predicate<E> filter) {
        return PredicatedIterator.with(
                iterator,
                filter
        );
    }

    /**
     * {@see ReadOnlyIterator}
     */
    public static <T> Iterator<T> readOnly(final Iterator<T> iterator) {
        return ReadOnlyIterator.wrap(iterator);
    }

    /**
     * {@see ReverseIterator}
     */
    public static <E> Iterator<E> reverse(final Iterator<E> iterator) {
        return ReverseIterator.with(iterator);
    }

    /**
     * Stop creation
     */
    private Iterators() {
        throw new UnsupportedOperationException();
    }
}
