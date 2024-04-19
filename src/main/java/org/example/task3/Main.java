package org.example.task3;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool threadPool = new MyThreadPool(3);
        for(int i = 0; i < 200; i++) {
            threadPool.execute(() -> {
                for(int j = 0; j < 1000; ) {
                    j++;
                }
            });
        }
        threadPool.awaitTermination();
        Thread.sleep(50);
        threadPool.shutdown();

    }
}
