

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

final class GlobPatternComponentSentinel extends GlobPatternComponent{

    static final GlobPatternComponentSentinel INSTANCE = new GlobPatternComponentSentinel();

    private GlobPatternComponentSentinel() {
        super();
    }

    @Override
    boolean isOnlyTextLiteral() {
        return true;
    }

    // search...........................................................................................................

    @Override
    int searchMinLength() {
        return 0;
    }

    // test.............................................................................................................

    @Override
    boolean test(final CharSequence text,
                 final int textPos,
                 final GlobPatternContext context) {
        return context.requireAllText ?
                textPos == text.length() : // since this is the last pattern component a match is true if the text is also consumed.
                        true;
    }

    // Object..........................................................................................................

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(final Object other) {
        return other == this;
    }

    @Override
    public String toString() {
        return "";
    }
}
