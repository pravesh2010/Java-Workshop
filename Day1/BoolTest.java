package com.mphasis.assignment.day1;

/*
 *   perfoming boolean operations and finding result
 */
public class BoolTest {

    public static void main(String args[]) {
        boolean b;

        b = false;
        System.out.println("b is " + false);
        b = true;
        System.out.println("b is " + true);

        // a boolean value can control the if statement
        if(b=true ) System.out.println("This is executed.");

       // b = false;
        if(  b = false) System.out.println("This is not executed.");

        // outcome of a relational operator is a boolean value
        System.out.println("10 > 9 is " + (10 > 9));
    }


}
