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

package walkingkooka.collect;


import walkingkooka.visit.Visiting;
import walkingkooka.visit.Visitor;

import java.util.Objects;

/**
 * A {@link Visitor} for a {@link Range}
 */
public abstract class RangeVisitor<C extends Comparable<C>> extends Visitor<Range<C>> {

    protected RangeVisitor() {
        super();
    }

    /**
     * Accepts a {@link Range} to be visited.
     */
    @Override
    public final void accept(final Range<C> range) {
        Objects.requireNonNull(range, "range");

        this.traverse(range);
    }

    final void traverse(final Range<C> range) {
        if (Visiting.CONTINUE == this.startVisit(range)) {
            for (; ; ) {
                final RangeBound<C> lower = range.lower;
                final RangeBound<C> upper = range.upper;

                if (lower.isAll() && upper.isAll()) {
                    this.all();
                    break;
                }

                if (lower.isInclusive() && lower.equals(upper)) {
                    //noinspection OptionalGetWithoutIsPresent
                    this.singleton(lower.value().get());
                    break;
                }

                if (Visiting.CONTINUE == this.startBetween(lower, upper)) {
                    lower.traverseLowerBound(this);
                    upper.traverseUpperBound(this);
                }
                this.endBetween(lower, upper);
                break;
            }
        }
        this.endVisit(range);
    }

    /**
     * Called with the initial range being visited.
     */
    protected Visiting startVisit(final Range<C> range) {
        return Visiting.CONTINUE;
    }

    protected void endVisit(final Range<C> range) {
        // nop
    }

    /**
     * Only called by {@link Range} that match all values.
     */
    protected void all() {
        // nop
    }

    /**
     * Only called by {@link Range} that match a single value.
     */
    protected void singleton(C value) {
        // nop
    }

    /**
     * Is visited by ranges that are not all or a single value, and prior to calling the individual components.
     */
    protected Visiting startBetween(final RangeBound<C> lowerBound,
                                    final RangeBound<C> upperBound) {
        return Visiting.CONTINUE;
    }

    protected void endBetween(final RangeBound<C> lowerBound,
                              final RangeBound<C> upperBound) {
        // nop
    }

    /**
     * Only called with ranges without a lower bound when {@link #startBetween(RangeBound, RangeBound)} returns {@link Visiting#CONTINUE}.
     */
    protected void lowerBoundAll() {
        // nop
    }

    /**
     * Only called with ranges with an exclusive lower bound when {@link #startBetween(RangeBound, RangeBound)} returns {@link Visiting#CONTINUE}.
     */
    protected void lowerBoundExclusive(final C value) {
        // nop
    }

    /**
     * Only called with ranges with an inclusive lower bound when {@link #startBetween(RangeBound, RangeBound)} returns {@link Visiting#CONTINUE}.
     */
    protected void lowerBoundInclusive(final C value) {
        // nop
    }

    /**
     * Only called with ranges without a upper bound when {@link #startBetween(RangeBound, RangeBound)} returns {@link Visiting#CONTINUE}.
     */
    protected void upperBoundAll() {
        // nop
    }

    /**
     * Only called with ranges with an exclusive upper bound when {@link #startBetween(RangeBound, RangeBound)} returns {@link Visiting#CONTINUE}.
     */
    protected void upperBoundExclusive(final C value) {
        // nop
    }

    /**
     * Only called with ranges with an inclusive upper bound when {@link #startBetween(RangeBound, RangeBound)} returns {@link Visiting#CONTINUE}.
     */
    protected void upperBoundInclusive(final C value) {
        // nop
    }
}
