package com.mphasis.main;

import java.util.concurrent.*;

/*
 *  implementing cyclicbarrier and performing Task
 */
public class CyclicBarrierExample implements Runnable {
    CyclicBarrier barrier;
	
	//constructor
    public CyclicBarrierExample(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("Processing....");
    }
}

class TestCyclicBarrier{
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);
        
	//create three task
	CyclicBarrier barrier = new CyclicBarrier(3);
        service.submit(new CyclicBarrierExample(barrier)); 
        service.submit(new CyclicBarrierExample(barrier));
        service.submit(new CyclicBarrierExample(barrier));


        System.out.println("Initiated Shutdown");
        service.shutdown();
        System.out.println("Shutdown Initiation");
    }
}