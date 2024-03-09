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

import walkingkooka.test.Fake;

/**
 * A {@link TextCursor} where all methods throw {@link UnsupportedOperationException}.
 */
public class FakeTextCursor implements TextCursor, Fake {

    static FakeTextCursor create() {
        return new FakeTextCursor();
    }

    protected FakeTextCursor() {
        super();
    }

    @Override
    public char at() throws TextCursorException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() throws TextCursorException {
        throw new UnsupportedOperationException();
    }

    @Override
    public TextCursorLineInfo lineInfo() {
        throw new UnsupportedOperationException();
    }

    @Override
    public TextCursor next() throws TextCursorException {
        throw new UnsupportedOperationException();
    }

    @Override
    public TextCursor end() throws TextCursorException {
        throw new UnsupportedOperationException();
    }

    @Override
    public TextCursorSavePoint save() {
        throw new UnsupportedOperationException();
    }
}
