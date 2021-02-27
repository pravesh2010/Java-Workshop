package com.mphasis;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScheduleExecutorService1 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread());
        Logger logger= Logger.getLogger(ScheduleExecutorService1.class.getName());
        logger.log(Level.INFO, "Task1");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Logger logger= Logger.getLogger(ScheduleExecutorService1.class.getName());
        logger.log(Level.INFO, "Task1");
        int coreCount= Runtime.getRuntime().availableProcessors();
        ScheduledExecutorService service= Executors.newScheduledThreadPool(coreCount);
       // service.schedule(new Runner1(), 10, TimeUnit.SECONDS);
       // service.scheduleAtFixedRate(new Runner1(),5,10, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay(new ScheduleExecutorService1(), 5, 10, TimeUnit.SECONDS);
        //service.shutdown();
    }
}
