package me.whiteship.java8to11.chapter7.chap1;

public class App {
    // interrupt
//    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thread(() -> {
//            while (true) {
//                System.out.println("Thread: " + Thread.currentThread().getName());
//                try {
//                    Thread.sleep(1000L);
//                } catch (InterruptedException e) {
//                    System.out.println("interrupted!");
//                    return;
//                }
//            }
//        });
//        thread.start();
//
//        System.out.println("Hello: " + Thread.currentThread().getName());
//        Thread.sleep(3000L);
//        thread.interrupt();
//    }

    // join
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("Thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
            }
        });
        thread.start();

        System.out.println("Hello: " + Thread.currentThread().getName());
        thread.join(); // 3초간 스레드가 끝날 때까지 기다렸다가 `thread + " is finished"` 실행!
        System.out.println(thread + " is finished");
    }
}
