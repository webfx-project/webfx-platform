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

package walkingkooka.text;

import java.util.function.Predicate;

/**
 * An abstract {@link Predicate} that test any {@link CharSequence} that start with the {@link
 * CharSequence} ignoring the case.
 */
abstract class CaseSensitivityCharSequencePredicateTemplate<C extends CharSequence> implements Predicate<C> {

    /**
     * Package private to limit sub classing.
     */
    CaseSensitivityCharSequencePredicateTemplate(final CharSequence chars,
                                                 final CaseSensitivity sensitivity) {
        super();
        this.chars = chars;
        this.sensitivity = sensitivity;
    }

    final CharSequence chars;

    final CaseSensitivity sensitivity;

    // Object...........................................................................................................

    @Override
    public final int hashCode() {
        return this.sensitivity.hash(this.chars);
    }

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    @Override
    public final boolean equals(final Object other) {
        return (this == other) || (this.canBeEqual(other)
                && this.equals0((CaseSensitivityCharSequencePredicateTemplate<?>) other));
    }

    abstract boolean canBeEqual(Object other);

    private boolean equals0(final CaseSensitivityCharSequencePredicateTemplate<?> other) {
        final CaseSensitivity sensitivity = this.sensitivity;
        return sensitivity.equals(this.chars, other.chars) && sensitivity == other.sensitivity;
    }

    @Override
    public final String toString() {
        return this.sensitivity.toString(this.toStringPrefix(), this.chars);
    }

    abstract String toStringPrefix();
}
