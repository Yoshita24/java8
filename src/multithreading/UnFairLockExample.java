package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnFairLockExample {
    private final Lock unFairLock = new ReentrantLock(true);
    public void accessResource()
    {
        unFairLock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+" acquired the lock");
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
        finally {
            unFairLock.unlock();
            System.out.println(Thread.currentThread().getName()+" released the lock");

        }
    }

    public static void main(String[] args) {
        UnFairLockExample unFairLockExample = new UnFairLockExample();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                unFairLockExample.accessResource();
            }
        };
        Thread t1 = new Thread(task,"Thread 1");
        Thread t2 = new Thread(task,"Thread 2");
        Thread t3 = new Thread(task,"Thread 3");
        t1.start();
        t2.start();
        t3.start();


    }
}
