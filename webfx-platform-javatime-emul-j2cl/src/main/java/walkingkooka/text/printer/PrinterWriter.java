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

import java.io.Writer;

/**
 * Acts as an adapter supporting the return of a {@link java.io.PrintWriter} from {@link Printer#asPrintWriter()}.
 */
final class PrinterWriter extends Writer {

    static PrinterWriter with(final Printer printer) {
        return new PrinterWriter(printer);
    }

    private PrinterWriter(final Printer printer) {
        this.printer = printer;
    }

    @Override
    public void write(final char[] buffer,
                      final int offset,
                      final int length) {
        this.printer.print(
                new String(buffer, offset, length)
        );
    }

    @Override
    public void flush() {
        this.printer.flush();
    }

    @Override
    public void close() {
        this.printer.close();
    }

    /**
     * The printer that receives all writes.
     */
    private final Printer printer;

    @Override
    public String toString() {
        return this.printer.toString();
    }
}
