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

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public enum MethodAttributes {
    ABSTRACT {
        boolean test(final Method method) {
            return Modifier.isAbstract(method.getModifiers());
        }
    },
    BRIDGE {
        boolean test(final Method method) {
            return method.isBridge();
        }
    },
    FINAL {
        boolean test(final Method method) {
            return Modifier.isFinal(method.getModifiers());
        }
    },
    NATIVE {
        boolean test(final Method method) {
            return Modifier.isNative(method.getModifiers());
        }
    },
    STATIC {
        boolean test(final Method method) {
            return Modifier.isStatic(method.getModifiers());
        }
    },
    SYNTHETIC {
        boolean test(final Method method) {
            return false == Arrays.equals(method.getGenericParameterTypes(), method.getParameterTypes()) ||
                    method.isBridge();

        }
    };

    public final boolean is(final Method method) {
        Objects.requireNonNull(method, "method");
        return this.test(method);
    }

    abstract boolean test(final Method method);

    public static Set<MethodAttributes> get(final Method method) {
        Objects.requireNonNull(method, "method");

        Set<MethodAttributes> result = EnumSet.noneOf(MethodAttributes.class);

        for (MethodAttributes possible : values()) {
            if (possible.test(method)) {
                result.add(possible);
            }
        }

        return Sets.readOnly(result);
    }
}
