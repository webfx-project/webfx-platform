package dev.webfx.platform.util.time;

import dev.webfx.platform.util.Numbers;
import dev.webfx.platform.util.Strings;

import java.time.*;
import java.time.format.DateTimeParseException;

import static java.time.temporal.ChronoField.MILLI_OF_SECOND;

/**
 * @author Bruno Salmon
 */
public final class Times {

    public static Instant asInstant(Object value) {
        return !(value instanceof Instant) ? null : (Instant) value;
    }

    public static LocalDateTime asLocalDateTime(Object value) {
        return !(value instanceof LocalDateTime) ? null : (LocalDateTime) value;
    }

    public static LocalDate asLocalDate(Object value) {
        return !(value instanceof LocalDate) ? null : (LocalDate) value;
    }

    public static LocalTime asLocalTime(Object value) {
        return !(value instanceof LocalTime) ? null : (LocalTime) value;
    }

    public static Instant parseIsoInstant(String s) {
        if (s == null)
            return null;
        try {
            return Instant.parse(s);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public static Instant fastCheckParseIsoInstant(String s) { // Iso format: YYYY-MM-ddThh:mm:ss[.xxxx]Z
        if (s == null || !s.endsWith("Z") || s.length() < 20 || s.charAt(4) != '-' || s.charAt(7) != '-' || s.charAt(10) != 'T')
            return null;
        return parseIsoInstant(s);
    }

    public static Object fastToInstantIfIsoString(Object value) {
        if (value instanceof String) {
            Instant instant = fastCheckParseIsoInstant((String) value);
            if (instant != null)
                value = instant;
        }
        return value;
    }

    public static LocalDate parseIsoLocalDate(String s) {
        if (s == null)
            return null;
        Instant instant = fastCheckParseIsoInstant(s);
        if (instant != null) {
            // return LocalDate.ofInstant(instant, ZoneOffset.UTC); // Doesn't compile with GWT as this method is absent in gwt-time
            long epochSec = instant.getEpochSecond();
            long epochDay = Math.floorDiv(epochSec, 24 * 3600);
            return LocalDate.ofEpochDay(epochDay);
        }
        try {
            return LocalDate.parse(s);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public static LocalDateTime parseIsoLocalDateTime(String s) {
        if (s == null)
            return null;
        Instant instant = fastCheckParseIsoInstant(s);
        if (instant != null)
            return LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
        try {
            return LocalDateTime.parse(s);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public static Instant toInstant(Object value) {
        Instant instant = asInstant(value);
        if (instant != null || value == null)
            return instant;
        instant = parseIsoInstant(value.toString());
        if (instant != null)
            return instant;
        Long l = Numbers.toLong(value);
        if (l != null)
            return Instant.ofEpochMilli(l);
        return null;
    }

    public static String formatIso(Instant instant) {
        return formatIso(LocalDateTime.ofInstant(instant, ZoneOffset.UTC));
    }

    public static LocalDateTime toLocalDateTime(Object value) {
        LocalDateTime localDateTime = asLocalDateTime(value);
        if (localDateTime != null || value == null)
            return localDateTime;
        localDateTime = toLocalDateTime(asLocalDate(value));
        if (localDateTime != null)
            return localDateTime;
        localDateTime = toLocalDateTime(asLocalTime(value));
        if (localDateTime != null)
            return localDateTime;
        localDateTime = toLocalDateTime(value.toString());
        if (localDateTime != null)
            return localDateTime;
        return toLocalDateTime(Numbers.toLong(value));
    }

    public static LocalDateTime toLocalDateTime(LocalDate localDate) {
        return localDate == null ? null : LocalDateTime.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth(), 0, 0);
    }

    public static LocalDateTime toLocalDateTime(LocalTime localTime) {
        return localTime == null ? null : LocalDateTime.of(0, 1, 1, localTime.getHour(), localTime.getMinute(), localTime.getSecond(), localTime.getNano());
    }

    public static LocalDateTime toLocalDateTime(String s) {
        return parseIsoLocalDateTime(s);
    }

    public static LocalDateTime toLocalDateTime(Long l) {
        return l == null ? null : epochMillisUtcToLocalDateTime(l);
    }

    public static LocalDate toLocalDate(Object value) {
        LocalDate localDate = asLocalDate(value);
        if (localDate != null || value == null)
            return localDate;
        if (value instanceof LocalDateTime)
            return ((LocalDateTime) value).toLocalDate();
        return toLocalDate(value.toString());
    }

    public static LocalDate toLocalDate(String s) {
        return parseIsoLocalDate(s);
    }

    public static LocalDateTime epochMillisUtcToLocalDateTime(long epochMillis) {
        return epochMillisToLocalDateTime(epochMillis, ZoneOffset.UTC);
    }

    public static LocalDateTime epochMillisToLocalDateTime(long epochMillis, ZoneOffset offset) {
        return LocalDateTime.ofEpochSecond(epochMillis / 1000, (int) (epochMillis % 1000), offset);
    }

    public static long localDateTimeToEpochMillisUtc(LocalDateTime dateTime) {
        return localDateTimeToEpochMillis(dateTime, ZoneOffset.UTC);
    }

    public static long localDateTimeToEpochMillis(LocalDateTime dateTime, ZoneOffset offset) {
        return dateTime.toEpochSecond(offset) * 1000 + dateTime.get(MILLI_OF_SECOND);
    }

    public static String format(Object date, String pattern) {
        LocalDateTime localDateTime = toLocalDateTime(date);
        if (localDateTime != null)
            return format(localDateTime, pattern);
        LocalDate localDate = toLocalDate(date);
        return format(localDate, pattern);
    }

    /**
     * Formats a date
     * @param dateTime the date to format
     * @param pattern the format pattern, ex: dd/MM/yyyy HH:mm:ss
     * @return the formatted date
     */

    public static String format(LocalDateTime dateTime, String pattern) {
        if (dateTime == null || pattern == null)
            return null;
        String s = pattern;
        if (pattern.contains("dd"))
            s = Strings.replaceAll(s, "dd", Numbers.twoDigits(dateTime.getDayOfMonth()));
        if (pattern.contains("MM"))
            s = Strings.replaceAll(s, "MM", Numbers.twoDigits(dateTime.getMonthValue()));
        if (pattern.contains("yyyy"))
            s = Strings.replaceAll(s, "yyyy", Numbers.twoDigits(dateTime.getYear()));
        if (pattern.contains("hh"))
            s = Strings.replaceAll(s, "hh", Numbers.twoDigits(dateTime.getHour()));
        if (pattern.contains("HH"))
            s = Strings.replaceAll(s, "HH", Numbers.twoDigits(dateTime.getHour()));
        if (pattern.contains("mm"))
            s = Strings.replaceAll(s, "mm", Numbers.twoDigits(dateTime.getMinute()));
        if (pattern.contains("ss"))
            s = Strings.replaceAll(s, "ss", Numbers.twoDigits(dateTime.getSecond()));
        if (pattern.contains("a"))
            s = Strings.replaceAll(s, "a", dateTime.getHour() <= 12 ? "AM" : "PM");
        return s;
    }

    public static String formatIso(LocalDateTime date) {
        return format(date, "yyyy-MM-ddTHH:mm:ss.00Z");
    }

    public static String format(ZonedDateTime dateTime, String pattern) {
        if (dateTime == null || pattern == null)
            return null;
        String s = pattern;
        if (pattern.contains("dd"))
            s = Strings.replaceAll(s, "dd", Numbers.twoDigits(dateTime.getDayOfMonth()));
        if (pattern.contains("MM"))
            s = Strings.replaceAll(s, "MM", Numbers.twoDigits(dateTime.getMonthValue()));
        if (pattern.contains("yyyy"))
            s = Strings.replaceAll(s, "yyyy", Numbers.twoDigits(dateTime.getYear()));
        if (pattern.contains("hh"))
            s = Strings.replaceAll(s, "hh", Numbers.twoDigits(dateTime.getHour() <= 12 ? dateTime.getHour() : dateTime.getHour() - 12));
        if (pattern.contains("HH"))
            s = Strings.replaceAll(s, "HH", Numbers.twoDigits(dateTime.getHour()));
        if (pattern.contains("mm"))
            s = Strings.replaceAll(s, "mm", Numbers.twoDigits(dateTime.getMinute()));
        if (pattern.contains("ss"))
            s = Strings.replaceAll(s, "ss", Numbers.twoDigits(dateTime.getSecond()));
        if (pattern.contains("a"))
            s = Strings.replaceAll(s, "a", dateTime.getHour() <= 12 ? "AM" : "PM");
        return s;
    }

    public static String format(LocalDate localDate, String pattern) {
        if (localDate == null || pattern == null)
            return null;
        String s = pattern;
        if (pattern.contains("dd"))
            s = Strings.replaceAll(s, "dd", Numbers.twoDigits(localDate.getDayOfMonth()));
        if (pattern.contains("MM"))
            s = Strings.replaceAll(s, "MM", Numbers.twoDigits(localDate.getMonthValue()));
        if (pattern.contains("yyyy"))
            s = Strings.replaceAll(s, "yyyy", Numbers.twoDigits(localDate.getYear()));
        if (pattern.contains("hh"))
            s = Strings.replaceAll(s, "hh", "00");
        if (pattern.contains("HH"))
            s = Strings.replaceAll(s, "HH", "00");
        if (pattern.contains("mm"))
            s = Strings.replaceAll(s, "mm", "00");
        if (pattern.contains("ss"))
            s = Strings.replaceAll(s, "ss", "00");
        if (pattern.contains("a"))
            s = Strings.replaceAll(s, "a", "AM");
        return s;
    }

    public static boolean isPast(LocalDate date) {
        return LocalDate.now().isAfter(date);
    }

    public static boolean isPast(LocalDate date, Clock clock) {
        return LocalDate.now(clock).isAfter(date);
    }


    public static boolean isFuture(LocalDate date) {
        return LocalDate.now().isBefore(date);
    }

    public static boolean isFuture(LocalDate date, Clock clock) {
        return LocalDate.now(clock).isBefore(date);
    }

    public static boolean isBetween(LocalDate dateToCheck, LocalDate startDate, LocalDate endDate) {
        return dateToCheck != null
            && (startDate == null || dateToCheck.isAfter(startDate) || dateToCheck.isEqual(startDate))
            && (endDate == null   || dateToCheck.isBefore(endDate)  || dateToCheck.isEqual(endDate));
    }

    public static boolean isPast(LocalDateTime date) {
        return LocalDateTime.now().isAfter(date);
    }

    public static boolean isPast(LocalDateTime date, Clock clock) {
        return LocalDateTime.now(clock).isAfter(date);
    }

    public static boolean isFuture(LocalDateTime date) {
        return LocalDateTime.now().isBefore(date);
    }

    public static boolean isFuture(LocalDateTime date, Clock clock) {
        return LocalDateTime.now(clock).isBefore(date);
    }

    public static boolean isBetween(LocalDateTime dateToCheck, LocalDateTime startDate, LocalDateTime endDate) {
        return dateToCheck != null
               && (startDate == null || dateToCheck.isAfter(startDate) || dateToCheck.isEqual(startDate))
               && (endDate == null   || dateToCheck.isBefore(endDate)  || dateToCheck.isEqual(endDate));
    }

}
