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

/**
 * The {@link LineEnding} equivalent to {@link CaseSensitivity}.
 */
public enum LineEndingSensitivity {
    /**
     * Equivalent to doing a straight equals of both {@link CharSequence}.
     */
    EXACT {
        @Override
        public boolean equals(final CharSequence left, final CharSequence right) {
            return CharSequences.equals(left, right);
        }
    },

    /**
     * Text between both {@link LineEnding} must be equal.
     */
    ANY {
        @Override
        public boolean equals(final CharSequence left, final CharSequence right) {
            return CharSequences.equals(
                    normalize(left),
                    normalize(right)
            );
        }

        private String normalize(final CharSequence chars) {
            return null == chars ?
                    null :
                    chars.toString()
                            .replace(LineEnding.CRNL, LineEnding.NL)
                            .replace(LineEnding.CR, LineEnding.NL);

        }
    };

    /**
     * Tests if both {@link CharSequence} are equal.
     */
    public abstract boolean equals(final CharSequence left, final CharSequence right);
}
