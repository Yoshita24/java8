import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureCancelledExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(
                ()->
                {
                    Thread.sleep(1000);
                    return 100;
                }
        );
        Thread.sleep(1000);
        future.cancel(true);
        if(future.isCancelled())
        {
            System.out.println("Task was cancelled");
        }
        else {
            System.out.println("Task completed: "+future.get());
        }
    }
}
