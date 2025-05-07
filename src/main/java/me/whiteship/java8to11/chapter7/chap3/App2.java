package me.whiteship.java8to11.chapter7.chap3;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * invokeAll(): 2초, 3초, 1초 모두 기다림 -> 가장 오래 걸리는 Java가 끝날 때까지 기다림
 * invokeAny(): 2초, 3초, 1초 중에서 가장 빨리 끝난 스레드
 */
public class App2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4); // 스레드 개수가 2개 이하일 때, invokeAny()를 하면 hello가 나옴.

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Callable<String> java = () -> {
            Thread.sleep(3000L);
            return "Java";
        };

        Callable<String> keesun = () -> {
            Thread.sleep(1000L);
            return "Keesun";
        };

//        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, keesun));
//        for (Future<String> future : futures) {
//            System.out.println(future.get());
//        }

        String s = executorService.invokeAny(Arrays.asList(hello, java, keesun));
        System.out.println(s);

        executorService.shutdown();
    }
}
