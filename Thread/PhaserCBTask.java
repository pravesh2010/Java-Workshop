package com.mphasis.assignment.Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 *  implementing phaser to create synchronization barrier
 */
public class PhaserCBTask implements Runnable {
    private final String name;
    Phaser phaser;

    PhaserCBTask(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
    }

    @Override
    public void run() {
        Logger logger = Logger.getLogger(PhaserCBMain.class.getName());
        logger.log(Level.INFO, () -> "Performing " + name);
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            phaser.arriveAndDeregister();
            logger.log(Level.INFO, () -> "Resuming " + name);

        }
    }
}

class PhaserCBMain {

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(4);
        Phaser phaser = new Phaser(3);
        service.submit(new PhaserCBTask(phaser, "Task 1"));
        service.submit(new PhaserCBTask(phaser, "Task 2"));
        service.submit(new PhaserCBTask(phaser, "Task 3"));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        phaser.arriveAndAwaitAdvance();
        service.shutdown();
        System.out.println("End");
    }
}
