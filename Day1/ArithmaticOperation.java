package com.mphasis.assignment.day1;

/*
 *   perfoming some arithmetic operations
 */
public class ArithmaticOperation {
    public static void main(String args[]) {
        int d = 42;
        char f = 'a';
        int i = 1024;
        long s = 50000;
        float c = 5.67f;
        double b = .1234;
        double result = (c * d) + (s / f) - (b * i);
        System.out.println((c * d) + " + " + (s / f) + " - " + (b * i));
        System.out.println("result = " + result);
    }

}
