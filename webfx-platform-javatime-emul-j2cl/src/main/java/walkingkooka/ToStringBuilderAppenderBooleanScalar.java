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

final class ToStringBuilderAppenderBooleanScalar extends ToStringBuilderAppenderNonUsesToStringBuilderScalar<Boolean> {

    static ToStringBuilderAppenderBooleanScalar with(final boolean value) {
        return new ToStringBuilderAppenderBooleanScalar(value);
    }

    private ToStringBuilderAppenderBooleanScalar(final boolean value) {
        super(value);
    }

    @Override
    boolean isDefaultValue() {
        return this.value == false;
    }

    @SuppressWarnings("UnnecessaryUnboxing")
    @Override
    void value(final ToStringBuilder builder) {
        builder.buffer.append(this.value.booleanValue() ?
                ToStringBuilder.DEFAULT_TRUE_VALUE :
                ToStringBuilder.DEFAULT_FALSE_VALUE);
        builder.mode = builder.mode.value();
    }
}
