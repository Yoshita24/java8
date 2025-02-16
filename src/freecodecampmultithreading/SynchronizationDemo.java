package freecodecampmultithreading;

public class SynchronizationDemo {
    private static int counter =0;
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->
        {
            for (int i =0;i<10000;i++)
                increment();
        });
        Thread thread1 = new Thread(()->
        {
            for (int i =0;i<10000;i++)
                increment();
        });
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println("counter value : "+counter);
    }

    private synchronized static void increment() {
        counter++;
    }
}
