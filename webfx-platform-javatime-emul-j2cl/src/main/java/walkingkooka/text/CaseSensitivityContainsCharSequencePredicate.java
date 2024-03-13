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

import java.util.Objects;

/**
 * {@link java.util.function.Predicate} that test any {@link CharSequence} that contains a {@link
 * CharSequence} maybe ignoring the case.
 */
final class CaseSensitivityContainsCharSequencePredicate<C extends CharSequence> extends CaseSensitivityCharSequencePredicateTemplate<C> {

    /**
     * Creates a {@link CaseSensitivityContainsCharSequencePredicate}
     */
    static <C extends CharSequence> CaseSensitivityContainsCharSequencePredicate<C> with(
            final C contains, final CaseSensitivity sensitivity) {
        CharSequences.failIfNullOrEmpty(contains, "contains");
        Objects.requireNonNull(sensitivity, "sensitivity");

        return new CaseSensitivityContainsCharSequencePredicate<>(contains, sensitivity);
    }

    /**
     * Private constructor use static factory.
     */
    private CaseSensitivityContainsCharSequencePredicate(final C contains,
                                                         final CaseSensitivity sensitivity) {
        super(contains, sensitivity);
    }

    @Override
    public boolean test(final C value) {
        return this.sensitivity.contains(value, this.chars);
    }

    @Override
    boolean canBeEqual(final Object other) {
        return other instanceof CaseSensitivityContainsCharSequencePredicate;
    }

    @Override
    String toStringPrefix() {
        return "contains ";
    }
}
