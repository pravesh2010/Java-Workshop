package com.mphasis;

import sun.rmi.runtime.Log;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Arithmetic {
    public int sum(int num1, int num2){
        return num1+num2;
    }

}
class Main2{
    public static void main(String[] args) {
        Logger logger= Logger.getLogger(Arithmetic.class.getName());
        System.out.println(args[0]+args[1]);
        assert(new Arithmetic().sum(2,4)==6):"The sum method has logical errors";
        logger.log(Level.INFO, "END");
    }
}
