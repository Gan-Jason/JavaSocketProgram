package com.gan.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerClient {
    private String[] advicelist = {
            "Take smaller bites",
            "Go for the tight jeans",
            "One word:inappropriate",
            "Just for today,be honest",
            "You might want to rethink that haircut"
    };

    public static void main(String[] args) {
        ServerClient se = new ServerClient();
        se.accept();

    }

    private void accept() {
        try {
            ServerSocket server = new ServerSocket(1688);

            while (true) {

                Socket sock = server.accept();


                PrintWriter writer = new PrintWriter(sock.getOutputStream());

                String advice = advicelist[(int) (Math.random() * advicelist.length)];
                writer.println(advice);
                writer.close();
                //System.out.println(advice);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }


}
