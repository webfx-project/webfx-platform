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

/**
 * A {@link CharPredicate} that only the tspecial characters defined at.
 * <a href="https://tools.ietf.org/html/rfc2045#page-5"></a>
 */
final class Rfc2045TokenSpecialCharPredicate implements CharPredicate {

    /**
     * Singleton.
     */
    final static Rfc2045TokenSpecialCharPredicate INSTANCE = new Rfc2045TokenSpecialCharPredicate();

    /**
     * Private ctor use singleton
     */
    private Rfc2045TokenSpecialCharPredicate() {
        super();
    }

    /**
     * <a href="https://tools.ietf.org/html/rfc2045#page-5"></a>
     * <pre>
     * token := 1*<any (US-ASCII) CHAR except SPACE, CTLs,
     *                  or tspecials>
     *
     *      tspecials :=  "(" / ")" / "<" / ">" / "@" /
     *                    "," / ";" / ":" / "\" / <">
     *                    "/" / "[" / "]" / "?" / "="
     *                    ; Must be in quoted-string,
     *                    ; to use within parameter values
     * </pre>
     */
    @Override
    public boolean test(final char c) {
        return specialTest(c);
    }

    static boolean specialTest(final char c) {
        return "()<>@,;:\\\"/[]?=".indexOf(c) != -1;
    }

    @Override
    public String toString() {
        return "RFC2045TokenSpecial";
    }
}
