package me.whiteship.java8to11.chapter3.chap2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorApp {

    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("keesun");
        name.add("whiteship");
        name.add("toby");
        name.add("foo");

        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase);
        name.sort(compareToIgnoreCase.reversed()); // 역순
//        name.sort(compareToIgnoreCase.reversed().thenComparing()); // 역순 + 정렬 조건 추가


    }
}
