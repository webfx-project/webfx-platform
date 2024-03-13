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

package walkingkooka.text;

import java.util.Objects;

final class GlobPatternComponentWildcard extends GlobPatternComponent{

    static GlobPatternComponentWildcard with(final int min,
                                             final int max) {
        return new GlobPatternComponentWildcard(
                min,
                max
        );
    }

    private GlobPatternComponentWildcard(final int min,
                                         final int max) {
        super();
        this.min = min;
        this.max = max;
    }

    @Override
    boolean isOnlyTextLiteral() {
        return false;
    }

    // search...........................................................................................................

    @Override
    int searchMinLength() {
        if (-1 == this.searchMinLength) {
            this.searchMinLength = this.min + this.next.searchMinLength();
        }
        return this.searchMinLength;
    }

    private int searchMinLength = -1;

    // test............................................................................................................

    @Override
    boolean test(final CharSequence text,
                 final int textPos,
                 final GlobPatternContext context) {
        final int start = textPos + this.min;
        final int textLength = text.length();

        boolean match = false;

        if(start <= textLength) {

            final int max = this.max;
            final int end = STAR_MAX == max ? textLength : textPos + max;
            final GlobPatternComponent next = this.next;

            int i = end;

            while (i >= start) {
                match = next.test(text, i, context);
                if (match) {
                    break;
                }
                i--;
            }
        }

        return match;
    }

    private final int min;

    private final int max;

    // Object..........................................................................................................

    @Override
    public int hashCode() {
        return Objects.hash(this.min, this.max);
    }

    @Override
    public boolean equals(final Object other) {
        return other == this || other instanceof GlobPatternComponentWildcard && this.equals0((GlobPatternComponentWildcard)other);
    }

    private boolean equals0(final GlobPatternComponentWildcard other) {
        return  Objects.equals(this.next, other.next) && this.min == other.min && this.max == other.max;
    }

    @Override
    public String toString() {
        final int max = this.max;

        return this.min + (max == STAR_MAX ? "*" : ".." + max);
    }
}
