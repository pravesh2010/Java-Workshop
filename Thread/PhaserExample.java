package com.mphasis.main;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

/*
 *  implementing phaser to create synchronization barrier
 */
public class PhaserExample implements Runnable{

    Phaser phaser;

	//constructor
    public PhaserExample(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        phaser.arriveAndDeregister();
        System.out.println("Processing....");
    }

}
class  TestPhaser{
    public static void main(String[] args) throws InterruptedException, ExecutionException {
	
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);
        
	//creating task
	Phaser phaser= new Phaser(4);
        service.submit(new PhaserExample(phaser));
        service.submit(new PhaserExample(phaser));
        service.submit(new PhaserExample(phaser));

        phaser.arriveAndAwaitAdvance();


        System.out.println("Initiated Shutdown");
        service.shutdown();
        System.out.println("Shutdown Initiation");
    }
        }
