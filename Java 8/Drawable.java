package com.mphasis.java8;

/*
 *  Creating Functional Inerface and use with lambda expression
 */
@FunctionalInterface
public interface Drawable {
    void draw();
     default void read(){
    }
    static  void write(){

    }
}

class WithoutLambda{
    public static void main(String[] args) {
        int width=10;
    /*   Drawable d= new Drawable() {
            @Override
            public void draw() {
                System.out.println("Drawing " + width);    //without Lambda
            }

        };*/
        Drawable d2= ()-> System.out.println("Drawing "+width);   //with lambda
        d2.draw();
    }
}
