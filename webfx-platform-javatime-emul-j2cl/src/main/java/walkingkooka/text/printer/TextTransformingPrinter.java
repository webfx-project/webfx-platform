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
import java.util.function.Function;

/**
 * A {@link Printer} that passes text to a wrapped {@link Printer} that has been transformed by a {@link java.util.function.Function}.
 */
final class TextTransformingPrinter implements Printer {

    /**
     * Creates a new {@link TextTransformingPrinter}.
     */
    static TextTransformingPrinter with(final Function<CharSequence, CharSequence> transformer,
                                        final Printer printer) {
        Objects.requireNonNull(transformer, "transformer");
        Objects.requireNonNull(printer, "printer");

        return new TextTransformingPrinter(transformer, printer);
    }

    /**
     * Private constructor use static factory.
     */
    private TextTransformingPrinter(final Function<CharSequence, CharSequence> transformer,
                                    final Printer printer) {
        super();
        this.transformer = transformer;
        this.printer = printer;
    }

    @Override
    public void print(final CharSequence chars) {
        this.printer.print(this.transformer.apply(chars));
    }

    final Function<CharSequence, CharSequence> transformer;

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
        this.printer.close();
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
