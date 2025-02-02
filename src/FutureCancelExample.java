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
