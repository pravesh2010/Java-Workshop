package com.mphasis.assignment.Threads;

import java.util.LinkedList;
import java.util.Random;

@SuppressWarnings("InfiniteLoopStatement")
public class Processor1 {
    private LinkedList<Integer> list = new LinkedList<>();
    private final int LIMIT = 10;
    private final Object lock = new Object();

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (lock) {
                //whenever the thread is notified starts again from the loop
                while (list.size() == LIMIT) {
                    lock.wait();// wait() is also true
                }
                list.add(value);

                System.out.println("Producer added: " + value + " queue size is " + list.size());
                value++;
                lock.notify();
            }
        }
    }

    public void consume() throws InterruptedException {
        Random random = new Random();
        while (true) {
            synchronized (lock) {
                while (list.size() == 0) {
                    lock.wait();
                }

                int value = list.removeFirst();
                System.out.print("Removed value by consumer is: " + value);
                System.out.println(" Now list size is: " + list.size());
                lock.notify();
            }
            Thread.sleep(random.nextInt(1000)); //force producer fill the queue to LIMIT_SIZE
        }
    }

    public static void main(String[] args) throws InterruptedException {

        final Processor1 processor1 = new Processor1();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor1.produce();
                } catch (InterruptedException ignored) {}
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor1.consume();
                } catch (InterruptedException ignored) {}
            }
        });

        t1.start();
        t2.start();

        Thread.sleep(30000);
        System.exit(0);
    }

    }


