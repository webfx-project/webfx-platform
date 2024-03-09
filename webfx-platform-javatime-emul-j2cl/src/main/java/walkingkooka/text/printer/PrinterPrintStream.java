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

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Locale;

final class PrinterPrintStream extends PrintStream {

    private final static OutputStream OUTPUT_STREAM = new OutputStream() {
        @Override
        public void write(final int b) {
            throw new UnsupportedOperationException();
        }
    };

    static PrinterPrintStream with(final Printer printer) {
        return new PrinterPrintStream(printer);
    }

    private PrinterPrintStream(final Printer printer) {
        super(OUTPUT_STREAM);
        this.printer = printer;
    }

    // print..........................................................................................................

    @Override
    public void print(final boolean x) {
        this.print(String.valueOf(x));
    }

    @Override
    public void print(final char x) {
        this.print(String.valueOf(x));
    }

    @Override
    public void print(final int x) {
        this.print(String.valueOf(x));
    }

    @Override
    public void print(final long x) {
        this.print(String.valueOf(x));
    }

    @Override
    public void print(final float x) {
        this.print(String.valueOf(x));
    }

    @Override
    public void print(final double x) {
        this.print(String.valueOf(x));
    }

    @Override
    public void print(final char[] x) {
        this.print(String.valueOf(x));
    }

    @Override
    public void print(final String string) {
        this.printer.print(string);
    }

    @Override
    public void print(final Object x) {
        this.print(String.valueOf(x));
    }

    // println..........................................................................................................
    
    @Override
    public void println() {
        this.printer.println();
    }

    @Override
    public void println(final boolean x) {
        this.println(String.valueOf(x));
    }

    @Override
    public void println(final char x) {
        this.println(String.valueOf(x));
    }

    @Override
    public void println(final int x) {
        this.println(String.valueOf(x));
    }

    @Override
    public void println(final long x) {
        this.println(String.valueOf(x));
    }

    @Override
    public void println(final float x) {
        this.println(String.valueOf(x));
    }

    @Override
    public void println(final double x) {
        this.println(String.valueOf(x));
    }

    @Override
    public void println(final char[] x) {
        this.println(String.valueOf(x));
    }

    @Override
    public void println(final String string) {
        this.printer.println(string);
    }

    @Override
    public void println(final Object x) {
        this.println(String.valueOf(x));
    }

    @Override
    public PrintStream printf(final String format,
                              final Object... values) {
        throw new UnsupportedOperationException();
    }

    @Override
    public PrintStream printf(final Locale l,
                              final String format,
                              final Object... values) {
        throw new UnsupportedOperationException();
    }

    // format...........................................................................................................

    @Override
    public PrintStream format(final String format,
                              final Object... values) {
        throw new UnsupportedOperationException();
    }

    @Override
    public PrintStream format(final Locale l,
                              final String format,
                              final Object... values) {
        throw new UnsupportedOperationException();
    }

    // write............................................................................................................

    @Override
    public void write(final byte[] buf,
                      final int off,
                      final int len) {
        throw new UnsupportedOperationException();
    }

    // flush/close......................................................................................................

    @Override
    public void flush() {
        this.printer.flush();
    }

    @Override
    public void close() {
        this.printer.close();
    }

    private final Printer printer;

    @Override
    public String toString() {
        return this.printer.toString();
    }
}
