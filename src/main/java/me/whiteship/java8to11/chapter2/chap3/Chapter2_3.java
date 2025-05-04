package me.whiteship.java8to11.chapter2.chap3;

import java.util.function.BinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.Supplier;

public class Chapter2_3 {
    public static void main(String[] args) {
        Supplier<Integer> get10 = () -> {
            return 10;
        };

        BinaryOperator<Integer> sum = (a, b) -> a + b; // == BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;

        Chapter2_3 foo = new Chapter2_3();
        foo.run();


    }

    private void run() {
        /**
         * `baseNumber`가 사.실.상 final 일 때 로컬 클래스/익명 클래스/람다에서 사용 가능
         */
        int baseNumber = 1;

        /**
         * `로컬 클래스/익명 클래스`는 쉐도잉 문제가 있다.
         * 쉐도잉 문제: baseNumber를 재정의하면 가장 가까운 baseNumber 값을 적용함.
         * `람다`: baseNumber를 재정의 할 수 없음. 같은 Scope로 인식됨.
         */
//        // 로컬 클래스
//        class LocalClass {
//            void printBaseNumber() {
//                int baseNumber = 11;
//                System.out.println(baseNumber); // 11
//            }
//        }
//
//        // 익명 클래스
//        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
//            @Override
//            public void accept(Integer baseNumber) {
//                System.out.println(baseNumber);
//            }
//        };

        // 람다
//        IntConsumer printInt = (baseNumber) -> {
//            System.out.println(baseNumber);
//        };
        IntConsumer printInt = (i) -> {
            System.out.println(i + baseNumber);
        };

        printInt.accept(10);

//        baseNumber++; // 람다 에러: baseNumber가 final이 아님!
    }
}
