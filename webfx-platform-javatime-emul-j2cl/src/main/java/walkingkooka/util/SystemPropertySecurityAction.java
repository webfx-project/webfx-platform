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

import walkingkooka.reflect.StaticHelper;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.function.Supplier;

/**
 * Internal class intended to be replaced by an alternative that does not use {@link AccessController} for javascript(J2CL).
 */
final class SystemPropertySecurityAction implements StaticHelper {

    static String clearProperty(final String property) {
        return execute(() -> System.clearProperty(property));
    }

    static String getProperty(final String property) {
        return execute(() -> System.getProperty(property));
    }

    static void setProperty(final String property, final String value) {
        execute(() -> System.setProperty(property, value));
    }

    static <T> T execute(final Supplier<T> action) {
        return execute0(action::get);
    }

    private static <T> T execute0(final PrivilegedAction<T> action) {
        return AccessController.doPrivileged(action);
    }
    /**
     * Stop creation
     */
    private SystemPropertySecurityAction() {
        throw new UnsupportedOperationException();
    }
}
