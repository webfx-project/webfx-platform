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

import walkingkooka.InvalidCharacterException;
import walkingkooka.collect.map.Maps;

import java.util.Map;
import java.util.Objects;

/**
 * A valid legal fully qualified name of java {@link Class}.
 */
public final class ClassName extends JavaName<ClassName> {

    /**
     * A map of all constants.
     */
    private final static Map<String, ClassName> CONSTANTS = Maps.ordered();

    /**
     * Internal method used to register a constant.
     */
    private static ClassName registerConstant(final String name) {
        final ClassName typeName = new ClassName(name);
        CONSTANTS.put(name, typeName);
        return typeName;
    }

    /**
     * {@see Boolean#TYPE}
     */
    public final static ClassName BOOLEAN = registerConstant("boolean");

    /**
     * {@see Byte#TYPE}
     */
    public final static ClassName BYTE = registerConstant("byte");

    /**
     * {@see Short#TYPE}
     */
    public final static ClassName SHORT = registerConstant("short");

    /**
     * {@see Integer#TYPE}
     */
    public final static ClassName INT = registerConstant("int");

    /**
     * {@see Long#TYPE}
     */
    public final static ClassName LONG = registerConstant("long");

    /**
     * {@see Float#TYPE}
     */
    public final static ClassName FLOAT = registerConstant("float");

    /**
     * {@see Double#TYPE}
     */
    public final static ClassName DOUBLE = registerConstant("double");

    /**
     * {@see Character#TYPE}
     */
    public final static ClassName CHAR = registerConstant("char");

    /**
     * {@see Void#TYPE}
     */
    public final static ClassName VOID = registerConstant("void");

    /**
     * {@see String#TYPE}
     */
    public final static ClassName STRING = registerConstant("java.lang.String");

    /**
     * Factory that creates a {@link ClassName} given a {@link Class}
     */
    public static ClassName fromClass(final Class<?> klass) {
        Objects.requireNonNull(klass, "class");

        final String name = klass.getName();
        final ClassName typeName = CONSTANTS.get(name);
        return null != typeName ?
                typeName :
                new ClassName(klass.getName());
    }

    /**
     * Creates a {@link ClassName} from a String containing a fully qualified class name. If this factory is called within a {@link ClassLoader} any
     * thrown {@link IllegalArgumentException} should be wrapped inside a {@link ClassNotFoundException}.
     */
    public static ClassName with(final String name) {
        Objects.requireNonNull(name, "name");

        final ClassName typeName = CONSTANTS.get(name);
        return null != typeName ?
                typeName :
                notConstant(name);
    }

    /**
     * Handles the case where the input {@link String} is not a constant, and must be verified.
     */
    private static ClassName notConstant(final String name) {
        checkNotEmpty(name);
        checkLength(name);

        final int length = name.length();
        int classStart = 0;
        int packageEnd = name.lastIndexOf(PACKAGE_SEPARATOR.character());
        if (-1 != packageEnd) {
            checkPackageName(name, packageEnd);
            classStart = packageEnd + 1;
        }

        if (classStart == length) {
            throw new InvalidCharacterException(name, classStart - 1);
        }

        if (!Character.isJavaIdentifierStart(name.charAt(classStart))) {
            throw new InvalidCharacterException(name, classStart);
        }
        for (int i = classStart + 1; i < length; i++) {
            if (!Character.isJavaIdentifierPart(name.charAt(i))) {
                throw new InvalidCharacterException(name, i);
            }
        }

        return new ClassName(name);
    }

    /**
     * Package private use ctor
     */
    private ClassName(final String name) {
        super(name);
    }

    /**
     * Returns the class name without the package. This is equivalent to {@link Class#getSimpleName()}.
     */
    public String nameWithoutPackage() {
        String nameWithoutPackage = this.nameWithoutPackage;

        if (null == nameWithoutPackage) {
            final String name = this.name;
            nameWithoutPackage = name;

            final int lastDot = name.lastIndexOf('.');
            if (-1 != lastDot) {
                nameWithoutPackage = name.substring(lastDot + 1);
            }
            this.nameWithoutPackage = nameWithoutPackage;
        }
        return nameWithoutPackage;
    }

    /**
     * A cached copy of the class name without the package. This is equivalent to {@link Class#getSimpleName()}.
     */
    private transient String nameWithoutPackage;

    /**
     * Returns the parent {@link PackageName}.
     */
    public PackageName parentPackage() {
        if (null == this.packageName) {
            final String name = this.name;
            PackageName packageName = PackageName.UNNAMED;
            final int lastDot = name.lastIndexOf('.');
            if (-1 != lastDot) {
                packageName = PackageName.with(name.substring(0, lastDot));
            }
            this.packageName = packageName;
        }
        return packageName;
    }

    private transient PackageName packageName;

    // Object...........................................................................................................

    @Override boolean canBeEqual(final Object other) {
        return other instanceof ClassName;
    }

    // Comparable ......................................................................................................

    @Override
    public int compareTo(final ClassName other) {
        return this.compareTo0(other);
    }
}
