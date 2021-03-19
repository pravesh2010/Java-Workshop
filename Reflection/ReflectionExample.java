package com.mphasis.reflection;

import java.util.HashSet;
import java.util.Set;

/*
 *  getting information about class 
 */
public class ReflectionExample {
    public static void main(String[] args) {

        byte[] bytes = new byte[1024];
        Class c = bytes.getClass();
        System.out.println(c);

      Set<String> s = new HashSet<String>();
        Class c1 = s.getClass();
        System.out.println(c1);


        Class c= boolean.class;
        System.out.println(c);

    }
}
