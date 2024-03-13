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

import walkingkooka.Context;

/**
 * Captures two important properties of a search/test, the {@link CaseSensitivity} and whether the search/test is greedy.
 */
final class GlobPatternContext implements Context {

    static GlobPatternContext search(final CaseSensitivity caseSensitivity) {
        return new GlobPatternContext(
                caseSensitivity,
                false
        );
    }

    static GlobPatternContext test(final CaseSensitivity caseSensitivity) {
        return new GlobPatternContext(
                caseSensitivity,
                true
        );
    }

    private GlobPatternContext(final CaseSensitivity caseSensitivity,
                               final boolean requireAllText) {
        super();
        this.caseSensitivity = caseSensitivity;
        this.requireAllText = requireAllText;
    }

    final CaseSensitivity caseSensitivity;

    /**
     * Will be true when GlobPattern#test and false when GlobPattern#search
     */
    final boolean requireAllText;

    @Override
    public String toString() {
        return this.caseSensitivity + (this.requireAllText ? " match all": "");
    }
}
