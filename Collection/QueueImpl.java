package com.mphasis.assignment.Collection;

import java.util.ArrayDeque;

/*
 *   Implementing queue collection and pefoming set, get operation
 */
public class QueueImpl{

    public static void main(String args[]) {
	
	// Create a collection. 
        ArrayDeque<String> adq = new ArrayDeque<String>();

        // Use the collection like a stack.
        adq.push("A");
        adq.push("B");
        adq.push("D");
        adq.push("E");
        adq.push("F");

        System.out.print("Popping the stack: ");

        while(adq.peek() != null)
            System.out.print(adq.pop() + " ");

        System.out.println();
    }
}
