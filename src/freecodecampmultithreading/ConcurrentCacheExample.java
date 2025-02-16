package freecodecampmultithreading;

import java.util.concurrent.*;

class ProductCache {
    private final ConcurrentHashMap<Integer, String> cache = new ConcurrentHashMap<>();

    // Simulating a database call (slow operation)
    private String fetchFromDatabase(int productId) {
        System.out.println("Fetching product from DB: " + productId);
        try {
            Thread.sleep(2000); // Simulating delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Product_" + productId;
    }

    // Get product details (first check cache, then DB if not present)
    public String getProduct(int productId) {
        return cache.computeIfAbsent(productId, this::fetchFromDatabase);
    }
}

public class ConcurrentCacheExample {
    public static void main(String[] args) {
        ProductCache productCache = new ProductCache();
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Simulating multiple users accessing product details
        Runnable task1 = () -> System.out.println("User 1: " + productCache.getProduct(101));
        Runnable task2 = () -> System.out.println("User 2: " + productCache.getProduct(101));
        Runnable task3 = () -> System.out.println("User 3: " + productCache.getProduct(102));

        executor.execute(task1);
        executor.execute(task2);
        executor.execute(task3);

        executor.shutdown();
    }
}

