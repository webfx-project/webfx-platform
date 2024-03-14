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

import walkingkooka.collect.iterator.Iterators;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

// ImmutableSet
final class ImmutableMapNonSingletonMapEntrySet<K, V> extends ImmutableMapEntrySet<Entry<K, V>> {

    static <K, V> ImmutableMapNonSingletonMapEntrySet<K, V> with(final Map<K, V> map) {
        return new ImmutableMapNonSingletonMapEntrySet<>(map);
    }

    private ImmutableMapNonSingletonMapEntrySet(final Map<K, V> map) {
        super();
        this.map = map;
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return Iterators.readOnly(this.map.entrySet().iterator());
    }

    @Override
    public int size() {
        return this.map.size();
    }

    final Map<K, V> map;

    @Override
    public String toString() {
        return this.map.entrySet().toString();
    }
}
