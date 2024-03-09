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

import walkingkooka.text.CharSequences;
import walkingkooka.text.LineAndColumn;

/**
 * A snapshot in time about the position of the {@link TextCursor}. Note that the actual line number, column and line text are extracted lazily.
 */
final class CharSequenceTextCursorLineInfo implements TextCursorLineInfo {

    /**
     * Creates a {@link CharSequenceTextCursorLineInfo} by locating the line containing the given absolute position within a String.
     */
    static CharSequenceTextCursorLineInfo with(final CharSequence text, final int pos) {
        return new CharSequenceTextCursorLineInfo(text, pos);
    }

    /**
     * Private constructor
     */
    private CharSequenceTextCursorLineInfo(final CharSequence text, final int pos) {
        this.text = text;
        this.pos = pos;
    }

    /**
     * The entire text belonging to the {@link TextCursor}.
     */
    final CharSequence text;
    /**
     * A snapshot of the current position of the {@link TextCursor}.
     */
    final int pos;

    /**
     * The entire line of text that the {@link TextCursor} is currently on.
     */
    @Override
    public CharSequence text() {
        return this.lineAndColumn().line();
    }

    /**
     * Returns the line number of the cursor. Note that line numbering begins at 1.
     */
    @Override
    public int lineNumber() {
        return this.lineAndColumn().lineNumber();
    }

    @Override
    public int column() {
        return this.lineAndColumn().columnNumber();
    }

    /**
     * Builds a string with with the column and line number separated by a comma and surrounded by parenthesis.
     */
    @Override
    public String summary() {
        final LineAndColumn info = this.lineAndColumn();
        return CharSequenceTextCursorLineInfo.summary(info.columnNumber(), info.lineNumber());
    }

    /**
     * Static helper used to create the at column and line number text.
     */
    private static String summary(final int column, final int lineNumber) {
        return '(' + String.valueOf(column) + ',' + lineNumber + ')';
    }

    @Override
    public int textOffset() {
        return this.pos;
    }

    // Object

    @Override
    public String toString() {
        final LineAndColumn info = this.lineAndColumn();
        return CharSequenceTextCursorLineInfo.toString(info.lineNumber(), info.line());
    }

    /**
     * The {@link LineAndColumn}
     */
    LineAndColumn lineAndColumn;

    /**
     * Includes a check that lazily calculates the column, linenumber, and line text.
     */
    private LineAndColumn lineAndColumn() {
        if (null == this.lineAndColumn) {
            final CharSequence text = this.text;
            this.lineAndColumn = LineAndColumn.determine(text, Math.min(this.pos, text.length()));
        }
        return this.lineAndColumn;
    }

    /**
     * Helper that builds the toString representation for this object.
     */
    private static String toString(final int lineNumber, final CharSequence line) {
        return "Line: " + lineNumber + '=' + CharSequences.quoteAndEscape(line);
    }
}
