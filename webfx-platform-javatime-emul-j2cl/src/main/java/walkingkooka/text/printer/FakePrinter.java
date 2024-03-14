/*
 * Copyright 2022 Miroslav Pokorny (github.com/mP1)
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

package walkingkooka.text.printer;

import walkingkooka.test.Fake;
import walkingkooka.text.LineEnding;

/**
 * A {@link Printer} that always throws {@link UnsupportedOperationException}.
 */
public class FakePrinter implements Printer, Fake {

    static FakePrinter create() {
        return new FakePrinter();
    }

    /**
     * Protected for sub classing.
     */
    protected FakePrinter() {
        super();
    }

    @Override
    public void print(final CharSequence value) {
        throw new UnsupportedOperationException(value.toString());
    }

    @Override
    public LineEnding lineEnding() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void flush() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException();
    }
}
