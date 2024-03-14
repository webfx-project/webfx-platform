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

package walkingkooka.predicate.character;

import walkingkooka.InvalidCharacterException;
import walkingkooka.reflect.PublicStaticHelper;
import walkingkooka.text.CaseSensitivity;
import walkingkooka.text.CharSequences;

import java.util.Objects;

final public class CharPredicates implements PublicStaticHelper {

    /**
     * {@see CharPredicateBuilder}
     */
    public static CharPredicateBuilder builder() {
        return CharPredicateBuilder.empty();
    }

    /**
     * {@see AlwaysCharPredicate}.
     */
    public static CharPredicate always() {
        return AlwaysCharPredicate.INSTANCE;
    }

    /**
     * {@see AndCharPredicate}.
     */
    public static CharPredicate and(final CharPredicate left, final CharPredicate right) {
        return AndCharPredicate.wrap(left, right);
    }

    /**
     * {@see AndNotCharPredicate}.
     */
    public static CharPredicate andNot(final CharPredicate left, final CharPredicate right) {
        return AndNotCharPredicate.wrap(left, right);
    }

    /**
     * {@see AsciiCharPredicate}
     */
    public static CharPredicate ascii() {
        return AsciiCharPredicate.INSTANCE;
    }

    /**
     * {@see AsciiControlCharPredicate}
     */
    public static CharPredicate asciiControl() {
        return AsciiControlCharPredicate.INSTANCE;
    }

    /**
     * {@see AsciiPrintableCharPredicate}
     */
    public static CharPredicate asciiPrintable() {
        return AsciiPrintableCharPredicate.INSTANCE;
    }

    /**
     * {@see AnyCharPredicate}
     */
    public static CharPredicate any(final String chars) {
        return AnyCharPredicate.with(chars);
    }

    /**
     * {@see CaseSensitivity#INSENSITIVE#charPredicate}.
     */
    public static CharPredicate caseInsensitive(final char c) {
        return CaseSensitivity.INSENSITIVE.charPredicate(c);
    }

    /**
     * {@see CaseInsensitiveCharPredicate}.
     */
    public static CharPredicate caseInsensitive(final CharPredicate predicate) {
        return CaseInsensitiveCharPredicate.with(predicate);
    }

    /**
     * {@see DigitCharPredicate}.
     */
    public static CharPredicate digit() {
        return DigitCharPredicate.INSTANCE;
    }

    /**
     * {@see EndOfLineCharPredicate}.
     */
    public static CharPredicate endOfLine() {
        return EndOfLineCharPredicate.INSTANCE;
    }

    /**
     * {@see FakeCharPredicate}.
     */
    public static CharPredicate fake() {
        return FakeCharPredicate.create();
    }

    /**
     * Fails if the chars are null or any characters fail the {@link CharPredicate} test.
     * It is assumed the {@link CharPredicate} have a meaningful toString as it is included in any exception messages.
     */
    public static void failIfNullOrFalse(final CharSequence chars,
                                         final String label,
                                         final CharPredicate predicate) {
        Objects.requireNonNull(chars, label);
        CharSequences.failIfNullOrEmpty(label, "label");
        Objects.requireNonNull(predicate, "predicate");

        checkCharacters(chars, predicate);
    }

    /**
     * Fails if the chars are null or empty or any characters fail the {@link CharPredicate} test.
     * It is assumed the {@link CharPredicate} have a meaningful toString as it is included in any exception messages.
     */
    public static void failIfNullOrEmptyOrFalse(final CharSequence chars,
                                                final String label,
                                                final CharPredicate predicate) {
        CharSequences.failIfNullOrEmpty(chars, label);
        CharSequences.failIfNullOrEmpty(label, "label");
        Objects.requireNonNull(predicate, "predicate");

        checkCharacters(chars, predicate);
    }

    /**
     * Checks that all characters pass the {@link CharPredicate} test.
     */
    private static void checkCharacters(final CharSequence chars,
                                        final CharPredicate predicate) {
        final int length = chars.length();
        for (int i = 0; i < length; i++) {
            final char c = chars.charAt(i);
            if (!predicate.test(c)) {
                throw new InvalidCharacterException(chars.toString(), i);
            }
        }
    }

    /**
     * Fails if the chars are null or empty or any characters fail the initial or part test.
     * It is assumed the {@link CharPredicate} have a meaningful toString as it is included in any exception messages.
     */
    public static void failIfNullOrEmptyOrInitialAndPartFalse(final CharSequence chars,
                                                              final String label,
                                                              final CharPredicate initial,
                                                              final CharPredicate part) {
        CharSequences.failIfNullOrEmpty(chars, label);
        CharSequences.failIfNullOrEmpty(label, "label");

        final int invalidChar = findInitialAndPartInvalidChar(
                chars,
                initial,
                part
        );

        if (-1 != invalidChar) {
            throw new InvalidCharacterException(
                    chars.toString(),
                    invalidChar
            );
        }
    }

    public static boolean isInitialAndPart(final String text,
                                           final CharPredicate initial,
                                           final CharPredicate part) {
        return !CharSequences.isNullOrEmpty(text) &&
                -1 == findInitialAndPartInvalidChar(
                        text,
                        initial,
                        part
                );
    }

    /**
     * This helper does double duty and is used by both {@link #failIfNullOrEmptyOrInitialAndPartFalse(CharSequence, String, CharPredicate, CharPredicate)}
     * and {@link #isInitialAndPart(String, CharPredicate, CharPredicate)}, the former throws when
     * the result is not -1 and the latter returns false for a result of -1.
     */
    private static int findInitialAndPartInvalidChar(final CharSequence chars,
                                                     final CharPredicate initial,
                                                     final CharPredicate part) {
        Objects.requireNonNull(initial, "initial");
        Objects.requireNonNull(part, "part");

        int result = -1;

        final char first = chars.charAt(0);
        if (!initial.test(first)) {
            result = 0;
        } else {
            final int length = chars.length();
            for (int i = 1; i < length; i++) {
                final char c = chars.charAt(i);
                if (!part.test(c)) {
                    result = i;
                    break;
                }
            }
        }

        return result;
    }

    /**
     * {@see CaseSensitivity#SENSITIVE#charPredicate}.
     */
    public static CharPredicate is(final char c) {
        return CaseSensitivity.SENSITIVE.charPredicate(c);
    }

    /**
     * {@see LetterCharPredicate}.
     */
    public static CharPredicate letter() {
        return LetterCharPredicate.INSTANCE;
    }

    /**
     * {@see LetterOrDigitCharPredicate}.
     */
    public static CharPredicate letterOrDigit() {
        return LetterOrDigitCharPredicate.INSTANCE;
    }

    /**
     * {@see LowerCasingCharPredicate}.
     */
    public static CharPredicate lowerCasing(final CharPredicate predicate) {
        return LowerCasingCharPredicate.wrap(predicate);
    }

    /**
     * {@see NeverCharPredicate}.
     */
    public static CharPredicate never() {
        return NeverCharPredicate.INSTANCE;
    }

    /**
     * {@see NotCharPredicate}.
     */
    public static CharPredicate not(final CharPredicate charPredicate) {
        return NotCharPredicate.wrap(charPredicate);
    }

    /**
     * {@see OrCharPredicate}.
     */
    public static CharPredicate or(final CharPredicate left, final CharPredicate right) {
        return OrCharPredicate.wrap(left, right);
    }

    /**
     * {@see PrintableCharPredicate}
     */
    public static CharPredicate printable() {
        return PrintableCharPredicate.INSTANCE;
    }

    /**
     * {@see RangeCharPredicate}
     */
    public static CharPredicate range(final char start, final char end) {
        return RangeCharPredicate.with(start, end);
    }

    /**
     * {@see Rfc2045TokenCharPredicate}
     */
    public static CharPredicate rfc2045Token() {
        return Rfc2045TokenCharPredicate.INSTANCE;
    }

    /**
     * {@see Rfc2045TokenSpecialCharPredicate}
     */
    public static CharPredicate rfc2045TokenSpecial() {
        return Rfc2045TokenSpecialCharPredicate.INSTANCE;
    }

    /**
     * {@see ToStringCharPredicate}.
     */
    public static CharPredicate toString(final CharPredicate predicate, final String toString) {
        return ToStringCharPredicate.wrap(predicate, toString);
    }

    /**
     * {@see WhitespaceCharPredicate}.
     */
    public static CharPredicate whitespace() {
        return WhitespaceCharPredicate.INSTANCE;
    }

    /**
     * {@see XmlCharPredicate}.
     */
    public static CharPredicate xml() {
        return XmlCharPredicate.INSTANCE;
    }

    /**
     * Stop creation
     */
    private CharPredicates() {
        throw new UnsupportedOperationException();
    }
}
