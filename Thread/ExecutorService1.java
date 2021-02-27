package com.mphasis;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ExecutorService1 implements Runnable{

    @Override
    public void run() {

        System.out.println(Thread.currentThread());
    }

    public static void main(String[] args) {

        int coreCount= Runtime.getRuntime().availableProcessors();
        ExecutorService service= Executors.newCachedThreadPool();

        for (int c=0; c<300; c++){
            service.execute(new ExecutorService1());
        }
            service.shutdown();
    }
}
