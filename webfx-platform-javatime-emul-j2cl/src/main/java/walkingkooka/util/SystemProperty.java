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

import walkingkooka.Value;
import walkingkooka.text.CaseSensitivity;
import walkingkooka.text.CharSequences;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Represents a system property with methods to interact with values.<br>
 * <a href="https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html"></a>
 */
final public class SystemProperty implements Value<String> {

    /**
     * A cache of {@link SystemProperty} constants.
     */
    private final static Map<String, SystemProperty> PROPERTIES = new HashMap<>();

    public final static SystemProperty FILE_ENCODING = registerConstant("file.encoding");

    public final static SystemProperty FILE_ENCODING_PKG = registerConstant("file.encoding.pkg");

    public final static SystemProperty FILE_SEPARATOR = registerConstant("file.separator");

    public final static SystemProperty JAVA_CLASS_PATH = registerConstant("java.class.path");

    public final static SystemProperty JAVA_CLASS_PATH_SEPARATOR = registerConstant("path.separator");

    public final static SystemProperty JAVA_CLASS_VERSION = registerConstant("java.class.version");

    public final static SystemProperty JAVA_COMPILER = registerConstant("java.compiler");

    public final static SystemProperty JAVA_HOME = registerConstant("java.home");

    public final static SystemProperty JAVA_IO_TMPDIR = registerConstant("java.io.tmpdir");

    public final static SystemProperty JAVA_VERSION = registerConstant("java.version");

    public final static SystemProperty JAVA_VENDOR = registerConstant("java.vendor");

    public final static SystemProperty JAVA_VENDOR_URL = registerConstant("java.vendor.url");

    public final static SystemProperty LINE_SEPARATOR = registerConstant("line.separator");

    public final static SystemProperty OS_NAME = registerConstant("os.name");

    public final static SystemProperty OS_ARCH = registerConstant("os.arch");

    public final static SystemProperty OS_VERSION = registerConstant("os.version");

    public final static SystemProperty USER_DIR = registerConstant("user.dir");

    public final static SystemProperty USER_HOME = registerConstant("user.home");

    public final static SystemProperty USER_LANGUAGE = registerConstant("user.language");

    public final static SystemProperty USER_NAME = registerConstant("user.name");

    public final static SystemProperty USER_REGION = registerConstant("user.region");

    public final static SystemProperty USER_TIMEZONE = registerConstant("user.timezone");

    // our properties

    /**
     * {@see walkingkooka.text.CaseSensitivity#FILE_SYSTEM_CASE_SENSITIVITY}
     */
    public final static SystemProperty FILE_SYSTEM_CASE_SENSITIVITY = registerConstant(CaseSensitivity.class.getName());

    /**
     * Retrieves a {@link SystemProperty} with the given name.
     */
    public static SystemProperty get(final String name) {
        CharSequences.failIfNullOrEmpty(name, "name");

        SystemProperty property = SystemProperty.PROPERTIES.get(name);
        if (null == property) {
            property = new SystemProperty(name);
        }
        return property;
    }

    /**
     * Creates then updates the cache and returns the new {@link SystemProperty}.
     */
    synchronized private static SystemProperty registerConstant(final String name) {
        final SystemProperty property = new SystemProperty(name);
        SystemProperty.PROPERTIES.put(name, property);
        return property;
    }

    /**
     * Private constructor use {@link #get(String)}
     */
    private SystemProperty(final String name) {
        super();
        this.name = name;
    }

    /**
     * Gets the name of the system property of a {@link String}.
     */
    @Override
    public String value() {
        return this.name;
    }

    private final String name;

    /**
     * Retrieves the current value of this system property. May return null if not set.
     */
    public Optional<String> propertyValue() {
        return Optional.ofNullable(SystemPropertySecurityAction.getProperty(this.name));
    }

    /**
     * Retrieves the current value of this property. If no value exists a {@link
     * MissingSystemPropertyException} rather than null will be thrown.
     */
    public String requiredPropertyValue() throws MissingSystemPropertyException {
        return this.propertyValue().orElseThrow(() -> new MissingSystemPropertyException("Unable to find value for=" + this.name));
    }

    /**
     * Sets or replaces the current value with the new value. A security manager may throw an
     * exception if the current user does not have permission.
     */
    public void set(final String value) {
        Objects.requireNonNull(value, "value");

        SystemPropertySecurityAction.setProperty(this.name, value);
    }

    /**
     * Clears the current system property value. A security manager may thrown an exception if the
     * current user does not have permission.
     */
    public String clear() {
        return SystemPropertySecurityAction.clearProperty(this.name);
    }

    // Object..........................................................................................................

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public boolean equals(final Object other) {
        return this == other ||
                (other instanceof SystemProperty && this.equals0((SystemProperty) other));
    }

    private boolean equals0(final SystemProperty other) {
        return this.name.equals(other.name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
