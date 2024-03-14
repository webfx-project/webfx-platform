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
 * A {@link TextCursorSavePoint} where all methods throw {@link UnsupportedOperationException}
 */
public class FakeTextCursorSavePoint implements TextCursorSavePoint, Fake {

    static FakeTextCursorSavePoint create() {
        return new FakeTextCursorSavePoint();
    }

    protected FakeTextCursorSavePoint() {
        super();
    }

    @Override
    public TextCursorLineInfo lineInfo() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void restore() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String textBetween() {
        throw new UnsupportedOperationException();
    }
}
