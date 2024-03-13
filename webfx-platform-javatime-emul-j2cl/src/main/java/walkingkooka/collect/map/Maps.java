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

import javaemul.internal.annotations.GwtIncompatible;
import walkingkooka.Cast;
import walkingkooka.reflect.PublicStaticHelper;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

final public class Maps extends GwtMaps implements PublicStaticHelper {

    /**
     * Registers a {@link Map} type as immutable.
     */
    @SuppressWarnings("rawtypes")
    public static void registerImmutableType(final Class<? extends Map> type) {
        Objects.requireNonNull(type, "type");

        synchronized (ImmutableMap.TYPES) {
            ImmutableMap.TYPES.add(type);
        }
    }

    /**
     * {@see ConcurrentHashMap}
     * This method is ignored, and will be replaced by the method it shadowes to return a {@link HashMap}.
     */
    @GwtIncompatible
    static public <K, V> Map<K, V> concurrent() {
        return new ConcurrentHashMap<>();
    }

    /**
     * {@see Collections#emptyMap()
     */
    static public <K, V> Map<K, V> empty() {
        return Collections.emptyMap();
    }

    /**
     * {@see MapsEntry}
     */
    static public <K, V> Entry<K, V> entry(final K key, final V value) {
        return MapsEntry.with(key, value);
    }

    /**
     * {@see FakeMap}
     */
    static public <K, V> Map<K, V> fake() {
        return FakeMap.create();
    }

    /**
     * {@see HashMap}
     */
    static public <K, V> Map<K, V> hash() {
        return new HashMap<>();
    }

    /**
     * {@see IdentityHashMap}
     */
    static public <K, V> Map<K, V> identity() {
        return new IdentityHashMap<>();
    }

    /**
     * Returns an immutable {@link Map}.
     */
    static public <K, V> Map<K, V> immutable(final Map<K, V> map) {
        Objects.requireNonNull(map, "map");

        return ImmutableMap.isImmutable(map) ?
                map :
                copyAndSelect(map);
    }

    /**
     * Makes a defensive copy and then wraps or selects a {@link Map}.
     */
    private static <K, V> Map<K, V> copyAndSelect(final Map<K, V> map) {
        final Map<K, V> copy = map instanceof SortedMap ?
                sortedMap(Cast.to(map)) :
                ordered();
        copy.putAll(map);

        Map<K, V> immutable;
        switch (copy.size()) {
            case 0:
                immutable = empty();
                break;
            case 1:
                final Entry<K, V> entry = copy.entrySet().iterator().next();
                immutable = of(entry.getKey(), entry.getValue());
                break;
            case 2:
                final Iterator<Entry<K, V>> entries2 = copy.entrySet().iterator();
                immutable = ImmutableMap.array(entries2.next(),
                        entries2.next());
                break;
            case 3:
                final Iterator<Entry<K, V>> entries3 = copy.entrySet().iterator();
                immutable = ImmutableMap.array(entries3.next(),
                        entries3.next(),
                        entries3.next());
                break;
            case 4:
                final Iterator<Entry<K, V>> entries4 = copy.entrySet().iterator();
                immutable = ImmutableMap.array(entries4.next(),
                        entries4.next(),
                        entries4.next(),
                        entries4.next());
                break;
            default:
                immutable = ImmutableMap.map(copy);
                break;
        }
        return immutable;
    }

    /**
     * Factory that creates a {@link SortedMap} with the {@link Comparator} if present.
     */
    private static <K, V> Map<K, V> sortedMap(final SortedMap<K, V> map) {
        return null == map.comparator() ?
                sorted() :
                sorted(map.comparator());
    }

    /**
     * {@see TreeMap}
     */
    static public <K, V> NavigableMap<K, V> navigable() {
        return new TreeMap<>();
    }

    /**
     * {@see TreeMap}
     */
    static public <K, V> NavigableMap<K, V> navigable(final Comparator<? super K> comparator) {
        return new TreeMap<>(comparator);
    }

    /**
     * {@see Collections#singletonMap(Object, Object)
     */
    static public <K, V> Map<K, V> of(final K key, final V value) {
        return ImmutableMap.singleton(entry(key, value));
    }

    /**
     * A Map with two key/value pairs
     */
    static public <K, V> Map<K, V> of(final K key0,
                                      final V value0,
                                      final K key1,
                                      final V value1) {
        final Entry<K, V>[] entries = entriesArray(2);

        entries[0] = entry(key0, value0);
        entries[1] = entry(key1, value1);

        return ImmutableMap.array(entries);
    }

    /**
     * A Map with three key/value pairs
     */
    static public <K, V> Map<K, V> of(final K key0,
                                      final V value0,
                                      final K key1,
                                      final V value1,
                                      final K key2,
                                      final V value2) {
        final Entry<K, V>[] entries = entriesArray(3);

        entries[0] = entry(key0, value0);
        entries[1] = entry(key1, value1);
        entries[2] = entry(key2, value2);

        return ImmutableMap.array(entries);
    }

    /**
     * A Map with four key/value pairs
     */
    static public <K, V> Map<K, V> of(final K key0,
                                      final V value0,
                                      final K key1,
                                      final V value1,
                                      final K key2,
                                      final V value2,
                                      final K key3,
                                      final V value3) {
        final Entry<K, V>[] entries = entriesArray(4);

        entries[0] = entry(key0, value0);
        entries[1] = entry(key1, value1);
        entries[2] = entry(key2, value2);
        entries[3] = entry(key3, value3);

        return ImmutableMap.array(entries);
    }

    /**
     * A Map with 5 key/value pairs
     */
    static public <K, V> Map<K, V> of(final K key0,
                                      final V value0,
                                      final K key1,
                                      final V value1,
                                      final K key2,
                                      final V value2,
                                      final K key3,
                                      final V value3,
                                      final K key4,
                                      final V value4) {
        final Entry<K, V>[] entries = entriesArray(5);

        entries[0] = entry(key0, value0);
        entries[1] = entry(key1, value1);
        entries[2] = entry(key2, value2);
        entries[3] = entry(key3, value3);
        entries[4] = entry(key4, value4);

        return ImmutableMap.array(entries);
    }

    /**
     * A Map with 6 key/value pairs
     */
    static public <K, V> Map<K, V> of(final K key0,
                                      final V value0,
                                      final K key1,
                                      final V value1,
                                      final K key2,
                                      final V value2,
                                      final K key3,
                                      final V value3,
                                      final K key4,
                                      final V value4,
                                      final K key5,
                                      final V value5) {
        final Entry<K, V>[] entries = entriesArray(6);

        entries[0] = entry(key0, value0);
        entries[1] = entry(key1, value1);
        entries[2] = entry(key2, value2);
        entries[3] = entry(key3, value3);
        entries[4] = entry(key4, value4);
        entries[5] = entry(key5, value5);

        return ImmutableMap.array(entries);
    }

    private static <K, V> Entry<K, V>[] entriesArray(final int size) {
        //noinspection unchecked
        return new Entry[size];
    }

    /**
     * {@see LinkedHashMap}
     */
    static public <K, V> Map<K, V> ordered() {
        return new LinkedHashMap<>();
    }

    /**
     * {@see Collections#unmodifiableMap(Map)
     */
    static public <K, V> Map<K, V> readOnly(final Map<K, V> map) {
        return ImmutableMap.isImmutable(map) ?
                map :
                Collections.unmodifiableMap(map);
    }

    /**
     * {@see TreeMap}
     */
    static public <K, V> SortedMap<K, V> sorted() {
        return new TreeMap<>();
    }

    /**
     * {@see TreeMap}
     */
    static public <K, V> SortedMap<K, V> sorted(final Comparator<? super K> comparator) {
        return new TreeMap<>(comparator);
    }

    /**
     * {@see WeakHashMap}
     */
    @GwtIncompatible("Maybe replace with regular HashMap for j2cl")
    static public <K, V> Map<K, V> weak() {
        return new WeakHashMap<>();
    }

    /**
     * Stop creation
     */
    private Maps() {
        throw new UnsupportedOperationException();
    }
}
