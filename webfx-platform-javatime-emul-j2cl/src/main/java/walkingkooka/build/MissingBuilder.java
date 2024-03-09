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

package walkingkooka.build;

import walkingkooka.text.Whitespace;

import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

/**
 * A {@link Builder} that may be used to accumulate all the missing properties or values charSequence
 * something being built, less the boilerplate.
 */
final public class MissingBuilder implements Builder<String> {

    /**
     * Creates a new empty {@link MissingBuilder}
     */
    public static MissingBuilder empty() {
        return new MissingBuilder();
    }

    /**
     * Private constructor use factory.
     */
    private MissingBuilder() {
        super();
        this.missing = 0;
        this.message = new StringBuilder();
    }

    /**
     * Records an error if the value is empty
     */
    public MissingBuilder addIfEmpty(final Optional<?> value, final String label) {
        Objects.requireNonNull(value, "value");

        return this.addIfFalse(
                value.isPresent(),
                label
        );
    }

    /**
     * Records an error if the value is empty
     */
    public MissingBuilder addIfEmpty(final OptionalDouble value, final String label) {
        Objects.requireNonNull(value, "value");

        return this.addIfFalse(
                value.isPresent(),
                label
        );
    }
    
    /**
     * Records an error if the value is empty
     */
    public MissingBuilder addIfEmpty(final OptionalInt value, final String label) {
        Objects.requireNonNull(value, "value");

        return this.addIfFalse(
                value.isPresent(),
                label
        );
    }

    /**
     * Records an error if the value is empty
     */
    public MissingBuilder addIfEmpty(final OptionalLong value, final String label) {
        Objects.requireNonNull(value, "value");

        return this.addIfFalse(
                value.isPresent(),
                label
        );
    }

    /**
     * Records an error if the value is zero
     */
    public MissingBuilder addIfZero(final long value, final String label) {
        this.checkLabelAndBumpTotalCounter(label);

        if (0 == value) {
            this.updateMessage(label);
        }
        return this;
    }

    /**
     * Records an error if the value is null.
     */
    public MissingBuilder addIfNull(final Object value, final String label) {
        this.checkLabelAndBumpTotalCounter(label);

        if (null == value) {
            this.updateMessage(label);
        }
        return this;
    }

    /**
     * Records an error if the test is false.
     */
    public MissingBuilder addIfFalse(final boolean test, final String label) {
        this.checkLabelAndBumpTotalCounter(label);

        if (false == test) {
            this.updateMessage(label);
        }
        return this;
    }

    /**
     * Records an error.
     */
    public MissingBuilder add(final String label) {
        this.checkLabelAndBumpTotalCounter(label);
        this.updateMessage(label);
        return this;
    }

    /**
     * Checks the label and bumps the total counter.
     */
    private void checkLabelAndBumpTotalCounter(final String label) {
        Builder.checkLabel(label);
        this.totals++;
    }

    /**
     * Updates the message and missing counter.
     */
    private void updateMessage(final String label) {
        final StringBuilder message = this.message;
        if (message.length() > 0) {
            message.append(", ");
        }
        message.append(label);
        this.missing++;
    }

    /**
     * Accumulates the message of the missing properties/values.
     */
    private final StringBuilder message;

    /**
     * Returns the current number of missing properties or values.
     */
    public int missing() {
        return this.missing;
    }

    /**
     * Counts the number of errors.
     */
    private int missing;

    /**
     * Returns the current number of missing properties or values.
     */
    public int total() {
        return this.totals;
    }

    /**
     * Counts the number of totals.
     */
    private int totals;

    /**
     * Returns the comma separated list of missing items which will be empty if none are present.
     */
    @Override
    public String build() throws BuilderException {
        return this.message.toString();
    }

    /**
     * Throws a {@link BuilderException} if any missing properties are recorded.
     */
    public void failIfMissing(final String before) throws BuilderException {
        Whitespace.failIfNullOrEmptyOrWhitespace(before, "before");

        if (this.missing > 0) {
            final StringBuilder message = new StringBuilder();
            message.append(before);
            if (false == before.endsWith(" ")) {
                message.append(' ');
            }
            message.append(this.build());

            throw new BuilderException(message.toString());
        }
    }

    /**
     * Dumps the counter and message so far.
     */
    @Override
    public String toString() {
        final int counter = this.missing;
        return 0 == counter ? "<None>" : counter + " " + this.message.toString();
    }
}
