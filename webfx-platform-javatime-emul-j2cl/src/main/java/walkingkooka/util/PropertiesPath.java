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

package walkingkooka.util;

import walkingkooka.naming.Path;
import walkingkooka.naming.PathSeparator;
import walkingkooka.text.CharSequences;

import java.util.Objects;
import java.util.Optional;
import java.util.Properties;

/**
 * A {@link Path} that wraps a {@link String} which may contain any character.
 */
final public class PropertiesPath implements Path<PropertiesPath, PropertiesName>, Comparable<PropertiesPath> {

    /**
     * {@link PathSeparator} instance
     */
    public final static PathSeparator SEPARATOR = PathSeparator.notRequiredAtStart('.');

    final static Optional<PropertiesPath> NO_PARENT = Optional.empty();

    /**
     * Parses the {@link String} into a {@link PropertiesPath}
     */
    public static PropertiesPath parse(final String path) {
        SEPARATOR.checkBeginning(path);

        try {
            PropertiesPath result = null;

            for (final String component : path.split("\\.")) {
                final PropertiesName name = PropertiesName.with(component);
                result = null == result ?
                        new PropertiesPath(component, name, NO_PARENT) :
                        result.append(name);
            }
            return result == null ?
                    new PropertiesPath(path, PropertiesName.with(path), NO_PARENT) :
                    result;
        } catch (final IllegalArgumentException cause) {
            throw new IllegalArgumentException("Failed to parse " + CharSequences.quote(path) + ", message: " + cause.getMessage(), cause);
        }
    }

    /**
     * Package private constructor, only called by factories in this class.
     */
    private PropertiesPath(final String path, final PropertiesName name, final Optional<PropertiesPath> parent) {
        super();
        this.path = path;
        this.name = name;
        this.parent = parent;
    }

    private final String path;

    // PropertiesPath

    public String getProperty(final Properties properties) {
        Objects.requireNonNull(properties, "properties");
        return properties.getProperty(this.value());
    }

    public String getProperty(final Properties properties, final String defaultValue) {
        Objects.requireNonNull(properties, "properties");
        return properties.getProperty(this.value(), defaultValue);
    }

    // Path

    @Override
    public PropertiesPath append(final PropertiesName name) {
        Objects.requireNonNull(name, "name");

        if (PropertiesName.ROOT.equals(name)) {
            throw new IllegalArgumentException(PropertiesPath.CANNOT_APPEND_ROOT_NAME);
        }

        final StringBuilder path = new StringBuilder();
        path.append(this.path);
        path.append(PropertiesPath.SEPARATOR.character());
        path.append(name.value());

        return new PropertiesPath(path.toString(), name, Optional.of(this));
    }

    /**
     * Thrown when attempting to add the root name to this {@link PropertiesPath}.
     */
    final static String CANNOT_APPEND_ROOT_NAME = "Cannot append root name.";

    @Override
    public String value() {
        return this.path;
    }

    private final Optional<PropertiesPath> parent;

    /**
     * Returns the parent {@link PropertiesPath}.
     */
    @Override
    public Optional<PropertiesPath> parent() {
        return this.parent;
    }

    final PropertiesName name;

    @Override
    public PropertiesName name() {
        return this.name;
    }

    /**
     * {@link PathSeparator} getter.
     */
    @Override
    public PathSeparator separator() {
        return PropertiesPath.SEPARATOR;
    }

    // Comparable
    @Override
    public int compareTo(final PropertiesPath path) {
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
        return (this == other) || ((other instanceof PropertiesPath) && this.equals0((PropertiesPath) other));
    }

    private boolean equals0(final PropertiesPath other) {
        return this.path.equals(other.path);
    }

    @Override
    public String toString() {
        return this.path;
    }
}
