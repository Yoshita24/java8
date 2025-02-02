import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureIsDoneExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(
                ()->{
                    Thread.sleep(10000);
                    return 100;
                }
        );
        while (!future.isDone())
        {
            System.out.println("Future is still running...");
            Thread.sleep(1000);
        }
        System.out.println("Task completed : "+future.get());
        executorService.shutdown();
    }
}
/*
isDone() - checks id task is completed
Return true if task is finished (either successfully,with an exeption or cancelled
if the task is still running, it returns false
*/