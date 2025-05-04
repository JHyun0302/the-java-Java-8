package me.whiteship.java8to11.chapter5.chap2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import me.whiteship.java8to11.chapter5.chap1.Progress;

public class App {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        boolean empty = optional.isEmpty();
        boolean present = optional.isPresent();
        System.out.println("empty = " + empty + ", present = " + present);

        // optional에서 바로 꺼내기
//        OnlineClass onlineClass = optional.get();
//        System.out.println(onlineClass.getTitle());

        // optional에 값이 있는 경우 stream 동작
        optional.ifPresent(oc -> System.out.println(oc.getTitle()));

        // optional에 있는 경우 작업, 없는 경우에도 동작 정의
        OnlineClass onlineClass1 = optional.orElse(createNewJpaClass());
//        OnlineClass onlineClass1 = optional.orElseGet(App::createNewJpaClass);
//        OnlineClass onlineClass1 = optional.orElseThrow(IllegalArgumentException::new);
        System.out.println(onlineClass1.getTitle());

        // 필터링 후 optional return
        Optional<OnlineClass> onlineClass = optional.filter(OnlineClass::isClosed);
        System.out.println(onlineClass.isPresent());

        /**
         * 문제: map으로 필터링하는 경우 복잡합!!
         * - input : result = 1대 1 맵핑
         */
        Optional<Optional<Progress>> progress = optional.map(OnlineClass::getProgress);
        Optional<Progress> progress1 = progress.orElseThrow();
        Progress progress2 = progress1.orElseThrow();

        /**
         * 해결: flatMap
         * - input : result = 1 대 N 맵핑
         */
        Optional<Progress> progress3 = optional.flatMap(OnlineClass::getProgress);

    }

    private static OnlineClass createNewJpaClass() {
        System.out.println("creating new online class");
        return new OnlineClass(10, "New class", false);
    }
}
