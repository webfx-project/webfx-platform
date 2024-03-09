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

package walkingkooka;

import walkingkooka.reflect.PublicStaticHelper;

/**
 * A collect of utilities relating to casting or narrowing of value to something with less
 * precision.
 */
final public class Cast implements PublicStaticHelper {

    /**
     * A simple way to perform a casts which can be potentially verbose when generics are involved.
     */
    @SuppressWarnings("unchecked")
    public static <T> T to(final Object object) throws ClassCastException {
        return (T) object;
    }

    /**
     * Stop creation
     */
    private Cast() {
        throw new UnsupportedOperationException();
    }
}
