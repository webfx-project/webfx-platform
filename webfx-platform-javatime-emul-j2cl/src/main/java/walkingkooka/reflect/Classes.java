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

import java.util.Objects;
import java.util.Optional;

final public class Classes implements PublicStaticHelper {

    /**
     * Returns the primitive {@link Class} for the given {@link Class}.
     */
    public static Optional<Class<?>> primitive(final Class<?> classs) {
        Objects.requireNonNull(classs, "class");

        Class<?> result = null;
        do {
            if (Boolean.class == classs) {
                result = Boolean.TYPE;
                break;
            }
            if (Byte.class == classs) {
                result = Byte.TYPE;
                break;
            }
            if (Character.class == classs) {
                result = Character.TYPE;
                break;
            }
            if (Double.class == classs) {
                result = Double.TYPE;
                break;
            }
            if (Float.class == classs) {
                result = Float.TYPE;
                break;
            }
            if (Integer.class == classs) {
                result = Integer.TYPE;
                break;
            }
            if (Long.class == classs) {
                result = Long.TYPE;
                break;
            }
            if (Short.class == classs) {
                result = Short.TYPE;
                break;
            }
        } while (false);

        return Optional.ofNullable(result);
    }

    /**
     * Returns the primitive {@link Class} for the given {@link Class}.
     */
    public static Optional<Class<?>> wrapper(final Class<?> classs) {
        Objects.requireNonNull(classs, "class");

        Class<?> result = null;
        do {
            if (Boolean.TYPE == classs) {
                result = Boolean.class;
                break;
            }
            if (Byte.TYPE == classs) {
                result = Byte.class;
                break;
            }
            if (Character.TYPE == classs) {
                result = Character.class;
                break;
            }
            if (Double.TYPE == classs) {
                result = Double.class;
                break;
            }
            if (Float.TYPE == classs) {
                result = Float.class;
                break;
            }
            if (Integer.TYPE == classs) {
                result = Integer.class;
                break;
            }
            if (Long.TYPE == classs) {
                result = Long.class;
                break;
            }
            if (Short.TYPE == classs) {
                result = Short.class;
                break;
            }
        } while (false);

        return Optional.ofNullable(result);
    }

    /**
     * Stop creation
     */
    private Classes() {
        throw new UnsupportedOperationException();
    }
}
