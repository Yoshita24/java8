package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {
    private final Lock lock = new ReentrantLock();
    public void outerMethod()
    {
        lock.lock();
        try
        {
            System.out.println("Outer method");
            innerMethod();
        }
        finally {
            lock.unlock();
        }
    }

    private void innerMethod() {
        try
        {
            lock.lock();
            System.out.println("Inside innerMethod");
        }
        finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantExample reentrantExample = new ReentrantExample();
        reentrantExample.outerMethod();
    }
}
