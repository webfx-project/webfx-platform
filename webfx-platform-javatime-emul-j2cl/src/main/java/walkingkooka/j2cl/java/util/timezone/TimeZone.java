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

import walkingkooka.j2cl.java.util.timezone.generated.TimeZoneProvider;
import walkingkooka.j2cl.locale.Locale;
import walkingkooka.text.CharSequences;

import java.util.Date;
import java.util.Objects;

public abstract class TimeZone {

    // available ids....................................................................................................

    /**
     * Gets the available time zone IDs. Any one of these IDs can be passed to
     * {@code get()} to create the corresponding {@code TimeZone} instance.
     *
     * @return an array of time zone ID strings.
     */
    public static synchronized String[] getAvailableIDs() {
        return DefaultTimeZone.getDefaultTimeZoneAvailableIDs();
    }

    /**
     * Gets the available time zone IDs which match the specified offset from
     * GMT. Any one of these IDs can be passed to {@code get()} to create the corresponding
     * {@code TimeZone} instance.
     *
     * @param offset the offset from GMT in milliseconds.
     * @return an array of time zone ID strings.
     */
    public static synchronized String[] getAvailableIDs(final int offset) {
        return DefaultTimeZone.getDefaultTimeZoneAvailableIDsWithRawOffset(offset);
    }

    /**
     * Gets the {@code TimeZone} with the specified ID.
     *
     * @param name a time zone string ID.
     * @return the {@code TimeZone} with the specified ID or null if no {@code TimeZone} with
     * the specified ID exists.
     */
    public static TimeZone getTimeZone(final String name) {
        return DefaultTimeZone.getDefaultTimeZone(name);
    }

    // default .........................................................................................................

    /**
     * Gets the default time zone.
     *
     * @return the default time zone.
     */
    public static synchronized TimeZone getDefault() {
        if (null == DEFAULT) {
            DEFAULT = getTimeZone(TimeZoneProvider.DEFAULT_TIMEZONE);
        }
        return DEFAULT;
    }

    /**
     * Sets the default time zone. If passed {@code null}, then the next
     * time {@link #getDefault} is called, the default time zone will be
     * determined. This behavior is slightly different than the canonical
     * description of this method, but it follows the spirit of it.
     *
     * @param timezone a {@code TimeZone} object.
     */
    public static synchronized void setDefault(final TimeZone timezone) {
        Objects.requireNonNull(timezone, "timezone");

        DEFAULT = timezone;
    }

    // @VisibleForTesting
    static TimeZone DEFAULT;

    // ctor.............................................................................................................

    TimeZone(final String id,
             final int rawOffset) {
        super();
        this.id = id;
        this.rawOffset = rawOffset;
    }


    /**
     * Gets the ID of this {@code TimeZone}.
     *
     * @return the time zone ID string.
     */
    public final String getID() {
        return id;
    }

    final String id;

    /**
     * Gets the daylight savings offset in milliseconds for this {@code TimeZone}.
     * <p>
     * This implementation returns 3600000 (1 hour), or 0 if the time zone does
     * not observe daylight savings.
     * <p>
     * Subclasses may override to return daylight savings values other than 1
     * hour.
     * <p>
     *
     * @return the daylight savings offset in milliseconds if this {@code TimeZone}
     * observes daylight savings, zero otherwise.
     */
    public final int getDSTSavings() {
        return this.useDaylightTime() ?
                ONE_HOUR :
                0;
    }

    private static final int HALF_HOUR = 1800000;
    private static final int ONE_HOUR = HALF_HOUR * 2;

    /**
     * Gets the offset from GMT of this {@code TimeZone} for the specified date. The
     * offset includes daylight savings time if the specified date is within the
     * daylight savings time period.
     *
     * @param time the date in milliseconds since January 1, 1970 00:00:00 GMT
     * @return the offset from GMT in milliseconds.
     */
    public final int getOffset(final long time) {
        final int offset = this.getRawOffset();

        return this.inDaylightTime(new Date(time)) ?
                offset + getDSTSavings() :
                offset;
    }

    /**
     * Gets the offset from GMT of this {@code TimeZone} for the specified date and
     * time. The offset includes daylight savings time if the specified date and
     * time are within the daylight savings time period.
     *
     * @param era       the {@code GregorianCalendar} era, either {@code GregorianCalendar.BC} or
     *                  {@code GregorianCalendar.AD}.
     * @param year      the year.
     * @param month     the {@code Calendar} month.
     * @param day       the day of the month.
     * @param dayOfWeek the {@code Calendar} day of the week.
     * @param time      the time of day in milliseconds.
     * @return the offset from GMT in milliseconds.
     */
    abstract public int getOffset(int era, int year, int month, int day,
                                  int dayOfWeek, int time);

    /**
     * Gets the offset for standard time from GMT for this {@code TimeZone}.
     *
     * @return the offset from GMT in milliseconds.
     */
    public final int getRawOffset() {
        return this.rawOffset;
    }

    /**
     * The raw offset.
     */
    final int rawOffset;

    /**
     * Returns whether the specified {@code TimeZone} has the same raw offset as this
     * {@code TimeZone}.
     *
     * @param other a {@code TimeZone}.
     * @return {@code true} when the {@code TimeZone} have the same raw offset, {@code false}
     * otherwise.
     */
    public final boolean hasSameRules(final TimeZone other) {
        return null != other && this.getRawOffset() == other.getRawOffset();
    }

    /**
     * Returns whether the specified {@code Date} is in the daylight savings time period for
     * this {@code TimeZone}.
     *
     * @param time a {@code Date}.
     * @return {@code true} when the {@code Date} is in the daylight savings time period, {@code false}
     * otherwise.
     */
    abstract public boolean inDaylightTime(Date time);

    abstract public boolean observesDaylightTime();

    /**
     * Returns whether this {@code TimeZone} has a daylight savings time period.
     *
     * @return {@code true} if this {@code TimeZone} has a daylight savings time period, {@code false}
     * otherwise.
     */
    abstract public boolean useDaylightTime();

    /**
     * The SHORT display name style.
     */
    public static final int SHORT = 0;

    /**
     * The LONG display name style.
     */
    public static final int LONG = 1;

    /**
     * Gets the LONG name for this {@code TimeZone} for the default {@code Locale} in standard
     * time. If the name is not available, the result is in the format
     * {@code GMT[+-]hh:mm}.
     *
     * @return the {@code TimeZone} name.
     */
    public final String getDisplayName() {
        return getDisplayName(false, LONG, Locale.getDefault());
    }

    /**
     * Gets the LONG name for this {@code TimeZone} for the specified {@code Locale} in standard
     * time. If the name is not available, the result is in the format
     * {@code GMT[+-]hh:mm}.
     *
     * @param locale the {@code Locale}.
     * @return the {@code TimeZone} name.
     */
    public final String getDisplayName(Locale locale) {
        return getDisplayName(false, LONG, locale);
    }

    /**
     * Gets the specified style of name ({@code LONG} or {@code SHORT}) for this {@code TimeZone} for
     * the default {@code Locale} in either standard or daylight time as specified. If
     * the name is not available, the result is in the format {@code GMT[+-]hh:mm}.
     *
     * @param daylightTime {@code true} for daylight time, {@code false} for standard
     *                     time.
     * @param style        either {@code LONG} or {@code SHORT}.
     * @return the {@code TimeZone} name.
     */
    public final String getDisplayName(boolean daylightTime, int style) {
        return getDisplayName(daylightTime, style, Locale.getDefault());
    }

    /**
     * Gets the specified style of name ({@code LONG} or {@code SHORT}) for this {@code TimeZone} for
     * the specified {@code Locale} in either standard or daylight time as specified. If
     * the name is not available, the result is in the format {@code GMT[+-]hh:mm}.
     *
     * @param daylightTime {@code true} for daylight time, {@code false} for standard
     *                     time.
     * @param style        either LONG or SHORT.
     * @param locale       either {@code LONG} or {@code SHORT}.
     * @return the {@code TimeZone} name.
     */
    public String getDisplayName(final boolean daylightTime,
                                 final int style,
                                 final Locale locale) {
        switch(style) {
            case SHORT:
            case LONG:
                break;
            default:
                throw new IllegalArgumentException("Illegal style " + style);
        }

        final String zoneId = this.getID();
        final DefaultTimeZone defaultTimeZone =  DefaultTimeZone.getDefaultTimeZone(zoneId);
        if (null == defaultTimeZone) {
            throw new IllegalStateException("ZoneId " + CharSequences.quoteAndEscape(zoneId) + " missing");
        }

        return defaultTimeZone.getDisplayName(daylightTime,
                style,
                locale);
    }

    /**
     * Required as clone is missing in javascript
     */
    public abstract Object clone();

    /**
     * Consumes {@link TimeZoneProvider#DATA} creating a {@link TimeZone} for each record.
     */
    static {
        DefaultTimeZone.register();
    }
}
