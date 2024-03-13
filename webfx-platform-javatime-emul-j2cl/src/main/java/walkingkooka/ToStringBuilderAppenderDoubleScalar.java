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

final class ToStringBuilderAppenderDoubleScalar extends ToStringBuilderAppenderNonUsesToStringBuilderScalar<Double> {

    static ToStringBuilderAppenderDoubleScalar with(final Double value) {
        return new ToStringBuilderAppenderDoubleScalar(value);
    }

    private ToStringBuilderAppenderDoubleScalar(final Double value) {
        super(value);
    }

    @SuppressWarnings("UnnecessaryUnboxing")
    @Override
    boolean isDefaultValue() {
        return Math.signum(this.value.doubleValue()) == 0;
    }

    @Override
    void value(final ToStringBuilder builder) {
        builder.buffer.append(this.value);
        builder.mode = builder.mode.value();
    }
}
