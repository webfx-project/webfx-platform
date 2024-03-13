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

import walkingkooka.Cast;
import walkingkooka.ToStringBuilder;
import walkingkooka.ToStringBuilderOption;

import java.util.Map;
import java.util.Objects;

/**
 * A read only{@link Map.Entry}.
 */
final class MapsEntry<K, V> implements Map.Entry<K, V> {

    static <K, V> MapsEntry<K, V> with(final K key, final V value) {
        Objects.requireNonNull(key, "key");
        return new MapsEntry<>(key, value);
    }

    private MapsEntry(final K key, final V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return this.key;
    }

    private final K key;

    @Override
    public V getValue() {
        return this.value;
    }

    private final V value;

    @Override
    public V setValue(final V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getKey(), this.getValue());
    }

    @Override
    public boolean equals(final Object other) {
        return this == other || other instanceof Map.Entry && equals0(Cast.to(other));
    }

    private boolean equals0(final Map.Entry<?, ?> other) {
        return this.getKey().equals(other.getKey()) && this.getValue().equals(other.getValue());
    }

    @Override
    public String toString() {
        return ToStringBuilder.empty()
                .disable(ToStringBuilderOption.QUOTE)
                .disable(ToStringBuilderOption.SKIP_IF_DEFAULT_VALUE)
                .labelSeparator("=")
                .label(this.getKey().toString())
                .surroundValues("[", "]")
                .value(this.getValue())
                .build();
    }
}
