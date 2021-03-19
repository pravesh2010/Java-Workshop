package com.mphasis.main;

/*
 *  creating thread and get status of threads
 */
public class ThreadStates implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread());
    }

    public static void main(String[] args) {
        Thread mainThread= Thread.currentThread();

        Thread thread1= new Thread(new ThreadStates());
        System.out.println(thread1.getState());
        thread1.start();
        System.out.println(thread1.getState());

        System.out.println(thread1.getState());
        System.out.println("End");
    }
}
