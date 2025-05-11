package me.whiteship.java8to11.chapter7.chap5;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        });

        /**
         * 원래는 주석처럼 get()을 통해 hello가 끝나고 world를 호출하는 방식
         * hello.get();
         * world.get();
         */
        CompletableFuture<String> future = hello.thenCompose(App::getWorld); // 두 CompletableFuture 연결

        System.out.println(future.get());

        System.out.println("============================");
        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            System.out.println("World " + Thread.currentThread().getName());
            return "World";
        });

        CompletableFuture<String> future1 = hello.thenCombine(world, (h, w) -> h + " " + w); // 연관관계 없는 두 데이터가 모두 왔을 때, 동작(ex. 애플 주식 + 마소 주식 데이터가 왔을 때 동작)
        System.out.println(future1.get());

        List<CompletableFuture<String>> futures = Arrays.asList(hello, world);
        CompletableFuture[] futuresArray = futures.toArray(new CompletableFuture[futures.size()]);

        CompletableFuture<List<String>> results = CompletableFuture.allOf(futuresArray) //allOf() 안에 task가 모두 끝났을 때, 이후 동작 정의
                .thenApply(v -> futures.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList()));

        results.get().forEach(System.out::println);

        System.out.println("============================");
        CompletableFuture<Void> future3 = CompletableFuture.anyOf(hello, world) // anyOf() 아무거나 빨리 작업 끝나는거
                .thenAccept((s) -> System.out.println(s));

        future3.get();

        System.out.println("============================");
        // 에외 처리
        boolean throwError = true;

        CompletableFuture<String> hello1 = CompletableFuture.supplyAsync(() -> {
            if (throwError) {
                throw new IllegalArgumentException();
            }

            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).exceptionally(ex -> {
            System.out.println(ex);
            return "Error!";
        });

        System.out.println(hello1.get());

        System.out.println("============================");
        // handle(): 정상,에러 모두 사용 가능
        boolean throwError1 = true;

        CompletableFuture<String> hello2 = CompletableFuture.supplyAsync(() -> {
            if (throwError1) {
                throw new IllegalArgumentException();
            }

            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).handle((result, ex) -> {
            if (ex != null) {
                System.out.println(ex);
                return "ERROR!";
            }
            return result;
        });

        System.out.println(hello2.get());
    }

    private static CompletableFuture<String> getWorld(String message) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("World " + Thread.currentThread().getName());
            return message + " World";
        });
    }
}
