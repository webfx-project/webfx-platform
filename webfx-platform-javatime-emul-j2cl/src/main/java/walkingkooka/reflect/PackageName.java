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

import walkingkooka.naming.Name;
import walkingkooka.text.CharacterConstant;

import java.util.Objects;

/**
 * A legal {@link Name} identifying a {@link Package}.
 */
final public class PackageName extends JavaName<PackageName> {

    /**
     * Holds the unnamed package singleton
     */
    public final static PackageName UNNAMED = new PackageName("");

    /**
     * The package separator character<code>.</code>
     */
    @SuppressWarnings("WeakerAccess")
    public final static CharacterConstant SEPARATOR = PACKAGE_SEPARATOR;

    /**
     * The wildcard character<code>*</code> that is used by package imports
     */
    @SuppressWarnings("WeakerAccess")
    public final static CharacterConstant WILDCARD = CharacterConstant.with('*');

    /**
     * Creates a {@link PackageName} for the given {@link Package}.
     */
    public static PackageName from(final Package pkg) {
        Objects.requireNonNull(pkg, "package");
        return new PackageName(pkg.getName());
    }

    /**
     * Creates a {@link PackageName} from a {@link String} containing a fully qualified class name.
     */
    public static PackageName with(final String name) {
        Objects.requireNonNull(name, "name");

        return name.isEmpty() ?
                UNNAMED :
                notUnnamed(name);
    }

    private static PackageName notUnnamed(final String name) {
        checkLength(name);

        final int length = name.length();
        PackageName packageName = PackageName.UNNAMED;

        if (length > 0) {
            checkPackageName(name, length); // all of $name

            packageName = new PackageName(name);
        }
        return packageName;
    }

    /**
     * Private constructor
     */
    private PackageName(final String name) {
        super(name);
    }

    /**
     * Returns the parent {@link PackageName}.
     */
    public PackageName parent() {
        PackageName packageName = this.packageName;
        if (null == packageName) {
            final String name = this.name;
            packageName = PackageName.UNNAMED;
            final int lastDot = name.lastIndexOf(SEPARATOR.character());
            if (-1 != lastDot) {
                packageName = PackageName.with(name.substring(0, lastDot));
            }
            this.packageName = packageName;
        }
        return packageName;
    }

    private transient PackageName packageName;

    /**
     * Appends the given {@link PackageName} onto this returning a {@link PackageName} that combines the two.
     */
    public PackageName append(final PackageName pkg) {
        Objects.requireNonNull(pkg, "package");

        return this.isUnnamed() ? pkg
                : pkg.isUnnamed() ? this : new PackageName(this.name + SEPARATOR + pkg.name);
    }

    /**
     * Internal helper that may be used to test if this {@link PackageName} is {@link #UNNAMED}
     */
    private boolean isUnnamed() {
        return this == PackageName.UNNAMED;
    }

    // Object.............................................................................................................

    @Override
    boolean canBeEqual(final Object other) {
        return other instanceof PackageName;
    }

    // Comparable.........................................................................................................

    @Override
    public int compareTo(final PackageName other) {
        return this.compareTo0(other);
    }
}
