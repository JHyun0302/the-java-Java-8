package me.whiteship.java8to11.chapter5.chap1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

public class App {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);
        spring_boot.setProgress(null);

        int asInt = OptionalInt.of(10).getAsInt();
    }
}
