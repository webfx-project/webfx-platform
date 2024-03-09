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
import walkingkooka.text.Indentation;

/**
 * A {@link Printer} that includes additional functionality to support indentation.
 */
public interface IndentingPrinter extends Printer {

    /**
     * Starts a new line, multiple requests are ignored.
     */
    void lineStart();

    /**
     * Increases the indentation
     */
    void indent();

    /**
     * Removes a previous indentation.
     */
    void outdent();

    /**
     * Returns the current {@link Indentation} if a newline followed by text was printed.
     */
    Indentation indentation();

    /**
     * <pre>
     * First line
     *     Second
     *     Third
     *     Fourth lines
     *   last
     * </pre>
     */
    @GwtIncompatible
    static void main(final String[] args) {
        final IndentingPrinter printer = Printers.sysOut()
                .indenting(Indentation.SPACES2);
        printer.print("First line\n");
        printer.indent();
        {
            printer.indent();
            {
                printer.print("Second\nThird\nFourth lines\n");
            }
            printer.outdent();
            printer.print("last\n");
        }
        printer.outdent();
    }
}
