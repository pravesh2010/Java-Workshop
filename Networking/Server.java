package com.mphasis.network;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


/*
 *  Creating server and connect to the client
 */
public class Server {

    public static void main(String[] args) {
        ServerSocket serverSocket;
        try{
            serverSocket = new ServerSocket(7654);
            while(true) {
                Socket client = serverSocket.accept();

                System.out.println("Client Connect");

                OutputStream outputStream= client.getOutputStream();
                PrintWriter pw= new PrintWriter(new OutputStreamWriter(outputStream));
                pw.write("Hello Java");
                pw.close();
                client.close();
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
