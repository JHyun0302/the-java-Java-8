package me.whiteship.java8to11.chapter3.chap2;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class App {

    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("keesun");
        name.add("whiteship");
        name.add("toby");
        name.add("foo");

//        for (String n : name) {
//            System.out.println(n);
//        }
        name.forEach(System.out::println);

        System.out.println("====================");
        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();

        while (spliterator.tryAdvance(System.out::println));
        System.out.println("====================");
        while (spliterator1.tryAdvance(System.out::println));

    }
}
