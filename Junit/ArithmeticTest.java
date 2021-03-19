package com.mphasis.main;

import static org.junit.Assert.*;

/*
 *  Creating junit tescase and perform unit testing
 */
public class ArithmeticTest {

    @org.junit.Test
    public void sum(){
        int expectedResult=6;
        Arithmetic arithmetic= new Arithmetic();
        int actualResult= arithmetic.sum(2,4);
        assertEquals(expectedResult,actualResult);
    }

}