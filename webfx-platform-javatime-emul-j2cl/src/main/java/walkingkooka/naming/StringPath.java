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
import java.util.Optional;

/**
 * A {@link Path} that wraps a {@link String} which may contain any character.
 */
final public class StringPath
        implements Path<StringPath, StringName>,
        Comparable<StringPath> {

    /**
     * {@link PathSeparator} instance
     */
    public final static PathSeparator SEPARATOR = PathSeparator.requiredAtStart('/');
    /**
     * Convenient constant holding the root.
     */
    public final static StringPath ROOT = new StringPath(StringPath.SEPARATOR.string(), StringName.ROOT, Optional.empty());

    /**
     * Parses the {@link String} into a {@link StringPath}
     */
    public static StringPath parse(final String path) {
        SEPARATOR.checkBeginning(path);

        try {
            StringPath result = ROOT;

            if(path.length() > 1) {
                for (String component : path.substring(1).split(SEPARATOR.string())) {
                    result = result.append(StringName.with(component));
                }
            }
            return result;
        } catch (final IllegalArgumentException cause) {
            throw new IllegalArgumentException("Failed to parse " + CharSequences.quote(path) + ", message: " + cause.getMessage(), cause);
        }
    }

    /**
     * Private constructor
     */
    private StringPath(final String path, final StringName name, final Optional<StringPath> parent) {
        super();
        this.path = path;
        this.name = name;
        this.parent = parent;
    }

    private final String path;

    // Path

    @Override
    public StringPath append(final StringName name) {
        Objects.requireNonNull(name, "name");

        if (StringName.ROOT.equals(name)) {
            throw new IllegalArgumentException(StringPath.CANNOT_APPEND_ROOT_NAME);
        }

        final StringBuilder path = new StringBuilder();
        if (false == this.isRoot()) {
            path.append(this.path);
        }
        path.append(StringPath.SEPARATOR.character());
        path.append(name.value());

        return new StringPath(path.toString(), name, Optional.of(this));
    }

    /**
     * Thrown when attempting to add the root name to this {@link StringPath}.
     */
    private final static String CANNOT_APPEND_ROOT_NAME = "Cannot append root name.";

    @Override
    public String value() {
        return this.path;
    }

    private final Optional<StringPath> parent;

    /**
     * Returns the parent {@link StringPath}.
     */
    @Override
    public Optional<StringPath> parent() {
        return this.parent;
    }

    private final StringName name;

    @Override
    public StringName name() {
        return this.name;
    }

    /**
     * {@link PathSeparator} getter.
     */
    @Override
    public PathSeparator separator() {
        return StringPath.SEPARATOR;
    }

    /**
     * Only returns true if this {@link StringPath} is the {@link #ROOT}.
     */
    @Override
    public boolean isRoot() {
        return this == StringPath.ROOT;
    }

    // Comparable
    @Override
    public int compareTo(final StringPath path) {
        Objects.requireNonNull(path, "path");
        return this.path.compareTo(path.path);
    }

    // Object...........................................................................................................

    @Override
    public int hashCode() {
        return this.path.hashCode();
    }

    @Override
    public boolean equals(final Object other) {
        return (this == other) || ((other instanceof StringPath) && this.equals0((StringPath) other));
    }

    private boolean equals0(final StringPath other) {
        return this.path.equals(other.path);
    }

    @Override
    public String toString() {
        return this.path;
    }
}
