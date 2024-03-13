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

package walkingkooka.naming;

import walkingkooka.text.CharSequences;

import java.util.Objects;

/**
 * A {@link PathSeparator} captures the actual character and rules about a {@link Path}.
 */
final public class PathSeparator {

    /**
     * Creates a {@link PathSeparator} that separates path components and is required to start with.
     */
    public static PathSeparator requiredAtStart(final char character) {
        return PathSeparator.SLASH.character == character ? PathSeparator.SLASH : PathSeparator.with(character, true);
    }

    /**
     * A {@link PathSeparator} that uses and requires a starting slash.
     */
    private final static PathSeparator SLASH = PathSeparator.with('/', true);

    /**
     * Creates a {@link PathSeparator} that separates path components and is required to start with.
     */
    public static PathSeparator notRequiredAtStart(final char character) {
        return PathSeparator.DOT.character == character ? PathSeparator.DOT : PathSeparator.with(character, false);
    }

    /**
     * A {@link PathSeparator} that uses and but does not expect a starting dot.
     */
    private final static PathSeparator DOT = PathSeparator.with('.', false);

    /**
     * Creates a new {@link PathSeparator} instance.
     */
    private static PathSeparator with(final char character, final boolean requiredAtStart) {
        if (character <= ' ' || Character.isLetterOrDigit(character)) {
            throw new IllegalArgumentException(PathSeparator.invalidCharacter(character));
        }
        return new PathSeparator(character, requiredAtStart);
    }

    /**
     * The message thrown inside an {@link IllegalArgumentException} when a control, letter or digit is passed in.
     */
    static String invalidCharacter(final char character) {
        return "Separator character cannot be control or letter/digit ='" + character + "'";
    }

    /**
     * Private constructor
     */
    private PathSeparator(final char character, final boolean requiredAtStart) {
        this.character = character;
        this.string = String.valueOf(character);
        this.requiredAtStart = requiredAtStart;
    }

    /**
     * Returns the actual separator character.
     */
    public char character() {
        return this.character;
    }

    private final char character;

    /**
     * The path separator character as a {@link String}.
     */
    public String string() {
        return this.string;
    }

    private final String string;

    /**
     * When true the path must start with the {@link #character()}.
     */
    public boolean isRequiredAtStart() {
        return this.requiredAtStart;
    }

    private final boolean requiredAtStart;

    /**
     * Tests if normalization of {@link Path paths} should not be tried because the separator character is '.'.
     */
    boolean disableNormalization() {
        return '.' == this.character;
    }

    /**
     * Fails if the path is null, empty or if beginning satifies the {@link #isRequiredAtStart()}.
     */
    public void checkBeginning(final String path) {
        Objects.requireNonNull(path, "path");
        if (path.isEmpty()) {
            throw new IllegalArgumentException("Path is empty");
        }

        final boolean atStart = this.character == path.charAt(0);
        if (this.requiredAtStart != atStart) {
            throw new IllegalArgumentException("Path " +
                    (this.requiredAtStart ? "is missing" : "should not start with") +
                    " " + CharSequences.quote(this.string) + " " + CharSequences.quote(path));
        }
    }

    // Object...........................................................................................................

    /**
     * Hashing is calculated using the character and {@link #requiredAtStart} properties
     */
    @Override
    public int hashCode() {
        return Objects.hash(character, this.requiredAtStart);
    }

    @Override
    public boolean equals(final Object other) {
        return (this == other) || ((other instanceof PathSeparator) && this.equals0((PathSeparator) other));
    }

    private boolean equals0(final PathSeparator other) {
        return (this.character == other.character) && //
                (this.requiredAtStart == other.requiredAtStart);
    }

    /**
     * Returns the separator character without quotes
     */
    @Override
    public String toString() {
        return this.string;
    }
}
