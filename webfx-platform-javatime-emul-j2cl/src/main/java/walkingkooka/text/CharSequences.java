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

import javaemul.internal.annotations.GwtIncompatible;
import walkingkooka.Cast;
import walkingkooka.InvalidCharacterException;
import walkingkooka.reflect.PublicStaticHelper;

import java.io.Reader;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

final public class CharSequences implements PublicStaticHelper {

    /**
     * Converts any nulls to empty string.
     */
    public static CharSequence nullToEmpty(final CharSequence chars) {
        return null == chars ?
                "" :
                chars;
    }

    /**
     * Reads a {@link CharSequence} that contains pairs of hex digits representing individual bytes
     * which are returned in a byte[].
     */
    public static byte[] bigEndianHexDigits(final CharSequence hexDigits) {
        Objects.requireNonNull(hexDigits, "hexDigits");

        final int length = hexDigits.length();
        final int halfLength = length / 2;
        if (length != (halfLength + halfLength)) {
            throw new IllegalArgumentException(oddNumberOfDigits(length));
        }

        final byte[] bytes = new byte[halfLength];

        int value = 0;
        boolean lo = true;
        int index = 0;

        for (int i = 0; i < length; i++) {
            final char c = hexDigits.charAt(i);
            final int digit = Character.digit(c, 16);
            if (digit < 0) {
                throw new InvalidCharacterException(hexDigits.toString(), i);
            }
            if (lo) {
                value = digit;
                lo = false;
                continue;
            }

            bytes[index] = (byte) ((value * 16) + digit);
            index++;
            lo = true;
        }
        return bytes;
    }

    private static String oddNumberOfDigits(final int length) {
        return "Expected even number of hex digits=" + length;
    }

    /**
     * Capitalises the first character of the given {@link CharSequence}
     */
    public static CharSequence capitalize(final CharSequence chars) {
        checkChars(chars);

        CharSequence result = chars;
        final int length = chars.length();
        if (length > 0) {
            result = new StringBuilder().append(Character.toUpperCase(chars.charAt(0)))
                    .append(chars, 1, length)
                    .toString();
        }
        return result;
    }

    /**
     * {@see ConcatCharSequence}
     */
    public static CharSequence concat(final CharSequence first,
                                      final CharSequence second) {
        return ConcatCharSequence.with(first, second);
    }

    /**
     * Returns a new {@link CharSequence} which is a copy of chars, but with the same case as
     * the caseSource. If the caseSource is shorter than chars, the extra characters in chars, will be copied
     * without change.<br>
     * This would be particularly useful for a search and replace functionality with preserveCase = true.
     */
    public static CharSequence copyCase(final CharSequence chars,
                                        final CharSequence caseSource) {
        checkChars(chars);
        Objects.requireNonNull(caseSource, "caseSource");

        final StringBuilder b = new StringBuilder();

        final int charsLength = chars.length();
        final int caseSourceLength = caseSource.length();

        final int count = Math.min(charsLength, caseSourceLength);
        for (int i = 0; i < count; i++) {
            char c = chars.charAt(i);
            if (Character.isLetter(c)) {
                final char d = caseSource.charAt(i);
                if (Character.isLetter(d)) {
                    final char lowerD = Character.toLowerCase(d);
                    if (d == lowerD) {
                        c = Character.toLowerCase(c);
                    }
                    final char upperD = Character.toUpperCase(d);
                    if (d == upperD) {
                        c = Character.toUpperCase(c);
                    }
                }
            }

            b.append(c);
        }

        if (caseSourceLength < charsLength) {
            b.append(chars, caseSourceLength, charsLength);
        }

        return b;
    }

    /**
     * {@see EmptyCharSequence}
     */
    public static CharSequence empty() {
        return EmptyCharSequence.INSTANCE;
    }

    /**
     * Tests if the first string ends with the second ignoring case. This is equivalent to
     * CharSequence.endsWith() but ignores case.
     */
    public static boolean endsWith(final CharSequence chars,
                                   final String endsWith) {
        checkChars(chars);
        failIfNullOrEmpty(endsWith, "endsWith");

        boolean result = false;

        final int stringLength = chars.length();
        final int endsWithLength = endsWith.length();
        if (endsWithLength <= stringLength) {
            result = true;

            for (int i = 0; i < endsWithLength; i++) {
                if (chars.charAt(stringLength - 1 - i) != endsWith.charAt(endsWithLength - 1 - i)) {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }

    /**
     * Escapes all newline, carriage returns and other common characters that are escaped in java by
     * a backslash prefix. Null inputs return null.
     */
    public static CharSequence escape(final CharSequence chars) {
        return null == chars ?
                null :
                escape0(chars);
    }

    private static CharSequence escape0(final CharSequence chars) {
        final int length = chars.length();
        final StringBuilder builder = new StringBuilder((length * 10) / 9);
        for (int i = 0; i < length; i++) {
            final char c = chars.charAt(i);

            switch (c) {
                case '\\':
                    builder.append("\\\\");
                    break;
                case '\t':
                    builder.append("\\t");
                    break;
                case '\r':
                    builder.append("\\r");
                    break;
                case '\n':
                    builder.append("\\n");
                    break;
                case '\0':
                    builder.append("\\0");
                    break;
                case '\'':
                    builder.append("\\'");
                    break;
                case '\"':
                    builder.append("\\\"");
                    break;
                case 1:
                    builder.append("\\u0001");
                    break;
                case 2:
                    builder.append("\\u0002");
                    break;
                case 3:
                    builder.append("\\u0003");
                    break;
                case 4:
                    builder.append("\\u0004");
                    break;
                case 5:
                    builder.append("\\u0005");
                    break;
                case 6:
                    builder.append("\\u0006");
                    break;
                case 7:
                    builder.append("\\u0007");
                    break;
                case 8:
                    builder.append("\\u0008");
                    break;
                case 11:
                    builder.append("\\u000B");
                    break;
                case 12:
                    builder.append("\\u000C");
                    break;
                case 14:
                    builder.append("\\u000E");
                    break;
                case 15:
                    builder.append("\\u000F");
                    break;
                case 16:
                    builder.append("\\u0010");
                    break;
                case 17:
                    builder.append("\\u0011");
                    break;
                case 18:
                    builder.append("\\u0012");
                    break;
                case 19:
                    builder.append("\\u0013");
                    break;
                case 20:
                    builder.append("\\u0014");
                    break;
                case 21:
                    builder.append("\\u0015");
                    break;
                case 22:
                    builder.append("\\u0016");
                    break;
                case 23:
                    builder.append("\\u0017");
                    break;
                case 24:
                    builder.append("\\u0018");
                    break;
                case 25:
                    builder.append("\\u0019");
                    break;
                case 26:
                    builder.append("\\u001A");
                    break;
                case 27:
                    builder.append("\\u001B");
                    break;
                case 28:
                    builder.append("\\u001C");
                    break;
                case 29:
                    builder.append("\\u001D");
                    break;
                case 30:
                    builder.append("\\u001E");
                    break;
                case 31:
                    builder.append("\\u001F");
                    break;
                default:
                    builder.append(c);
                    break;
            }
        }
        return builder.toString();
    }

    /**
     * Tests if two {@link CharSequences} are equal
     */
    public static boolean equals(final CharSequence chars,
                                 final CharSequence otherChars) {
        checkChars(chars);
        Objects.requireNonNull(otherChars, "otherChars");

        boolean equals = false;
        final int length = chars.length();
        final int otherLength = otherChars.length();

        // must first be the same length
        if (length == otherLength) {
            equals = true;

            // give up when a mis-match is encountered
            for (int i = 0; i < length; i++) {
                if (chars.charAt(i) != otherChars.charAt(i)) {
                    equals = false;
                    break;
                }
            }
        }

        return equals;
    }

    /**
     * Fails if the chars are null or empty.
     */
    public static <C extends CharSequence> C failIfNullOrEmpty(final C chars,
                                                               final String label) {
        failIfNullOrEmpty0(label, "label");
        failIfNullOrEmpty0(chars, label);
        return chars;
    }

    private static void failIfNullOrEmpty0(final CharSequence chars,
                                           final String label) {
        Objects.requireNonNull(chars, label);
        if (chars.length() == 0) {
            throw new IllegalArgumentException(label + " is empty");
        }
    }

    // hash.............................................................................................................

    /**
     * Computes the hashcode for the given {@link CharSequence} iterating over the characters producing a value
     * equal to {@link String#hashCode()} for the same characters.
     */
    public static int hash(final CharSequence chars) {
        return null == chars ?
                0 :
                hash0(chars);
    }

    private static int hash0(final CharSequence chars) {
        final int length = chars.length();

        int hash = 0;
        for (int i = 0; i < length; i++) {
            hash = 31 * hash + chars.charAt(i);
        }
        return hash;
    }

    // indexOf..........................................................................................................

    /**
     * Attempts to find the {@link CharSequence searchFor} within the {@link CharSequence}
     */
    public static int indexOf(final CharSequence chars,
                              final String indexOf) {
        checkChars(chars);
        failIfNullOrEmpty(indexOf, "indexOf");

        int index = -1;
        final int charLength = chars.length();
        final int searchForLength = indexOf.length();
        if ((charLength > 0) && (searchForLength > 0) && (searchForLength <= charLength)) {
            final char firstCharOfTest = indexOf.charAt(0);
            final int lastCharSequenceCharacterToCheck = (charLength - searchForLength) + 1;

            for (int i = 0; i < lastCharSequenceCharacterToCheck; i++) {
                if (firstCharOfTest == chars.charAt(i)) {
                    index = i;
                    for (int j = 1; j < searchForLength; j++) {
                        final char c = chars.charAt(i + j);
                        final char otherChar = indexOf.charAt(j);
                        if (c != otherChar) {
                            index = -1;
                            break;
                        }
                    }
                    if (-1 != index) {
                        break;
                    }
                }
            }
        }
        return index;
    }

    /**
     * Helper that returns true if the given {@link CharSequence} is null or empty.
     */
    public static boolean isNullOrEmpty(final CharSequence chars) {
        return (chars == null) || (chars.length() == 0);
    }

    /**
     * Returns a {@link CharSequence} that is of the requested length adding the pad character to fill remaining chars.
     */
    public static CharSequence padLeft(final CharSequence chars,
                                       final int length,
                                       final char pad) {
        checkChars(chars);

        final int charsLength = chars.length();
        if (length < charsLength) {
            throw new IllegalArgumentException("Length " + length + " < " + charsLength);
        }

        final int requiredPadding = length - chars.length();
        return requiredPadding == 0 ?
                chars :
                concat(repeating(pad, requiredPadding), chars);
    }

    /**
     * Returns a {@link CharSequence} that is of the requested length adding the pad character to fill remaining chars.
     */
    public static CharSequence padRight(final CharSequence chars,
                                        final int length,
                                        final char pad) {
        final int charsLength = chars.length();
        if (length < charsLength) {
            throw new IllegalArgumentException("Length " + length + " < " + charsLength);
        }

        final int requiredPadding = length - chars.length();
        return requiredPadding == 0 ?
                chars :
                concat(chars, repeating(pad, requiredPadding));
    }

    /**
     * Adds double quotes around the given {@link CharSequence}.
     */
    public static CharSequence quote(final CharSequence sequence) {
        return concat("\"", concat(sequence, "\""));
    }

    /**
     * Convenience method which quotes non null {@link CharSequence chars} of well of escaping
     * newlines, carriage returns and double quotes.
     */
    public static CharSequence quoteAndEscape(final CharSequence chars) {
        return null == chars ? null : CharSequences.quoteAndEscape2(chars);
    }

    /**
     * Helper that combines {@link #escape} and adds double quotes if required and escapes.
     */
    private static CharSequence quoteAndEscape2(final CharSequence chars) {
        final int length = chars.length();
        final boolean quoted = length > 1 &&
                startsWith(chars, "\"") &&
                endsWith(chars, "\"");

        return "\"" +
                escape(quoted ? chars.subSequence(1, length - 1) : chars) +
                '"';
    }

    /**
     * Accepts a character and returns a {@link CharSequence} that has been escaped and surrounded
     * by single quotes.
     */
    public static CharSequence quoteAndEscape(final char c) {
        return concat("'", concat(escape(String.valueOf(c)), "'"));
    }

    /**
     * Helper which adds quotes to the given {@link CharSequence} if it contains any whitespace. For
     * null or {@link CharSequence sequences} without whitespace the original will be returned.
     */
    public static CharSequence quoteIfNecessary(final CharSequence chars) {
        CharSequence result = chars;

        if (null != chars) {
            if (Whitespace.has(chars)) {
                result = quoteIfChars(chars);
            }
        }

        return result;
    }

    /**
     * Quotes and escapes {@link CharSequence}, {@link char[]} or {@link Character}. The later is
     * surrounded in single quotes and the others in double quotes. It is ok to pass in null. Note quoting is recursive
     * elements in {@link Collection}, keys and values within a {@link Map} are also quoted if possible.
     */
    public static CharSequence quoteIfChars(final Object object) {
        CharSequence result;

        for (; ; ) {
            if (object instanceof CharSequence) {
                result = CharSequences.quoteAndEscape(String.valueOf(object));
                break;
            }
            if (object instanceof char[]) {
                result = CharSequences.quoteAndEscape(new String((char[]) object));
                break;
            }
            if (object instanceof Character) {
                result = "'" + CharSequences.escape(String.valueOf(object)) + '\'';
                break;
            }
            if (object instanceof Optional) {
                final Optional<?> optional = Cast.to(object);
                result = quoteIfChars(
                        optional.orElse(null)
                );
                break;
            }
            if (object instanceof Collection) {
                final Collection<?> collecton = Cast.to(object);
                result = collecton.stream()
                        .map(CharSequences::quoteIfChars)
                        .collect(Collectors.joining(", ", "[", "]"));
                break;
            }
            if (object instanceof Map) {
                final Map<?, ?> map = Cast.to(object);

                result = map.entrySet()
                        .stream()
                        .map(CharSequences::quoteIfCharMapEntry)
                        .collect(Collectors.joining(", ", "{", "}"));
                break;
            }
            result = String.valueOf(object);
            break;
        }

        return result;
    }

    private static CharSequence quoteIfCharMapEntry(final Entry<?, ?> entry) {
        return quoteIfChars(entry.getKey()) +
                "=" +
                quoteIfChars(entry.getValue());
    }

    /**
     * {@see ReaderConsumingCharSequence}
     */
    @GwtIncompatible
    public static CharSequence readerConsuming(final Reader reader,
                                               final int bufferSize) {
        return ReaderConsumingCharSequence.with(reader, bufferSize);
    }

    /**
     * {@see RepeatingCharSequence}
     */
    public static CharSequence repeating(final char c,
                                         final int length) {
        return RepeatingCharSequence.with(c, length);
    }

    /**
     * Tests if the first string starts with the second ignoring case. This is equivalent to
     * CharSequence.startsWith() but ignores case.
     */
    public static boolean startsWith(final CharSequence chars,
                                     final String startsWith) {
        checkChars(chars);
        failIfNullOrEmpty(startsWith, "startsWith");

        boolean result = false;

        final int startsWithLength = startsWith.length();
        if (startsWithLength <= chars.length()) {
            result = true;

            for (int i = 0; i < startsWithLength; i++) {
                if (chars.charAt(i) != startsWith.charAt(i)) {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }

    /**
     * Adds support for negative to indexes without needing to fetch the length and subSequence. If
     * the to index is negative and before the from index a {@link ArrayIndexOutOfBoundsException}
     * is thrown.
     */
    public static CharSequence subSequence(final CharSequence chars,
                                           final int from,
                                           final int to) {
        checkChars(chars);

        CharSequence subSequence;
        do {
            if (0 == to) {
                subSequence = chars.subSequence(from, chars.length());
                break;
            }
            if (to > 0) {
                subSequence = chars.subSequence(from, to);
                break;
            }
            subSequence = subSequenceWithNegativeToIndex(chars, from, to);
        } while (false);

        return subSequence;
    }

    /**
     * Performs a {@link CharSequence#subSequence(int, int)} with a negative to index.
     */
    private static CharSequence subSequenceWithNegativeToIndex(final CharSequence sequence,
                                                               final int from,
                                                               final int to) {
        final int length = sequence.length();
        final int positiveToIndex = length + to;
        if (positiveToIndex < from) {
            throw new StringIndexOutOfBoundsException(toIndexBeforeFromIndex(
                    from,
                    to,
                    length));
        }
        return sequence.subSequence(from, positiveToIndex);
    }

    /**
     * Returns a message that the to index points to a character before the from index.
     */
    static String toIndexBeforeFromIndex(final int from, final int to, final int length) {
        return "To index (which is negative) is before from: " + to + " < " + -(length - from);
    }

    /**
     * Trims whitespace from the left and end of the given {@link CharSequence}.
     */
    public static CharSequence trim(final CharSequence chars) {
        checkChars(chars);

        final int start = findNonWhitespaceStart(chars);
        return chars.subSequence(start, findNonWhitespaceEnd(chars, start));
    }

    /**
     * Trims whitespace from the left or beginning of the given {@link CharSequence}.
     */
    public static CharSequence trimLeft(final CharSequence chars) {
        checkChars(chars);

        return chars.subSequence(findNonWhitespaceStart(chars), chars.length());
    }

    /**
     * Trims whitespace from the right or end of the given {@link CharSequence}.
     */
    public static CharSequence trimRight(final CharSequence chars) {
        checkChars(chars);

        return chars.subSequence(0, findNonWhitespaceEnd(chars, 0));
    }

    /**
     * Finds the first non whitespace character in the {@link CharSequence}
     */
    static private int findNonWhitespaceStart(final CharSequence chars) {
        final int length = chars.length();
        int i = 0;

        while (i < length) {
            final char c = chars.charAt(i);
            if (Character.isWhitespace(c)) {
                i++;
                continue;
            }

            break;
        }

        return i;
    }

    /**
     * Finds the last non whitespace character in the {@link CharSequence}
     */
    static private int findNonWhitespaceEnd(final CharSequence chars,
                                            final int stop) {
        int i = chars.length();

        while (i > stop) {
            i--;

            final char c = chars.charAt(i);
            if (Character.isWhitespace(c)) {
                continue;
            }
            i++;
            break;
        }

        return i;
    }

    /**
     * Un-escapes {@link CharSequence chars} escaped by {@link #escape(CharSequence)}. Note support
     * is included for backslash escape sequences and unicode escape sequences.
     */
    public static CharSequence unescape(final CharSequence chars) {
        return null == chars ?
                null :
                unescape0(chars);
    }

    private static CharSequence unescape0(final CharSequence chars) {
        final int length = chars.length();
        final StringBuilder builder = new StringBuilder(length);

        boolean wasBackslash = false;

        int i = 0;
        while (i < length) {
            final char c = chars.charAt(i);
            i++;

            if (wasBackslash) {
                switch (c) {
                    case '\\':
                        builder.append('\\');
                        break;
                    case 't':
                        builder.append('\t');
                        break;
                    case 'r':
                        builder.append('\r');
                        break;
                    case 'n':
                        builder.append('\n');
                        break;
                    case '0':
                        builder.append('\0');
                        break;
                    case '\'':
                        builder.append('\'');
                        break;
                    case '"':
                        builder.append('\"');
                        break;
                    case 'u':
                        // incomplete unicode character
                        if ((i + 4) > length) {
                            builder.append("\\u");
                            break;
                        }
                        // \\u0000;
                        final char firstChar = chars.charAt(i);
                        final int firstValue = Character.digit(firstChar, 16);
                        if (firstValue < 0) {
                            builder.append("\\u");
                            break;
                        }
                        final char secondChar = chars.charAt(i + 1);
                        final int secondValue = Character.digit(secondChar, 16);
                        if (secondValue < 0) {
                            builder.append("\\u");
                            break;
                        }
                        final char thirdChar = chars.charAt(i + 2);
                        final int thirdValue = Character.digit(thirdChar, 16);
                        if (thirdValue < 0) {
                            builder.append("\\u");
                            break;
                        }
                        final char fourthChar = chars.charAt(i + 3);
                        final int fourthValue = Character.digit(fourthChar, 16);
                        if (fourthValue < 0) {
                            builder.append("\\u");
                            break;
                        }
                        i = i + 4;
                        builder.append((char) ((firstValue * 0x1000) + (secondValue * 0x0100)
                                + (thirdValue * 0x10) + fourthValue));
                        break;
                    default:
                        builder.append(c);
                        break;
                }
                wasBackslash = false;
                continue;
            }
            wasBackslash = '\\' == c;
            if (false == wasBackslash) {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    private static void checkChars(final CharSequence chars) {
        Objects.requireNonNull(chars, "chars");
    }

    /**
     * Stop creation
     */
    private CharSequences() {
        throw new UnsupportedOperationException();
    }
}
