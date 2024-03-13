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

package walkingkooka.compare;

import walkingkooka.test.Fake;

import java.util.Comparator;

/**
 * A {@link Comparator} that always throws {@link UnsupportedOperationException}.
 */
final class FakeComparator<T> implements Comparator<T>, Fake {

    static <T> FakeComparator<T> create() {
        return new FakeComparator<>();
    }

    private FakeComparator() {
        super();
    }

    @Override
    public int compare(final T o1, final T o2) {
        throw new UnsupportedOperationException();
    }
}
