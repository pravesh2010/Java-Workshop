package com.mphasis.assignment.day1;

/*
 *   performing arithmetic operation and finding distance
 */
public class Light {
    public static void main(String args[]) {
        long lightspeed;
        long days;
        long seconds;
        long distance;


        lightspeed = 186000;

        days = 1000; // specify number of days here

        seconds = days * 24 * 60 * 60; // convert to seconds

        distance = lightspeed * seconds; // compute distance

        System.out.print("In " + days);
        System.out.print(" days light will travel about ");
        System.out.println(distance + " miles.");
    }

}
