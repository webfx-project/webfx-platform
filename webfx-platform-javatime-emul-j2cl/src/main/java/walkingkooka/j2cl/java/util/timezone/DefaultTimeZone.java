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

package walkingkooka.j2cl.java.util.timezone;

import walkingkooka.collect.map.Maps;
import walkingkooka.j2cl.java.util.locale.support.MultiLocaleValue;
import walkingkooka.j2cl.java.util.timezone.support.TimeZoneProviderReader;
import walkingkooka.j2cl.java.util.timezone.zonerulesreader.ZoneRulesReader;
import walkingkooka.j2cl.locale.HasTimeZoneCalendar;
import walkingkooka.j2cl.locale.LocaleAware;
import walkingkooka.j2cl.locale.TimeZoneCalendar;
import walkingkooka.j2cl.locale.TimeZoneDisplay;
import walkingkooka.j2cl.locale.TimeZoneOffsetAndDaylightSavings;

import java.io.DataInput;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import walkingkooka.j2cl.locale.Locale;
import java.util.Map;

/**
 * The default {@link TimeZone} instances created from the data by {@link walkingkooka.j2cl.java.util.timezone.support.TimeZoneProvider#DATA}
 */
@LocaleAware
final class DefaultTimeZone extends TimeZone implements HasTimeZoneCalendar {

    /**
     * TimeZoneId to {@link DefaultTimeZone} instances.
     */
    private static Map<String, DefaultTimeZone> ZONEID_TO_DEFAULT_TIME_ZONE;

    /**
     * Intended to only be called by the static init above. A test exists to verify the {@link DataInput} is consumed
     * and further operations will fail with an {@link java.io.EOFException}.
     */
    static void register() {
        ZONEID_TO_DEFAULT_TIME_ZONE = Maps.sorted(); // field is null on travis w/ openjdk9.

        new TimeZoneProviderReader<TimeZoneOffsetAndDaylightSavings>() {

            @Override
            public TimeZoneOffsetAndDaylightSavings readZoneRules(final DataInput data) throws IOException {
                return ZoneRulesReader.readZoneRules(data);
            }

            @Override
            public void record(final String id,
                               final int rawOffset,
                               final TimeZoneOffsetAndDaylightSavings zoneRules,
                               final List<MultiLocaleValue<TimeZoneCalendar>> timeZoneCalendar,
                               final List<MultiLocaleValue<TimeZoneDisplay>> allDisplayLocales) {
                new DefaultTimeZone(id,
                        rawOffset,
                        zoneRules,
                        timeZoneCalendar,
                        allDisplayLocales);
            }
        }.read(walkingkooka.j2cl.java.util.timezone.generated.TimeZoneProvider.DATA);
    }

    /**
     * Gets the {@code TimeZone} with the specified ID.
     *
     * @param name a time zone string ID.
     * @return the {@code TimeZone} with the specified ID or null if no {@code TimeZone} with
     * the specified ID exists.
     */
    static DefaultTimeZone getDefaultTimeZone(final String name) {
        return ZONEID_TO_DEFAULT_TIME_ZONE.get(name);
    }

    /**
     * Gets the available time zone IDs. Any one of these IDs can be passed to
     * {@code get()} to create the corresponding {@code TimeZone} instance.
     *
     * @return an array of time zone ID strings.
     */
    static String[] getDefaultTimeZoneAvailableIDs() {
        return ZONEID_TO_DEFAULT_TIME_ZONE.keySet()
                .stream()
                .toArray(String[]::new);
    }

    /**
     * Gets the available time zone IDs which match the specified offset from
     * GMT. Any one of these IDs can be passed to {@code get()} to create the corresponding
     * {@code TimeZone} instance.
     *
     * @param offset the offset from GMT in milliseconds.
     * @return an array of time zone ID strings.
     */
    static synchronized String[] getDefaultTimeZoneAvailableIDsWithRawOffset(final int offset) {
        return ZONEID_TO_DEFAULT_TIME_ZONE.values()
                .stream()
                .filter(d -> d.getRawOffset() == offset)
                .map(DefaultTimeZone::getID)
                .toArray(String[]::new);
    }

    /**
     * Constructor only called by {@link #register()}.
     */
    private DefaultTimeZone(final String id,
                            final int rawOffset,
                            final TimeZoneOffsetAndDaylightSavings zoneRules,
                            final List<MultiLocaleValue<TimeZoneCalendar>> timeZoneCalendar,
                            final List<MultiLocaleValue<TimeZoneDisplay>> allDisplayLocales) {
        super(id, rawOffset);
        this.zoneRules = zoneRules;
        this.timeZoneCalendar = timeZoneCalendar;
        this.allDisplayLocales = allDisplayLocales;

        ZONEID_TO_DEFAULT_TIME_ZONE.put(id, this);
    }

    @Override
    public int getOffset(final int era,
                         final int year,
                         final int month,
                         final int day,
                         final int dayOfWeek,
                         final int time) {
        return this.zoneRules.getOffset(era,
                year,
                month,
                day,
                dayOfWeek,
                time);
    }

    @Override
    public boolean inDaylightTime(final Date time) {
        return this.zoneRules.inDaylightTime(time);
    }

    @Override
    public boolean observesDaylightTime() {
        return this.zoneRules.observesDaylightTime();
    }

    @Override
    public boolean useDaylightTime() {
        return this.zoneRules.useDaylightTime();
    }

    private final TimeZoneOffsetAndDaylightSavings zoneRules;

    // HasTimeZoneCalendar..............................................................................................

    /**
     * This is only intended to be consumed by something emulating java.util.Calendar instances providing the firstDayOfWeek and
     * minimalDaysInFirstWeek properties.
     */
    public TimeZoneCalendar timeZoneCalendar(final Locale locale) {
        return MultiLocaleValue.findValue(this.timeZoneCalendar, locale);
    }

    private final List<MultiLocaleValue<TimeZoneCalendar>> timeZoneCalendar;

    @Override
    public String getDisplayName(final boolean daylightTime,
                                 final int style,
                                 final Locale locale) {
        final TimeZoneDisplay display = MultiLocaleValue.findValue(this.allDisplayLocales, locale);
        final String text;

        switch (style) {
            case SHORT:
                text = daylightTime ? display.shortDisplayNameDaylight : display.shortDisplayName;
                break;
            case LONG: // if not SHORT must be LONG.
                text = daylightTime ? display.longDisplayNameDaylight : display.longDisplayName;
                break;
            default:
                throw new IllegalArgumentException("Invalid style=" + style);
        }

        return text;
    }

    private final List<MultiLocaleValue<TimeZoneDisplay>> allDisplayLocales;

    // Object...........................................................................................................

    /**
     * {@link DefaultTimeZone} is immutable so clone always returns this.
     */
    @Override
    public TimeZone clone() {
        return this;
    }

    @Override
    public String toString() {
        return this.getID();
    }
}
