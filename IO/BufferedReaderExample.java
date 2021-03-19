package com.mphasis.assignment.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
/*
 *  Creating FileReader, BufferedReader and read text from input stream
 */
public class BufferedReaderExample {
    public static void main(String args[]) throws Exception {
        FileReader fr = new FileReader("file2.txt");
        BufferedReader br = new BufferedReader(fr);
        String s;

        while((s = br.readLine()) != null) {
            System.out.println(s);
        }

        fr.close();
    }
}
