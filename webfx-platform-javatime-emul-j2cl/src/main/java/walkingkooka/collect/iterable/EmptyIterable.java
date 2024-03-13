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

import walkingkooka.Cast;
import walkingkooka.collect.iterator.Iterators;

import java.util.Iterator;

/**
 * An {@link Iterable} that returns an empty {@link Iterator}.
 */
final class EmptyIterable<T> implements Iterable<T> {

    static <T> EmptyIterable<T> instance() {
        return Cast.to(INSTANCE);
    }

    /**
     * Singleton instance
     */
    private final static EmptyIterable<?> INSTANCE = new EmptyIterable<>();

    private EmptyIterable() {
        super();
    }

    @Override
    public Iterator<T> iterator() {
        return Iterators.empty();
    }

    @Override
    public String toString() {
        return "[]";
    }
}
