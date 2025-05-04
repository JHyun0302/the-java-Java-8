package me.whiteship.java8to11.chapter3.chap2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {

    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("keesun");
        name.add("whiteship");
        name.add("toby");
        name.add("foo");

        List<String> k = name.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("K"))
                .collect(Collectors.toList());
        System.out.println(k);

        name.removeIf(s -> s.startsWith("k"));
        name.forEach(System.out::println);
    }
}
