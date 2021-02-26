package com.mphasis.main;

public class One implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread());
    }

    public static void main(String[] args) {
        Thread mainThread= Thread.currentThread();

        Thread thread1= new Thread(new One());
        System.out.println(thread1.getState());
        thread1.start();
        System.out.println(thread1.getState());

        System.out.println(thread1.getState());
        System.out.println("End");
    }
}
