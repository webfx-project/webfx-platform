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

import walkingkooka.Cast;

import java.util.AbstractSet;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/**
 * A {@link Set} known to be immutable and holds a copy of any {@link Set} given to it.
 */
abstract class ImmutableSet<T> extends AbstractSet<T> {

    /**
     * A registry of immutable {@link Set} types.
     */
    final static Set<Class<?>> TYPES = Sets.hash();

    static {
        TYPES.add(Sets.empty().getClass());
    }

    /**
     * Returns true if the {@link Set} is immutable. This may not detect all but tries to attempt a few known to {@link Set}.
     */
    static boolean isImmutable(final Set<?> set) {
        return set instanceof ImmutableSet || TYPES.contains(set.getClass());
    }

    /**
     * Returns a {@link Set} which is immutable including copying elements if necessary.
     */
    static <T> Set<T> with(final Set<T> set) {
        Objects.requireNonNull(set, "set");

        return isImmutable(set) ?
                set :
                copy(set);
    }

    /**
     * Copy to an ordered {@link Set} keeping the original order for sorted or unsorted {@link Set sets}.
     */
    static <T> Set<T> copy(final Set<T> from) {
        return from instanceof SortedSet ?
                copySortedSet(from) :
                copyUnsortedSet(from);
    }

    /**
     * Handles sorted sets by either returning empty or wrapping them to block modifications.
     */
    private static <T> Set<T> copySortedSet(final Set<T> from) {
        final Set<T> to = sorted(Cast.to(from));
        to.addAll(from);

        Set<T> immutable;
        switch (to.size()) {
            case 0:
                immutable = Sets.empty();
                break;
            default:
                immutable = wrap(to);
                break;
        }

        return immutable;
    }

    /**
     * Handles {@link Set} that are not {@link SortedSet}.
     */
    private static <T> Set<T> copyUnsortedSet(final Set<T> from) {
        final Set<T> to = from instanceof SortedSet ?
                sorted(Cast.to(from)) :
                Sets.ordered();
        to.addAll(from);

        Set<T> immutable;
        switch (to.size()) {
            case 0:
                immutable = Sets.empty();
                break;
            case 1:
                immutable = singleton(to.iterator().next());
                break;
            default:
                immutable = wrap(to);
                break;
        }

        return immutable;
    }

    /**
     * Factory that creates a new {@link SortedSet} with or without the same {@link java.util.Comparator}
     */
    private static <T> Set<T> sorted(final SortedSet<T> from) {
        return null != from.comparator() ?
                Sets.sorted(from.comparator()) :
                Sets.sorted();
    }

    /**
     * {@see ImmutableSetSingleton}.
     */
    static <T> Set<T> singleton(final T element) {
        return ImmutableSetSingleton.withSingleton(element);
    }

    /**
     * Creates a {@link ImmutableSetNonSingleton} with the given {@link Set} which is not defensively copied.
     */
    static <T> ImmutableSet<T> wrap(final Set<T> wrap) {
        return ImmutableSetNonSingleton.withNonSingleton(wrap);
    }

    /**
     * Package private to limit sub classing.
     */
    ImmutableSet() {
        super();
    }

    @Override
    abstract public boolean contains(final Object other);

    @Override
    abstract public boolean isEmpty();

    @Override
    abstract public String toString();
}
