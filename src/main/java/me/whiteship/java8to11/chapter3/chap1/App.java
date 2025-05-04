package me.whiteship.java8to11.chapter3.chap1;

public class App {

    public static void main(String[] args) {
        Chapter3_1_DefaultFoo foo = new Chapter3_1_DefaultFoo("keesun");
        foo.printName();
        foo.printNameUpperCase();

        Chapter3_1_Foo.printAnything();
    }
}
