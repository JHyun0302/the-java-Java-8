package me.whiteship.java8to11.chapter7.chap3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Future<String> helloFuture = executorService.submit(hello);
        System.out.println(helloFuture.isDone());
        System.out.println("Started!");

//        helloFuture.cancel(true); // 현재 진행 중인 작업을 interrupt하면서 종료
        helloFuture.cancel(false); // 기다림. 기다렸다 한들 cancel 호출하면 가져올 수 없음

//        helloFuture.get(); // 블록킹 콜(결과 값을 가져올 때까지 기다림)

        System.out.println(helloFuture.isDone());
        System.out.println("End!");
        executorService.shutdown();
    }
}
