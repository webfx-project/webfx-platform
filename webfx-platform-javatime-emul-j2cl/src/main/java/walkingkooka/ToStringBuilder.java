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

import walkingkooka.build.Builder;
import walkingkooka.text.CharSequences;

import java.util.EnumSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * A builder that makes it easy to build nice consistent {@link Object#toString()}. Note that any
 * labels are only used for the next value that is added once. A second value will not have use the
 * first label but it must be set again. <br> The default {@link ToStringBuilderOption} are
 * <ul>
 * <li>{@link ToStringBuilderOption#QUOTE}</li>
 * <li>{@link ToStringBuilderOption#INLINE_ELEMENTS}</li>
 * <li>{@link ToStringBuilderOption#SKIP_IF_DEFAULT_VALUE}</li>
 * </ul>
 * <br>
 * Types that by definition are stateful such as {@link java.util.Iterator} and {@link java.util.Enumeration} do not have their
 * elements consumed but rather the default {@link Object#toString()} or {@link UsesToStringBuilder#buildToString(ToStringBuilder)} is used.
 */
final public class ToStringBuilder implements Builder<String> {

    /**
     * Accepts a {@link UsesToStringBuilder} and creates a {@link ToStringBuilder} and then invokes
     * {@link UsesToStringBuilder#buildToString(ToStringBuilder)} and returns the final result.
     */
    public static String buildFrom(final UsesToStringBuilder uses) {
        Objects.requireNonNull(uses, "uses");

        final ToStringBuilder builder = new ToStringBuilder();
        uses.buildToString(builder);
        return builder.build();
    }

    /**
     * Creates an empty {@link ToStringBuilder}.
     */
    public static ToStringBuilder empty() {
        return new ToStringBuilder();
    }

    /**
     * The value that is added when a null value is encountered.
     */
    public final static String NULL = "null";

    /**
     * The default label value which also results in the {@link #labelSeparator(String)} being
     * skipped when a value is added.
     */
    public final static String DEFAULT_LABEL = null;

    /**
     * The default label separator is the equals sign. New or different values may be set using
     * {@link #labelSeparator(String)}.
     */
    @SuppressWarnings("WeakerAccess")
    public static final String LABEL_SEPARATOR = "=";

    /**
     * The default value separator which is a comma followed by a space. New or different values may
     * be set using {@link #valueSeparator(String)}.
     */
    public static final String DEFAULT_VALUE_SEPARATOR = ", ";

    /**
     * The default separator is a single space. New or different values may be set using {@link
     * #separator(String)}.
     */
    public static final String SEPARATOR = " ";

    /**
     * The default value which surrounds values charSequence an {@link Iterable iterable}, {@link Map} and arrays
     * except for char[] which is nothing. New or different values may be set using {@link #surroundValues(String, String)}.
     */
    @SuppressWarnings("WeakerAccess")
    public static final String DEFAULT_BEFORE_VALUES = "";

    /**
     * The default value which surrounds values charSequence an {@link Iterable iterable}, {@link Map} and arrays
     * except for char[] which is nothing. New or different values may be set using {@link #surroundValues(String, String)}.
     */
    @SuppressWarnings("WeakerAccess")
    public static final String DEFAULT_AFTER_VALUES = "";

    /**
     * The {@link String} added when processing true elements of a boolean[] when {@link
     * ToStringBuilderOption#ONE_AND_ZERO_BOOLEAN_ARRAYS} is false.
     */
    public static final String DEFAULT_TRUE_VALUE = Boolean.TRUE.toString();

    /**
     * The {@link String} added when processing false elements of a boolean[] when {@link
     * ToStringBuilderOption#ONE_AND_ZERO_BOOLEAN_ARRAYS} is false.
     */
    public static final String DEFAULT_FALSE_VALUE = Boolean.FALSE.toString();

    /**
     * The {@link char} added when processing true elements of a boolean[] when {@link
     * ToStringBuilderOption#ONE_AND_ZERO_BOOLEAN_ARRAYS} is true.
     */
    public static final char COMPACT_TRUE_VALUE = '1';

    /**
     * The {@link char} added when processing false elements of a boolean[] when {@link
     * ToStringBuilderOption#ONE_AND_ZERO_BOOLEAN_ARRAYS} is true.
     */
    public static final char COMPACT_FALSE_VALUE = '0';

    /**
     * The default global length.
     */
    public static final int GLOBAL_LENGTH = 1000;

    /**
     * The default value length.
     */
    public static final int VALUE_LENGTH = GLOBAL_LENGTH - 100;

    /**
     * Private constructor use static factory
     */
    private ToStringBuilder() {
        super();

        this.before = DEFAULT_BEFORE_VALUES;
        this.after = DEFAULT_AFTER_VALUES;

        this.globalLength = GLOBAL_LENGTH;
        this.maxGlobalLength = Integer.MAX_VALUE;
        this.valueLength = VALUE_LENGTH;
        this.maxValueLength = Integer.MAX_VALUE;
        this.callerBufferLengthSnapshot = 0;

        this.options = EnumSet.noneOf(ToStringBuilderOption.class);
        this.buffer = new StringBuilder();

        this.mode = ToStringBuilderMode.NONE;

        this.defaults();
    }

    /**
     * Restores this {@link ToStringBuilder} mutable state to defaults.
     */
    public ToStringBuilder defaults() {
        this.separator = SEPARATOR;
        this.labelSeparator = LABEL_SEPARATOR;
        this.valueSeparator = DEFAULT_VALUE_SEPARATOR;

        final Set<ToStringBuilderOption> options = this.options;
        options.clear();
        options.add(ToStringBuilderOption.QUOTE);
        options.add(ToStringBuilderOption.INLINE_ELEMENTS);
        options.add(ToStringBuilderOption.SKIP_IF_DEFAULT_VALUE);

        return this;
    }

    // state/config.....................................................................................................

    /**
     * Returns a {@link Runnable} which will when invoked restore the state captured here.
     * Currently the following is captured.
     * <ul>
     * <li>{@link #labelSeparator(String)}</li>
     * <li>{@link #options}</li>
     * <li>{@link #separator(String)}</li>
     * </ul>
     * Short term values such as {@link #label(String)} which are cleared after each value are ignored.
     */
    public Runnable saveState() {
        return ToStringBuilderSaveStateRunnable.with(this.labelSeparator,
                this.options,
                this.separator,
                this.valueSeparator,
                this);
    }

    /**
     * Only invoked by {@link ToStringBuilderSaveStateRunnable#run()}
     */
    void restoreState(final String labelSeparator,
                      final EnumSet<ToStringBuilderOption> options,
                      final String separator,
                      final String valueSeparator) {
        this.labelSeparator = labelSeparator;
        this.options.clear();
        this.options.addAll(options);
        this.separator = separator;
        this.valueSeparator = valueSeparator;
    }

    /**
     * Adds a possible enabled {@link ToStringBuilderOption option}.
     */
    public ToStringBuilder enable(final ToStringBuilderOption option) {
        Objects.requireNonNull(option, "option");

        this.options.add(option);
        return this;
    }

    /**
     * Removes a possible enabled {@link ToStringBuilderOption option}.
     */
    public ToStringBuilder disable(final ToStringBuilderOption option) {
        Objects.requireNonNull(option, "option");

        this.options.remove(option);
        return this;
    }

    /**
     * Tests if the given {@link ToStringBuilderOption} is enabled.
     */
    boolean option(final ToStringBuilderOption option) {
        return this.options.contains(option);
    }

    /**
     * Holds the currently enabled {@link ToStringBuilderOption options}.
     */
    EnumSet<ToStringBuilderOption> options;

    /**
     * Sets the separator before labels and after values. The default is a single space.
     */
    public ToStringBuilder separator(final String separator) {
        Objects.requireNonNull(separator, "separator");

        this.separator = separator;
        return this;
    }

    /**
     * The default separator is a single space.
     */
    private String separator;

    /**
     * Sets the separator between a label and value.
     */
    public ToStringBuilder labelSeparator(final String separator) {
        Objects.requireNonNull(separator, "separator");

        this.labelSeparator = separator;
        return this;
    }

    /**
     * The default label separator is the equals sign.
     */
    private String labelSeparator;

    /**
     * Sets the separator between consecutive values.
     */
    public ToStringBuilder valueSeparator(final String separator) {
        Objects.requireNonNull(separator, "separator");

        this.valueSeparator = separator;
        return this;
    }

    private String valueSeparator;

    /**
     * Sets two surround {@link String} values that surround zero or more values. This only affects {@link Iterable iterable},
     * {@link Map maps} and arrays except for char[].
     *
     * <pre>
     * create()<br>
     * .surroundValues(&quot;[&quot;, &quot;]&quot;)<br>
     * .label(&quot;label&quot;)<br>
     * .value(new int[] { 1, 2, 3 })<br>
     * </pre>
     * <p>
     * prints
     *
     * <pre>
     * [1, 2, 3]
     * </pre>
     */
    public ToStringBuilder surroundValues(final String before, final String after) {
        Objects.requireNonNull(before, "before");
        Objects.requireNonNull(after, "after");

        this.before = before;
        this.after = after;
        return this;
    }

    String before;

    String after;

    /**
     * Sets the maximum length of the {@link String} form for any value that is added. Once this
     * limit is reached all future appends involving that value are short circuited such of
     * processing a multi value array etc. Note when processing a value recursively it is not
     * possible increase the global length.
     */
    public ToStringBuilder valueLength(final int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length " + length + " must be greater than 0");
        }

        this.valueLength = Math.min(length, this.maxValueLength);
        return this;
    }

    int valueLength;

    private int maxValueLength;

    /**
     * Sets the maximum length of the {@link String} that will be returned. Once this limit is
     * reached all future appends in any form are ignored. Note when processing a value recursively
     * it is not possible increase the global length.
     */
    public ToStringBuilder globalLength(final int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length " + length + " must be greater than 0");
        }

        final int max = this.maxGlobalLength;
        final int updatedLength = this.callerBufferLengthSnapshot + length;
        this.globalLength = Math.min(updatedLength, max);
        this.maxGlobalLength = Math.max(updatedLength, max);
        return this;
    }

    int globalLength;

    private int maxGlobalLength;

    private int callerBufferLengthSnapshot;


    // individual values................................................................................................

    /**
     * Adds a {@link String label}. Note the label is not committed until a value is added. Setting
     * an empty label is ignored results in only the value separator followed by the value without
     * the label separator. Labels are only used for the next value even if it is skipped because it
     * is a default.
     */
    public ToStringBuilder label(final String label) {
        Objects.requireNonNull(label, "label");

        this.label = label;
        return this;
    }

    /**
     * When a value is added this will be added before the value.
     */
    String label;

    // value............................................................................................................

    /**
     * Adds a boolean value.
     */
    public ToStringBuilder value(final boolean value) {
        ToStringBuilderAppender.booleanValue(value).append(this);
        return this;
    }

    /**
     * Adds a boolean array.
     */
    public ToStringBuilder value(final boolean[] value) {
        ToStringBuilderAppender.booleanArray(value).append(this);
        return this;
    }

    /**
     * Adds a byte note it will be in hex-decimal form if {@link ToStringBuilderOption#HEX_BYTES} is
     * enabled.
     */
    public ToStringBuilder value(final byte value) {
        ToStringBuilderAppender.byteValue(value).append(this);
        return this;
    }

    /**
     * Adds a byte array respecting any set {@link ToStringBuilderOption options}
     */
    public ToStringBuilder value(final byte[] value) {
        ToStringBuilderAppender.byteArray(value).append(this);
        return this;
    }

    /**
     * Adds a character.
     */
    public ToStringBuilder value(final char value) {
        ToStringBuilderAppender.charValue(value).append(this);
        return this;
    }

    /**
     * Adds a char array.
     */
    public ToStringBuilder value(final char[] value) {
        ToStringBuilderAppender.charArray(value).append(this);
        return this;
    }

    /**
     * Adds a double value
     */
    public ToStringBuilder value(final double value) {
        ToStringBuilderAppender.doubleValue(value).append(this);
        return this;
    }

    /**
     * Adds a double array.
     */
    public ToStringBuilder value(final double[] value) {
        ToStringBuilderAppender.doubleArray(value).append(this);
        return this;
    }

    /**
     * Adds a float value
     */
    public ToStringBuilder value(final float value) {
        ToStringBuilderAppender.floatValue(value).append(this);
        return this;
    }

    /**
     * Adds a float array.
     */
    public ToStringBuilder value(final float[] value) {
        ToStringBuilderAppender.floatArray(value).append(this);
        return this;
    }

    /**
     * Adds an int value.
     */
    public ToStringBuilder value(final int value) {
        ToStringBuilderAppender.intValue(value).append(this);
        return this;
    }

    /**
     * Adds a int array.
     */
    public ToStringBuilder value(final int[] value) {
        ToStringBuilderAppender.intArray(value).append(this);
        return this;
    }

    /**
     * Adds a long value
     */
    public ToStringBuilder value(final long value) {
        ToStringBuilderAppender.longValue(value).append(this);
        return this;
    }

    /**
     * Adds a long array.
     */
    public ToStringBuilder value(final long[] value) {
        ToStringBuilderAppender.longArray(value).append(this);
        return this;
    }

    /**
     * Adds the given {@link CharSequence} which may involve escaping and quoting if those {@link
     * ToStringBuilderOption options} are enabled.
     */
    public ToStringBuilder value(final CharSequence value) {
        ToStringBuilderAppender.charSequence(value).append(this);
        return this;
    }

    /**
     * Adds a new value.
     */
    public ToStringBuilder value(final Object value) {
        ToStringBuilderAppender.object(value).append(this);
        return this;
    }

    /**
     * Adds a short value skipping 0 values if {@link ToStringBuilderOption#SKIP_IF_DEFAULT_VALUE}
     * is true.
     */
    public ToStringBuilder value(final short value) {
        ToStringBuilderAppender.shortValue(value).append(this);
        return this;
    }

    /**
     * Adds a short array with a special test
     */
    public ToStringBuilder value(final short[] value) {
        ToStringBuilderAppender.shortArray(value).append(this);
        return this;
    }

    /**
     * Adds a {@link UsesToStringBuilder}.
     */
    public ToStringBuilder value(final UsesToStringBuilder value) {
        ToStringBuilderAppender.usesToStringBuilder(value).append(this);
        return this;
    }

    /**
     * Must be called after processing a single value, resets some internal state.
     */
    ToStringBuilder valueFinished() {
        this.label = null;
        this.before = null;
        this.after = null;

        return this;
    }

    // append...........................................................................................................

    /**
     * Adds a {@link boolean}. Note any orphaned label is cleared.
     */
    public ToStringBuilder append(final boolean value) {
        return this.appendFinish(value);
    }

    /**
     * Adds a {@link byte} of is ignoring {@link ToStringBuilderOption#HEX_BYTES}. Note any orphaned
     * label is cleared.
     */
    public ToStringBuilder append(final byte value) {
        return this.appendFinish(value);
    }

    /**
     * Adds a {@link char}. Note any orphaned label is cleared.
     */
    public ToStringBuilder append(final char value) {
        return this.appendFinish(value);
    }

    /**
     * Adds a {@link double}. Note any orphaned label is cleared.
     */
    public ToStringBuilder append(final double value) {
        return this.appendFinish(value);
    }

    /**
     * Adds a {@link float}. Note any orphaned label is cleared.
     */
    public ToStringBuilder append(final float value) {
        return this.appendFinish(value);
    }

    /**
     * Adds a {@link int}. Note any orphaned label is cleared.
     */
    public ToStringBuilder append(final int value) {
        return this.appendFinish(value);
    }

    /**
     * Adds a {@link long}. Note any orphaned label is cleared.
     */
    public ToStringBuilder append(final long value) {
        return this.appendFinish(value);
    }

    /**
     * Adds a {@link short}. Note any orphaned label is cleared.
     */
    public ToStringBuilder append(final short value) {
        return this.appendFinish(value);
    }

    /**
     * Adds a {@link Object} calling {@link Object#toString()} and accepting null.
     */
    public ToStringBuilder append(final Object object) {
        return this.appendFinish(object);
    }

    // append helpers...................................................................................................

    /**
     * Appends the chars, escaping and quoting if they are enabled. This should only be executed by a {@link ToStringBuilderAppender}.
     */
    void appendCharSequence(final CharSequence chars, final char quote) {
        CharSequence append = chars;

        if (this.option(ToStringBuilderOption.ESCAPE)) {
            append = CharSequences.escape(chars);
        }
        if (this.option(ToStringBuilderOption.QUOTE)) {
            append = "" + quote + append + quote;
        }

        this.buffer.append(append);
        this.mode = ToStringBuilderMode.VALUE;
    }

    /**
     * Adds a label and separators of required and if necessary. Note if the buffer is full true is
     * returned and the label removed.
     */
    boolean appendLabel(final String label) {
        final StringBuilder buffer = this.buffer;
        final int length = buffer.length();

        this.mode.beforeLabel(this);

        if (null != label) {
            buffer.append(label);
            // only add $labelSeparator if label isnt empty
            if (!label.isEmpty()) {
                buffer.append(this.labelSeparator);
                this.mode = ToStringBuilderMode.LABEL_SEPARATOR;
            }
            this.label = null;
        }

        // if the buffer has become full remove label, separators etc and return true.
        final boolean full = false;
        if (buffer.length() >= this.globalLength) {
            buffer.setLength(length);
        }

        return full;
    }

    void appendUsesToStringBuilder(final UsesToStringBuilder uses) {
        final String separator = this.separator;
        final String labelSeparator = this.labelSeparator;
        final String valueSeparator = this.valueSeparator;
        final String before = this.before;
        final String after = this.after;
        final EnumSet<ToStringBuilderOption> options = this.options;
        this.options = EnumSet.copyOf(options);

        final int globalLength = this.globalLength;
        final int maxGlobalLength = this.maxGlobalLength;

        final int valueLength = this.valueLength;
        final int maxValueLength = this.maxValueLength;

        final int callerBufferLengthSnapshot = this.buffer.length();
        this.callerBufferLengthSnapshot = callerBufferLengthSnapshot;

        // share
        this.maxValueLength = valueLength;

        final int max = callerBufferLengthSnapshot + valueLength;
        this.maxGlobalLength = max;
        this.globalLength = max;

        final int bufferLengthBefore = this.buffer.length();

        try {
            uses.buildToString(this);
        } finally {

            // restore after finishing/failing
            this.separator = separator;
            this.labelSeparator = labelSeparator;
            this.valueSeparator = valueSeparator;
            this.before = before;
            this.after = after;

            this.globalLength = globalLength;
            this.maxGlobalLength = maxGlobalLength;

            this.valueLength = valueLength;
            this.maxValueLength = maxValueLength;

            this.callerBufferLengthSnapshot = callerBufferLengthSnapshot;

            this.options = options;

            this.trimBufferIfNecessary(bufferLengthBefore);

            this.mode = ToStringBuilderMode.VALUE;
        }
    }

    public ToStringBuilder appendSeparator() {
        this.buffer.append(this.separator);
        this.mode = ToStringBuilderMode.NONE;
        return this;
    }

    public ToStringBuilder appendValueSeparator() {
        this.buffer.append(this.valueSeparator);
        this.mode = ToStringBuilderMode.NONE;
        return this;
    }

    /**
     * Appends the value, honours the global length.
     */
    private ToStringBuilder appendFinish(final Object object) {
        final StringBuilder buffer = this.buffer;
        final int before = buffer.length();
        final int globalLength = this.globalLength;
        final int left = globalLength - before;

        if (left > 0) {
            final String string = String.valueOf(object);
            final int copy = Math.min(string.length(), left);
            if (copy > 0) {
                buffer.append(string, 0, copy);
                this.mode = ToStringBuilderMode.APPEND;
            }
        }

        this.valueFinished();
        return this;
    }

    /**
     * Trims or chops any excess chars added to the {@link StringBuilder buffer} if it has spilled
     * over the limits of {@link #globalLength} or {@link #valueLength}.
     */
    void trimBufferIfNecessary(final int beforeLength) {
        final StringBuilder buffer = this.buffer;
        int length = buffer.length();

        // value
        final int valueLength = this.valueLength;
        if ((length - beforeLength) > valueLength) {
            length = beforeLength + valueLength;
            buffer.setLength(length);
        }

        // global
        final int globalLength = this.globalLength;
        if ((length - globalLength) > 0) {
            buffer.setLength(globalLength);
        }
    }

    /**
     * Returns the built {@link String}.
     */
    @Override
    public String build() {
        return this.buffer.toString();
    }


    /**
     * Tests if the {@link StringBuilder} is full returning the maximum number of characters left. A
     * value less than or equal to 0 indicates its full.
     */
    int bufferLeft() {
        return this.globalLength - this.buffer.length();
    }

    /**
     * Accumulates the to string result of it is built.
     */
    final StringBuilder buffer;

    /**
     * Used to keep track of which separator could / should be added.
     */
    ToStringBuilderMode mode;

    // Object...........................................................................................................

    /**
     * Dump the any set options followed by the {@link StringBuilder buffer}.
     */
    @Override
    public String toString() {
        final StringBuilder toString = new StringBuilder();
        toString.append(this.options);
        toString.setLength(toString.length() - 1); // remove the closing ]

        toString.append(", labelSeparator=");
        toString.append(CharSequences.quoteAndEscape(this.labelSeparator));

        toString.append(", valueSeparator=");
        toString.append(CharSequences.quoteAndEscape(this.valueSeparator));

        toString.append(", separator=");
        toString.append(CharSequences.quoteAndEscape(this.separator));

        final StringBuilder buffer = this.buffer;
        if (this.bufferLeft() >= 0) {
            toString.append(", valueLength=");
            toString.append(this.valueLength);

            toString.append(", globalLength=");
            toString.append(this.globalLength);
        } else {
            toString.append(", FULL");
        }
        toString.append("] ");
        toString.append(buffer.length());
        toString.append("=");
        toString.append(CharSequences.quoteAndEscape(buffer));
        return toString.toString();
    }

    /**
     * Returns the appropriate encoder to handle numeric values.
     */
    ToStringBuilderOption numberEncoder() {
        final Set<ToStringBuilderOption> options = this.options;
        return options.contains(ToStringBuilderOption.HEX_BYTES) ?
                ToStringBuilderOption.HEX_BYTES :
                options.contains(ToStringBuilderOption.HEX_WHOLE_NUMBERS) ?
                        ToStringBuilderOption.HEX_WHOLE_NUMBERS :
                        ToStringBuilderOption.DEFAULT;
    }
}
