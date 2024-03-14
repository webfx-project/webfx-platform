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

final class ToStringBuilderAppenderBooleanArrayVector extends ToStringBuilderAppenderArrayVector<boolean[]> {

    static ToStringBuilderAppenderBooleanArrayVector with(final boolean[] value) {
        return new ToStringBuilderAppenderBooleanArrayVector(value);
    }

    private ToStringBuilderAppenderBooleanArrayVector(final boolean[] value) {
        super(value);
    }

    @Override
    int length() {
        return this.value.length;
    }

    @Override
    void value(final ToStringBuilder builder) {
        if (builder.option(ToStringBuilderOption.ONE_AND_ZERO_BOOLEAN_ARRAYS)) {
            this.compact(builder);
        } else {
            this.appendElements(builder);
        }
    }

    /**
     * Adds {@link ToStringBuilder#DEFAULT_TRUE_VALUE} for true and {@link ToStringBuilder#DEFAULT_FALSE_VALUE} for false elements
     * without a separator.
     */
    private void compact(final ToStringBuilder builder) {
        final StringBuilder buffer = builder.buffer;
        for (final boolean value : this.value) {
            buffer.append(value ?
                    ToStringBuilder.COMPACT_TRUE_VALUE :
                    ToStringBuilder.COMPACT_FALSE_VALUE);
        }
        builder.mode = builder.mode.value();
    }

    @Override
    void append(int index, final ToStringBuilder builder) {
        builder.buffer.append(this.value[index] ?
                ToStringBuilder.DEFAULT_TRUE_VALUE :
                ToStringBuilder.DEFAULT_FALSE_VALUE);
        builder.mode = builder.mode.value();
    }
}