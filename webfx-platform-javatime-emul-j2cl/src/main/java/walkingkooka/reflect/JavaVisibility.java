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

import walkingkooka.visit.Visitable;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Objects;

/**
 * The visibility of a {@link Class}, {@link Constructor}, {@link Method} or {@link Field}.
 */
public enum JavaVisibility implements Visitable {
    PUBLIC(4, "public") {
        boolean testModifiers(final int modifiers) {
            return this.isPublic(modifiers);
        }

        @Override
        void accept(final JavaVisibilityVisitor visitor) {
            visitor.visitPublic();
        }
    },
    PROTECTED(3, "protected") {
        boolean testModifiers(final int modifiers) {
            return this.isProtected(modifiers);
        }

        @Override
        void accept(final JavaVisibilityVisitor visitor) {
            visitor.visitProtected();
        }
    },
    PACKAGE_PRIVATE(2, "") {
        boolean testModifiers(final int modifiers) {
            return !(this.isPublic(modifiers) ||
                    this.isProtected(modifiers) ||
                    this.isPrivate(modifiers));
        }

        @Override
        void accept(final JavaVisibilityVisitor visitor) {
            visitor.visitPackagePrivate();
        }
    },
    PRIVATE(1, "private") {
        boolean testModifiers(final int modifiers) {
            return this.isPrivate(modifiers);
        }

        @Override
        void accept(final JavaVisibilityVisitor visitor) {
            visitor.visitPrivate();
        }
    };

    JavaVisibility(final int priority,
                   final String javaKeyword) {
        this.priority = priority;
        this.javaKeyword = javaKeyword;
    }

    private final int priority;

    /**
     * The java keyword that notes this visibility in a java source file. For package private this will be empty string,
     * others are basically the name in lower case.
     */
    private final String javaKeyword;

    // reflect.............................................................................................................

    /**
     * Returns true if the {@link Class} visibility is the same or less.
     */
    public final boolean isOrLess(final JavaVisibility other) {
        return this.priority <= other.priority;
    }

    public final String javaKeyword() {
        return this.javaKeyword;
    }

    // factory..........................................................................................................

    public static JavaVisibility of(final Class<?> type) {
        Objects.requireNonNull(type, "type");
        return get0(type.getModifiers());
    }

    public static JavaVisibility of(final Member member) {
        Objects.requireNonNull(member, "member");
        return get0(member.getModifiers());
    }

    private static JavaVisibility get0(final int modifiers) {
        JavaVisibility result = null;

        for (JavaVisibility possible : values()) {
            if (possible.testModifiers(modifiers)) {
                result = possible;
                break;
            }
        }

        return result;
    }

    // helper...........................................................................................................

    abstract boolean testModifiers(final int modifiers);

    final boolean isPublic(final int modifiers) {
        return Modifier.isPublic(modifiers);
    }

    final boolean isProtected(final int modifiers) {
        return Modifier.isProtected(modifiers);
    }

    final boolean isPrivate(final int modifiers) {
        return Modifier.isPrivate(modifiers);
    }

    // JavaVisibilityVisitor............................................................................................

    abstract void accept(final JavaVisibilityVisitor visitor);
}
