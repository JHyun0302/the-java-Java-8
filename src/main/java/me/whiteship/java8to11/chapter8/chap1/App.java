package me.whiteship.java8to11.chapter8.chap1;

import java.util.Arrays;
import java.util.List;

@Chicken("양념")
@Chicken("간장")
public class App {
    public static void main(String[] args) throws @Chicken("") RuntimeException {
        List<@Chicken("") String> names = Arrays.asList("keesun");

        Chicken[] chickens = App.class.getAnnotationsByType(Chicken.class);
        Arrays.stream(chickens).forEach((c -> {
            System.out.println(c.value());
        }));

        System.out.println("============================");
        ChickenContainer chickenContainer = App.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(chickenContainer.value()).forEach(c -> {
            System.out.println(c.value());
        });
    }

    static class FeelsLikeChicken<@Chicken("") T> {

        public static  <@Chicken("") C> void print(C c) {
            System.out.println(c);
        }
    }
}
