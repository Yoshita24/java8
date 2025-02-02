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
/*
Returns true if cancel() was called before completion.
If false, the task either completed normally or was never cancelled
What happens if u call get() on canceled task
If future task is canceled, calling future.get() will throw CancellationException
try{
System.out.println(future.get());
}
catch(Exception e)
{
System.out.print("Cannot retrive result: task was cancelled: ");
}

Use isDone() to check completion before calling get()
Use cancel(true) to stop long running task(if needed)
Use iscancelled() to confirm cancellation status
* */