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

import javaemul.internal.annotations.GwtIncompatible;
import walkingkooka.reflect.PublicStaticHelper;
import walkingkooka.text.LineEnding;

import java.io.PrintStream;
import java.io.Writer;
import java.util.function.Function;

final public class Printers implements PublicStaticHelper {

    /**
     * {@see HtmlEntityDecodingPrinter}.
     */
    public static Printer htmlEntityDecoder(final Function<String, String> entityDecoder,
                                            final Printer printer) {
        return HtmlEntityDecodingPrinter.wrap(entityDecoder, printer);
    }

    /**
     * {@see FakePrinter}.
     */
    public static Printer fake() {
        return FakePrinter.create();
    }

    /**
     * {@see PrintedLineHandlerPrinter}
     */
    public static Printer printedLine(final Printer printer, final PrintedLineHandler handler) {
        return PrintedLineHandlerPrinter.wrap(printer, handler);
    }

    /**
     * {@see PrintStreamPrinter}.
     */
    public static Printer printStream(final PrintStream printStream, final LineEnding lineEnding) {
        return PrintStreamPrinter.with(printStream, lineEnding);
    }

    /**
     * {@see SinkPrinter}.
     */
    public static Printer sink(final LineEnding lineEnding) {
        return SinkPrinter.with(lineEnding);
    }

    /**
     * {@see StringBuilderPrinter}.
     */
    public static Printer stringBuilder(final StringBuilder builder, final LineEnding lineEnding) {
        return StringBuilderPrinter.with(builder, lineEnding);
    }

    /**
     * {@see PrintStreamPrinter}.
     */
    public static Printer sysErr() {
        return PrintStreamPrinter.sysErr();
    }

    /**
     * {@see PrintStreamPrinter}
     */
    public static Printer sysOut() {
        return PrintStreamPrinter.sysOut();
    }

    /**
     * {@see TeePrinter}.
     */
    public static Printer tee(final Printer first, final Printer second) {
        return TeePrinter.wrap(first, second);
    }

    /**
     * {@see TextTransformingPrinter}
     */
    public static Printer textTransforming(final Function<CharSequence, CharSequence> transformer,
                                           final Printer printer) {
        return TextTransformingPrinter.with(transformer, printer);
    }

    /**
     * {@see UncloseablePrinter}
     */
    public static Printer uncloseable(final Printer printer) {
        return UncloseablePrinter.wrap(printer);
    }

    /**
     * {@see WriterPrinter}
     */
    @GwtIncompatible
    public static Printer writer(final Writer writer, final LineEnding lineEnding) {
        return WriterPrinter.adapt(writer, lineEnding);
    }

    /**
     * Stop creation
     */
    private Printers() {
        throw new UnsupportedOperationException();
    }
}
