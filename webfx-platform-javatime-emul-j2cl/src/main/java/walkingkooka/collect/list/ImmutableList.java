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

import walkingkooka.Cast;
import walkingkooka.collect.set.Sets;

import java.util.AbstractList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Base class for all immutable {@link List} returned by {@link Lists}.
 */
abstract class ImmutableList<T> extends AbstractList<T> {

    /**
     * A registry of immutable {@link List} types.
     */
    final static Set<Class<?>> TYPES = Sets.hash();

    static {
        TYPES.add(List.class);
        TYPES.add(Lists.empty().getClass());
    }

    /**
     * Returns true if the {@link List} is immutable. This may not detect all but tries to attempt a few known to {@link List}.
     */
    static boolean isImmutable(final List<?> list) {
        return list instanceof ImmutableList || TYPES.contains(list.getClass());
    }

    /**
     * Returns a {@link List} which is immutable including copying elements if necessary.
     */
    static <T> List<T> with(final List<T> list) {
        Objects.requireNonNull(list, "list");

        return isImmutable(list) ?
                list :
                prepare(list.toArray());
    }

    /**
     * Takes a defensive copy of the list elements and returns a immutable list.
     */
    static <T> List<T> prepare(final Object[] elements) {
        final List<T> immutable;

        switch (elements.length) {
            case 0:
                immutable = Lists.empty();
                break;
            case 1:
                immutable = singleton(
                        Cast.to(elements[0])
                );
                break;
            default:
                immutable = nonSingleton(elements);
                break;
        }

        return immutable;
    }


    /**
     * {@see ImmutableListSingleton}.
     */
    static <T> List<T> singleton(final T element) {
        return ImmutableListSingleton.withElement(element);
    }

    /**
     * Creates a {@link ImmutableListNonSingleton} with the given {@link List} which is not defensively copied.
     */
    private static <T> ImmutableList<T> nonSingleton(final Object[] wrap) {
        return ImmutableListNonSingleton.with(wrap);
    }
}
