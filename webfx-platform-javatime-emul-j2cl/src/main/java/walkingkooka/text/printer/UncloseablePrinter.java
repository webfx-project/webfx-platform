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

import walkingkooka.text.LineEnding;

import java.util.Objects;

/**
 * A {@link Printer} that forwards all methods to another {@link Printer} but ignores any {@link
 * #close()}
 */
final class UncloseablePrinter implements Printer {

    /**
     * Creates a new {@link UncloseablePrinter} or returns the {@link Printer} if it is already a
     * {@link UncloseablePrinter}
     */
    static UncloseablePrinter wrap(final Printer printer) {
        Objects.requireNonNull(printer, "printer");

        // do not double wrap.
        return printer instanceof UncloseablePrinter ?
                (UncloseablePrinter) printer :
                new UncloseablePrinter(printer);
    }

    /**
     * Private constructor use static factory.
     */
    private UncloseablePrinter(final Printer printer) {
        super();
        this.printer = printer;
    }

    @Override
    public void print(final CharSequence chars) {
        this.printer.print(chars);
    }

    @Override
    public LineEnding lineEnding() {
        return this.printer.lineEnding();
    }

    @Override
    public void flush() {
        this.printer.flush();
    }

    @Override
    public void close() {
        // ignore
    }

    /**
     * The wrapped {@link Printer}
     */
    private final Printer printer;

    /**
     * Dumps the wrapped {@link Printer}.
     */
    @Override
    public String toString() {
        return this.printer.toString();
    }
}
