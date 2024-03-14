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

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Function;

/**
 * An {@link Iterator} that applies a mapping {@link Function} to the values returned by the wrapped {@link Iterator}.
 */
final class MappingIterator<S, D> implements Iterator<D> {

    static <S, D> MappingIterator<S, D> with(final Iterator<S> iterator,
                                             final Function<S, D> mapper) {
        Objects.requireNonNull(iterator, "iterator");
        Objects.requireNonNull(mapper, "mapper");

        return new MappingIterator<>(iterator, mapper);
    }

    private MappingIterator(final Iterator<S> iterator,
                            final Function<S, D> mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }

    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override
    public D next() {
        return this.mapper.apply(this.iterator.next());
    }

    /**
     * Mapping function to each returned value.
     */
    private final Function<S, D> mapper;

    @Override
    public void remove() {
        this.iterator.remove();
    }

    private final Iterator<S> iterator;

    @Override
    public String toString() {
        return this.iterator.toString();
    }
}
