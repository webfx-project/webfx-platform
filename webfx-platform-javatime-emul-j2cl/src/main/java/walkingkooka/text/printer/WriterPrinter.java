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

import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

/**
 * A Printer that directs all prints  to the provided Writer. Any {@link IOException} that may. be thrown is wrapped
 * and rethrown within a {@link IllegalStateException}. The wrapped {@link Writer} is never automatically flushed, calls to
 * {@link Printer#flush} are required.
 */
final class WriterPrinter implements Printer {

    /**
     * Creates a new {@link WriterPrinter}
     */
    static WriterPrinter adapt(final Writer writer, final LineEnding lineEnding) {
        Objects.requireNonNull(writer, "writer");
        Objects.requireNonNull(lineEnding, "lineEnding");

        return new WriterPrinter(writer, lineEnding);
    }

    private WriterPrinter(final Writer writer, final LineEnding lineEnding) {
        super();
        this.writer = writer;
        this.lineEnding = lineEnding;
    }

    @Override
    public void print(final CharSequence chars) {
        Objects.requireNonNull(chars, "chars");

        try {
            this.writer.write(chars.toString());
        } catch (final IOException cause) {
            throw new IllegalStateException("Print failed", cause);
        }
    }

    /**
     * Returns the {@link LineEnding} passed to the factory.
     */
    @Override
    public LineEnding lineEnding() {
        return this.lineEnding;
    }

    private final LineEnding lineEnding;

    @Override
    public void flush() {
        try {
            this.writer.flush();
        } catch (final IOException cause) {
            throw new IllegalStateException("Flush failed", cause);
        }
    }

    @Override
    public void close() {
        try {
            this.writer.close();
        } catch (final IOException cause) {
            throw new IllegalStateException("Close failed", cause);
        }
    }

    // properties

    /**
     * The wrapped {@link Writer}
     */
    final Writer writer;

    @Override
    public String toString() {
        return this.writer.toString();
    }
}
