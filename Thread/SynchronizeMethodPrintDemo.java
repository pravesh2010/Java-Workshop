package com.mphasis.main;

/*
 *  creating synchronize on run method and remove race condition
 */
public class SynchronizeMethodPrintDemo extends Thread{
    public void printCount() {
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println("Counter --- " + i );
            }
        } catch (Exception e) {
            System.out.println("Thread " + Thread.currentThread().getName()+" interrupted.");
        }
    }
    public synchronized void run() {
        printCount();
        System.out.println("Thread " + Thread.currentThread().getName() + " exiting.");
    }
}
class TestSynchronizeMethodPrintDemo {
    public static void main(String args[]) {
        SynchronizeMethodPrintDemo PD1 = new SynchronizeMethodPrintDemo();
        Thread t1 = new Thread(PD1 );
        Thread t2 = new Thread(PD1 );
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
