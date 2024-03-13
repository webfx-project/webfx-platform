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

package walkingkooka.text.cursor;

import java.util.Objects;

/**
 * A {@link TextCursor} that tracks the further position advanced.
 * <pre>
 *  if(false == token.isPresent() || false == textCursor.isEmpty()) {
 *    throw new InvalidCharacterException(
 *            text,
 *            textCursor.max()
 *    );
 * }
 * </pre>
 */
public final class MaxPositionTextCursor implements TextCursor {

    static MaxPositionTextCursor with(final TextCursor cursor) {
        Objects.requireNonNull(cursor, "cursor");

        return new MaxPositionTextCursor(cursor);
    }

    private MaxPositionTextCursor(final TextCursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public boolean isEmpty() throws TextCursorException {
        return this.cursor.isEmpty();
    }

    @Override
    public char at() throws TextCursorException {
        return this.cursor.at();
    }

    @Override
    public TextCursor next() throws TextCursorException {
        final TextCursor next = this.cursor.next();
        this.max = Math.max(next.lineInfo().textOffset(), this.max);
        return next;
    }

    @Override
    public TextCursorSavePoint save() {
        return this.cursor.save();
    }

    @Override
    public TextCursorLineInfo lineInfo() {
        return this.cursor.lineInfo();
    }

    private TextCursor cursor;

    /**
     * Returns the highest position that the cursor advanced. This may be used to throw an accurate {@link walkingkooka.InvalidCharacterException}.
     */
    public int max() {
        return this.max;
    }

    private int max;

    // Object..........................................................................................................

    @Override
    public String toString() {
        return this.cursor.toString();
    }
}
