import java.util.concurrent.*;

public class ExecutorServiceSubmitExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String > future = executorService.submit(()->
        {
            Thread.sleep(1000);
            return "Hello : "+Thread.currentThread().getName();
        });
        System.out.println(future.get());
        executorService.shutdown();
    }
}
