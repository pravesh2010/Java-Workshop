package com.mphasis.assignment.day1;

/*
 *   perfoming typecasting and converting one datatype into another datatype
 */
public class Conversation {
    public static void main(String args[]) {
        byte b;
        int i = 257;
        double d = 323.142;

        b = (byte) i;
        System.out.println("i and b " + i + " " + b);

        i = (int) d;
        System.out.println("d and i " + d + " " + i);

        b = (byte) d;
        System.out.println("d and b " + d + " " + b);
    }

}
