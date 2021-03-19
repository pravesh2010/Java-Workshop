package com.java8.Stream;

import java.util.Arrays;
import java.util.List;

/*
 *  Creating list and perform stream, reduce operations
 */
public class StreamReduceExamples{

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

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
                .reduce(1,Integer::sum));

    }

}
