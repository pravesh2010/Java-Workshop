package com.mphasis.assignment.serialization;

import java.io.*;

public class Two implements Serializable {
    private static final long serialVersionUID =1L;
    transient int a;
    static int b;
    String name;
    int age;

    public Two(int a,int b, String name, int age) {
        this.a = a;
        this.b = b;
        this.name = name;
        this.age = age;
    }
    }

    class Test{
        public static void printData(Two object1)
        {

            System.out.println("name = " + object1.name);
            System.out.println("age = " + object1.age);
            System.out.println("a = " + object1.a);
            System.out.println("b = " + object1.b);
        }

        public static void main(String[] args) {
            Two object = new Two(5, 10, "ab", 40);
            String filename = "File1.txt";

            try {
                FileOutputStream file = new FileOutputStream
                        (filename);
                ObjectOutputStream out = new ObjectOutputStream
                        (file);

                out.writeObject(object);

                out.close();
                file.close();

                System.out.println("Object has been serialized\n"+ "Data before Deserialization.");
                printData(object);

                object.b = 2000;
            }

            catch (IOException ex) {
                System.out.println("IOException is caught");
            }

            object = null;

            try {

                FileInputStream file = new FileInputStream
                        (filename);
                ObjectInputStream in = new ObjectInputStream
                        (file);

                object = (Two)in.readObject();

                in.close();
                file.close();
                System.out.println("Object has been deserialized\n" + "Data after Deserialization.");
                printData(object);

            }

            catch (IOException ex) {
                System.out.println("IOException is caught");
            }

            catch (ClassNotFoundException ex) {
                System.out.println("ClassNotFoundException" +
                        " is caught");
            }
        }
    }


