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
 * A {@link TextCursor} represents a cursor that may only move forwards to read characters.
 */
public interface TextCursor extends TextCursorLike {

    /**
     * Test if the cursor is empty at the current position. False means that the current character is available to be read by {@link #at()}.
     */
    boolean isEmpty() throws TextCursorException;

    /**
     * Retrieves the character at the current location
     */
    char at() throws TextCursorException;

    /**
     * Advances the cursor to the next character which may be read. Note it is possible to move past the last character.
     */
    TextCursor next() throws TextCursorException;

    /**
     * Moves the {@link TextCursor} to the end. Any future attempts to read a character or move will fail.
     */
    default TextCursor end() throws TextCursorException {
        while (false == this.isEmpty()) {
            this.next();
        }
        return this;
    }

    /**
     * Creates a {@link TextCursorSavePoint} for this {@link TextCursor}.
     */
    TextCursorSavePoint save();

    /**
     * Returns a {@link TextCursorLineInfo} for the current position of this {@link TextCursor}
     */
    TextCursorLineInfo lineInfo();
}