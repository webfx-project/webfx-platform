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
 * A {@link Printer} that buffers lines of text as they are written. Each complete line is then passed to the given
 * {@link PrintedLineHandler}.
 */
final class PrintedLineHandlerPrinter implements Printer {

    /**
     * Creates a new {@link PrintedLineHandlerPrinter} unconditionally.
     */
    static PrintedLineHandlerPrinter wrap(final Printer printer, final PrintedLineHandler handler) {
        Objects.requireNonNull(printer, "printer");
        Objects.requireNonNull(handler, "handler");

        return new PrintedLineHandlerPrinter(printer, handler);
    }

    /**
     * Private constructor use static factory.
     */
    private PrintedLineHandlerPrinter(final Printer printer, final PrintedLineHandler handler) {
        super();
        this.printer = printer;
        this.handler = handler;
    }

    @Override
    public void print(final CharSequence chars) {
        Objects.requireNonNull(chars, "chars");

        // only attempt to process if not an empty line
        if (chars.length() > 0) {
            // attempt to find an end of line with the buffer
            final StringBuilder buffer = this.buffer;
            if (null != buffer) {
                this.printToBuffer(chars, buffer);
            } else {
                this.printPartOfBuffer(chars, 0);
            }
        }
    }

    /**
     * Fills the {@link StringBuilder buffer} until a new line is encountered. The new line will be
     * handled by {@link #printPartOfBuffer(CharSequence, int)}.
     */
    private void printToBuffer(final CharSequence chars, final StringBuilder buffer)
            {
        final Printer printer = this.printer;
        final int length = chars.length();
        final PrintedLineHandler handler = this.handler;

        // variables
        int i = 0;

        for (; ; ) {
            // buffer may a line ending with CR
            final int lastIndex = buffer.length() - 1;
            final char last = buffer.charAt(lastIndex);
            if ('\r' == last) {
                this.buffer = null;

                // line ends with CRNL
                final char maybeNl = chars.charAt(0);
                if ('\n' == maybeNl) {
                    handler.linePrinted(buffer.subSequence(0, lastIndex), LineEnding.CRNL, printer);
                    this.printPartOfBuffer(chars, 1); // continue after the NL
                    break;
                }

                // line ends with only CR print everything before
                handler.linePrinted(buffer.subSequence(0, lastIndex), LineEnding.CR, printer);
                this.printPartOfBuffer(chars, 0);
                break;
            }

            // after checking if line ends with CR
            for (; ; ) {
                if (length == i) {
                    break;
                }

                // process next character
                final char c = chars.charAt(i);
                i++;

                // line ends with CR
                if ('\r' == c) {
                    // might be CR followed by NL

                    // line ends with \r buffer and continue later...
                    if (length == i) {
                        buffer.append(c);
                        break;
                    }

                    // lines ends with CRNL
                    final char maybeNl = chars.charAt(i);
                    if ('\n' == maybeNl) {
                        this.buffer = null;

                        handler.linePrinted(buffer, LineEnding.CRNL, printer);
                        this.printPartOfBuffer(chars, 1 + i);
                        break;
                    }

                    // line ends with only CR
                    handler.linePrinted(buffer, LineEnding.CR, printer);
                    this.buffer = null;
                    i--; // process maybeNl again
                    this.printPartOfBuffer(chars, i);
                    break;
                }

                // line ends with NL
                if ('\n' == c) {
                    handler.linePrinted(buffer, LineEnding.NL, printer);
                    this.buffer = null;

                    this.printPartOfBuffer(chars, i);
                    break;
                }

                buffer.append(c);
            }
            break;
        }
    }

    /**
     * Processes the {@link CharSequence} directly without a buffer. If an incomplete line is
     * encountered at the end a {@link StringBuilder buffer} will be created and set with the
     * unprinted characters.
     */
    private void printPartOfBuffer(final CharSequence chars, int start) {
        final Printer printer = this.printer;
        final int length = chars.length();
        final PrintedLineHandler handler = this.handler;

        // variables
        int i = start;

        for (; ; ) {
            // add any unprinted characters to the buffer
            if (length == i) {
                if (start < length) {
                    final StringBuilder buffer = new StringBuilder();
                    buffer.append(chars, start, length);
                    this.buffer = buffer;
                }
                break;
            }

            // process next character
            final char c = chars.charAt(i);
            i++;

            // line ends with CR
            if ('\r' == c) {
                // might be CR followed by NL

                // line ends with \r buffer and continue later...
                if (length == i) {
                    final StringBuilder buffer = new StringBuilder();
                    buffer.append(chars, start, length);
                    this.buffer = buffer;
                    break;
                }

                final char maybeNl = chars.charAt(i);
                if ('\n' == maybeNl) {
                    handler.linePrinted(chars.subSequence(start, i - 1), LineEnding.CRNL, printer);
                    i++; // skip NL
                    start = i;
                    continue;
                }

                // line ends with only CR
                handler.linePrinted(chars.subSequence(start, i - 1), LineEnding.CR, printer);
                start = i; // process maybeNl again
                continue;
            }

            // line ends with NL
            if ('\n' == c) {
                handler.linePrinted(chars.subSequence(start, i - 1), LineEnding.NL, printer);
                start = i;
                continue;
            }
        }
    }

    /**
     * Returns the wrapped {@link Printer#lineEnding()}.
     */
    @Override
    public LineEnding lineEnding() {
        return this.printer.lineEnding();
    }

    /**
     * Does nothing, flushing of the last line is performed when this printer is closed.
     */
    @Override
    public void flush() {
        final Printer printer = this.printer;

        final StringBuilder buffer = this.buffer;
        if (null != buffer) {
            // special case CR which may be in buffer expecting NL
            final int size = buffer.length();
            LineEnding lineEnding = LineEnding.NONE;
            if ('\r' == buffer.charAt(size - 1)) {
                buffer.setLength(size - 1);
                lineEnding = LineEnding.CR;
            }
            this.handler.linePrinted(buffer, lineEnding, printer);
            printer.flush();
            this.buffer = null;
        }
    }

    /**
     * Closes the wrapped printer after flushing the last pending line.
     */
    @Override
    public void close() {
        this.printer.close();
    }

    // properties

    /**
     * The wrapped {@link Printer}.
     */
    private final Printer printer;

    /**
     * The {@link PrintedLineHandler long line handler}.
     */
    private final PrintedLineHandler handler;

    /**
     * The buffer contains uncommitted characters. The buffer is only processed whenever a complete
     * line (terminated by a {@link LineEnding} ) is encountered. <br> Package private for testing.
     */
    StringBuilder buffer;

    /**
     * Dumps the {@link PrintedLineHandler handler} followed by the wrapped {@link Printer}.
     */
    @Override
    public String toString() {
        return this.handler + " " + this.printer;
    }
}
