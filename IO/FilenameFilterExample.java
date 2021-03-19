package com.mphasis.assignment.io;


import java.io.File;
import java.io.FilenameFilter;

/*
 *  Creating file and filter through filenamefilter
 */
public class FilenameFilterExample {
    public static void main(String args[]) {
        String dirname = "D:/java";
	
	// create new file
        File f1 = new File(dirname);
	
	// create new filename filter
        FilenameFilter only = new FilenameFilter() {
		
		//override accept method of filenamefilter interface
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
