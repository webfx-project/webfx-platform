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
 * A {@link java.util.function.Predicate} that test any incoming {@link CharSequence} against a
 * {@link String} ignoring case.
 */
final class CaseSensitivityCharSequencePredicate<C extends CharSequence> extends CaseSensitivityCharSequencePredicateTemplate<C> {

    /**
     * Creates a {@link CaseSensitivityCharSequencePredicate}
     */
    static <C extends CharSequence> CaseSensitivityCharSequencePredicate<C> with(final C chars,
                                                                                 final CaseSensitivity sensitivity) {
        Objects.requireNonNull(chars, "chars");
        Objects.requireNonNull(sensitivity, "sensitivity");

        return new CaseSensitivityCharSequencePredicate<>(chars, sensitivity);
    }

    /**
     * Private constructor use static factory.
     */
    private CaseSensitivityCharSequencePredicate(final C chars, final CaseSensitivity sensitivity) {
        super(chars, sensitivity);
    }

    @Override
    public boolean test(final C value) {
        return this.sensitivity.equals(value, this.chars);
    }

    @Override
    boolean canBeEqual(final Object other) {
        return other instanceof CaseSensitivityCharSequencePredicate;
    }

    @Override
    String toStringPrefix() {
        return "";
    }
}
