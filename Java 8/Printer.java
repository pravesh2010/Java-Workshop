package com.mphasis.java8;

/*
 *  Creating Inerface and use with lambda expression
 */
public interface Printer {
    void print(String str, int number);
}

class Task{
    public int perform(Printer printer){
        printer.print("Emphasis", 40);
        return 0;
    }
}
class main{
    public static void main(String[] args) {


        Task task = new Task();
        task.perform((text,number) -> System.out.println(text+ " " +number));
    }

}
