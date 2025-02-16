package freecodecampmultithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorDemo {
    public static void main(String[] args) {

        int core = Runtime.getRuntime().availableProcessors();
        System.out.println("Core : "+core);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for(int i =0;i<5;i++)
        {
            executorService.execute(new Task2(i));
        }
        executorService.shutdown();
    }
}
class Task2 implements Runnable
{
    private final int taskId;

    public Task2(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task : "+taskId+" is executed by "+Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
