package me.whiteship.java8to11.chapter7.chap2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {
//    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        executorService.submit(() -> {
//            System.out.println("Thread " + Thread.currentThread().getName());
//        });
//        executorService.shutdown(); //graceful shutdown
////        executorService.shutdownNow();
//    }

//    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        executorService.submit(getRunnable("Hello"));
//        executorService.submit(getRunnable("Keesun"));
//        executorService.submit(getRunnable("The"));
//        executorService.submit(getRunnable("Java"));
//        executorService.submit(getRunnable("Thread"));
//
//        executorService.shutdown();
//    }

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
//        executorService.schedule(getRunnable("Hello"), 3, TimeUnit.SECONDS); // 3초 뒤 출력
        executorService.scheduleAtFixedRate(getRunnable("Hello"), 1,2, TimeUnit.SECONDS); // 1초 기다렸다가 2초마다 찍음

    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + Thread.currentThread().getName());
    }
}
