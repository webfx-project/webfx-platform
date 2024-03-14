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

import walkingkooka.collect.iterator.Iterators;

import java.util.Iterator;
import java.util.Set;

/**
 * A {@link Set} presents a read only view of a defensively copied {@link Set} given to it.
 */
final class ImmutableSetNonSingleton<T> extends ImmutableSet<T> {

    /**
     * Returns a {@link Set} which is immutable including copying elements if necessary.
     */
    static <T> ImmutableSetNonSingleton<T> withNonSingleton(final Set<T> notCopied) {
        return new ImmutableSetNonSingleton<>(notCopied);
    }

    private ImmutableSetNonSingleton(final Set<T> set) {
        super();
        this.set = set;
    }

    @Override
    public boolean contains(final Object other) {
        return this.set.contains(other);
    }

    @Override
    public Iterator<T> iterator() {
        return Iterators.readOnly(this.set.iterator());
    }

    @Override
    public int size() {
        return this.set.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    private final Set<T> set;

    @Override
    public String toString() {
        return this.set.toString();
    }
}
