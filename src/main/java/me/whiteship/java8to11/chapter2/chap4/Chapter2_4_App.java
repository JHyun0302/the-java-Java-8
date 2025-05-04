package me.whiteship.java8to11.chapter2.chap4;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * 메서드 레퍼런스
 * 람다가 하는 일이 기존 메소드 또는 생성자를 호출하는 거라면, 메소드 레퍼런스를 사용해서 매우 간결하게 표현할 수 있다.
 */
public class Chapter2_4_App {

    public static void main(String[] args) {
        // 생성자
        Supplier<Chapter2_4_Greeting> newGreeting = Chapter2_4_Greeting::new;
        Chapter2_4_Greeting chapter2_4_greeting = newGreeting.get();

        Function<String, Chapter2_4_Greeting> keesunGreeting = Chapter2_4_Greeting::new; // name 들어간 생성자
        Chapter2_4_Greeting keesun = keesunGreeting.apply("keesun");
        System.out.println(keesun.getName());

        Supplier<Chapter2_4_Greeting> keesunGreeting2 = Chapter2_4_Greeting::new; // 기본 생성자

        // 인스턴스 메서드
        Chapter2_4_Greeting greeting = new Chapter2_4_Greeting();
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hello.apply("keesun"));

        // static
        UnaryOperator<String> hi = Chapter2_4_Greeting::hi;

        // 임의 객체의 인스턴스 메소드 참조 타입::인스턴스 메소드
        String[] names = {"keesun", "whiteship", "toby"};
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));
        Arrays.sort(names, (o1, o2) -> 0); // ComparatorApp 함수는 @FunctionalInterface 이므로 람다 사용 가능
        System.out.println(Arrays.toString(names));

    }
}
