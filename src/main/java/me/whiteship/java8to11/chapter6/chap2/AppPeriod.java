package me.whiteship.java8to11.chapter6.chap2;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class AppPeriod {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate thisYearBirthday = LocalDate.of(2020, Month.JULY, 15);

        // Period: 사람용 기간을 비교
        Period period = Period.between(today, thisYearBirthday);
        System.out.println(period.getDays());

        Period until = today.until(thisYearBirthday);
        System.out.println(until.get(ChronoUnit.DAYS));

        // Duration: Machine용 시간을 비교
        Instant now = Instant.now();
        Instant plus = now.plus(10, ChronoUnit.SECONDS);
        Duration between = Duration.between(now, plus);
        System.out.println(between.getSeconds());

        // DateTime Formatting
        LocalDateTime now1 = LocalDateTime.now();
        DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyy");
        System.out.println(now1.format(MMddyyyy));

        // DateTime Parsing
        LocalDate parse = LocalDate.parse("07/15/1982", MMddyyyy);
        System.out.println(parse);

        // date <-> instant
        Date date = new Date();
        Instant instant = date.toInstant();
        Date newDate = Date.from(instant);
        // gregorianCalendar <-> localDate
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        LocalDate dateTime = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // gregorianCalendar <-> zonedDateTime
        ZonedDateTime zonedDateTime = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault());
        GregorianCalendar from = GregorianCalendar.from(zonedDateTime);

        // ZonId <-> TimeZone
        ZoneId zoneId = TimeZone.getTimeZone("PST").toZoneId();
        TimeZone timeZone = TimeZone.getTimeZone(zoneId);

    }
}
