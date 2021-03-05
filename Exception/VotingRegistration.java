package com.mphasis;

import java.util.logging.Level;
import java.util.logging.Logger;

class IllegalAgeException extends Exception{
    @Override
    public String getMessage() {
        return "your age must be 18";
    }
}
public class VotingRegistration {

        void register(int age) throws IllegalAgeException {
            if(age<18){
                throw new IllegalAgeException();
            }
        }

    public static void main(String[] args) {
        Logger logger= Logger.getLogger(VotingRegistration.class.getName());
        try {
            new VotingRegistration().register( 18);
        } catch (IllegalAgeException e) {
            e.printStackTrace();
        }
        logger.log(Level.INFO, "END");
    }
}
