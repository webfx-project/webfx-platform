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

import walkingkooka.text.Indentation;
import walkingkooka.text.LineEnding;

import java.util.Objects;

/**
 * Adds support for writing text that requires some line formatting functionality such of
 * indentation and starting a new line.
 */
final class BasicIndentingPrinter implements IndentingPrinter {

    private final static char NL = '\n';
    private final static char CR = '\r';
    private final static char START_OF_NEW_LINE = BasicIndentingPrinter.NL;

    /**
     * The {@link Printer} that is written too.
     */
    private final Printer printer;
    /**
     * This string is written to each and every new line.
     */
    private final Indentation indentation;

    /**
     * The indentation depth that increases with calls to {@link #indent} and decreases with calls to {@link #outdent()}.
     */
    private int indentationDepth;

    /**
     * Holds the last character to be added.
     */
    private char previous;

    static BasicIndentingPrinter with(final Printer printer,
                                      final Indentation indentation) {
        Objects.requireNonNull(printer, "printer");
        Objects.requireNonNull(indentation, "indentation");

        return new BasicIndentingPrinter(printer, indentation);
    }

    /**
     * Private constructor use static factory.
     */
    private BasicIndentingPrinter(final Printer printer,
                                  final Indentation indentation) {
        super();

        this.printer = printer;
        this.indentation =indentation;
        this.previous = START_OF_NEW_LINE;
    }

    @Override
    public void print(final CharSequence chars) {
        this.print0(null == chars ? "null" : chars);
    }

    /**
     * Assumes that chars is not null.
     */
    private void print0(final CharSequence chars) {
        final Printer printer = this.printer;
        final int end = chars.length();

        // vars
        char previous = this.previous;
        int start = 0;

        for (int i = 0; i < end; i++) {
            final char c = chars.charAt(i);

            if (BasicIndentingPrinter.NL == previous || ((previous == CR) && (NL != c))) {
                if (start != i) {
                    printer.print(chars.subSequence(start, i));
                }
                printer.print(
                        this.indentation.repeat(
                                this.indentationDepth
                        )
                );
                start = i;
            }

            previous = c;
        }
        this.previous = previous;

        if (start != end) {
            printer.print(chars.subSequence(start, end));
        }
    }

    @Override
    public void indent() {
        this.indentationDepth++; // dont care if overflows...
    }

    /**
     * Decreases indentation.
     */
    @Override
    public void outdent() {
        if (0 == this.indentationDepth) {
            throw new IllegalStateException("More outdents than indents");
        }
        this.indentationDepth--;
    }

    @Override
    public LineEnding lineEnding() {
        return this.printer.lineEnding();
    }

    /**
     * Conditionally inserts a EOL guaranteeing the next print will start on a new line.
     */
    @Override
    public void lineStart() {
        final char previous = this.previous;
        if ((BasicIndentingPrinter.CR != previous) && (BasicIndentingPrinter.NL != previous)) {
            final Printer printer = this.printer;
            printer.print(printer.lineEnding());
            this.previous = BasicIndentingPrinter.START_OF_NEW_LINE;
        }
    }

    @Override
    public Indentation indentation() {
        return this.indentation.repeat(this.indentationDepth);
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
     * Dumps something meaningful about this {@link IndentingPrinter}.
     */
    @Override
    public String toString() {
        return this.printer.toString();
    }
}
