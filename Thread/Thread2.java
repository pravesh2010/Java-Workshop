package com.mphasis.main;

public class Thread2{
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
class Runner2 implements Runnable{
    Thread2 thread2;
    Runner2(){
        thread2= new Thread2();
    }

    @Override
    public void run() {
        Thread currThread= Thread.currentThread();
       for (int counter=0; counter<10; counter++){
           System.out.println(currThread);
           if (currThread.getName().equals("Producer")){
               thread2.setValue(counter+1);
           }else{
               thread2.getValue();
           }
       }
    }
}
class TestThread2{
    public static void main(String[] args) {

        Thread thread= Thread.currentThread();
        Runner2 runner2= new Runner2();
        Thread thread1= new Thread(runner2, "Producer");
        Thread thread2= new Thread(runner2, "Consumer");
            thread1.start();
            thread2.start();
        System.out.println("END");


    }

        }
