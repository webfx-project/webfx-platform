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

/**
 * Represents a position of a {@link TextCursor} with methods to mark or save and then restore.
 */
final class CharSequenceTextCursorSavePoint implements TextCursorSavePoint {

    /**
     * Creates a new TextCursorSavePoint.
     */
    static CharSequenceTextCursorSavePoint with(final CharSequenceTextCursor cursor) {
        return new CharSequenceTextCursorSavePoint(cursor);
    }

    /**
     * Private constructor
     */
    private CharSequenceTextCursorSavePoint(final CharSequenceTextCursor cursor) {
        super();
        this.cursor = cursor;
        this.position = cursor.position;
    }

    @Override
    public void restore() {
        this.cursor.position = this.position;
    }

    @Override
    public void save() {
        this.position = this.cursor.position;
    }

    @Override
    public CharSequence textBetween() {
        final CharSequenceTextCursor cursor = this.cursor;
        final int cursorPosition = cursor.position;
        final CharSequence text = cursor.text;
        final int position = this.position;

        return cursorPosition < position ? text.subSequence(cursorPosition, position)
                : text.subSequence(position, cursorPosition);
    }

    @Override
    public TextCursorLineInfo lineInfo() {
        return CharSequenceTextCursorLineInfo.with(this.cursor.text, this.position);
    }

    // properties

    private final CharSequenceTextCursor cursor;

    private int position;

    @Override
    public String toString() {
        return this.cursor.toString("save ", this.position);
    }
}