package multithreading;

public class Hello extends Thread{
    public void run()
    {
        for(int i =0;i<2;i++)
        {
            System.out.println("Hello thread : "+i);
        }
    }
}

class World1 implements Runnable
{

    @Override
    public void run() {
        for(int i =0;i<2;i++)
        {
            System.out.println("World1 thread : "+i);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
class Main
{
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Inside main method");
        for(int i =0;i<2;i++)
        {
            System.out.println("Main thread : "+i);
        }
        Hello hello = new Hello();
        hello.start();

        World1 world1 = new World1();
        Thread t =new Thread(world1);
        System.out.println(t.getState());
           t.start();
        System.out.println(t.getState());
        t.sleep(5000);
        System.out.println(t.getState());
        t.join();
        System.out.println(t.getState());


    }
}