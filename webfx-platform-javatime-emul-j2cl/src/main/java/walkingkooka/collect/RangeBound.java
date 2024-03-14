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

import walkingkooka.Value;

import java.util.Objects;
import java.util.Optional;

/**
 * One of three bounds of a {@link Range}
 */
abstract public class RangeBound<C extends Comparable<C>> implements Value<Optional<C>> {

    /**
     * {@see RangeBoundAll}
     */
    public static <C extends Comparable<C>> RangeBoundAll<C> all() {
        return RangeBoundAll.instance();
    }

    /**
     * {@see RangeBoundExclusive}
     */
    public static <C extends Comparable<C>> RangeBoundExclusive<C> exclusive(final C value) {
        checkValue(value);

        return RangeBoundExclusive.with(value);
    }

    /**
     * {@see RangeBoundInclusive}
     */
    public static <C extends Comparable<C>> RangeBoundInclusive<C> inclusive(final C value) {
        checkValue(value);

        return RangeBoundInclusive.with(value);
    }

    /**
     * Checks that a value parameter is not null.
     */
    static <C> void checkValue(final C value) {
        Objects.requireNonNull(value, "value");
    }

    /**
     * Package private to limit sub classing.
     */
    RangeBound() {
        super();
    }

    /**
     * Only bounds without a value return true.
     */
    public final boolean isAll() {
        return this instanceof RangeBoundAll;
    }

    /**
     * Only bounds with an exclusive value return true.
     */
    public final boolean isExclusive() {
        return this instanceof RangeBoundExclusive;
    }

    /**
     * Only bounds with an inclusive value return true.
     */
    public final boolean isInclusive() {
        return this instanceof RangeBoundInclusive;
    }

    /**
     * Inclusive and exclusive will also include a value.
     */
    @Override
    public abstract Optional<C> value();

    // Range.predicate...........................................

    /**
     * Tests if the value.
     */
    abstract boolean lowerTest(final C value);

    /**
     * Tests if the value.
     */
    abstract boolean upperTest(final C value);

    // Range.isOverlapping equals...........................................

    abstract boolean lessThanOrEqual(final RangeBound<C> other);

    /**
     * wildcard is always never less than or equal to anything else.
     */
    final boolean lessThanOrEqual0(final RangeBoundAll<C> other) {
        return false;
    }

    abstract boolean lessThanOrEqual0(final RangeBoundExclusive<C> other);

    abstract boolean lessThanOrEqual0(final RangeBoundInclusive<C> other);

    // Range.and...........................................

    abstract RangeBound<C> min(final RangeBound<C> other);

    final RangeBound<C> min0(final RangeBoundAll<C> other) {
        return this;
    }

    abstract RangeBound<C> min0(final RangeBoundExclusive<C> other);

    abstract RangeBound<C> min0(final RangeBoundInclusive<C> other);

    abstract RangeBound<C> max(final RangeBound<C> other);

    final RangeBound<C> max0(final RangeBoundAll<C> other) {
        return this;
    }

    abstract RangeBound<C> max0(final RangeBoundExclusive<C> other);

    abstract RangeBound<C> max0(final RangeBoundInclusive<C> other);

    // RangeVisitor.............................................................................................

    abstract void traverseLowerBound(final RangeVisitor<C> visitor);

    abstract void traverseUpperBound(final RangeVisitor<C> visitor);

    // toString.........................................................................................................

    final static String BETWEEN = "..";

    final static String INCLUSIVE_OPEN = "(";
    final static char INCLUSIVE_CLOSE = ')';

    final static String EXCLUSIVE_OPEN = "[";
    final static char EXCLUSIVE_CLOSE = ']';

    abstract String rangeToString(final Range<C> range);

    abstract String rangeToString0(final RangeBoundAll<C> lower);

    abstract String rangeToString0(final RangeBoundExclusive<C> lower);

    abstract String rangeToString0(final RangeBoundInclusive<C> lower);

    // Object................................

    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(final Object other);

    /**
     * Similar to {@link #equals(Object)} except the value is compared using {{@link Comparable#compareTo(Object)}} rather
     * than equals.
     */
    abstract boolean compareToEquals(final RangeBound<?> other);
}
