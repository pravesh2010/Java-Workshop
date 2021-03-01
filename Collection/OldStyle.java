package com.mphasis.assignment.Collection;

import java.util.ArrayList;
import java.util.Iterator;

public class OldStyle {

    public static void main(String args[]) {

        ArrayList list = new ArrayList();


        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        Iterator itr = list.iterator();
        while (itr.hasNext()) {

            // To retrieve an element, an explicit type cast is needed
            // because the collection stores only Object.
            String str = (String) itr.next(); // explicit cast needed here.
            System.out.println(str);
            System.out.println(str + " is " + str.length() + " chars long.");
        }
    }
}
