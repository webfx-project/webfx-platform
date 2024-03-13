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

import walkingkooka.test.Fake;
import walkingkooka.visit.Visiting;

public class FakeRangeVisitor<C extends Comparable<C>> extends RangeVisitor<C> implements Fake {

    protected FakeRangeVisitor() {
        super();
    }

    @Override
    protected void all() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void singleton(final C value) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected Visiting startBetween(final RangeBound<C> lowerBound, final RangeBound<C> upperBound) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void endBetween(final RangeBound<C> lowerBound, final RangeBound<C> upperBound) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void lowerBoundAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void lowerBoundExclusive(final C value) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void lowerBoundInclusive(final C value) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void upperBoundAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void upperBoundExclusive(final C value) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void upperBoundInclusive(final C value) {
        throw new UnsupportedOperationException();
    }
}
