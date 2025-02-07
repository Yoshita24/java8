package multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private int balance = 100;
    private final Lock lock = new ReentrantLock();
    public  void withdraw(int amount) throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+" attempting to withdraw "+amount);
        if(lock.tryLock(1000, TimeUnit.MILLISECONDS))
        {
            if(balance >= amount)
            {
                try {
                    System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal");
                    Thread.sleep(3000);
                    balance -= amount;
                    System.out.println("Updated balance : "+balance);
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
                finally {
                    lock.unlock();
                }
            }
            else {
                System.out.println(Thread.currentThread().getName()+" insufficient balance");

            }
        }
        else {
            System.out.println("could not acquire lock will try again later");

        }
        /*if(balance>=amount)
        {
            System.out.println(Thread.currentThread().getName()+" proceeding with withdrawal");
            Thread.sleep(3000);
            balance -=amount;
        }
        else {
            System.out.println(Thread.currentThread().getName()+" insufficient balance");
        }*/
    }
}
class Mainn
{
    public static void main(String[] args) {
        BankAccount sbi=new BankAccount();
        Runnable task  = new Runnable() {
            @Override
            public void run() {
                try {
                    sbi.withdraw(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread t1 = new Thread(task,"Thread 1");
        Thread t2 = new Thread(task,"Thread 2");
        t1.start();
        t2.start();

    }
}