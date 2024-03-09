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

import walkingkooka.collect.set.Sets;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public enum FieldAttributes {
    STATIC {
        boolean testModifiers(final int modifiers) {
            return Modifier.isStatic(modifiers);
        }
    },
    FINAL {
        boolean testModifiers(final int modifiers) {
            return Modifier.isFinal(modifiers);
        }
    },
    TRANSIENT {
        boolean testModifiers(final int modifiers) {
            return Modifier.isTransient(modifiers);
        }
    },
    VOLATILE {
        boolean testModifiers(final int modifiers) {
            return Modifier.isVolatile(modifiers);
        }
    };

    public final boolean is(final Field field) {
        Objects.requireNonNull(field, "field");
        return this.testModifiers(field.getModifiers());
    }

    abstract boolean testModifiers(final int modifiers);

    public static Set<FieldAttributes> get(final Field field) {
        Objects.requireNonNull(field, "field");

        Set<FieldAttributes> result = EnumSet.noneOf(FieldAttributes.class);

        final int modifiers = field.getModifiers();
        for (FieldAttributes possible : values()) {
            if (possible.testModifiers(modifiers)) {
                result.add(possible);
            }
        }

        return Sets.readOnly(result);
    }
}
