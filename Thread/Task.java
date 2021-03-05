package com.mphasis.main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Point{
    public int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
public class Task implements Callable<Point> {
    String name;
    int x;
    int y;

    public Task(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    @Override
    public Point call() throws Exception {
        System.out.println(Thread.currentThread()+name);
        return new Point(x,y);
    }
}

class Main{
    public static void main(String[] args) {
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newScheduledThreadPool(coreCount);
        List<Future> allFuture = new ArrayList<Future>();

        for (int counter = 0; counter < 10; counter++) {
            Future<Point> future = service.submit(new Task("Task" + (counter + 1), counter + 1, counter + 2));  //This is Task
            allFuture.add(future);
        }
        System.out.println("Initiated Shutdown");
        service.shutdown();
        System.out.println("Shutdown Initiation");


        try {
            for (Future<Point> future : allFuture) {
                System.out.println(future.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
