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

package walkingkooka.predicate;

import walkingkooka.collect.set.Sets;

import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

/**
 * A {@link Predicate} that returns true only if the value being tested exists in the {@link Set}.
 */
final class SetContainsPredicate<T> implements Predicate<T> {

    /**
     * Factory that takes a copy of the {@link Set} and creates a new {@link SetContainsPredicate}
     */
    static <T> SetContainsPredicate<T> with(final Set<T> set) {
        return new SetContainsPredicate<>(Sets.immutable(set));
    }

    /**
     * Private ctor use factory
     */
    private SetContainsPredicate(final Set<T> set) {
        super();
        this.set = set;
    }

    @Override
    public boolean test(final T value) {
        Objects.requireNonNull(value, "value");
        return this.set.contains(value);
    }

    private final Set<T> set;

    @Override
    public String toString() {
        return this.set.toString();
    }
}
