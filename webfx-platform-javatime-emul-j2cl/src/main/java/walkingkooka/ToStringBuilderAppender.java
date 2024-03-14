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

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

/**
 * A template class that handles "appending" a value of any type honouring the options and encodings set on the parent {@link ToStringBuilderOption}.
 */
abstract class ToStringBuilderAppender<V> {

    /**
     * {@see ToStringBuilderAppenderBooleanArrayVector}
     */
    static ToStringBuilderAppender<?> booleanArray(final boolean[] value) {
        return ToStringBuilderAppenderBooleanArrayVector.with(value);
    }

    /**
     * {@see ToStringBuilderAppenderBooleanScalar}
     */
    static ToStringBuilderAppender<?> booleanValue(final Boolean value) {
        return ToStringBuilderAppenderBooleanScalar.with(value);
    }

    /**
     * {@see ToStringBuilderAppenderByteArrayVector}
     */
    static ToStringBuilderAppender<?> byteArray(final byte[] value) {
        return ToStringBuilderAppenderByteArrayVector.with(value);
    }

    /**
     * {@see ToStringBuilderAppenderByteScalar}
     */
    static ToStringBuilderAppender<?> byteValue(final Byte value) {
        return ToStringBuilderAppenderByteScalar.with(value);
    }

    /**
     * {@see ToStringBuilderAppenderCharArrayVector}
     */
    static ToStringBuilderAppender<?> charArray(final char[] value) {
        return ToStringBuilderAppenderCharArrayVector.with(value);
    }

    /**
     * {@see ToStringBuilderAppenderCharScalar}
     */
    static ToStringBuilderAppender<?> charValue(final Character value) {
        return ToStringBuilderAppenderCharScalar.with(value);
    }

    /**
     * {@see ToStringBuilderAppenderCharSequenceScalar}
     */
    static ToStringBuilderAppender<?> charSequence(final CharSequence value) {
        return ToStringBuilderAppenderCharSequenceScalar.with(value);
    }

    /**
     * {@see ToStringBuilderAppenderDefaultScalar}
     */
    private static ToStringBuilderAppenderDefaultScalar defaultScalar(final Object value) {
        return ToStringBuilderAppenderDefaultScalar.with(value);
    }

    /**
     * {@see ToStringBuilderAppenderDoubleArrayVector}
     */
    static ToStringBuilderAppender<?> doubleArray(final double[] value) {
        return ToStringBuilderAppenderDoubleArrayVector.with(value);
    }

    /**
     * {@see ToStringBuilderAppenderDoubleScalar}
     */
    static ToStringBuilderAppender<?> doubleValue(final Double value) {
        return ToStringBuilderAppenderDoubleScalar.with(value);
    }
    
    /**
     * {@see ToStringBuilderAppenderEntryScalar}
     */
    private static ToStringBuilderAppender<?> entry(final Entry<?, ?> value) {
        return ToStringBuilderAppenderEntryScalar.with(value);
    }

    /**
     * {@see ToStringBuilderAppenderFloatArrayVector}
     */
    static ToStringBuilderAppender<?> floatArray(final float[] value) {
        return ToStringBuilderAppenderFloatArrayVector.with(value);
    }

    /**
     * {@see ToStringBuilderAppenderDoubleScalar}
     */
    static ToStringBuilderAppender<?> floatValue(final Float value) {
        return ToStringBuilderAppenderDoubleScalar.with(null == value ? null : value.doubleValue());
    }

    /**
     * {@see ToStringBuilderAppenderIntArrayVector}
     */
    static ToStringBuilderAppender<?> intArray(final int[] value) {
        return ToStringBuilderAppenderIntArrayVector.with(value);
    }

    /**
     * {@see ToStringBuilderAppenderIntScalar}
     */
    static ToStringBuilderAppender<?> intValue(final Integer value) {
        return ToStringBuilderAppenderIntScalar.with(value);
    }

    /**
     * {@see ToStringBuilderAppenderIterableVector}
     */
    private static ToStringBuilderAppender<?> iterable(final Iterable<?> value) {
        return ToStringBuilderAppenderIterableVector.with(value);
    }

    /**
     * {@see ToStringBuilderAppenderLongArrayVector}
     */
    static ToStringBuilderAppender<?> longArray(final long[] value) {
        return ToStringBuilderAppenderLongArrayVector.with(value);
    }

    /**
     * {@see ToStringBuilderAppenderLongScalar}
     */
    static ToStringBuilderAppender<?> longValue(final Long value) {
        return ToStringBuilderAppenderLongScalar.with(value);
    }

    /**
     * Performs a series of instanceof checks to determine the matching {@link ToStringBuilderAppender}.
     */
    static ToStringBuilderAppender<?> object(final Object value) {
        ToStringBuilderAppender<?> appender;

        do {
            if (value instanceof UsesToStringBuilder) {
                appender = usesToStringBuilder((UsesToStringBuilder) value);
                break;
            }
            if (value instanceof Boolean) {
                appender = booleanValue((Boolean) value);
                break;
            }
            if (value instanceof Character) {
                appender = charValue((Character) value);
                break;
            }
            if (value instanceof CharSequence) {
                appender = charSequence((CharSequence) value);
                break;
            }
            if (value instanceof Number) {
                if (value instanceof Byte) {
                    appender = byteValue((Byte) value);
                    break;
                }
                if (value instanceof Double) {
                    appender = doubleValue((Double) value);
                    break;
                }
                if (value instanceof Float) {
                    appender = floatValue((Float) value);
                    break;
                }
                if (value instanceof Integer) {
                    appender = intValue((Integer) value);
                    break;
                }
                if (value instanceof Long) {
                    appender = longValue((Long) value);
                    break;
                }
                if (value instanceof Short) {
                    appender = shortValue((Short) value);
                    break;
                }
                appender = defaultScalar(value);
                break;
            }

            if (value instanceof Optional) {
                appender = optional(
                        Cast.to(value)
                );
                break;
            }
            
            if (value instanceof Map) {
                final Map<?, ?> map = Cast.to(value);
                appender = iterable(map.entrySet());
                break;
            }
            if (value instanceof Map.Entry) {
                appender = entry(Cast.to(value));
                break;
            }
            if (value instanceof Iterable) {
                appender = iterable(Cast.to(value));
                break;
            }
            if (value instanceof boolean[]) {
                appender = booleanArray((boolean[]) value);
                break;
            }
            if (value instanceof byte[]) {
                appender = byteArray((byte[]) value);
                break;
            }
            if (value instanceof char[]) {
                appender = charArray((char[]) value);
                break;
            }
            if (value instanceof double[]) {
                appender = doubleArray((double[]) value);
                break;
            }
            if (value instanceof float[]) {
                appender = floatArray((float[]) value);
                break;
            }
            if (value instanceof int[]) {
                appender = intArray((int[]) value);
                break;
            }
            if (value instanceof long[]) {
                appender = longArray((long[]) value);
                break;
            }
            if (value instanceof Object[]) {
                appender = objectArray((Object[]) value);
                break;
            }
            if (value instanceof short[]) {
                appender = shortArray((short[]) value);
                break;
            }

            if (value instanceof OptionalDouble) {
                appender = optionalDouble(
                        Cast.to(value)
                );
                break;
            }
            if (value instanceof OptionalInt) {
                appender = optionalInt(
                        Cast.to(value)
                );
                break;
            }
            if (value instanceof OptionalLong) {
                appender = optionalLong(
                        Cast.to(value)
                );
                break;
            }

            appender = defaultScalar(value);
        } while (false);

        return appender;
    }

    /**
     * Wraps the object array which must be non null, and creates a {@link #iterable(Iterable)}.
     */
    private static ToStringBuilderAppender<?> objectArray(final Object[] value) {
        return iterable(Arrays.asList(value));
    }

    /**
     * {@see ToStringBuilderAppenderOptionalVector}
     */
    static ToStringBuilderAppender<?> optional(final Optional<?> value) {
        return ToStringBuilderAppenderOptionalVector.with(value);
    }

    /**
     * {@see ToStringBuilderAppenderOptionalDoubleVector}
     */
    static ToStringBuilderAppender<?> optionalDouble(final OptionalDouble value) {
        return ToStringBuilderAppenderOptionalDoubleVector.with(value);
    }

    /**
     * {@see ToStringBuilderAppenderOptionalIntVector}
     */
    static ToStringBuilderAppender<?> optionalInt(final OptionalInt value) {
        return ToStringBuilderAppenderOptionalIntVector.with(value);
    }

    /**
     * {@see ToStringBuilderAppenderOptionalLongVector}
     */
    static ToStringBuilderAppender<?> optionalLong(final OptionalLong value) {
        return ToStringBuilderAppenderOptionalLongVector.with(value);
    }

    /**
     * {@see ToStringBuilderAppenderShortArrayVector}
     */
    static ToStringBuilderAppender<?> shortArray(final short[] value) {
        return ToStringBuilderAppenderShortArrayVector.with(value);
    }

    /**
     * {@see ToStringBuilderAppenderShortScalar}
     */
    static ToStringBuilderAppender<?> shortValue(final Short value) {
        return ToStringBuilderAppenderShortScalar.with(value);
    }

    /**
     * {@see ToStringBuilderAppenderUsesToStringBuilderScalar}
     */
    static ToStringBuilderAppender<?> usesToStringBuilder(final UsesToStringBuilder value) {
        return ToStringBuilderAppenderUsesToStringBuilderScalar.with(value);
    }

    /**
     * Package private to limit sub classing.
     */
    ToStringBuilderAppender(final V value) {
        super();
        this.value = value;
    }

    final void append(final ToStringBuilder builder) {
        if (builder.bufferLeft() > 0) {
            this.append0(builder);
        }
        builder.valueFinished(); // clear labels, before and after
    }

    abstract void append0(final ToStringBuilder builder);

    final void appendLabelBeforeValueAfter(final ToStringBuilder builder) {
        final int beforeLength = builder.buffer.length();

        if (!this.shouldSkip(builder)) {
            if (false == builder.appendLabel(builder.label)) {

                final String after = this.before(builder);
                this.value(builder);
                this.after(after, builder);

                builder.trimBufferIfNecessary(beforeLength);
            }
        }
    }

    void appendLabelBeforeValueAfterPostEmptyCheck(final ToStringBuilder builder) {
        final StringBuilder buffer = builder.buffer;
        final int beforeLength = buffer.length();

        if (!this.shouldSkip(builder)) {
            final ToStringBuilderMode mode = builder.mode;
            if (false == builder.appendLabel(builder.label)) {

                final String after = this.before(builder);

                final int lengthBeforeValue = buffer.length();
                this.value(builder);

                if (buffer.length() == lengthBeforeValue && builder.option(ToStringBuilderOption.SKIP_IF_DEFAULT_VALUE)) {
                    buffer.setLength(beforeLength);
                    builder.mode = mode; // restore mode trying to reverse any changes because value is empty
                } else {
                    this.after(after, builder);

                    builder.trimBufferIfNecessary(beforeLength);
                }
            }
        }
    }

    /**
     * Returns true if the value should be skipped because skipping is enabled and the value is empty/default.
     */
    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    abstract boolean shouldSkip(final ToStringBuilder builder);

    /**
     * Vectors or contains may surround values with a before/after values.
     */
    abstract String before(final ToStringBuilder builder);

    /**
     * Inserts the value which may involve escaping or other forms of encoding such as HEX if enabled.
     */
    abstract void value(final ToStringBuilder builder);

    abstract void after(final String after, ToStringBuilder builder);

    /**
     * The value.
     */
    final V value;

    @Override
    public final String toString() {
        return String.valueOf(this.value);
    }
}
