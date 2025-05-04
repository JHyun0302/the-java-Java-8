package me.whiteship.java8to11.chapter3.chap1;

public class Chapter3_1_DefaultFoo implements Chapter3_1_Foo, Chapter3_1_Bar {

    String name;

    public Chapter3_1_DefaultFoo(String name) {
        this.name = name;
    }

    @Override
    public void printNameUpperCase() {
        System.out.println(this.name.toUpperCase());
    }

    @Override
    public void printName() {
        System.out.println(this. name);
    }

    @Override
    public String getName() {
        return this.name;
    }

}
