    package freecodecampmultithreading;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class ProducerConsumerDemo {
    public static void main(String[] args) {
        Worker worker = new Worker(5,0);
        Thread producer = new Thread(()->
        {
            try {
                worker.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumer = new Thread(()->
        {
            try {
                worker.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        producer.start();
        consumer.start();
    }


}

    class Worker
    {
        private int sequence =0;
        private final Integer top;
        private final Integer bottom;
        private final LinkedList<Integer> container;
        private final Object lock = new Object();

        public Worker(Integer top, Integer bottom) {
            this.top = top;
            this.bottom = bottom;
            this.container = new LinkedList<>();
        }

        public void produce() throws InterruptedException {
            synchronized (lock)
            {
                while(true)
                {
                    if (container.size() == top)
                    {
                        System.out.println("Container full , waiting for the item to be removed...");
                        lock.wait();
                    }
                    else{
                        System.out.println(sequence+"  Added to the container");
                        container.add(sequence++);
                        lock.notify();
                    }
                    Thread.sleep(500);
                }
            }

        }
        public void consume() throws InterruptedException {
            synchronized (lock)
            {
                while(true) {
                    if (container.size() == bottom) {
                        System.out.println("Container is empty, please add item to the container");
                        lock.wait();
                    } else {
                        System.out.println(container.removeFirst() + " consumed from the container");
                        //container.remove(sequence);
                        lock.notify();
                    }
                    Thread.sleep(500);
                }
            }
        }
    }
