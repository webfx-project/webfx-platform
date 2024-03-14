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

import java.util.Date;

/**
 * Defines an interface for {@link java.util.TimeZone} methods that require a tzdb to provide offsets, daylight saving
 * like data.
 */
public interface TimeZoneOffsetAndDaylightSavings {

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
    int getOffset(int era,
                  int year,
                  int month,
                  int day,
                  int dayOfWeek,
                  int time);

    /**
     * Gets the offset from GMT of this {@code TimeZone} for the specified date. The
     * offset includes daylight savings time if the specified date is within the
     * daylight savings time period.
     *
     * @param time the date in milliseconds since January 1, 1970 00:00:00 GMT
     * @return the offset from GMT in milliseconds.
     */
    int getOffset(final long time);

    /**
     * Returns whether the specified {@code Date} is in the daylight savings time period for
     * this {@code TimeZone}.
     *
     * @param time a {@code Date}.
     * @return {@code true} when the {@code Date} is in the daylight savings time period, {@code false}
     * otherwise.
     */
    boolean inDaylightTime(Date time);

    boolean observesDaylightTime();

    /**
     * Returns whether this {@code TimeZone} has a daylight savings time period.
     *
     * @return {@code true} if this {@code TimeZone} has a daylight savings time period, {@code false}
     *         otherwise.
     */
    boolean useDaylightTime();
}
