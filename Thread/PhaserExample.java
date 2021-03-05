package com.mphasis.main;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserExample implements Runnable{

    Phaser phaser;

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
class  Main3{
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);
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
