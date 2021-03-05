package com.mphasis.assignment.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStream;

public class C {
    public static void main(String args[]) {
        String dirname = "D:/java";
        File f1 = new File(dirname);
        FilenameFilter only = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                boolean result;
                if(name.startsWith("contents")){
                    result=true;
                }
                else{
                    result=false;
                }
                return result;
            }
        };
        String s[] = f1.list(only);

        for (int i=0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }

}
