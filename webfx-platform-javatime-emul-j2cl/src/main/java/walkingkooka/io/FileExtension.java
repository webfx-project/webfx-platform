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

package walkingkooka.io;

import walkingkooka.Cast;
import walkingkooka.InvalidCharacterException;
import walkingkooka.Value;
import walkingkooka.text.CaseSensitivity;
import walkingkooka.text.CharSequences;

import java.util.Objects;
import java.util.Optional;

/**
 * Represents the file extension with a filename.
 */
public final class FileExtension implements
        Comparable<FileExtension>,
        Value<String> {

    /**
     * Extracts the file extension if present from the given filename.
     */
    public static Optional<FileExtension> extract(final String filename) {
        Objects.requireNonNull(filename, "filename");

        final int dot = filename.lastIndexOf(DOT);
        return Optional.ofNullable(-1 == dot || dot == filename.length() - 1 ?
                null :
                with(filename.substring(dot + 1)));
    }

    /**
     * Factory that creates a {@link FileExtension}
     */
    public static FileExtension with(final String value) {
        CharSequences.failIfNullOrEmpty(value, "value");

        final int dot = value.indexOf(DOT);
        if (dot != -1) {
            throw new InvalidCharacterException(value, dot);
        }

        return new FileExtension(value);
    }

    private final static char DOT = '.';

    /**
     * Private ctor use public static methods.
     */
    private FileExtension(final String value) {
        super();
        this.value = value;
    }

    // Value...........................................................................................................

    @Override
    public String value() {
        return this.value;
    }

    private final String value;

    // Object...........................................................................................................

    @Override
    public int hashCode() {
        return CASE_SENSITIVITY.hash(this.value);
    }

    @Override
    public boolean equals(final Object other) {
        return this == other ||
                other instanceof FileExtension &&
                        this.equals0(Cast.to(other));
    }

    private boolean equals0(final FileExtension other) {
        return 0 == this.compareTo(other);
    }

    /**
     * Dumps the method name.
     */
    @Override
    public String toString() {
        return this.value;
    }

    // Comparable..........................................................................................................

    private final static CaseSensitivity CASE_SENSITIVITY = CaseSensitivity.INSENSITIVE;

    @Override
    public int compareTo(final FileExtension other) {
        return CASE_SENSITIVITY.comparator().compare(this.value, other.value);
    }
}
