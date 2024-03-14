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

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/**
 * An {@link Iterable} that produces an {@link Iterator} that lazily chains all the {@link Iterator iterators}.
 */
final class ChainIterable<T> implements Iterable<T> {

    static <T> Iterable<T> with(final Iterable<T>... iterables) {
        Objects.requireNonNull(iterables, "iterables");

        final Iterable<T> result;

        final int count = iterables.length;
        switch (count) {
            case 0:
                result = Iterables.empty();
                break;
            case 1:
                result = iterables[0];
                break;
            default:
                result = new ChainIterable<>(
                        Arrays.copyOf(
                                iterables,
                                count
                        ) // GWT doesnt support Array.clone();
                );
                break;
        }
        return result;
    }

    private ChainIterable(final Iterable<T>[] iterables) {
        this.iterables = iterables;
    }

    @Override
    public Iterator<T> iterator() {
        return ChainIterableIterator.with(this.iterables);
    }

    private final Iterable<T>[] iterables;

    @Override
    public String toString() {
        return Arrays.toString(this.iterables);
    }
}
