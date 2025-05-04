package me.whiteship.java8to11.chapter2;

/**
 * 추상 메서드가 1개만 있으면 함수형 인터페이스!
 * 다른 메서드(static, default)는 상관 없음
 */
@FunctionalInterface
public interface RunSomething {

    public abstract int doIt(int number); // `abstract` 생략 가능

//    void doAgain(); // 컴파일 에러: 함수형 인터페이스 X

    static void printName() {
        System.out.println("Keesun");
    }

    default void printAge() {
        System.out.println("40");
    }
}
