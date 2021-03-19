package com.mphasis.assignment.Threads;

/*
 *  creating daemon thread and check for exception
 */
public class DaemonThreadExample2 extends Thread{
    public void run(){
        System.out.println("Name: "+Thread.currentThread().getName());
        System.out.println("Daemon: "+Thread.currentThread().isDaemon());
    }

    public static void main(String[] args){
        DaemonThreadExample2 t1=new DaemonThreadExample2();
        DaemonThreadExample2 t2=new DaemonThreadExample2();
        //t1.start();
        //will throw exception here
        //can't make daemon thread after start
        t1.setDaemon(true);
        t1.start();
        t2.start();
    }
}
