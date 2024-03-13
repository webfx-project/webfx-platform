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

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Objects;
import walkingkooka.j2cl.java.util.timezone.TimeZone;

/**
 * A simple record which holds all the display strings for a zoneid and locale. This class should be
 * considered internal and not referenced except by the annotation processor and emulated {@link TimeZone}.
 */
public final class TimeZoneDisplay implements Comparable<TimeZoneDisplay> {

    /**
     * Should only be used by {@link TimeZone} during initialization.
     */
    public static TimeZoneDisplay read(final DataInput data) throws IOException {
        return with(data.readUTF(),
                data.readUTF(),
                data.readUTF(),
                data.readUTF());
    }

    public static TimeZoneDisplay with(final String shortDisplayName,
                                       final String shortDisplayNameDaylight,
                                       final String longDisplayName,
                                       final String longDisplayNameDaylight) {
        return new TimeZoneDisplay(shortDisplayName,
                shortDisplayNameDaylight,
                longDisplayName,
                longDisplayNameDaylight);
    }

    private TimeZoneDisplay(final String shortDisplayName,
                            final String shortDisplayNameDaylight,
                            final String longDisplayName,
                            final String longDisplayNameDaylight) {
        super();
        this.shortDisplayName = shortDisplayName;
        this.shortDisplayNameDaylight = shortDisplayNameDaylight;
        this.longDisplayName = longDisplayName;
        this.longDisplayNameDaylight = longDisplayNameDaylight;
    }

    // internal intended only to be used by emulated TimeZone

    public final String shortDisplayName;
    public final String shortDisplayNameDaylight;
    public final String longDisplayName;
    public final String longDisplayNameDaylight;

    @GwtIncompatible
    public final void write(final DataOutput data) throws IOException {
        data.writeUTF(this.shortDisplayName);
        data.writeUTF(this.shortDisplayNameDaylight);
        data.writeUTF(this.longDisplayName);
        data.writeUTF(this.longDisplayNameDaylight);
    }

    // Object...........................................................................................................

    @Override
    public int hashCode() {
        return Objects.hash(this.shortDisplayName, this.shortDisplayNameDaylight, this.longDisplayName, this.longDisplayNameDaylight);
    }

    @Override
    public boolean equals(final Object other) {
        return this == other || (other instanceof TimeZoneDisplay && this.equals0((TimeZoneDisplay) other));
    }

    private boolean equals0(final TimeZoneDisplay other) {
        return this.shortDisplayName.equals(other.shortDisplayName) &&
                this.shortDisplayNameDaylight.equals(other.shortDisplayNameDaylight) &&
                this.longDisplayName.equals(other.longDisplayName) &&
                this.longDisplayNameDaylight.equals(other.longDisplayNameDaylight);
    }

    @Override
    public String toString() {
        return ToStringBuilder.empty()
                .value(this.shortDisplayName)
                .value(this.shortDisplayNameDaylight)
                .value(this.longDisplayName)
                .value(this.longDisplayNameDaylight)
                .build();
    }

    // Comparable.......................................................................................................

    @Override
    public int compareTo(final TimeZoneDisplay other) {
        return this.toString().compareTo(other.toString());
    }
}
