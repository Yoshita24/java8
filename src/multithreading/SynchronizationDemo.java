package multithreading;

public class SynchronizationDemo {
    public static void main(String[] args) {
        Counter counter = new Counter();
        MyThread t = new MyThread(counter);
        MyThread t1 = new MyThread(counter);
        t.start();
        t1.start();
        try {
            t.join();
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(counter.getCount());
    }
}
 class  MyThread extends Thread
 {
     Counter counter;
     public MyThread(Counter counter)
     {
         this.counter=counter;
     }
     public void run()
     {
         for(int i=0;i<1000;i++)
         {
             counter.increment();
         }
     }
 }
class Counter
{
    private int count=0;
    public synchronized void increment()
    {
        count++;
    }
    public int getCount()
    {
        return count;
    }
}
