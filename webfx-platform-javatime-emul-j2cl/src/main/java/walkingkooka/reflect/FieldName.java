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

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * A legal field name.
 */
public final class FieldName extends JavaName<FieldName> {

    /**
     * Factory that creates a {@link FieldName} given a {@link Field}
     */
    public static FieldName from(final Field field) {
        Objects.requireNonNull(field, "field");
        return new FieldName(field.getName());
    }

    /**
     * Factory that creates a {@link FieldName} after verifying a {@link String}.
     */
    public static FieldName with(final String name) {
        check(name);
        return new FieldName(name);
    }

    /**
     * Private ctor use factory.
     */
    private FieldName(final String name) {
        super(name);
    }

    // Object...........................................................................................................

    @Override
    boolean canBeEqual(final Object other) {
        return other instanceof FieldName;
    }

    // Comparable ......................................................................................................

    @Override
    public int compareTo(final FieldName other) {
        return this.compareTo0(other);
    }
}
