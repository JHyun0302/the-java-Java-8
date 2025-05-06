package me.whiteship.java8to11.chapter6.chap2;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class AppTime {
    public static void main(String[] args) throws InterruptedException {
        Instant instant = Instant.now();
        System.out.println(instant); // 기준시 UTC, GMT
        System.out.println(instant.atZone(ZoneId.of("UTC")));

        ZoneId zone = ZoneId.systemDefault();
        System.out.println(zone);
        ZonedDateTime zonedDateTime = instant.atZone(zone);
        System.out.println(zonedDateTime);

        System.out.println("=================================");
        // 주의: 배포를 미국 서버에 한다면, LocalDateTime이 미국 시간이 됨!
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        // ZonedDateTime와 Instant 변경 가능
        LocalDateTime birthday = LocalDateTime.of(1982, Month.JULY, 15, 0, 0, 0);
        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(nowInKorea);

        Instant nowInstant = Instant.now();
        ZonedDateTime zonedDateTime1 = nowInstant.atZone(ZoneId.of("Asia/Seoul"));
        System.out.println(zonedDateTime1);
        zonedDateTime1.toInstant();
    }
}
