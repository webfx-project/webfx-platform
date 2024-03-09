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

package walkingkooka;

abstract class ToStringBuilderAppenderArrayVector<V> extends ToStringBuilderAppenderArrayOrCharArrayVector<V> {

    ToStringBuilderAppenderArrayVector(final V value) {
        super(value);
    }

    @Override
    final boolean isEmpty() {
        return null == this.value || 0 == this.length();
    }

    abstract int length();

    final void appendElements(final ToStringBuilder builder) {
        final int length = this.length();

        for (int i = 0; i < length; i++) {
            if (0 != i) {
                builder.appendValueSeparator();
            }
            this.append(i, builder);
        }
    }

    /**
     * Appends the given element to the {@link ToStringBuilder}
     */
    abstract void append(final int index, final ToStringBuilder builder);
}
