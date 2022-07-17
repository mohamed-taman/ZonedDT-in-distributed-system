package com.sxi.lab.fizzbus.infra.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public final class DateTimeUtil {

    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private DateTimeUtil() {
    }

    public static LocalDate parseDate(String date) {

        return LocalDate.parse(date, DateTimeFormatter.ofPattern(DATE_PATTERN));

    }

    public static ZonedDateTime parseDateTime(String timestamp, String timezone) {

        return ZonedDateTime
                .of(LocalDateTime.parse(timestamp, DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)),
                        ZoneId.of(timezone));

    }

    public static ZonedDateTime parseDateTime(LocalDateTime timestamp, String timezone) {
        return ZonedDateTime.of(timestamp, ZoneId.of(timezone));
    }

    public static String toString(ZonedDateTime zonedDateTime, String timezone) {

        return zonedDateTime.toInstant()
                .atZone(ZoneId.of(timezone))
                .format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));
    }

    public static String calculateRecordAge(ZonedDateTime datetime, String timezone) {

        var recordAge = "No age? maybe is a future date";

        long years;
        long months;
        long days;
        long hours;
        long minutes;
        long seconds;

        var recordDateTime = datetime.toInstant().atZone(ZoneId.of(timezone))
                .toLocalDateTime();

        var currentDateTime = LocalDateTime.now(ZoneId.of(timezone));

        years = ChronoUnit.YEARS.between(recordDateTime, currentDateTime);
        months = ChronoUnit.MONTHS.between(recordDateTime, currentDateTime);
        days = ChronoUnit.DAYS.between(recordDateTime, currentDateTime);
        hours = ChronoUnit.HOURS.between(recordDateTime, currentDateTime);
        minutes = ChronoUnit.MINUTES.between(recordDateTime, currentDateTime);
        seconds = ChronoUnit.SECONDS.between(recordDateTime, currentDateTime);

        if (years > 0) {
            recordAge = years + " years";
        } else if (months > 0) {
            recordAge = months + " months";
        } else if (days > 0) {
            recordAge = days + " days";
        } else if (hours > 0) {
            recordAge = hours + " hours";
        } else if (minutes > 0) {
            recordAge = minutes + " minutes";
        } else if (seconds > 0) {
            recordAge = seconds + " seconds";
        }

        return recordAge;

    }
}
