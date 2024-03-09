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
package walkingkooka.j2cl.java.util.currency;

import walkingkooka.collect.list.Lists;
import walkingkooka.collect.map.Maps;
import walkingkooka.collect.set.Sets;
import walkingkooka.j2cl.java.io.string.StringDataInputDataOutput;
import walkingkooka.j2cl.java.util.currency.generated.CurrencyProvider;
import walkingkooka.j2cl.java.util.locale.support.LocaleSupport;
import walkingkooka.j2cl.java.util.locale.support.MultiLocaleValue;
import walkingkooka.j2cl.locale.Locale;
import walkingkooka.j2cl.locale.LocaleAware;
import walkingkooka.predicate.Predicates;
import walkingkooka.text.CharSequences;

import java.io.DataInput;
import java.io.IOException;
import java.util.*;

@LocaleAware
public final class Currency {

    public static Set<Currency> getAvailableCurrencies() {
        if (null == AVAILABLE_CURRENCIES) {
            final Set<Currency> all = Sets.ordered();
            all.addAll(CODE_TO_CURRENCY.values());
            AVAILABLE_CURRENCIES = Sets.readOnly(all);
        }
        return AVAILABLE_CURRENCIES;
    }

    private static Set<Currency> AVAILABLE_CURRENCIES;

    /**
     * Performs a simple lookup of the currency code to find a {@link Currency} throwing a {@link IllegalArgumentException}
     * when not found.
     */
    public static Currency getInstance(final String currencyCode) {
        Objects.requireNonNull(currencyCode, "currencyCode");

        final Currency currency = CODE_TO_CURRENCY.get(currencyCode);
        if (null == currency) {
            throw new IllegalArgumentException("Invalid currency code " + CharSequences.quote(currencyCode));
        }
        return currency;
    }

    /**
     * Performs a simple lookup of a {@link Locale} using its {@link Locale#toLanguageTag()} with a special case for nn-NO
     * throwing a {@link IllegalArgumentException} when not found.
     */
    public static Currency getInstance(final Locale locale) {
        checkLocale(locale);

        final String languageTag = locale.toLanguageTag();

        Currency currency = LOCALE_TO_CURRENCY.get(languageTag.equals("nn-NO") ?
                "no-NO" :
                languageTag);
        if (null == currency) {
            final Optional<Locale> alternative = LocaleSupport.alternatives(locale,
                    LocaleSupport.IGNORE_NORWAY); // the old and new no related locales give different symbols
            if (alternative.isPresent()) {
                currency = LOCALE_TO_CURRENCY.get(alternative.get().toLanguageTag());
            }
        }

        if (null == currency) {
            throw new IllegalArgumentException("No currency available for " + CharSequences.quote(languageTag) + " " + locale);
        }

        return currency;
    }

    private final static Map<String, Currency> LOCALE_TO_CURRENCY = Maps.ordered();

    private static void checkLocale(final Locale locale) {
        Objects.requireNonNull(locale, "locale");
    }

    /**
     * Pre-populated table of code to {@link Currency}.
     */
    private final static Map<String, Currency> CODE_TO_CURRENCY = Maps.sorted();

     // Consumes {@link CurrencyProvider#DATA} creating a {@link Currency} for each record.
    static {
        try {
            register(StringDataInputDataOutput.input(CurrencyProvider.DATA));
        } catch (final IOException cause) {
            throw new Error(cause);
        }
    }

    /**
     * Intended to only be called by the static init above. A test exists to verify the {@link DataInput} is consumed
     * and further operations will fail with an {@link java.io.EOFException}.
     */
    static void register(final DataInput data) throws IOException {
        final int count = data.readInt();

        for (int i = 0; i < count; i++) {
            final String currencyCode = data.readUTF();
            final int defaultFractionDigits = data.readInt();
            final int numericCode = data.readInt();
            final String defaultSymbol = data.readUTF();
            final Set<Locale> locales = LocaleSupport.readLocales(data);

            final List<MultiLocaleValue<String>> symbolToLocales = readSymbolToLocales(data);
            symbolToLocales.add(MultiLocaleValue.with(defaultSymbol, Predicates.always(), LocaleSupport.IGNORE_NORWAY));

            new Currency(currencyCode,
                    defaultFractionDigits,
                    numericCode,
                    defaultSymbol,
                    locales,
                    symbolToLocales);
        }
    }

    private static List<MultiLocaleValue<String>> readSymbolToLocales(final DataInput data) throws IOException {
        final int symbolToLocaleCount = data.readInt();
        final List<MultiLocaleValue<String>> symbolToLocales = Lists.array();

        for (int i = 0; i < symbolToLocaleCount; i++) {
            final String symbol = data.readUTF();

            symbolToLocales.add(MultiLocaleValue.with(symbol,
                    LocaleSupport.readLocales(data)::contains,
                    LocaleSupport.IGNORE_NORWAY));
        }

        return symbolToLocales;
    }

    /**
     * Private ctor, called only by static initializer.
     */
    private Currency(final String currencyCode,
                     final int defaultFractionDigits,
                     final int numericCode,
                     final String defaultSymbol,
                     final Set<Locale> locales,
                     final List<MultiLocaleValue<String>> symbolToLocales) {
        super();
        this.currencyCode = currencyCode;
        this.defaultFractionDigits = defaultFractionDigits;
        this.numericCode = numericCode;
        this.defaultSymbol = defaultSymbol;
        this.symbolToLocales = symbolToLocales;

        CODE_TO_CURRENCY.put(currencyCode, this);

        for (final Locale locale : locales) {
            LOCALE_TO_CURRENCY.put(locale.toLanguageTag(), this);
        }
    }

    /**
     * Default the currency symbol for the default {@link Locale}.
     */
    public String getSymbol() {
        return getSymbol(Locale.getDefault());
    }

    /**
     * If the Locale has a 2 character country code search for that, defaulting to the {@link #defaultSymbol}, otherwise
     * return the {@link #currencyCode}.
     */
    public String getSymbol(final Locale locale) {
        checkLocale(locale);

        return locale.toLanguageTag().equals("und") ?
                this.defaultSymbol :
                MultiLocaleValue.findValue(this.symbolToLocales, locale);
    }

    private final List<MultiLocaleValue<String>> symbolToLocales;

    private final String defaultSymbol;

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    private final String currencyCode;

    public int getDefaultFractionDigits() {
        return this.defaultFractionDigits;
    }

    private final int defaultFractionDigits;

    public int getNumericCode() {
        return this.numericCode;
    }

    public String getNumericCodeAsString() {
        final int code = this.numericCode;
        return code < 100 ?
                code < 10 ?
                        "00" + code :
                        "0" + code :
                String.valueOf(code);
    }

    private final int numericCode;

    // Object...........................................................................................................

    @Override
    public String toString() {
        return this.currencyCode;
    }
}
