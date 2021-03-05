package com.mphasis;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {


        Logger log= Logger.getLogger(Main.class.getName());

        try{
            System.out.println(2/0);
            try{
                System.out.println(Integer.parseInt("23"));    //to create a file
            }catch (ArithmeticException ae){
                log.log(Level.SEVERE, "nope");
            }
            Class.forName("java.util.Date");
            System.out.println("end of try");
        }catch(ArithmeticException ae){
            log.log(Level.SEVERE, "you can not divide by zero");
        }catch(NumberFormatException nfe){
            log.log(Level.SEVERE, "please provide a valid number");
        }catch(ClassNotFoundException e){
            log.log(Level.SEVERE, "could not locate the class");
        }

    }

}
