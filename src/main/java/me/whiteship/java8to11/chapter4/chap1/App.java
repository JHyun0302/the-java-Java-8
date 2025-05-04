package me.whiteship.java8to11.chapter4.chap1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        List<Object> names = new ArrayList<>();
        names.add("keesun");
        names.add("whiteship");
        names.add("toby");
        names.add("foo");

        List<Object> collect = names.stream().map((s) -> {
            System.out.println(s);
            return s.toString();
        }).collect(Collectors.toList());

        System.out.println("=============");

        names.forEach(System.out::println);

        System.out.println("=============");

        // element를 병렬 처리
        List<Object> collect2 = names.parallelStream().map((s) -> {
                    System.out.println(s + Thread.currentThread().getName());
                    return s.toString();
                }).collect(Collectors.toList());
        collect2.forEach(System.out::println);
    }
}
