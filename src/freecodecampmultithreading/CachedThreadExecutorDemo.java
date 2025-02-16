package freecodecampmultithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CachedThreadExecutorDemo {
    public static void main(String[] args) {
        // Create a CachedThreadPool
        ExecutorService executor = Executors.newCachedThreadPool();

        // Submitting 5 tasks
        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(2000); // Simulating work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // Shutdown executor after task completion
        executor.shutdown();
    }
}
