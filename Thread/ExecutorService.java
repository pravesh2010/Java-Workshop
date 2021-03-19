package com.mphasis;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 *  creating executer service and using thread pool
 */
public class ExecutorService implements Runnable{

    @Override
    public void run() {
	
	// printing current thread
        System.out.println(Thread.currentThread());
    }

    public static void main(String[] args) {
	
	//corecount on basis of available processors
        int coreCount= Runtime.getRuntime().availableProcessors();
        ExecutorService service= Executors.newCachedThreadPool(); 

        for (int c=0; c<300; c++){
            service.execute(new ExecutorService1());
        }
            service.shutdown();
    }
}
