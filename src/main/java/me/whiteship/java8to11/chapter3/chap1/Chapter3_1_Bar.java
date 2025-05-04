package me.whiteship.java8to11.chapter3.chap1;

public interface Chapter3_1_Bar extends Chapter3_1_Foo {

    /**
     * `Chapter3_1_Foo`에서 제공하는 기본 함수를 재정의 해야함.
     */
//    void printNameUpperCase();

    default void printNameUpperCase() {
        System.out.println("BAR");
    }

}
