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

final class GlobPatternComponentTextLiteral extends GlobPatternComponent{

    static GlobPatternComponentTextLiteral with(final String text) {
        return new GlobPatternComponentTextLiteral(text);
    }

    private GlobPatternComponentTextLiteral(final String text) {
        super();
        this.text = text;
    }

    @Override
    boolean isOnlyTextLiteral() {
        return this.next.isOnlyTextLiteral();
    }

    // search...........................................................................................................

    @Override
    int searchMinLength() {
        if (-1 == this.searchMinLength) {
            this.searchMinLength = this.text.length() + this.next.searchMinLength();
        }

        return this.searchMinLength;
    }

    private int searchMinLength = -1;

    // test............................................................................................................

    @Override
    boolean test(final CharSequence text,
                 final int textPos,
                 final GlobPatternContext context) {
        final String required = this.text;

        return textPos < text.length() &&
                context.caseSensitivity.startsWith(
                        text,
                        required,
                        textPos
                ) &&
                this.next.test(
                        text,
                        textPos + required.length(),
                        context
                );
    }

    private final String text;

    // Object..........................................................................................................

    @Override
    public int hashCode() {
        return this.text.hashCode();
    }

    @Override
    public boolean equals(final Object other) {
        return other == this || other instanceof GlobPatternComponentTextLiteral && this.equals0((GlobPatternComponentTextLiteral)other);
    }

    private boolean equals0(final GlobPatternComponentTextLiteral other) {
        return Objects.equals(this.next, other.next) && this.text.equals(other.text);
    }

    @Override
    public String toString() {
        return this.text;
    }
}
