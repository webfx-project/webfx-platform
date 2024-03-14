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

package walkingkooka.compare;

import walkingkooka.predicate.character.CharPredicate;
import walkingkooka.reflect.PublicStaticHelper;

import java.util.Comparator;

final public class Comparators implements PublicStaticHelper {
    // constants
    public final static int LESS = -1;

    public final static int EQUAL = 0;

    public final static int MORE = 1;

    /**
     * {@see FakeComparator}
     */
    public static <T> Comparator<T> fake() {
        return FakeComparator.create();
    }

    /**
     * {@see NormalizingCharSequenceComparator}
     */
    public static <S extends CharSequence> Comparator<S> normalizing(final CharPredicate predicate) {
        return NormalizingCharSequenceComparator.with(predicate);
    }

    /**
     * Returns an integer that contains the sign of the given int value.
     */
    @SuppressWarnings("UseCompareMethod")
    public static int normalize(final int value) {
        return 0 == value ? 0 : value < 0 ? -1 : +1;
    }

    /**
     * Returns an integer that contains the sign of the given long value.
     */
    public static int normalize(final long value) {
        return 0 == value ? 0 : value < 0 ? -1 : +1;
    }

    /**
     * Stop creation
     */
    private Comparators() {
        throw new UnsupportedOperationException();
    }
}
