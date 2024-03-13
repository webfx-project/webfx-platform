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

final class ToStringBuilderAppenderByteArrayVector extends ToStringBuilderAppenderArrayVector2<byte[]> {

    static ToStringBuilderAppenderByteArrayVector with(final byte[] value) {
        return new ToStringBuilderAppenderByteArrayVector(value);
    }

    private ToStringBuilderAppenderByteArrayVector(final byte[] value) {
        super(value);
    }

    @Override
    int length() {
        return this.value.length;
    }

    @Override
    void prepareValue(final ToStringBuilder builder) {
        this.encoder = builder.numberEncoder();
    }

    ToStringBuilderOption encoder;

    @Override
    void append(int index, ToStringBuilder builder) {
        this.encoder.add(this.value[index], builder);
    }
}
