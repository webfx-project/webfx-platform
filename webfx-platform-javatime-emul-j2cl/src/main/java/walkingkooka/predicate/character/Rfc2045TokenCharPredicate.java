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
 * A {@link CharPredicate} that only matches characters that are valid http tokens as specified by RFC2045.
 * <a href="https://tools.ietf.org/html/rfc2045#page-5"></a>
 */
final class Rfc2045TokenCharPredicate implements CharPredicate {

    /**
     * Singleton.
     */
    final static Rfc2045TokenCharPredicate INSTANCE = new Rfc2045TokenCharPredicate();

    /**
     * Private ctor use singleton
     */
    private Rfc2045TokenCharPredicate() {
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
    public boolean test(char c) {
        return c > ' ' && c < 127 && false == Rfc2045TokenSpecialCharPredicate.specialTest(c);
    }

    @Override
    public String toString() {
        return "RFC2045Token";
    }
}
