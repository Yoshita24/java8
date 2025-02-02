import com.sun.org.apache.xml.internal.resolver.helpers.FileURL;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MyCallableMultipleThread {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Callable<String>> tasks = new ArrayList<>();
        for(int i=1;i<=3;i++)
        {
            int taskId=i;
            tasks.add(()-> "Task "+taskId+" executed by "+Thread
                    .currentThread()
                    .getName());
        }
        List<Future<String>> results = executorService.invokeAll(tasks);
        for(Future<String> result :results)
        {
            System.out.println(result.get());
        }
        executorService.shutdown();
    }
}
