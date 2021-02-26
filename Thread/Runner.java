package com.mphasis.main;

public class Runner implements Runnable {

    @Override
    public void run() {
        for(int i=0; i<100; i++){
            System.out.println(Thread.currentThread());
        }
    }

    public static void main(String[] args) {
        Thread mainThread= Thread.currentThread();
        Runner runner= new Runner();
        Thread thread1=new Thread(runner);
        Thread thread2= new Thread(runner);

        thread1.start();
        thread2.start();

        System.out.println("End");


    }
}
