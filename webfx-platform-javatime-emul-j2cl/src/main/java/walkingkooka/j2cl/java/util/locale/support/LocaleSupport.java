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

import javaemul.internal.annotations.GwtIncompatible;
import walkingkooka.collect.set.Sets;
import walkingkooka.j2cl.locale.WalkingkookaLanguageTag;
import walkingkooka.reflect.PublicStaticHelper;
import walkingkooka.text.printer.IndentingPrinter;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import walkingkooka.j2cl.locale.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public final class LocaleSupport implements PublicStaticHelper {

    public static Locale read(final DataInput data) throws IOException {
        return Locale.forLanguageTag(data.readUTF());
    }

    public static Set<Locale> readLocales(final DataInput data) throws IOException {
        final int count = data.readInt();
        final Set<Locale> locales = Sets.ordered();
        for (int i = 0; i < count; i++) {
            locales.add(read(data));
        }

        return locales;
    }

    public static void write(final Locale locale,
                             final DataOutput data) throws IOException {
        data.writeUTF(locale.toLanguageTag());
    }

    @GwtIncompatible
    public static void generateLocales(final Set<Locale> locales,
                                       final DataOutput data,
                                       final IndentingPrinter comments) throws IOException {
        generateLocales(locales,
                data,
                "locales",
                comments);
    }

    @GwtIncompatible
    public static void generateLocales(final Set<Locale> locales,
                                       final DataOutput data,
                                       final String label,
                                       final IndentingPrinter comments) throws IOException {
        comments.lineStart();
        comments.print(label + "=" + locales.stream()
                .map(Locale::toLanguageTag)
                .collect(Collectors.joining(", ")));

        writeLocales(locales, data);
    }

    public static void writeLocales(final Set<Locale> locales,
                                    final DataOutput data) throws IOException {
        data.writeInt(locales.size());

        for (final Locale locale : locales) {
            write(locale, data);
        }
    }

    /**
     * Returns the alternate form for the given {@link Locale} if one would exist in a JVM and has been included by the relevant provider.
     * Examples include:
     * <ol>
     * <li>HE and IW</li>
     * <li>"no_NO_NY" and "nn-NO"</li>
     * </ol>
     * This includes smarts so unavailable alternative locales are silent ignores.
     */
    public static Optional<Locale> alternatives(final Locale locale,
                                                final boolean includeNorway) {
        Objects.requireNonNull(locale, "locale");

        final Optional<Locale> alternative;

        switch (locale.toString()) {
            case "nn_NO":
                alternative = includeNorway ?
                        tryLocaleForLanguageTag("no-no-ny") :
                        Optional.empty();
                break;
            case "no_NO_NY":
                alternative = includeNorway ?
                        tryLocaleForLanguageTag("nn-no") :
                        Optional.empty();
                break;
            default:
                // might be one of the other specials like HE or IW.
                final String language = locale.getLanguage();
                final String newLanguage = WalkingkookaLanguageTag.oldToNewLanguage(language);
                if (false == language.isEmpty() && false == language.equals(newLanguage)) {
                    alternative = tryLocaleForLanguageTag(newLanguage + locale.toLanguageTag().substring(language.length()));// replace $oldLanguage with $newLanguage
                } else {
                    alternative = Optional.empty();
                }
                break;
        }

        return alternative;
    }

    public final static boolean INCLUDE_NORWAY = true;
    public final static boolean IGNORE_NORWAY = false;

    private static Optional<Locale> tryLocaleForLanguageTag(final String tag) {
        Optional<Locale> alternative;
        try {
            alternative = Optional.of(Locale.forLanguageTag(tag));
        } catch (final IllegalArgumentException unknownLocale) {
            alternative = Optional.empty();
        }
        return alternative;
    }

    private LocaleSupport() {
        throw new UnsupportedOperationException();
    }
}
