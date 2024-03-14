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

import walkingkooka.text.CharSequences;
import walkingkooka.text.LineEnding;

import java.util.Objects;

/**
 * A {@link PrintedLineHandler} that breaks up any long lines each with a trailing continuation
 * character.
 */
final class ContinuationCharacterInsertingPrintedLineHandler implements PrintedLineHandler {

    /**
     * Creates a new {@link ContinuationCharacterInsertingPrintedLineHandler}. Note continuation may
     * not be a carriage return or new line.
     */
    static ContinuationCharacterInsertingPrintedLineHandler with(final int width,
                                                                 final char continuation) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width " + width + " must be greater than 0");
        }

        if (('\r' == continuation) || ('\n' == continuation)) {
            throw new IllegalArgumentException(ContinuationCharacterInsertingPrintedLineHandler.mustNotBeEndOfLineCharacter(
                    continuation));
        }
        return new ContinuationCharacterInsertingPrintedLineHandler(width, continuation);
    }

    /**
     * Thrown whenever attempting to create with a carriage return or new line.
     */
    static String mustNotBeEndOfLineCharacter(final char c) {
        return "Continuation character must not be carriage return or new line ="
                + CharSequences.quoteAndEscape(c);
    }

    /**
     * Private constructor use static factory.
     */
    private ContinuationCharacterInsertingPrintedLineHandler(final int width,
                                                             final char continuation) {
        super();
        this.width = width;
        this.continuation = String.valueOf(continuation);
    }

    @Override
    public void linePrinted(final CharSequence line, final LineEnding lineEnding,
                            final Printer printer) {
        Objects.requireNonNull(line, "line");
        Objects.requireNonNull(lineEnding, "lineEnding");
        Objects.requireNonNull(printer, "printer");

        final int width = this.width;
        final String continuation = this.continuation;
        final int widthLessOne = width - 1;
        CharSequence left = line;

        for (; ; ) {
            final int length = left.length();
            if (length <= width) {
                printer.print(left);
                printer.print(lineEnding);
                break;
            }

            printer.print(left.subSequence(0, widthLessOne));
            printer.print(continuation);
            printer.print(lineEnding);

            left = left.subSequence(widthLessOne, left.length());
        }
    }

    // properties

    /**
     * The thresh hold that defines long lines that need to be broken up.
     */
    private final int width;

    /**
     * The line continuation character that is inserted for really long lines.
     */
    private final String continuation;

    /**
     * Dumps the line width and continuation character.
     */
    @Override
    public String toString() {
        return "lines > " + this.width + " continue w/ '" + this.continuation + "'";
    }
}
