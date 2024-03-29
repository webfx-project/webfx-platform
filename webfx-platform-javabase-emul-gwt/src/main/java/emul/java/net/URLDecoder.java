/*
 * Copyright (c) 1998, 2021, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package emul.java.net;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Objects;

/**
 * Utility class for HTML form decoding. This class contains static methods
 * for decoding a String from the <CODE>application/x-www-form-urlencoded</CODE>
 * MIME format.
 * <p>
 * The conversion process is the reverse of that used by the URLEncoder class. It is assumed
 * that all characters in the encoded string are one of the following:
 * &quot;{@code a}&quot; through &quot;{@code z}&quot;,
 * &quot;{@code A}&quot; through &quot;{@code Z}&quot;,
 * &quot;{@code 0}&quot; through &quot;{@code 9}&quot;, and
 * &quot;{@code -}&quot;, &quot;{@code _}&quot;,
 * &quot;{@code .}&quot;, and &quot;{@code *}&quot;. The
 * character &quot;{@code %}&quot; is allowed but is interpreted
 * as the start of a special escaped sequence.
 * <p>
 * The following rules are applied in the conversion:
 *
 * <ul>
 * <li>The alphanumeric characters &quot;{@code a}&quot; through
 *     &quot;{@code z}&quot;, &quot;{@code A}&quot; through
 *     &quot;{@code Z}&quot; and &quot;{@code 0}&quot;
 *     through &quot;{@code 9}&quot; remain the same.
 * <li>The special characters &quot;{@code .}&quot;,
 *     &quot;{@code -}&quot;, &quot;{@code *}&quot;, and
 *     &quot;{@code _}&quot; remain the same.
 * <li>The plus sign &quot;{@code +}&quot; is converted into a
 *     space character &quot; &nbsp; &quot; .
 * <li>A sequence of the form "<i>{@code %xy}</i>" will be
 *     treated as representing a byte where <i>xy</i> is the two-digit
 *     hexadecimal representation of the 8 bits. Then, all substrings
 *     that contain one or more of these byte sequences consecutively
 *     will be replaced by the character(s) whose encoding would result
 *     in those consecutive bytes.
 *     The encoding scheme used to decode these characters may be specified,
 *     or if unspecified, the default charset will be used.
 * </ul>
 * <p>
 * There are two possible ways in which this decoder could deal with
 * illegal strings.  It could either leave illegal characters alone or
 * it could throw an {@link IllegalArgumentException}.
 * Which approach the decoder takes is left to the
 * implementation.
 *
 * @see Charset#defaultCharset()
 *
 * @author  Mark Chamness
 * @author  Michael McCloskey
 * @since   1.2
 */

public class URLDecoder {

    /**
     * Do not call.
     */
    private URLDecoder() {}

    // The default charset
    static String dfltEncName = URLEncoder.dfltEncName;

    /**
     * Decodes a {@code x-www-form-urlencoded} string.
     * The default charset is used to determine what characters
     * are represented by any consecutive sequences of the form
     * "<i>{@code %xy}</i>".
     * @param s the {@code String} to decode
     * @deprecated The resulting string may vary depending on the
     *          default charset. Instead, use the decode(String,String) method
     *          to specify the encoding.
     * @return the newly decoded {@code String}
     */
    @Deprecated
    public static String decode(String s) {

        String str = null;

        try {
            str = decode(s, dfltEncName);
        } catch (UnsupportedEncodingException e) {
            // The system should always have the default charset
        }

        return str;
    }

    /**
     * Decodes an {@code application/x-www-form-urlencoded} string using
     * a specific encoding scheme.
     *
     * <p>
     * This method behaves the same as {@linkplain decode(String s, Charset charset)}
     * except that it will {@linkplain Charset#forName look up the charset}
     * using the given encoding name.
     *
     * @implNote This implementation will throw an {@link IllegalArgumentException}
     * when illegal strings are encountered.
     *
     * @param s the {@code String} to decode
     * @param enc   The name of a supported
     *    <a href="../lang/package-summary.html#charenc">character
     *    encoding</a>.
     * @return the newly decoded {@code String}
     * @throws UnsupportedEncodingException
     *             If character encoding needs to be consulted, but
     *             named character encoding is not supported
     * @see URLEncoder#encode(String, String)
     * @since 1.4
     */
    public static String decode(String s, String enc) throws UnsupportedEncodingException {
        if (enc.isEmpty()) {
            throw new UnsupportedEncodingException ("URLDecoder: empty string enc parameter");
        }

        try {
            Charset charset = Charset.forName(enc);
            return decode(s, charset);
        } catch (IllegalCharsetNameException | UnsupportedCharsetException e) {
            throw new UnsupportedEncodingException(enc);
        }
    }

    /**
     * Decodes an {@code application/x-www-form-urlencoded} string using
     * a specific {@linkplain Charset Charset}.
     * The supplied charset is used to determine
     * what characters are represented by any consecutive sequences of the
     * form "<i>{@code %xy}</i>".
     * <p>
     * <em><strong>Note:</strong> The <a href=
     * "http://www.w3.org/TR/html40/appendix/notes.html#non-ascii-chars">
     * World Wide Web Consortium Recommendation</a> states that
     * UTF-8 should be used. Not doing so may introduce
     * incompatibilities.</em>
     *
     * @implNote This implementation will throw an {@link IllegalArgumentException}
     * when illegal strings are encountered.
     *
     * @param s the {@code String} to decode
     * @param charset the given charset
     * @return the newly decoded {@code String}
     * @throws NullPointerException if {@code s} or {@code charset} is {@code null}
     * @throws IllegalArgumentException if the implementation encounters illegal
     * characters
     * @see URLEncoder#encode(String, Charset)
     * @since 10
     */
    public static String decode(String s, Charset charset) {
        Objects.requireNonNull(charset, "Charset");
        boolean needToChange = false;
        int numChars = s.length();
        StringBuilder sb = new StringBuilder(numChars > 500 ? numChars / 2 : numChars);
        int i = 0;

        char c;
        byte[] bytes = null;
        while (i < numChars) {
            c = s.charAt(i);
            switch (c) {
                case '+':
                    sb.append(' ');
                    i++;
                    needToChange = true;
                    break;
                case '%':
                    /*
                     * Starting with this instance of %, process all
                     * consecutive substrings of the form %xy. Each
                     * substring %xy will yield a byte. Convert all
                     * consecutive  bytes obtained this way to whatever
                     * character(s) they represent in the provided
                     * encoding.
                     */

                    try {

                        // (numChars-i)/3 is an upper bound for the number
                        // of remaining bytes
                        if (bytes == null)
                            bytes = new byte[(numChars-i)/3];
                        int pos = 0;

                        while ( ((i+2) < numChars) &&
                                (c=='%')) {
                            int v = /*Integer.*/parseInt(s, i + 1, i + 3, 16);
                            if (v < 0)
                                throw new IllegalArgumentException(
                                        "URLDecoder: Illegal hex characters in escape "
                                                + "(%) pattern - negative value");
                            bytes[pos++] = (byte) v;
                            i+= 3;
                            if (i < numChars)
                                c = s.charAt(i);
                        }

                        // A trailing, incomplete byte encoding such as
                        // "%x" will cause an exception to be thrown

                        if ((i < numChars) && (c=='%'))
                            throw new IllegalArgumentException(
                                    "URLDecoder: Incomplete trailing escape (%) pattern");

                        sb.append(new String(bytes, 0, pos, charset));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException(
                                "URLDecoder: Illegal hex characters in escape (%) pattern - "
                                        + e.getMessage());
                    }
                    needToChange = true;
                    break;
                default:
                    sb.append(c);
                    i++;
                    break;
            }
        }

        return (needToChange? sb.toString() : s);
    }

    private static int parseInt(CharSequence s, int beginIndex, int endIndex, int radix)
            throws NumberFormatException {
        Objects.requireNonNull(s);
        //Objects.checkFromToIndex(beginIndex, endIndex, s.length());

        if (radix < Character.MIN_RADIX) {
            throw new NumberFormatException("radix " + radix +
                    " less than Character.MIN_RADIX");
        }
        if (radix > Character.MAX_RADIX) {
            throw new NumberFormatException("radix " + radix +
                    " greater than Character.MAX_RADIX");
        }

        boolean negative = false;
        int i = beginIndex;
        int limit = -Integer.MAX_VALUE;

        if (i < endIndex) {
            char firstChar = s.charAt(i);
            if (firstChar < '0') { // Possible leading "+" or "-"
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;
                } else if (firstChar != '+') {
                    throw /*NumberFormatException.*/forCharSequence(s, beginIndex,
                            endIndex, i);
                }
                i++;
                if (i == endIndex) { // Cannot have lone "+" or "-"
                    throw /*NumberFormatException.*/forCharSequence(s, beginIndex,
                            endIndex, i);
                }
            }
            int multmin = limit / radix;
            int result = 0;
            while (i < endIndex) {
                // Accumulating negatively avoids surprises near MAX_VALUE
                int digit = Character.digit(s.charAt(i), radix);
                if (digit < 0 || result < multmin) {
                    throw /*NumberFormatException.*/forCharSequence(s, beginIndex,
                            endIndex, i);
                }
                result *= radix;
                if (result < limit + digit) {
                    throw /*NumberFormatException.*/forCharSequence(s, beginIndex,
                            endIndex, i);
                }
                i++;
                result -= digit;
            }
            return negative ? result : -result;
        } else {
            throw /*NumberFormatException.*/forInputString("", radix);
        }
    }

    static NumberFormatException forCharSequence(CharSequence s,
                                                 int beginIndex, int endIndex, int errorIndex) {
        return new NumberFormatException("Error at index "
                + (errorIndex - beginIndex) + " in: \""
                + s.subSequence(beginIndex, endIndex) + "\"");
    }

    static NumberFormatException forInputString(String s, int radix) {
        return new NumberFormatException("For input string: \"" + s + "\"" +
                (radix == 10 ?
                        "" :
                        " under radix " + radix));
    }

}
