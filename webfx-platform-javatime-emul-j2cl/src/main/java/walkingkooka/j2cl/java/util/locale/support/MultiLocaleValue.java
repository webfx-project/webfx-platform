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

package walkingkooka.j2cl.java.util.locale.support;

import java.util.Collection;
import walkingkooka.j2cl.locale.Locale;
import java.util.Optional;
import java.util.function.Predicate;

public final class MultiLocaleValue<T> implements Predicate<Locale> {

    public static <T> T findValue(final Collection<MultiLocaleValue<T>> multi,
                                  final Locale locale) {
        return multi.stream()
                .filter(m -> m.test(locale))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Last predicate should always return true"))
                .value;
    }

    public static <T> MultiLocaleValue<T> with(final T value,
                                               final Predicate<Locale> locales,
                                               final boolean includeNorway) {
        return new MultiLocaleValue<>(value, locales, includeNorway);
    }

    private MultiLocaleValue(final T value,
                             final Predicate<Locale> locales,
                             final boolean doNorway) {
        super();
        this.value = value;
        this.locales = locales;
        this.doNorway = doNorway;
    }

    @Override
    public boolean test(final Locale locale) {
        // Optional.stream() not available in GWT/J2CL
        final Optional<Locale> alternatives = LocaleSupport.alternatives(locale, this.doNorway);
        return this.locales.test(locale) ||
                alternatives.isPresent() && this.locales.test(alternatives.get());
    }

    private final Predicate<Locale> locales;

    public final T value;

    private final boolean doNorway;

    @Override
    public String toString() {
        return this.value + " " + this.locales;
    }
}
