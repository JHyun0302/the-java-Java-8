package me.whiteship.java8to11.chapter2.chap4;

public class Chapter2_4_Greeting {

    private String name;

    public Chapter2_4_Greeting() {
    }

    public Chapter2_4_Greeting(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String hello(String name) {
        return "hello " + name;
    }

    public static String hi(String name) {
        return "hi " + name;
    }
}
