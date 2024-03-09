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

import java.util.List;

/**
 * A {@link List} presents a read only view of a previously defensively copied {@link List} given to it.
 */
final class ImmutableListNonSingleton<T> extends ImmutableList<T> {

    /**
     * Returns a {@link List} which is immutable but does not make a copy of the given list which assumed to already be copied.
     */
    static <T> ImmutableListNonSingleton<T> with(final Object[] notCopied) {
        return new ImmutableListNonSingleton<>(notCopied);
    }

    private ImmutableListNonSingleton(final Object[] elements) {
        super();
        this.elements = elements;
    }

    @Override
    public T get(final int index) {
        return Cast.to(this.elements[index]);
    }

    @Override
    public int size() {
        return this.elements.length;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    private final Object[] elements;
}
