package com.mphasis;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Process {

    void test1() throws ClassNotFoundException {
        test2();
    }
    void test2() throws ClassNotFoundException {
        test3();
    }
    void test3() throws ClassNotFoundException {
        test4();
    }
    void test4() throws ClassNotFoundException {
        Class.forName("java.Util.Dat");
    }

    public static void main(String[] args) {

        Logger logger= Logger.getLogger(Arithmetic.class.getName());
        try {
            new Process().test1();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        logger.log(Level.INFO, "END");
    }

}
