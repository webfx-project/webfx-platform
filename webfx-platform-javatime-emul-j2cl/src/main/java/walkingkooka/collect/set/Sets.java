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

package walkingkooka.collect.set;

import walkingkooka.collect.iterable.Iterables;
import walkingkooka.reflect.PublicStaticHelper;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.BiPredicate;

final public class Sets implements PublicStaticHelper {
    /**
     * Registers a {@link Set} type as immutable.
     */
    @SuppressWarnings("rawtypes")
    public static void registerImmutableType(final Class<? extends Set> type) {
        Objects.requireNonNull(type, "type");

        synchronized (ImmutableSet.TYPES) {
            ImmutableSet.TYPES.add(type);
        }
    }

    /**
     * {@see Collections#empty()}
     */
    public static <T> Set<T> empty() {
        return Collections.emptySet();
    }

    /**
     * Tests if both {@link Set} are equal using the {@link BiPredicate} to test each and every element.
     */
    public static <T> boolean equals(final Set<T> Set,
                                     final Set<T> other,
                                     final BiPredicate<? super T, ? super T> equivalency) {
        return Iterables.equals(Set, other, equivalency);
    }

    /**
     * {@see HashSet}
     */
    public static <E> Set<E> hash() {
        return new HashSet<>();
    }

    /**
     * Returns a {@link Set} that is immutable, making a defensive copy if necessary.
     */
    public static <E> Set<E> immutable(final Set<E> set) {
        return ImmutableSet.with(set);
    }

    /**
     * {@see TreeSet}
     */
    public static <E> NavigableSet<E> navigable() {
        return new TreeSet<>();
    }

    /**
     * {@see Collections#singleton(Object)}
     */
    public static <T> Set<T> of(final T item) {
        return ImmutableSet.singleton(item);
    }

    /**
     * Convenience method that creates a set from an array of elements. This method only exists of a
     * convenience because Lists.of() does not have a {@link Set} equivalent.
     */
    @SafeVarargs
    public static <E> Set<E> of(final E... elements) {
        Objects.requireNonNull(elements, "elements");

        final Set<E> set = ordered();
        Collections.addAll(set, elements);
        return ImmutableSet.copy(set);
    }

    /**
     * {@see LinkedHashSet}
     */
    public static <E> Set<E> ordered() {
        return new LinkedHashSet<>();
    }

    /**
     * Returns a read only {@link Set} view, not an immutable set. The original may still be modified.
     */
    public static <T> Set<T> readOnly(final Set<T> set) {
        return ImmutableSet.isImmutable(set) ?
                set :
                Collections.unmodifiableSet(set);
    }

    /**
     * {@see TreeSet}
     */
    public static <E> SortedSet<E> sorted() {
        return new TreeSet<>();
    }

    /**
     * {@see TreeSet}
     */
    public static <E> SortedSet<E> sorted(final Comparator<? super E> comparator) {
        return new TreeSet<>(comparator);
    }

    /**
     * Stop creation
     */
    private Sets() {
        throw new UnsupportedOperationException();
    }
}
