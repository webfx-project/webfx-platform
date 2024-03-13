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

abstract class GlobPatternComponent {

    final static int STAR_MAX = Integer.MAX_VALUE;

    final static GlobPatternComponent SENTINEL = GlobPatternComponentSentinel.INSTANCE;

    static GlobPatternComponent textLiteral(final String text) {
        return GlobPatternComponentTextLiteral.with(text);
    }

    static GlobPatternComponent wildcard(final int min,
                                         final int max) {
        return GlobPatternComponentWildcard.with(min, max);
    }

    GlobPatternComponent() {
    }

    abstract boolean isOnlyTextLiteral();

    GlobPatternComponent next;

    // search..........................................................................................................

    /**
     * Used to stop advancing the starting text position by searchStart.
     */
    abstract int searchMinLength();

    // test............................................................................................................

    abstract boolean test(final CharSequence text,
                          final int textPos,
                          final GlobPatternContext context);

    // Object..........................................................................................................

    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(final Object other);

    @Override
    public abstract String toString();
}
