import java.util.concurrent.*;

public class CallableWithTimeOut {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String> task = () ->
        {
            Thread.sleep(2000);
            return "Task completed";
        };
        Future<String> future = executorService.submit(task);
        try

        {
            System.out.println(future.get(1, TimeUnit.SECONDS));
        }
        catch (TimeoutException | InterruptedException | ExecutionException e)
        {
            System.out.println(e);
        }
        executorService.shutdown();
    }
}
