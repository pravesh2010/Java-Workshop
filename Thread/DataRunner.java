package com.mphasis.main;

/*
 *  implementing syncronize block on object and performing synchronization
 */
public class DataRunner implements Runnable{
	
	//creating Data Class object
    Data data;
    DataRunner(){
        data= new Data();
    }

    @Override
    public void run() {
        Thread currThread= Thread.currentThread();
        for(int c=0; c<10; c++){
            System.out.println(currThread);
            if(currThread.getName().equals("Producer")){
		//Syncronize block
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
        DataRunner r= new DataRunner();
        Thread t1= new Thread(r, "Producer");
        Thread t2= new Thread(r, "Consumer");

        t1.start();
        t2.start();
        System.out.println("END");
    }
}
