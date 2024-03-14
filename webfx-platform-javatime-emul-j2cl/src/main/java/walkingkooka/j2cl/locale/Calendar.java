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

// java.util.Calendar with only constants copied from Apache Harmony
public abstract class Calendar {
    /**
     * Value of the {@code MONTH} field indicating the first month of the
     * year.
     */
    public static final int JANUARY = 0;

    /**
     * Value of the {@code MONTH} field indicating the second month of
     * the year.
     */
    public static final int FEBRUARY = 1;

    /**
     * Value of the {@code MONTH} field indicating the third month of the
     * year.
     */
    public static final int MARCH = 2;

    /**
     * Value of the {@code MONTH} field indicating the fourth month of
     * the year.
     */
    public static final int APRIL = 3;

    /**
     * Value of the {@code MONTH} field indicating the fifth month of the
     * year.
     */
    public static final int MAY = 4;

    /**
     * Value of the {@code MONTH} field indicating the sixth month of the
     * year.
     */
    public static final int JUNE = 5;

    /**
     * Value of the {@code MONTH} field indicating the seventh month of
     * the year.
     */
    public static final int JULY = 6;

    /**
     * Value of the {@code MONTH} field indicating the eighth month of
     * the year.
     */
    public static final int AUGUST = 7;

    /**
     * Value of the {@code MONTH} field indicating the ninth month of the
     * year.
     */
    public static final int SEPTEMBER = 8;

    /**
     * Value of the {@code MONTH} field indicating the tenth month of the
     * year.
     */
    public static final int OCTOBER = 9;

    /**
     * Value of the {@code MONTH} field indicating the eleventh month of
     * the year.
     */
    public static final int NOVEMBER = 10;

    /**
     * Value of the {@code MONTH} field indicating the twelfth month of
     * the year.
     */
    public static final int DECEMBER = 11;

    /**
     * Value of the {@code MONTH} field indicating the thirteenth month
     * of the year. Although {@code GregorianCalendar} does not use this
     * value, lunar calendars do.
     */
    public static final int UNDECIMBER = 12;

    /**
     * Value of the {@code DAY_OF_WEEK} field indicating Sunday.
     */
    public static final int SUNDAY = 1;

    /**
     * Value of the {@code DAY_OF_WEEK} field indicating Monday.
     */
    public static final int MONDAY = 2;

    /**
     * Value of the {@code DAY_OF_WEEK} field indicating Tuesday.
     */
    public static final int TUESDAY = 3;

    /**
     * Value of the {@code DAY_OF_WEEK} field indicating Wednesday.
     */
    public static final int WEDNESDAY = 4;

    /**
     * Value of the {@code DAY_OF_WEEK} field indicating Thursday.
     */
    public static final int THURSDAY = 5;

    /**
     * Value of the {@code DAY_OF_WEEK} field indicating Friday.
     */
    public static final int FRIDAY = 6;

    /**
     * Value of the {@code DAY_OF_WEEK} field indicating Saturday.
     */
    public static final int SATURDAY = 7;

    /**
     * Field number for {@code get} and {@code set} indicating the
     * era, e.g., AD or BC in the Julian calendar. This is a calendar-specific
     * value; see subclass documentation.
     *
     * @see GregorianCalendar#AD
     * @see GregorianCalendar#BC
     */
    public static final int ERA = 0;

    /**
     * Field number for {@code get} and {@code set} indicating the
     * year. This is a calendar-specific value; see subclass documentation.
     */
    public static final int YEAR = 1;

    /**
     * Field number for {@code get} and {@code set} indicating the
     * month. This is a calendar-specific value. The first month of the year is
     * {@code JANUARY}; the last depends on the number of months in a
     * year.
     *
     * @see #JANUARY
     * @see #FEBRUARY
     * @see #MARCH
     * @see #APRIL
     * @see #MAY
     * @see #JUNE
     * @see #JULY
     * @see #AUGUST
     * @see #SEPTEMBER
     * @see #OCTOBER
     * @see #NOVEMBER
     * @see #DECEMBER
     * @see #UNDECIMBER
     */
    public static final int MONTH = 2;

    /**
     * Field number for {@code get} and {@code set} indicating the
     * week number within the current year. The first week of the year, as
     * defined by {@code getFirstDayOfWeek()} and
     * {@code getMinimalDaysInFirstWeek()}, has value 1. Subclasses
     * define the value of {@code WEEK_OF_YEAR} for days before the first
     * week of the year.
     *
     * @see #getFirstDayOfWeek
     * @see #getMinimalDaysInFirstWeek
     */
    public static final int WEEK_OF_YEAR = 3;

    /**
     * Field number for {@code get} and {@code set} indicating the
     * week number within the current month. The first week of the month, as
     * defined by {@code getFirstDayOfWeek()} and
     * {@code getMinimalDaysInFirstWeek()}, has value 1. Subclasses
     * define the value of {@code WEEK_OF_MONTH} for days before the
     * first week of the month.
     *
     * @see #getFirstDayOfWeek
     * @see #getMinimalDaysInFirstWeek
     */
    public static final int WEEK_OF_MONTH = 4;

    /**
     * Field number for {@code get} and {@code set} indicating the
     * day of the month. This is a synonym for {@code DAY_OF_MONTH}. The
     * first day of the month has value 1.
     *
     * @see #DAY_OF_MONTH
     */
    public static final int DATE = 5;

    /**
     * Field number for {@code get} and {@code set} indicating the
     * day of the month. This is a synonym for {@code DATE}. The first
     * day of the month has value 1.
     *
     * @see #DATE
     */
    public static final int DAY_OF_MONTH = 5;

    /**
     * Field number for {@code get} and {@code set} indicating the
     * day number within the current year. The first day of the year has value
     * 1.
     */
    public static final int DAY_OF_YEAR = 6;

    /**
     * Field number for {@code get} and {@code set} indicating the
     * day of the week. This field takes values {@code SUNDAY},
     * {@code MONDAY}, {@code TUESDAY}, {@code WEDNESDAY},
     * {@code THURSDAY}, {@code FRIDAY}, and
     * {@code SATURDAY}.
     *
     * @see #SUNDAY
     * @see #MONDAY
     * @see #TUESDAY
     * @see #WEDNESDAY
     * @see #THURSDAY
     * @see #FRIDAY
     * @see #SATURDAY
     */
    public static final int DAY_OF_WEEK = 7;

    /**
     * Field number for {@code get} and {@code set} indicating the
     * ordinal number of the day of the week within the current month. Together
     * with the {@code DAY_OF_WEEK} field, this uniquely specifies a day
     * within a month. Unlike {@code WEEK_OF_MONTH} and
     * {@code WEEK_OF_YEAR}, this field's value does <em>not</em>
     * depend on {@code getFirstDayOfWeek()} or
     * {@code getMinimalDaysInFirstWeek()}. {@code DAY_OF_MONTH 1}
     * through {@code 7} always correspond to <code>DAY_OF_WEEK_IN_MONTH
     * 1</code>;
     * {@code 8} through {@code 15} correspond to
     * {@code DAY_OF_WEEK_IN_MONTH 2}, and so on.
     * {@code DAY_OF_WEEK_IN_MONTH 0} indicates the week before
     * {@code DAY_OF_WEEK_IN_MONTH 1}. Negative values count back from
     * the end of the month, so the last Sunday of a month is specified as
     * {@code DAY_OF_WEEK = SUNDAY, DAY_OF_WEEK_IN_MONTH = -1}. Because
     * negative values count backward they will usually be aligned differently
     * within the month than positive values. For example, if a month has 31
     * days, {@code DAY_OF_WEEK_IN_MONTH -1} will overlap
     * {@code DAY_OF_WEEK_IN_MONTH 5} and the end of {@code 4}.
     *
     * @see #DAY_OF_WEEK
     * @see #WEEK_OF_MONTH
     */
    public static final int DAY_OF_WEEK_IN_MONTH = 8;

    /**
     * Field number for {@code get} and {@code set} indicating
     * whether the {@code HOUR} is before or after noon. E.g., at
     * 10:04:15.250 PM the {@code AM_PM} is {@code PM}.
     *
     * @see #AM
     * @see #PM
     * @see #HOUR
     */
    public static final int AM_PM = 9;

    /**
     * Field number for {@code get} and {@code set} indicating the
     * hour of the morning or afternoon. {@code HOUR} is used for the
     * 12-hour clock. E.g., at 10:04:15.250 PM the {@code HOUR} is 10.
     *
     * @see #AM_PM
     * @see #HOUR_OF_DAY
     */
    public static final int HOUR = 10;

    /**
     * Field number for {@code get} and {@code set} indicating the
     * hour of the day. {@code HOUR_OF_DAY} is used for the 24-hour
     * clock. E.g., at 10:04:15.250 PM the {@code HOUR_OF_DAY} is 22.
     *
     * @see #HOUR
     */
    public static final int HOUR_OF_DAY = 11;

    /**
     * Field number for {@code get} and {@code set} indicating the
     * minute within the hour. E.g., at 10:04:15.250 PM the {@code MINUTE}
     * is 4.
     */
    public static final int MINUTE = 12;

    /**
     * Field number for {@code get} and {@code set} indicating the
     * second within the minute. E.g., at 10:04:15.250 PM the
     * {@code SECOND} is 15.
     */
    public static final int SECOND = 13;

    /**
     * Field number for {@code get} and {@code set} indicating the
     * millisecond within the second. E.g., at 10:04:15.250 PM the
     * {@code MILLISECOND} is 250.
     */
    public static final int MILLISECOND = 14;

    /**
     * Field number for {@code get} and {@code set} indicating the
     * raw offset from GMT in milliseconds.
     */
    public static final int ZONE_OFFSET = 15;

    /**
     * Field number for {@code get} and {@code set} indicating the
     * daylight savings offset in milliseconds.
     */
    public static final int DST_OFFSET = 16;

    /**
     * This is the total number of fields in this calendar.
     */
    public static final int FIELD_COUNT = 17;

    /**
     * Value of the {@code AM_PM} field indicating the period of the day
     * from midnight to just before noon.
     */
    public static final int AM = 0;

    /**
     * Value of the {@code AM_PM} field indicating the period of the day
     * from noon to just before midnight.
     */
    public static final int PM = 1;

    Calendar() {
        super();
    }
}
