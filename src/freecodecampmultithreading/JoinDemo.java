package freecodecampmultithreading;

public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
       Runnable runnable = ()->{
           for(int i=0;i<10;i++)
           {
              System.out.println(Thread.currentThread().getName()+" for : "+i);
           }
       };

       Runnable runnable1=()->
       {
           for(int i=0;i<15;i++)
           {
               System.out.println(Thread.currentThread().getName()+" for : "+i);
           }
       };
       System.out.println("Before starting execution");
       Thread thread = new Thread(runnable,"Thread 1");
        Thread thread1 = new Thread(runnable1,"Thread 1");
        thread1.start();
        thread.start();
        thread.join();
        thread1.join();
        System.out.println("Ending execution");



    }
}
