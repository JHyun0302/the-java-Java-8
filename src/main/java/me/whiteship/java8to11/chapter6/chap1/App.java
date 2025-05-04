package me.whiteship.java8to11.chapter6.chap1;

import java.security.interfaces.RSAKey;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat dateFormat = new SimpleDateFormat();

        /**
         * 날짜에서 시간을 가져온다고? 우리가 아는 시간이 아님.
         * - January 1, 1970, 00:00:00 GMT represented by this date. 이후로의 시간을 뜻함
         */
        long time = date.getTime();
        System.out.println(date);
        System.out.println(time);

        // java.util.Date 클래스는 mutable 하기 때문에 thead safe하지 않다.
        Thread.sleep(1000 * 3);
        Date after3Seconds = new Date();
        System.out.println(after3Seconds);
        after3Seconds.setTime(time);
        System.out.println(after3Seconds);

        // 문제 : 1월이 0부터 시작함;;
        Calendar keesunBirthDay = new GregorianCalendar(1982, Calendar.AUGUST, 15);

        // java.util.Date 클래스는 mutable 하기 때문에 thead safe하지 않다.
        System.out.println(keesunBirthDay.getTime());
        keesunBirthDay.add(Calendar.DAY_OF_YEAR, 1);
        System.out.println(keesunBirthDay.getTime());
    }
}
