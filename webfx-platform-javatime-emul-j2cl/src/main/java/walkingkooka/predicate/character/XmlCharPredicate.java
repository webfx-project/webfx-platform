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
 * A {@link CharPredicate} that only test valid XML characters.
 */
final class XmlCharPredicate implements CharPredicate {
    /**
     * Singleton
     */
    final static XmlCharPredicate INSTANCE = new XmlCharPredicate();

    /**
     * Private constructor use singleton
     */
    private XmlCharPredicate() {
        super();
    }

    // CharPredicate

    /**
     * <a>http://www.w3.org/TR/xml/#charsets}</a>
     *
     * <pre>
     * Char     ::=    #x9 | #xA | #xD | [#x20-#xD7FF] | [#xE000-#xFFFD] | [#x10000-#x10FFFF]
     * </pre>
     */
    @Override
    public boolean test(final char c) {
        boolean valid;

        do {
            if (c < ' ') {
                if ('\t' == c) {
                    valid = true;
                    break;
                }
                if ('\r' == c) {
                    valid = true;
                    break;
                }
                if ('\n' == c) {
                    valid = true;
                    break;
                }
                valid = false;
                break;
            }
            if (c <= 0xd7ff) {
                // must be between 0x20 and 0xd7ff
                valid = true;
                break;
            }
            if (c < 0xe000) {
                valid = false;
                break;
            }
            if (c <= 0xfffd) {
                valid = true;
                break;
            }
            valid = false;
        } while (false);

        return valid;
    }

    // Object

    @Override
    public String toString() {
        return "XML";
    }
}
