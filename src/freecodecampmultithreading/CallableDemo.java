package freecodecampmultithreading;

import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService= Executors.newFixedThreadPool(2);
        Future<Integer> future=executorService.submit(new ReturnValueTask());
        System.out.println("Value fetched from executor service: "+future.get());
        System.out.println("Is cancelled: "+future.isCancelled());
        System.out.println("Is done: "+future.isDone());
        executorService.shutdown();
    }
}
class ReturnValueTask implements Callable<Integer>
{
    @Override
    public Integer call() throws Exception {
        return 13;
    }
}
