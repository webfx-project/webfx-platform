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

package walkingkooka.j2cl.locale;

import javaemul.internal.annotations.GwtIncompatible;
import walkingkooka.NeverError;
import walkingkooka.collect.list.Lists;
import walkingkooka.collect.set.Sets;
import walkingkooka.predicate.Predicates;
import walkingkooka.text.CaseSensitivity;
import walkingkooka.text.CharSequences;
import walkingkooka.text.CharacterConstant;

import java.io.DataInput;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Represents a single language tag parsed into components. This class should not be referenced in code and is intended
 * for internal use by the javascript emulated java.util.Locale.
 */
public final class WalkingkookaLanguageTag {

    /**
     * Helper that accepts a comma separated list if filters, with support for wildcard which matches everything
     * and trailing wildcards.
     */
    public static Predicate<String> filter(final String filter) {
        CharSequences.failIfNullOrEmpty(filter, "filter");

        final String[] tokens = filter.split(",");
        if (tokens.length == 0) {
            throw new IllegalArgumentException("Filter empty");
        }

        Predicate<String> predicate = Predicates.never();
        String toString = filter;

        for (final String token : tokens) {
            if (token.equals("*")) {
                predicate = Predicates.always();
                toString = "*";
                break;
            }

            final int wildcard = token.indexOf("*");
            final int length = token.length();
            if (-1 != wildcard) {
                if (wildcard != length - 1) {
                    throw new IllegalArgumentException("Bad filter " + CharSequences.quoteAndEscape(token) + " only trailing wildcards supported.");
                }

                // EN* matches EN and EN* anything after.
                final String beforeWildcard = token.substring(0, token.length() - 1);
                predicate = predicate.or(Predicates.charSequenceStartsWith(CaseSensitivity.INSENSITIVE, beforeWildcard))
                        .or(Predicate.isEqual(beforeWildcard));
                continue;
            }

            predicate = predicate.or(token::equalsIgnoreCase);
        }

        return Predicates.customToString(predicate, toString);
    }

    public final static CharacterConstant SEPARATOR = CharacterConstant.with('-');

    /**
     * Returns a {@link Set} containing all {@link String languageTags} including their alternate forms.
     */
    @GwtIncompatible
    public static Set<String> all() {
        return all("*");
    }

    /**
     * The filter may have multiple patterns separated by csvs, each pattern can end in a wildcard or star.
     * An annotation processor could fetch the filter from a system property and use that to filter requested locales language tags
     * for final processing.
     */
    @GwtIncompatible
    public static Set<String> all(final String filter) {
        return all0(filter(filter));
    }

    @GwtIncompatible
    private static Set<String> all0(final Predicate<String> filter) {
        final Set<String> all = Sets.sorted();

        for(final java.util.Locale locale : java.util.Locale.getAvailableLocales()) {
            if(locale.getExtensionKeys().size() > 0) {
                continue;
            }

            final String languageTag = locale.toLanguageTag();
            if(false == filter.test(languageTag)) {
                continue;
            }

            all.add(languageTag);

            final String language = locale.getLanguage();
            if(language.equals("und")) {
                continue;
            }

            final String languageFixed = WalkingkookaLanguageTag.oldToNewLanguage(language);
            if(languageFixed.equals(language)) {
                continue;
            }

            if(WalkingkookaLanguageTag.isUnsupported(languageTag)) {
                continue;
            }

            final String alt = language + languageTag.substring(languageFixed.length());
            java.util.Locale.forLanguageTag(alt); // if alt is invalid this will fail.
            all.add(alt);
        }

        return Sets.readOnly(all);
    }

    /**
     * Returns all supported locales, this is equivalent of transforming {@link #all()}
     */
    /*@GwtIncompatible
    public static Set<Locale> locales() {
        return locales("*");
    }*/

    /**
     * Returns all supported locales filtered using the filter, this is equivalent of transforming {@link #all()}
     */
    /*@GwtIncompatible
    public static Set<Locale> locales(final String filter) {
        return LocaleAwareAnnotationProcessorTool.toLocales(all(filter));
    }*/

    /**
     * Complex locales that are ignored.
     */
    public static boolean isUnsupported(final String languageTag) {
        boolean ignored;

        switch (languageTag) {
            case "ja-JP-u-ca-japanese-x-lvariant-JP":
            case "th-TH-u-nu-thai-x-lvariant-TH":
                ignored = true;
                break;
            default:
                ignored = false;
                break;
        }

        return ignored;
    }

    public final static String LOCALE_COMPONENT_SEPARATOR = ",";

    /**
     * Locales are comma separated and their components are slash separated.
     */
    public static List<WalkingkookaLanguageTag> decode(final DataInput encoded) throws IOException  {
        final int count = encoded.readInt();
        final List<WalkingkookaLanguageTag> decoded = Lists.array();
        for(int i = 0; i < count; i++) {
            decoded.add(decode0(encoded.readUTF()));
        }
        return decoded;
    }

    public final static int TAG_INDEX = 0;
    public final static int LANGUAGE_INDEX = TAG_INDEX + 1; // 1
    public final static int COUNTRY_INDEX = LANGUAGE_INDEX + 1; // 2
    public final static int VARIANT_INDEX = COUNTRY_INDEX + 1; // 3
    public final static int SCRIPT_INDEX = VARIANT_INDEX + 1; // 4

    /**
     * Accepts a {@link String} with components separated by a slashes and locale component groupings separated by a commas.
     * Missing components default to an empty {@link String}.
     */
    private static WalkingkookaLanguageTag decode0(final String encoded) {
        final String[] components = encoded.split("\\" + LOCALE_COMPONENT_SEPARATOR);

        final String tag;
        final String language;
        final String country;
        final String variant;
        final String script;

        switch (components.length) {
            case 0:
                tag = "";
                language = "";
                country = "";
                variant = "";
                script = "";
                break;
            case 1:
                tag = components[TAG_INDEX];
                language = tag;
                country = "";
                variant = "";
                script = "";
                break;
            case 2:
                tag = components[TAG_INDEX];
                language = components[LANGUAGE_INDEX];
                country = "";
                variant = "";
                script = "";
                break;
            case 3:
                tag = components[TAG_INDEX];
                language = components[LANGUAGE_INDEX];
                country = components[COUNTRY_INDEX];
                variant = "";
                script = "";
                break;
            case 4:
                tag = components[TAG_INDEX];
                language = components[LANGUAGE_INDEX];
                country = components[COUNTRY_INDEX];
                variant = components[VARIANT_INDEX];
                script = "";
                break;
            case 5:
                tag = components[TAG_INDEX];
                language = components[LANGUAGE_INDEX];
                country = components[COUNTRY_INDEX];
                variant = components[VARIANT_INDEX];
                script = components[SCRIPT_INDEX];
                break;
            default:
                throw new NeverError("Bad encoding " + CharSequences.quote(encoded));
        }

        return with(tag,
                language,
                country,
                variant,
                script);
    }

    /**
     * Parses the source language tag into a {@link WalkingkookaLanguageTag}.
     */
    public static WalkingkookaLanguageTag parse(final String source) {
        final String language;
        final String script;
        final String country;
        final String variant;

        final String[] components = source.split("-");
        final int count = components.length;
        switch (count) {
            case 0:
                throw new NeverError("parse " + CharSequences.quote(source) + " split gave 0 tokens");
            case 1:
                language = components[0];
                script = "";
                country = "";
                variant = "";

                break;
            default:
                language = components[0];

                final String b = components[1];
                final String c;

                switch (count) {
                    case 2:
                        c = "";
                        break;
                    default:
                        // simplified handling not perfect.
                        c = components[count - 1];
                        break;
                }

                if (b.isEmpty()) {
                    country = "";
                    script = "";
                    variant = "";
                } else {
                    // false == isNumbers means ar-001 determines that the 001 is country and not script.
                    if (false == isNumbers(b) && b.equals(titleCase(b))) {
                        script = b;
                        country = c;
                        variant = "";
                    } else {
                        country = b;
                        variant = c;
                        script = "";
                    }
                }
                break;
        }

        return with(null,
                language,
                country,
                variant,
                script);
    }

    /**
     * This is used to match Locales such as ar-001 where 001 should be interpreted as the "country".
     * Rather than hardcode a test for is this 001 we test for numbers.
     */
    private static boolean isNumbers(final String text) {
        boolean numbers = true;
        for (final char c : text.toCharArray()) {
            numbers &= Character.isDigit(c);
        }
        return numbers;
    }

    private static String titleCase(final String text) {
        return text.isEmpty() ?
                "" :
                Character.toUpperCase(text.charAt(0)) + text.substring(1).toLowerCase();
    }

    /**
     * Makes the language lower case and substitutes new language codes with old to match JRE behaviour.
     */
    public static String newToOldLanguage(final String language) {
        final String lower = language.toLowerCase();

        final String fixed;

        switch (lower) {
            case "he":
                fixed = "iw";
                break;
            case "yi":
                fixed = "ji";
                break;
            case "id":
                fixed = "in";
                break;
            case "und":
                fixed = "";
                break;
            default:
                fixed = lower.toLowerCase();
                break;
        }
        return fixed;
    }

    /**
     * The inverse of {@link #newToOldLanguage(String).}
     */
    public static String oldToNewLanguage(final String language) {
        final String lower = language.toLowerCase();

        final String fixed;

        switch (lower) {
            case "iw":
                fixed = "he";
                break;
            case "ji":
                fixed = "yi";
                break;
            case "in":
                fixed = "id";
                break;
            case "":
                fixed = "und";
                break;
            default:
                fixed = lower.toLowerCase();
                break;
        }

        return fixed;
    }

    /**
     * Factory overload with tag, language, country and variant.
     */
    public static WalkingkookaLanguageTag with(final String tag,
                                               final String language,
                                               final String country,
                                               final String variant) {
        return with(tag,
                language,
                country,
                variant,
                "");
    }

    /**
     * Factory overload with tag, language, country, variant and script.
     */
    public static WalkingkookaLanguageTag with(final String tag,
                                               final String language,
                                               final String country,
                                               final String variant,
                                               final String script) {
        return new WalkingkookaLanguageTag(tag,
                language.toLowerCase(),
                country.toUpperCase(),
                variant,
                script);
    }

    /**
     * Trying to match the ctor ordering of the real {link java.util.Locale}.
     */
    private WalkingkookaLanguageTag(final String tag,
                                    final String language,
                                    final String country,
                                    final String variant,
                                    final String script) {
        super();

        this.language = language;
        this.country = country;
        this.script = script;
        this.variant = variant;
        this.tag = tag;
    }

    public String language() {
        return this.language;
    }

    private final String language;

    public String country() {
        return this.country;
    }

    private final String country;

    public String script() {
        return this.script;
    }

    private final String script;

    public String variant() {
        return this.variant;
    }

    private final String variant;

    public String toLanguageTag() {
        if (null == this.tag) {

            final String language = this.language();
            String tag = WalkingkookaLanguageTag.oldToNewLanguage(language);

            final String script = this.script();
            if (false == script.isEmpty()) {
                tag = tag + SEPARATOR + script;
            }

            final String country = this.country();
            if (false == CharSequences.isNullOrEmpty(country)) {
                tag = tag + SEPARATOR + country;

                final String variant = this.variant();
                if (false == CharSequences.isNullOrEmpty(variant)) {
                    tag = tag + SEPARATOR + variant;
                }
            }

            this.tag = tag;
        }
        return this.tag;
    }

    private String tag;

    /**
     * Intended internal helper that tries with the given {@link WalkingkookaLanguageTag} dropping script and variant and
     * then country until only the language is left or earlier success.
     */
    public <T> Optional<T> tryLookup(final Function<String, T> lookup) {
        final T result = lookup.apply(this.toLanguageTag());

        return null == result ?
                this.variant.length() + this.script.length() > 0 ? // if it has script or variant try without those
                        this.tryLookupWithoutScriptAndVariant(lookup) :
                        this.tryLookupWithoutCountry(lookup) : // try without country last possible try.
                Optional.of(result);
    }

    private <T> Optional<T> tryLookupWithoutScriptAndVariant(final Function<String, T> lookup) {
        final T result = lookup.apply(new WalkingkookaLanguageTag(null, this.language, this.country, "", "").toLanguageTag());
        return null == result ?
                this.tryLookupWithoutCountry(lookup) :
                Optional.of(result);
    }

    private <T> Optional<T> tryLookupWithoutCountry(final Function<String, T> lookup) {
        return Optional.ofNullable(lookup.apply(this.language));
    }

    // Object...........................................................................................................

    @Override
    public int hashCode() {
        return Objects.hash(this.country, this.language, this.variant, this.script);
    }

    @Override
    public boolean equals(final Object other) {
        return this == other || other instanceof WalkingkookaLanguageTag && this.equals0((WalkingkookaLanguageTag) other);
    }

    private boolean equals0(final WalkingkookaLanguageTag other) {
        return Objects.equals(this.country, other.country) &&
                Objects.equals(this.language, other.language) &&
                Objects.equals(this.variant, other.variant) &&
                Objects.equals(this.script, other.script) &&
                Objects.equals(this.toLanguageTag(), other.toLanguageTag());
    }

    @Override
    public String toString() {
        return this.toLanguageTag().replace('-', '_');
    }
}
