import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureCancelExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(()->
        {
            Thread.sleep(5000);
            return 100;
        });
        Thread.sleep(1000);
        boolean cancelled = future.cancel(true);
        System.out.println("Task cancelled : "+cancelled);

        executorService.shutdown();
    }
}
/*
future.cancel(true) - Attempts to stop the task immediately (if running)
future.cancel(false) - Allows task to finish, but prevents fetching the result
returns true if cancellation was successful, otherwise false
Once cancelled, get() will throw CancellationExample
* */