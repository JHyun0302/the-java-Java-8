package me.whiteship.java8to11.chapter8.chap1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.TYPE_PARAMETER) // static class FeelsLikeChicken<@Chicken T> {} : 제네릭 타입에 붙일 수 있음
@Target(ElementType.TYPE_USE) //TYPE_PARAMETER를 포함해서 TYPE을 선언하는 모든 곳에 선언 가능
@Repeatable(ChickenContainer.class)
public @interface Chicken {
    String value();
}
