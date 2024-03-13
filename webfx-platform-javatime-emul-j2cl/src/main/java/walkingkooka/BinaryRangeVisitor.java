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

import walkingkooka.collect.Range;
import walkingkooka.collect.RangeBound;
import walkingkooka.collect.RangeVisitor;

import java.util.Objects;

/**
 * A {@link RangeVisitor} that contains the main logic for extracting a {@link Binary} given a {@link Range}.
 */
final class BinaryRangeVisitor extends RangeVisitor<Long> {

    // Binary.extractRange
    static Binary extract(final Binary binary, final Range<Long> range) {
        Objects.requireNonNull(range, "range");

        final BinaryRangeVisitor visitor = new BinaryRangeVisitor(range);
        visitor.binary = binary;
        visitor.accept(range);
        return visitor.binary;
    }

    // @Testing
    BinaryRangeVisitor(final Range<Long> range) {
        super();
        this.range = range;
        this.lower = 0;
        this.upper = 0;
    }

    @Override
    protected void all() {
        // this.binary is the answer
    }

    @Override
    protected void singleton(final Long value) {
        final int integer = value.intValue();

        this.binary = this.binary.extract0(integer, integer + 1, this.range);
    }

    @Override
    protected void lowerBoundAll() {
        // already set to 0
    }

    @Override
    protected void lowerBoundExclusive(final Long value) {
        this.lower = value.intValue() + 1;
    }

    @Override
    protected void lowerBoundInclusive(final Long value) {
        this.lower = value.intValue();
    }

    /**
     * Tries to create the new {@link Binary} give the known lower & upper bounds.
     */
    @Override
    protected void endBetween(final RangeBound<Long> lowerBound,
                              final RangeBound<Long> upperBound) {
        this.binary = this.binary.extract0(this.lower, this.upper, this.range);
    }

    @Override
    protected void upperBoundAll() {
        this.upper = this.binary.size();
    }

    @Override
    protected void upperBoundExclusive(final Long value) {
        this.upper = value.intValue();
    }

    @Override
    protected void upperBoundInclusive(final Long value) {
        this.upper = value.intValue() + 1;
    }

    private Binary binary;
    private final Range<Long> range;
    private int lower;
    private int upper;

    @Override
    public String toString() {
        return this.range.toString();
    }
}
