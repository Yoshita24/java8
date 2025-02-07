package multithreading;

public class LambdaExpression {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable=()->System.out.println("Hello runnable");
Thread t =new Thread(runnable);
    t.start();
    //throw  new ArithmeticException("Division by 0");
    //  throw new InterruptedException();
        t.start();

    }


}
