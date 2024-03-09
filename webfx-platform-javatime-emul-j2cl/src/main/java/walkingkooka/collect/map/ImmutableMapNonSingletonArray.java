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

package walkingkooka.collect.map;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * An immutable {@link Map} with an array of at least 2 entries.
 */
final class ImmutableMapNonSingletonArray<K, V> extends ImmutableMap<K, V> {

    @SuppressWarnings("unchecked")
    static <K, V> ImmutableMapNonSingletonArray<K, V> with(final Entry<K, V>... notCopied) {
        return new ImmutableMapNonSingletonArray<>(notCopied);
    }

    @SafeVarargs
    private ImmutableMapNonSingletonArray(final Entry<K, V>... entries) {
        super();
        this.entrySet = ImmutableMapNonSingletonArrayEntrySet.with(entries);
    }

    @Override
    public boolean containsKey(final Object key) {
        return Arrays.stream(this.entrySet.entries)
                .anyMatch(e -> e.getKey().equals(key));
    }

    @Override
    public V get(final Object key) {
        V value = null;

        for (final Entry<K, V> entry : this.entrySet.entries) {
            if (entry.getKey().equals(key)) {
                value = entry.getValue();
                break;
            }
        }
        return value;
    }

    @Override
    public boolean containsValue(final Object value) {
        return Arrays.stream(this.entrySet.entries)
                .anyMatch(e -> Objects.equals(e.getValue(), value));
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return this.entrySet;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return this.entrySet.entries.length;
    }

    private final ImmutableMapNonSingletonArrayEntrySet<K, V> entrySet;
}
