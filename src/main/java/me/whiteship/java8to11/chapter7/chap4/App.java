package me.whiteship.java8to11.chapter7.chap4;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = new CompletableFuture<>();
        future.complete("keesun");

        System.out.println(future.get());
        System.out.println("============================");

        // 위와 같은 코드
//        CompletableFuture<String> future1 = CompletableFuture.completedFuture("keesun");
//        System.out.println(future1.get());
//        System.out.println("============================");

        // return이 없는 경우
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
        });
        future2.get();
        System.out.println("============================");

        // return 타입이 있는 경우
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).thenApply((s) -> { // .thenApply(): 결과 값을 다른 타입으로 변경(콜백)
            System.out.println(Thread.currentThread().getName());
            return s.toUpperCase();
        });
        System.out.println(future3.get()); //get()을 호출하지 않으면 아무 일도 일어나지 않는다.
        System.out.println("============================");

        // return 없음
        CompletableFuture<Void> future4 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).thenAccept((s) -> { // .thenAccept(): return 없음(콜백)
            System.out.println(Thread.currentThread().getName());
            System.out.println(s.toUpperCase());
        });
        future4.get(); //get()을 호출하지 않으면 아무 일도 일어나지 않는다.
        System.out.println("============================");

        // return 없음
        // executorService를 추가하면 ForkJoinPool이 아닌 직접 정의한 스레드풀 사용
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        CompletableFuture<Void> future5 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }, executorService).thenRun(() -> { // .thenRun(): 결과값을 참고도 못함
            System.out.println(Thread.currentThread().getName());
        });
        future5.get(); //get()을 호출하지 않으면 아무 일도 일어나지 않는다.
        System.out.println("============================");

        // thenRunAsync(): callback 실행을 다른 곳에서 하고 싶다.
       ExecutorService executorService2 = Executors.newFixedThreadPool(4);

        CompletableFuture<Void> future6 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }, executorService2).thenRunAsync(() -> { // .thenRun(): 결과값을 참고도 못함
            System.out.println(Thread.currentThread().getName());
        }, executorService2);
        future6.get(); //get()을 호출하지 않으면 아무 일도 일어나지 않는다.
        System.out.println("============================");

        executorService.shutdown();
        executorService2.shutdown();


    }
}
