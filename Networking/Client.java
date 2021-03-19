package com.mphasis.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;


/*
 *  Creating client and connect to the server
 */
public class Client {
    public static void main(String[] args) {

        try {
            Socket socket=new Socket("192.168.1.159",7654);
            InputStream is= socket.getInputStream();

            BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(is));
            System.out.println(bufferedReader.readLine());

            bufferedReader.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
