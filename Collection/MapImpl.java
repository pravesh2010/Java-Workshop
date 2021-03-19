package com.mphasis.assignment.Collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 *   Implementing map and pefoming iteration Through entryset()
 */
public class MapImpl {
    public static void main(String args[]) {

        // Use a data structure.
        HashMap<String , Double> hm = new HashMap<>();

        // Place elements to the data structure
        hm.put("John Doe", new Double(3434.34));
        hm.put("Tom Smith", new Double(123.22));
        hm.put("Jane Baker", new Double(1378.00));
        hm.put("Tod Hall", new Double(99.22));
        hm.put("Ralph Smith", new Double(-19.08));

        // Get a set of the entries.
        Set<Map.Entry<String, Double>> set = hm.entrySet();

        // Display the set.
        for(Map.Entry<String, Double> me : set) {
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }

        System.out.println();

        // Deposit 1000 into John Doe's account.
        double balance = hm.get("John Doe");
        hm.put("John Doe", balance + 1000);

        System.out.println("John Doe's new balance: " +
                hm.get("John Doe"));
    }
}
