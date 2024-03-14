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

final class ToStringBuilderAppenderDefaultScalar extends ToStringBuilderAppenderNonUsesToStringBuilderScalar<Object> {

    static ToStringBuilderAppenderDefaultScalar with(final Object value) {
        return new ToStringBuilderAppenderDefaultScalar(value);
    }

    private ToStringBuilderAppenderDefaultScalar(final Object value) {
        super(value);
        this.string = String.valueOf(value);
    }

    @Override
    boolean isDefaultValue() {
        return null == this.value || this.string.length() == 0; // null or empty may be skipped
    }

    @Override
    void value(final ToStringBuilder builder) {
        builder.buffer.append(this.string); // without escaping or quoting, verbatim.
        builder.mode = builder.mode.value();
        builder.valueFinished();
    }

    private final String string;
}
