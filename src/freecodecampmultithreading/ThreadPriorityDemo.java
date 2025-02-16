package freecodecampmultithreading;

public class ThreadPriorityDemo {
    public static void main(String[] args) {
        System.out.println("Main Thread current priority: "+Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        System.out.println("Main Thread new current priority: "+Thread.currentThread().getPriority());

    }
}
