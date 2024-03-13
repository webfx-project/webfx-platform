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

import walkingkooka.test.Fake;

import java.util.Iterator;

/**
 * An {@link Iterable} that always throws {@link UnsupportedOperationException}
 */
final class FakeIterable<T> implements Iterable<T>, Fake {

    /**
     * Creates a new {@link FakeIterable}
     */
    static <T> FakeIterable<T> create() {
        return new FakeIterable<>();
    }

    /**
     * Private constructor use factory
     */
    private FakeIterable() {
        super();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }
}
