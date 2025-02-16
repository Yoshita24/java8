package freecodecampmultithreading;

public class DeamonUserThreadDemo {
    public static void main(String[] args) {
        UserThread userThread = new UserThread();
        DemonThread demonThread = new DemonThread();
        userThread.start();
        demonThread.setDaemon(true);
        demonThread.start();


       System.out.println("Main Thread completed");
    }
}
class UserThread extends Thread
{
    public void run()
    {
        for(int i=0;i<4;i++)
        {
            System.out.println(Thread.currentThread().getName()+" executing "+i);
        }

    }
}
class DemonThread extends Thread
{
    public void run()
    {
        for(int i=0;i<10;i++)
        {
            System.out.println(Thread.currentThread().getName()+" executing "+i);
        }
    }
}