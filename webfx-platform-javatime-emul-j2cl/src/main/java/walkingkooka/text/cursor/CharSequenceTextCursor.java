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

import java.util.Objects;

/**
 * A {@link TextCursor} that moves around a {@link String} in a linear fashion. No filtering or skipping occurs.
 */
final class CharSequenceTextCursor implements TextCursor {

    /**
     * Creates a new {@link CharSequenceTextCursor} that can travel over the entire {@link String}.
     */
    static CharSequenceTextCursor with(final CharSequence text) {
        Objects.requireNonNull(text, "text");

        return new CharSequenceTextCursor(text);
    }

    /**
     * private constructor use static factory
     */
    private CharSequenceTextCursor(final CharSequence text) {
        super();

        this.text = text;
        this.position = 0;
    }

    /**
     * Retrieves the character at the current location
     */
    @Override
    public char at() throws TextCursorException {
        final int position = this.position;
        final int to = this.text.length();

        if (position < 0 || position >= to) {
            throw new TextCursorException(CharSequenceTextCursor.cursorIsEmpty(position, to));
        }
        return this.text.charAt(position);
    }

    /**
     * Message that is thrown whenever a cursor has been exhausted and an attempt is made to retrieve the current character with {@link #at()}.
     */
    private static String cursorIsEmpty(final int position, final int to) {
        return "Cursor is empty, position=" + position + " is NOT between 0 ... " + to;
    }

    /**
     * Tests if another character follows
     */
    @Override
    public boolean isEmpty() throws TextCursorException {
        return this.position >= this.text.length();
    }

    @Override
    public TextCursor next() throws TextCursorException {
        final int position = this.position + 1;
        if (position > this.text.length()) {
            throw new TextCursorException("Can not move past end");
        }
        this.position = position;
        return this;
    }

    @Override
    public TextCursor end() throws TextCursorException {
        this.position = this.text.length();
        return this;
    }

    /**
     * {@see CharSequenceTextCursorSavePoint}.
     */
    @Override
    public TextCursorSavePoint save() {
        return CharSequenceTextCursorSavePoint.with(this);
    }

    /**
     * {@see CharSequenceTextCursorLineInfo}.
     */
    @Override
    public TextCursorLineInfo lineInfo() {
        return CharSequenceTextCursorLineInfo.with(this.text, this.position);
    }

    /**
     * The entire {@link String} being moved about.
     */
    final CharSequence text;

    /**
     * The current position of this {@link TextCursor}
     */
    int position;

    /**
     * Returns a nice {@link Object#toString} highlighting the cursor and surrounding characters.
     */
    @Override
    public String toString() {
        return this.toString("", this.position);
    }

    /**
     * Package private so {@link CharSequenceTextCursorSavePoint#toString()} can call.
     */
    String toString(final String label, final int position) {
        final StringBuilder toString = new StringBuilder();

        toString.append(label);
        toString.append("at ");
        toString.append(position);

        final CharSequence text = this.text;
        final int length = text.length();

        toString.append(" \"");
        toString.append(
                CharSequences.escape(text.subSequence(Math.max(0, position - 7), Math.min(position, length))));

        if (position < length) {
            toString.append("[");
            toString.append(CharSequences.escape(Character.toString(text.charAt(position))));
            toString.append("]");

            if (position < (length - 1)) {
                final CharSequence after = this.text.subSequence(position + 1, Math.min(position + 8, length));
                toString.append(CharSequences.escape(after));
            }
            toString.append('"');
        } else {
            toString.append('"');
            toString.append("[]");
        }

        return toString.toString();
    }
}
