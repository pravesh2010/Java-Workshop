package com.mphasis.assignment.Threads;

/*
 *  creating daemon thread
 */
public class DaemonThreadExample implements Runnable {

    @Override
    public void run() {
        if(Thread.currentThread().isDaemon()){
            System.out.println("Daemon Thread is Working");
        }else{
            System.out.println("User Thread is Working");
        }
    }

    public static void main(String[] args) {
        DaemonThreadExample d1= new DaemonThreadExample();
        DaemonThreadExample d2= new DaemonThreadExample();
        DaemonThreadExample d3= new DaemonThreadExample();

        //create threads
        Thread t1= new Thread(d1);
        Thread t2= new Thread(d2);
        Thread t3= new Thread(d3);

        //t1 is daemon thread
        t1.setDaemon(true);

        t1.start();
        t2.start();
        t3.start();
    }
}
