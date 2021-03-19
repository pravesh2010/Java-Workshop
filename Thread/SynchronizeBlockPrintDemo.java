package com.mphasis.main;

/*
 *  creating synchronization block to remove race condition
 */
public class SynchronizeBlockPrintDemo extends Thread {
    public void printCount() {
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println("Counter --- " + i );
            }
        } catch (Exception e) {
            System.out.println("Thread " + Thread.currentThread().getName()+" interrupted.");
        }
    }
    public void run() {
        synchronized(this) {
            printCount();
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " exiting.");
    }

}
class TestSynchronizeBlockPrintDemo {
    public static void main(String args[]) {
        SynchronizeBlockPrintDemo PD = new SynchronizeBlockPrintDemo();
        Thread t1 = new Thread(PD );
        Thread t2 = new Thread(PD );
        t1.start();
        t2.start();
        // wait for threads to end
        try {
            t1.join();
            t2.join();
        } catch ( Exception e) {
            System.out.println("Interrupted");
        }
    }
        }
