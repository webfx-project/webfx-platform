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

import java.util.Map;
import java.util.Set;

/**
 * An immutable {@link Map} with an {@link Map} holding a defensive copy. The map must not be empty.
 */
final class ImmutableMapNonSingletonMap<K, V> extends ImmutableMap<K, V> {

    static <K, V> ImmutableMapNonSingletonMap<K, V> with(final Map<K, V> notCopied) {
        return new ImmutableMapNonSingletonMap<>(notCopied);
    }

    private ImmutableMapNonSingletonMap(final Map<K, V> map) {
        super();
        this.entrySet = ImmutableMapNonSingletonMapEntrySet.with(map);
    }

    @Override
    public boolean containsKey(final Object key) {
        return this.entrySet.map.containsKey(key);
    }

    @Override
    public boolean containsValue(final Object value) {
        return this.entrySet.map.containsValue(value);
    }

    @Override
    public V get(final Object key) {
        return this.entrySet.map.get(key);
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
        return this.entrySet.size();
    }

    private final ImmutableMapNonSingletonMapEntrySet<K, V> entrySet;
}
