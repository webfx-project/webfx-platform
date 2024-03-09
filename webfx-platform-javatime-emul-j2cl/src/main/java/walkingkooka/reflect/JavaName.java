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

package walkingkooka.reflect;

import walkingkooka.Cast;
import walkingkooka.InvalidCharacterException;
import walkingkooka.InvalidTextLengthException;
import walkingkooka.naming.Name;
import walkingkooka.predicate.character.CharPredicate;
import walkingkooka.predicate.character.CharPredicates;
import walkingkooka.text.CaseSensitivity;
import walkingkooka.text.CharacterConstant;

/**
 * Base class for several jdk component names.
 */
abstract class JavaName<N extends JavaName<N>> implements Name, Comparable<N> {

    static void check(final String name) {
        CharPredicates.failIfNullOrEmptyOrInitialAndPartFalse(name,
                "name",
                INITIAL,
                PART);
        checkLength(name);
    }

    static void checkNotEmpty(final String name) {
        if (0 == name.length()) {
            throw new IllegalArgumentException("Empty name");
        }
    }

    static void checkLength(final String name) {
        if (name.length() > MAX_LENGTH) {
            throw new InvalidTextLengthException("name", name, 0, MAX_LENGTH);
        }
    }

    private static final int MAX_LENGTH = 65535;

    /**
     * The package separator character<code>.</code>
     */
    static final CharacterConstant PACKAGE_SEPARATOR = CharacterConstant.with('.');

    /**
     * Checks that the package name between the given bounds of the name string is a valid package.
     */
    static void checkPackageName(final String name, final int end) {
        char previous = PACKAGE_SEPARATOR.character();

        for (int i = 0; i < end; i++) {
            final char c = name.charAt(i);
            final char wasPrevious = previous;
            previous = c;

            if (PACKAGE_SEPARATOR.equals(c)) {
                if (PACKAGE_SEPARATOR.equals(wasPrevious)) {
                    throw new InvalidCharacterException(name, i);
                }
                continue;
            }
            if (PACKAGE_SEPARATOR.equals(wasPrevious)) {
                if (false == Character.isJavaIdentifierStart(c)) {
                    throw new InvalidCharacterException(name, i);
                }
                continue;
            }
            if (false == Character.isJavaIdentifierPart(c)) {
                throw new InvalidCharacterException(name, i);
            }
        }

        final int last = end - 1;
        if (PACKAGE_SEPARATOR.equals(name.charAt(last))) {
            throw new InvalidCharacterException(name, last);
        }
    }

    private static final CharPredicate INITIAL = Character::isJavaIdentifierStart;
    private static final CharPredicate PART = Character::isJavaIdentifierPart;

    JavaName(final String name) {
        super();
        this.name = name;
    }

    @Override
    public final String value() {
        return this.name;
    }

    final String name;

    // Object...........................................................................................................

    @Override
    public final int hashCode() {
        return CASE_SENSITIVITY.hash(this.name);
    }

    @Override
    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    public boolean equals(final Object other) {
        return this == other ||
                this.canBeEqual(other) &&
                        this.equals0(Cast.to(other));
    }

    abstract boolean canBeEqual(final Object other);

    private boolean equals0(final JavaName<?> other) {
        return CASE_SENSITIVITY.equals(this.name, other.name);
    }

    @Override
    public String toString() {
        return this.name;
    }

    // Comparable .......................................................................................................

    final int compareTo0(final JavaName<?> other) {
        return CASE_SENSITIVITY.comparator().compare(this.name, other.name);
    }

    // HasCaseSensitivity................................................................................................

    @Override
    public final CaseSensitivity caseSensitivity() {
        return CASE_SENSITIVITY;
    }

    private static final CaseSensitivity CASE_SENSITIVITY = CaseSensitivity.SENSITIVE;
}
