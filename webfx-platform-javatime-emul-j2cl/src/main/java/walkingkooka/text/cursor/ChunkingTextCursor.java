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

import java.util.Iterator;
import java.util.Objects;

/**
 * A {@link TextCursor} that walks a buffer of text consuming new text when the buffer has been consumed.
 */
final class ChunkingTextCursor implements TextCursor {

    /**
     * Factory that creates a {@link TextCursor} using the provided {@link Iterator}
     */
    static ChunkingTextCursor with(final Iterator<String>  chunks) {
        Objects.requireNonNull(chunks, "chunks");

        return new ChunkingTextCursor(chunks);
    }

    /**
     * Private ctor use factory
     */
    private ChunkingTextCursor(final Iterator<String> chunks) {
        this.chunks = chunks;
        this.cursor = TextCursors.charSequence(this.text);
    }

    @Override
    public boolean isEmpty() throws TextCursorException {
        this.fillIfCursorEmpty();
        return this.cursor.isEmpty();
    }

    @Override
    public char at() throws TextCursorException {
        this.fillIfCursorEmpty();
        return this.cursor.at();
    }

    @Override
    public TextCursor next() throws TextCursorException {
        this.fillIfCursorEmpty();
        this.cursor.next();
        return this;
    }

    private void fillIfCursorEmpty() {
        if (this.cursor.isEmpty()) {
            if(this.chunks.hasNext()) {
                this.text.append(this.chunks.next());
            }
        }
    }

    @Override
    public TextCursorSavePoint save() {
        return cursor.save();
    }

    @Override
    public TextCursorLineInfo lineInfo() {
        return this.cursor.lineInfo();
    }

    /**
     * Provides the next chunk of {@link String text}.
     */
    private final Iterator<String> chunks;

    /**
     * Filled with text whenever the wrapped {@link #chunks} becomes empty.
     */
    private final StringBuilder text = new StringBuilder();

    /**
     * The wrapped {@link TextCursor} that provides individual characters, save points, line info etc.
     */
    private final TextCursor cursor;

    @Override
    public String toString() {
        return this.cursor.toString();
    }
}
