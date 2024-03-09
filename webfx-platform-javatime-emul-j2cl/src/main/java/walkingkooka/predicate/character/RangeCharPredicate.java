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

package walkingkooka.predicate.character;

import walkingkooka.text.CharSequences;

/**
 * A {@link CharPredicate} that only matches a range of characters.
 */
final class RangeCharPredicate implements CharPredicate {

    /**
     * Factory that creates a char predicate that matches the given range of characters(both inclusive).
     */
    static CharPredicate with(final char start, final char end) {
        if (start > end) {
            throw new IllegalArgumentException("Start " + start + " less than end " + end);
        }
        return start == end ? CharPredicates.is(start) : new RangeCharPredicate(start, end);
    }

    /**
     * Private constructor
     */
    private RangeCharPredicate(final char start, final char end) {
        super();
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean test(final char c) {
        return c >= start && c <= end;
    }

    private final char start;
    private final char end;

    @Override
    public String toString() {
        return CharSequences.quoteAndEscape(start) + ".." + CharSequences.quoteAndEscape(end);
    }
}
