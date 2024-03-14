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

import walkingkooka.text.CharSequences;

import java.util.Collection;
import java.util.Map;

/**
 * The options that may be used to control how various values are encoded or handled by {@link
 * ToStringBuilder}.
 */
public enum ToStringBuilderOption {
    /**
     * Any added {@link CharSequence} or characters value will be escaped
     */
    ESCAPE,
    //

    /**
     * Any added {@link CharSequence} or characters value will be double quoted.
     */
    QUOTE,
    //

    /**
     * If an array, {@link Collection} or {@link Map} or similar container the elements will be
     * added of a comma separated values.
     */
    INLINE_ELEMENTS,
    //

    /**
     * Null, false or 0 values are ignored.
     */
    SKIP_IF_DEFAULT_VALUE,
    //

    /**
     * any byte values added will be in a hex-decimal value
     */
    HEX_BYTES {
        @Override
        void add(final byte value, final ToStringBuilder builder) {
            addHex(0xFF & value, builder, 2);
        }
    },
    //

    /**
     * any <code>byte</code>, <code>short</code>, <code>int</code> or <code>long<code> values added
     * will be in a hex-decimal value
     */
    HEX_WHOLE_NUMBERS {
        @Override
        void add(final byte value, final ToStringBuilder builder) {
            addHex(0xFF & (long) value, builder, 2);
        }

        @Override
        void add(final short value, final ToStringBuilder builder) {
            addHex(0xFFFF & (long) value, builder, 4);
        }

        @Override
        void add(final int value, final ToStringBuilder builder) {
            addHex(0xFFFFFFFFL & (value), builder, 8);
        }

        @Override
        void add(final long value, final ToStringBuilder builder) {
            addHex(value, builder, 16);
        }
    },
    //

    /**
     * Any <code>boolean array<code> will have its true values encoded of ones and false values
     * encoded of zeroes.
     */
    ONE_AND_ZERO_BOOLEAN_ARRAYS;

    /**
     * Adds the byte in string form using the default base 10 system.
     */
    void add(final byte value, final ToStringBuilder builder) {
        builder.buffer.append(value);
        builder.mode = builder.mode.value();
    }

    /**
     * Encodes the given value into its hex form and pads with leading zeroes of required.
     */
    static private void addHex(final long value, final ToStringBuilder builder, final int pad) {
        builder.buffer.append(CharSequences.padLeft(Long.toHexString(value).toLowerCase(), pad, '0'));
        builder.mode = builder.mode.value();
    }

    void add(final short value, final ToStringBuilder builder) {
        builder.buffer.append(value);
        builder.mode = builder.mode.value();
    }

    void add(final int value, final ToStringBuilder builder) {
        builder.buffer.append(value);
        builder.mode = builder.mode.value();
    }

    void add(final long value, final ToStringBuilder builder) {
        builder.buffer.append(value);
        builder.mode = builder.mode.value();
    }

    final static ToStringBuilderOption DEFAULT = ESCAPE;
}
