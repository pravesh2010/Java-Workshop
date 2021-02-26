package com.mphasis.main;

public class Runner1 implements Runnable{
    Data data;
    Runner1(){
        data= new Data();
    }

    @Override
    public void run() {
        Thread currThread= Thread.currentThread();
        for(int c=0; c<10; c++){
            System.out.println(currThread);
            if(currThread.getName().equals("Producer")){
                synchronized (data){
                    data.setValue(c+1);
                    try {
                        data.notifyAll();
                        data.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }else{

                synchronized (data){
                    data.getValue();
                    try {
                        data.notifyAll();
                        data.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread mainTread= Thread.currentThread();
        Runner1 r= new Runner1();
        Thread t1= new Thread(r, "Producer");
        Thread t2= new Thread(r, "Consumer");

        t1.start();
        t2.start();
        System.out.println("END");
    }
}
