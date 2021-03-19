package com.mphasis.assignment.io;

import java.io.*;
/*
 *  Creating DataoutputStream and write premitivetypes in outputStream
 */
public class DataoutputStreamExample {
    public static void main(String args[]) throws Exception {

        FileOutputStream fout = new FileOutputStream("D:/java/Test.dat");
        DataOutputStream out = new DataOutputStream(fout);

        out.writeDouble(98.6);
        out.writeInt(1000);
        out.writeBoolean(true);

        System.out.println("working");
        out.close();

        FileInputStream fin = new FileInputStream("D:/java/Test.dat");
        DataInputStream in = new DataInputStream(fin);

        double d = in.readDouble();
        int i = in.readInt();
        boolean b = in.readBoolean();

        System.out.println("Here are the values:  " +
                d + " " + i + " " + b);

        in.close();
    }
}
