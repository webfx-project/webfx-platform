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

import java.io.PrintStream;
import java.util.Objects;

/**
 * A {@link Printer} that is an adaptor for a {@link PrintStream}.
 */
final class PrintStreamPrinter implements Printer {

    /**
     * Factory with special cases when the given {@link PrintStream} is {@link System#out} or {@link
     * System#err}.
     */
    static PrintStreamPrinter with(final PrintStream printStream, final LineEnding lineEnding) {
        Objects.requireNonNull(printStream, "printStream");
        Objects.requireNonNull(lineEnding, "lineEnding");

        PrintStreamPrinter printer;
        do {
            if (System.out == printStream) {
                printer = PrintStreamPrinter.sysOut();
                break;
            }
            if (System.err == printStream) {
                printer = PrintStreamPrinter.sysErr();
                break;
            }
            printer = new PrintStreamPrinter("", printStream, LineEnding.SYSTEM);
        } while (false);

        return printer;
    }

    /**
     * Lazily creates a {@link Printer} with {@link System#out}.
     */
    static PrintStreamPrinter sysOut() {
        if (null == PrintStreamPrinter.sysOut) {
            PrintStreamPrinter.sysOut = new PrintStreamPrinter("System.out ",
                    System.out,
                    LineEnding.SYSTEM);
        }
        return PrintStreamPrinter.sysOut;
    }

    private static PrintStreamPrinter sysOut;

    /**
     * Lazily creates a {@link Printer} with {@link System#err}.
     */
    static PrintStreamPrinter sysErr() {
        if (null == PrintStreamPrinter.sysErr) {
            PrintStreamPrinter.sysErr = new PrintStreamPrinter("System.err ",
                    System.err,
                    LineEnding.SYSTEM);
        }
        return PrintStreamPrinter.sysErr;
    }

    private static PrintStreamPrinter sysErr;

    /**
     * Private constructor
     */
    private PrintStreamPrinter(final String label,
                               final PrintStream printStream,
                               final LineEnding lineEnding) {
        super();

        this.label = label;
        this.printStream = printStream;
        this.lineEnding = lineEnding;
    }

    @Override
    public void print(final CharSequence chars) {
        this.printStream.print(chars);
    }

    @Override
    public LineEnding lineEnding() {
        return this.lineEnding;
    }

    private final LineEnding lineEnding;

    @Override
    public void flush() {
        this.printStream.flush();
    }

    /**
     * This method closes the wrapped {@link PrintStream}.
     */
    @Override
    public void close() {
        try {
            this.printStream.close();
            // j2cl emulated PrintStream#close throws IOException
        } catch (final RuntimeException cause) {
            throw cause;
        } catch (final Exception cause) {
            throw new IllegalStateException(cause.getMessage(), cause);
        }
    }

    // properties

    /**
     * The wrapped {@link PrintStream}.
     */
    private final PrintStream printStream;

    /**
     * A label that is used by {@link #toString()}
     */
    private final String label;

    @Override
    public String toString() {
        return this.label + this.printStream;
    }
}
