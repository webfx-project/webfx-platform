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
 * A {@link Printer} that replaces any HTML entities with their raw form before passing any printed
 * {@link CharSequence} to a wrapped {@link Printer}.
 */
final class HtmlEntityDecodingPrinter implements Printer, CharSequence {

    /**
     * Creates a new {@link HtmlEntityDecodingPrinter}.
     */
    static HtmlEntityDecodingPrinter wrap(final Function<String, String> entityDecoder,
                                          final Printer printer) {
        Objects.requireNonNull(entityDecoder, "htmlEntityDecoder");
        Objects.requireNonNull(printer, "printer");

        return new HtmlEntityDecodingPrinter(entityDecoder, printer);
    }

    /**
     * private constructor.
     */
    private HtmlEntityDecodingPrinter(final Function<String, String> entityDecoder,
                                      final Printer printer) {
        this.entityDecoder = entityDecoder;
        this.printer = printer;
    }

    // Printer

    @Override
    public void print(final CharSequence chars) {
        Objects.requireNonNull(chars, "chars");

        int i = 0;
        final int length = chars.length();
        int j = 0;
        final char[] buffer = this.buffer;
        final Printer printer = this.printer;

        int last = this.last;
        while (i < length) {
            if (last > 0) {
                while (i < length) {
                    final char c = chars.charAt(i);
                    i++;
                    buffer[last] = c;
                    if (last == buffer.length) {
                        break;
                    }
                    last++;
                    if (';' == c) {
                        this.addDecodedCharacter(buffer, last, printer);
                        last = 0;
                        j = i;
                        break;
                    }
                }
            }
            while (i < length) {
                if ('&' == chars.charAt(i)) {
                    printer.print(chars.subSequence(j, i));

                    i++;
                    buffer[0] = '&';
                    last = 1;
                    break;
                }
                i++;
            }
        }
        this.last = last;
        if ((last == 0) & (j < length)) {
            printer.print(chars.subSequence(j, length));
        }
    }

    private void addDecodedCharacter(final char[] buffer, final int last, final Printer printer) {
        boolean written = false;

        Loop:
        //
        do {
            if (last == 2) {
                printer.print("&;");
                written = true;
                break;
            }
            if (buffer[1] == '#') {
                if (last > 3) {
                    int radix = 10;
                    int start = 2;
                    final char c = buffer[2];
                    if ((c == 'X') || (c == 'x')) {
                        radix = 16;
                        start = 3;
                    }

                    // hand rolled conversion avoids needing to catch costly NumberFormatException if parsing fails.
                    int value = 0;
                    final int end = last - 1;
                    while (start < end) {
                        final char d = buffer[start];
                        start++;
                        final int digit = Character.digit(d, radix);
                        if (-1 == digit) {
                            break Loop;
                        }
                        value = (value * radix) + digit;
                    }

                    printer.print(Character.toString((char) value));
                    written = true;
                }
                break;
            }
            // decode
            printer.print(this.entityDecoder.apply(new String(buffer, 0, last)));
            written = true;
        } while (false);

        if (false == written) {
            this.last = last;
            printer.print(this);
        }
        this.last = 0;
    }

    /**
     * Returns the wrapped {@link Printer#lineEnding()}.
     */
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

    // CharSequence

    @Override
    public char charAt(final int index) {
        final int length = this.last;
        if ((index < 0) || (index > length)) {
            throw new StringIndexOutOfBoundsException(index + " not between 0 and " + length);
        }
        return this.buffer[index];
    }

    @Override
    public int length() {
        return this.last;
    }

    @Override
    public CharSequence subSequence(final int start, final int end) {
        throw new UnsupportedOperationException();
    }

    // properties

    /**
     * A {@link Function <String>} that maps entities to plain characters.
     */
    private final Function<String, String> entityDecoder;

    /**
     * The wrapped {@link Printer}.
     */
    private final Printer printer;

    /**
     * When non zero indicates a named entity has been buffered in {@link #buffer}. Package private
     * for testing purposes.
     */
    int last = 0;

    /**
     * The buffered HTML entity.
     */
    private final char[] buffer = new char[32];

    /**
     * Creates a {@link String} from the filled buffer.
     */
    String buffer() {
        return new String(this.buffer, 0, this.last);
    }

    @Override
    public String toString() {
        return this.printer + " AND " + this.entityDecoder;
    }
}
