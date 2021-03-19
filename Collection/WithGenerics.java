package com.mphasis.assignment.Collection;

import java.util.ArrayList;
import java.util.Iterator;

/*
 *   Implementing Arraylist with generics and prfoming iteration
 */
public class WithGenerics{
    public static void main(String args[]) {

        // Now, list holds references of type String.
        ArrayList<String> list = new ArrayList<String>();

        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        // Iterator is also generic.
        Iterator<String> itr = list.iterator();

        while(itr.hasNext()) {
            String str = itr.next(); // no cast needed

            System.out.println(str + " is " + str.length() + " chars long.");
        }
    }
}
