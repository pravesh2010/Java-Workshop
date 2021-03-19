package com.mphasis.java8;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
/*
 *  Creating List and performing Stream Operation and lambda expression
 */
public class StreamExample{
    public static void main(String[] args) {
	//create list 
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// java 7
                for (Object list: numbers){         
                    System.out.println(list);
                }
	
	//java 8 lambda expression
        numbers.forEach(e -> System.out.println(e)); 
	
	// java 8 lambda expression with method reference
        numbers.forEach(System.out::println); 


		//Stream operations with map, filter, reduce methods
                numbers.stream()
                        .map(e -> e*2.0)
                        .forEach(System.out::println);

                numbers.stream()
                        .map(String::valueOf)
                        .forEach(System.out::println);

       System.out.println( numbers.stream().
                reduce(0,(total,e)->Integer.sum(total,e)));

        System.out.println(numbers.stream()
                .map(e-> String.valueOf(e))
                .reduce("",(conctdString,str)->conctdString.concat(str)));

       System.out.println(numbers.stream()
                .map(e->String.valueOf(e))
                .reduce("", String::concat));

       System.out.println(numbers.stream()
                .filter(e-> e%2 ==0)
                .map(e-> e*2)
                .reduce(0,Integer::sum));

       System.out.println(numbers.stream()
                .filter(e-> e%2==0)
                .map(e-> e*2)
                .reduce(0,Integer::sum));

        List<Integer> list= Arrays.asList(1,2,3,4,5,1,2,3,4,5);
        List<Integer> list1= list.stream().filter(element-> element%2==0)
                .map(element-> element*2)
                .collect(Collectors.toList());
        System.out.println(list1);

         Set<Integer> set = new HashSet<Integer>();

        pMonitor.code(() -> System.out.println(numbers.stream()
                .filter(element -> element % 2 == 0)
                .mapToInt(One::compute)
                .sum()));

        pMonitor.code(() -> System.out.println(numbers.parallelStream()
                .filter(element -> element % 2 == 0)
                .mapToInt(One::compute)
                .sum()));

    }

    public static int compute(int number) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return number * 2;
    }
}

class pMonitor {

    public static void code(Runnable task) {
        long start= System.currentTimeMillis();
        try {
            task.run();
        }
        finally {
           long end= System.currentTimeMillis();
            System.out.println("Time taken " + (end-start)/1.0e9);
        }
    }
}