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

import walkingkooka.reflect.PublicStaticHelper;

/**
 * A collect of utilities related to ASCII.<br> Constants taken from <a>http://en.wikipedia.org/wiki/Control_character</a>
 */
final public class Ascii implements PublicStaticHelper {

    /**
     * 0 (null, NUL, \0, ^@), originally intended to be an ignored character, but now used by many
     * programming languages to mark the end of a string.
     */
    public final static char NUL = 0;

    /**
     * 7 (bell, BEL, \a, ^G), which may cause the device receiving it to emit a warning of some kind
     * (usually audible).
     */
    public final static char BELL = 7;

    /**
     * 8 (backspace, BS, \b, ^H), used either to erase the last character printed or to overprint
     * it.
     */
    public final static char BACKSPACE = 8;

    /**
     * 9 (horizontal tab, HT, \t, ^I), moves the printing position some spaces to the right.
     */
    public final static char TAB = 9;

    /**
     * 10 (line feed, LF, \n, ^J), used of the end of line marker in most UNIX systems and
     * variants.
     */
    public final static char LINE_FEED = 10;

    /**
     * 12 (form feed, FF, \f, ^L), to cause a printer to eject paper to the top of the next page, or
     * a video terminal to clear the screen.
     */
    public final static char FORM_FEED = 12;

    /**
     * 13 (carriage return, CR, \r, ^M), used of the end of line marker in Mac OS, OS-9, FLEX (and
     * variants). A carriage return/line feed pair is used by CP/M-80 and its derivatives including
     * DOS and Windows, and by Application Layer protocols such of HTTP.
     */
    public final static char CARRIAGE_RETURN = 13;

    /**
     * 27 (escape, ESC, \e [GCC only], ^[).
     */
    public final static char ESCAPE = 27;

    /**
     * 127 (delete, DEL, ^?), originally intended to be an ignored character, but now used in some
     * systems to erase a character. Also used by some Plan9 console programs to send an interrupt
     * note to the current process.
     */
    public final static char DELETE = 127;

    /**
     * Returns true if the given letter is an ASCII letter.
     */
    public static boolean isLetter(final char c) {
        return ((c >= 'A') && (c <= 'Z')) || ((c >= 'a') && (c <= 'z'));
    }

    /**
     * Returns true if the given character is an ASCII digit.
     */
    public static boolean isDigit(final char c) {
        return (c >= '0') && (c <= '9');
    }

    /**
     * Tests if the character is an ASCII character.
     */
    public static boolean is(final char c) {
        return c < 128;
    }

    /**
     * Tests if the character is a ASCII control character.
     */
    public static boolean isControl(final char c) {
        return (c < ' ') || (Ascii.DELETE == c);
    }

    /**
     * Tests if the character is a printable ASCII character.
     */
    public static boolean isPrintable(final char c) {
        return (c >= ' ') & (c < Ascii.DELETE);
    }

    /**
     * Stop creation
     */
    private Ascii() {
        throw new UnsupportedOperationException();
    }
}
