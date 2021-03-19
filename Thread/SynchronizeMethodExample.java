package com.mphasis.main;

/*
 *  creating synchronization method on get and set value
 */
public class SynchronizeMethodExample{
    private int value;

    public synchronized void getValue() {
        System.out.println(value);
        try {
            notify();
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void setValue(int value) {
        this.value = value;
        try {
            notify();
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Runner implements Runnable{
    SynchronizeMethodExample synchronizeMethodExample;
    Runner(){
        SynchronizeMethodExample= new SynchronizeMethodExample();
    }

    @Override
    public void run() {
        Thread currThread= Thread.currentThread();
       for (int counter=0; counter<10; counter++){
           System.out.println(currThread);
           if (currThread.getName().equals("Producer")){
               synchronizeMethodExample.setValue(counter+1);
           }else{
               synchronizeMethodExample.getValue();
           }
       }
    }
}
class  TestSynchronizeMethodExample;{
    public static void main(String[] args) {

        Thread thread= Thread.currentThread();
        Runner runner2= new Runner();
        Thread thread1= new Thread(runner2, "Producer");
        Thread thread2= new Thread(runner2, "Consumer");
            thread1.start();
            thread2.start();
        System.out.println("END");


    }

        }
