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
import walkingkooka.ToStringBuilder;
import walkingkooka.text.printer.IndentingPrinter;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import walkingkooka.j2cl.java.util.calendar.Calendar;
import java.util.Objects;

public final class TimeZoneCalendar implements Comparable<TimeZoneCalendar> {

    @GwtIncompatible
    public static TimeZoneCalendar with(final Calendar calendar) {
        return with(calendar.getFirstDayOfWeek(),
                calendar.getMinimalDaysInFirstWeek());
    }

    public static TimeZoneCalendar read(final DataInput data) throws IOException {
        return with(data.readInt(), data.readInt());
    }

    public static TimeZoneCalendar with(final int firstDayOfWeek,
                                        final int minimalDaysInFirstWeek) {
        return new TimeZoneCalendar(firstDayOfWeek, minimalDaysInFirstWeek);
    }

    private TimeZoneCalendar(final int firstDayOfWeek,
                             final int minimalDaysInFirstWeek) {
        super();
        this.firstDayOfWeek = firstDayOfWeek;
        this.minimalDaysInFirstWeek = minimalDaysInFirstWeek;
    }

    @GwtIncompatible
    public void generate(final DataOutput data,
                         final String prefix,
                         final IndentingPrinter comments) throws IOException {
        comments.lineStart();
        comments.print(prefix + "firstDayOfWeek: " + this.firstDayOfWeek);
        comments.lineStart();
        comments.print(prefix + "minimalDaysInFirstWeek: " + this.minimalDaysInFirstWeek);

        this.write(data);
    }

    public void write(final DataOutput data) throws IOException {
        data.writeInt(this.firstDayOfWeek);
        data.writeInt(this.minimalDaysInFirstWeek);
    }

    public final int firstDayOfWeek;
    public final int minimalDaysInFirstWeek;

    @Override
    public int hashCode() {
        return Objects.hash(this.firstDayOfWeek, this.minimalDaysInFirstWeek);
    }

    @Override
    public boolean equals(final Object other) {
        return this == other || (other instanceof TimeZoneCalendar && this.equals0((TimeZoneCalendar) other));
    }

    private boolean equals0(final TimeZoneCalendar other) {
        return 0 == this.compareTo(other);
    }

    @Override
    public int compareTo(final TimeZoneCalendar other) {
        int result = this.firstDayOfWeek - other.firstDayOfWeek;
        if (0 == result) {
            result = this.minimalDaysInFirstWeek - other.minimalDaysInFirstWeek;
        }

        return result;
    }

    @Override
    public String toString() {
        return ToStringBuilder.empty()
                .label("firstDayOfWeek")
                .value(this.firstDayOfWeek)
                .label("minimalDaysInFirstWeek")
                .value(this.minimalDaysInFirstWeek)
                .build();
    }
}
