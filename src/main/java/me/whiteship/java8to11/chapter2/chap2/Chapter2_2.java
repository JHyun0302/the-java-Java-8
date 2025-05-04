package me.whiteship.java8to11.chapter2.chap2;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import me.whiteship.java8to11.RunSomething;

public class Chapter2_2 {

    public static void main(String[] args) {
        final int baseNumber = 10;

        // 익명 내부 클래스 anonymous inner class
        RunSomething runSomething = number -> number + baseNumber;

        /**
         * 아래처럼 항상 같은 결과가 나와야 함! (멱등성 보장)
         */
        System.out.println(runSomething.doIt(1));
        System.out.println(runSomething.doIt(1));
        System.out.println(runSomething.doIt(1));

        Function<Integer, Integer> plus10 = (i) -> i + 10;
        Function<Integer, Integer> multiply2 = (i) -> i  * 2;

        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2); // 2(multiply2) * 4 + 10(plus10)
        System.out.println(multiply2AndPlus10.apply(4));

        System.out.println(plus10.andThen(multiply2).apply(3)); // (10(plus10) + 3) * 2(multiply2)

        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(50);

        Supplier<Integer> get10 = () -> 15;
        System.out.println(get10);

        Predicate<String> startsWithKeesun = (s) -> s.startsWith("keesun");
        Predicate<Integer> isEven = (i) -> i % 2 == 0;

        /**
         * Function<Integer, Integer> plus10 = (i) -> i + 10;
         * 위와 같이 입력 값과 리턴 값이 같은 경우 UnaryOperator<Integer> 가능
         */
        UnaryOperator<Integer> plus100 = i -> i + 100;
        System.out.println(plus100.andThen(multiply2).apply(1)); // (100 + 1) * 2


    }
}
