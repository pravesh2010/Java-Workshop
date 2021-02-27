package com.mphasis.assignment.serialization;

import java.io.*;

public class One implements Serializable {
    public int a;
    public String b;

    public One(int a, String b) {
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) {
        One one= new One(1,"Serialize");
        String fileName= "file.ser";

        try {
            FileOutputStream fileOutputStream= new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream= new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(one);

            objectOutputStream.close();
            fileOutputStream.close();

            System.out.println("object has been Serialized");
        } catch (IOException e) {
            System.out.println("Exception is caught");
        }
        One one1= null;

        try {
            FileInputStream fileInputStream= new FileInputStream(fileName);
            ObjectInputStream objectInputStream= new ObjectInputStream(fileInputStream);
            one1= (One) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();

            System.out.println("Object has been deserialized ");
            System.out.println("a = " + one1.a);
            System.out.println("b = " + one1.b);

        } catch (IOException | ClassNotFoundException ex) {

            System.out.println("IOException is caught");
            System.out.println("ClaasNotFoundException is caught");

        }
    }
}
