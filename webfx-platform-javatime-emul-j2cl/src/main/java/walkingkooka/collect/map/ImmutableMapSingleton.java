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

import walkingkooka.collect.set.Sets;

import java.util.Map;
import java.util.Set;

/**
 * An immutable {@link Map} with a single entry.
 */
final class ImmutableMapSingleton<K, V> extends ImmutableMap<K, V> {

    static <K, V> ImmutableMapSingleton<K, V> with(final Entry<K, V> entry) {
        return new ImmutableMapSingleton<>(entry);
    }

    private ImmutableMapSingleton(final Entry<K, V> entry) {
        super();
        this.entry = entry;
    }

    @Override
    public boolean containsKey(final Object key) {
        return this.entry.getKey().equals(key);
    }

    @Override
    public boolean containsValue(final Object value) {
        return this.entry.getValue().equals(value);
    }

    @Override
    public V get(final Object key) {
        final Entry<K, V> entry = this.entry;

        return entry.getKey().equals(key) ?
                entry.getValue() :
                null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return Sets.of(this.entry);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 1;
    }

    private final Entry<K, V> entry;
}
