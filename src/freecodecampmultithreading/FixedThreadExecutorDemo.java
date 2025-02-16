package freecodecampmultithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for(int i=0;i<5;i++)
        {
            executorService.execute(new FixedThreadTask(i));
        }
        executorService.shutdown();
    }

}
class FixedThreadTask implements Runnable
{
    private final int taskId;

    public FixedThreadTask(int taskId) {
        this.taskId = taskId;
    }

    public void run()
    {
        System.out.println("Task "+taskId+" is executed by "+Thread.currentThread().getName());
    }
}