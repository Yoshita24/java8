package freecodecampmultithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



import java.util.concurrent.*;

public class ScheduleThreadExecutorDemo {
    public static void main(String[] args) {
        // Creating a ScheduledThreadPool with 2 core threads
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        // Task 1: Runs after a 3-second delay
        scheduler.schedule(() -> {
            System.out.println("Task 1: Runs after 3 seconds - " + Thread.currentThread().getName());
        }, 3, TimeUnit.SECONDS);

        // Task 2: Runs every 2 seconds, with an initial delay of 1 second
        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Task 2: Runs every 2 seconds - " + Thread.currentThread().getName());
        }, 1, 2, TimeUnit.SECONDS);

        // Task 3: Runs 2 seconds after the previous task completes
        scheduler.scheduleWithFixedDelay(() -> {
            System.out.println("Task 3: Runs 2 seconds after previous execution - " + Thread.currentThread().getName());
        }, 1, 2, TimeUnit.SECONDS);

        // Scheduler will run for 10 seconds before shutdown
        scheduler.schedule(() -> {
            System.out.println("Shutting down the scheduler...");
            scheduler.shutdown();
        }, 10, TimeUnit.SECONDS);
    }
}
