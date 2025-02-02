import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExecuteExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(()->{System.out.println("Helloooo");});
        executorService.shutdown();

    }
}
