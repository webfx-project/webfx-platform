/*
 * Copyright 2019 Miroslav Pokorny (github.com/mP1)
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

package walkingkooka.text;

import java.util.Objects;

/**
 * Represents the line and column of a position within text.
 */
public final class LineAndColumn {

    public final static int LINE_NUMBER_START = 1;
    public final static int COLUMN_START = 1;

    /**
     * Builds a {@link LineAndColumn} from the given chars for the provided position.
     */
    public static LineAndColumn determine(final CharSequence chars, final int pos) {
        Objects.requireNonNull(chars, "chars");
        final int length = chars.length();
        if (pos < 0 || pos > length) {
            throw new StringIndexOutOfBoundsException("pos " + pos + " must be between 0 and " + length);
        }

        int lineNumber = LINE_NUMBER_START;
        char previous = 0;
        int startOfLine = 0;

        int last = pos + 1;
        if (last > length) {
            last = length;
        }

        for (int i = 0; i < last; i++) {
            final char c = chars.charAt(i);
            if (('\r' == c) || ('\n' == c)) {
                if ((c == previous) || (('\r' == c) && ('\n' == previous))) {
                    startOfLine = i;
                    lineNumber++;
                }
                previous = c;
                continue;
            }
            if (('\n' == previous) || ('\r' == previous)) {
                startOfLine = i;
                lineNumber++;
            }
            previous = c;
        }

        CharSequence line;
        int column = COLUMN_START;

        // find end of line...
        int end = length;
        for (int j = startOfLine; j < length; j++) {
            final char c = chars.charAt(j);
            if (('\r' == c) || ('\n' == c)) {
                end = j;
                break;
            }
            if (j < pos) {
                column++;
            }
        }
        line = chars.subSequence(startOfLine, end);
        final int lineLength = line.length();
        if (lineLength > 0) {
            column = column <= lineLength ?
                    column :
                    lineLength + 1;
        }

        return new LineAndColumn(lineNumber, column, line);
    }

    public static LineAndColumn with(int lineNumber, int columnNumber, final CharSequence line) {
        check(lineNumber, "lineNumber");
        check(columnNumber, "columnNumber");
        Objects.requireNonNull(line, "line");

        return new LineAndColumn(lineNumber, columnNumber, line);
    }

    private static void check(final int value, final String label) {
        if (value < 1) {
            throw new IllegalArgumentException(label + "=" + value + " must be >= 1");
        }
    }

    private LineAndColumn(int lineNumber, int columnNumber, final CharSequence line) {
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
        this.line = line;
    }

    private final int lineNumber;

    public int lineNumber() {
        return this.lineNumber;
    }

    private final int columnNumber;

    public int columnNumber() {
        return columnNumber;
    }

    private final CharSequence line;

    public CharSequence line() {
        return this.line;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.lineNumber(), this.columnNumber(), this.line());
    }

    @Override
    public boolean equals(final Object other) {
        return this == other || other instanceof LineAndColumn && equals0((LineAndColumn) other);
    }

    private boolean equals0(final LineAndColumn other) {
        return this.lineNumber() == other.lineNumber() &&
                this.columnNumber() == other.columnNumber() &&
                this.line().equals(other.line());
    }

    @Override
    public String toString() {
        return "line: " + this.lineNumber() + ", col: " + this.columnNumber() + ", " + CharSequences.quoteAndEscape(this.line());
    }
}
