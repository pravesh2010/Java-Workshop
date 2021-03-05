package com.mphasis.main;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample implements Runnable{

    CountDownLatch latch;

    public CountDownLatchExample(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();
        System.out.println("Processing....");
    }
}

class Main1{

        public static void main(String[] args) throws Exception {

                        int coreCount = Runtime.getRuntime().availableProcessors();
                        ExecutorService service = Executors.newFixedThreadPool(coreCount);
                CountDownLatch latch= new CountDownLatch(3);

                service.submit(new CountDownLatchExample(latch)); // three task
                service.submit(new CountDownLatchExample(latch));
                service.submit(new CountDownLatchExample(latch));

                latch.await();
            System.out.println("Initiated Shutdown");
            service.shutdown();
            System.out.println("Shutdown Initiation");

        }
        }
