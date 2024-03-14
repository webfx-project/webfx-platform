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

package walkingkooka.predicate;

import walkingkooka.Cast;
import walkingkooka.reflect.PublicStaticHelper;

import java.util.Objects;

final public class Notables implements PublicStaticHelper {

    /**
     * A helper that inverts the given {@link Object object} which it assumes is {@link Notable}.
     * Note because of the nature of casting this is an unsafe operation and may throw {@link
     * ClassCastException} if the incompatible inputs are passed.
     */
    public static <T> T not(final Object notable) {
        Objects.requireNonNull(notable, "notable");

        return Cast.to(((Notable<?>) notable).negate());
    }

    /**
     * If the {@link Object} is {@link Notable} it returns its Notted otherwise returns
     * <code>null</code>
     */
    public static <T> T maybeNotable(final Object maybe) {
        return maybe instanceof Notable ? Notables.not(maybe) : null;
    }

    /**
     * Stop creation
     */
    private Notables() {
        throw new UnsupportedOperationException();
    }
}
