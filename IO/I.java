package com.mphasis.assignment.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class I {
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
