import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyCallable {
    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String> task = () ->
        {
            Thread.sleep(1000);
            return "Task completed by "+Thread.currentThread().getName();
        };
        Future<String> future = executorService.submit(task);
        System.out.println(future.get());
    }
}
