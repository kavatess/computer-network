package com.company.thread;

import java.io.*;
import java.net.*;

public class MultiThreadClient {

    public static void main(String args[]) throws UnknownHostException, IOException {
        // establish the connection
        Socket s = new Socket("localhost", 2222);

        // obtaining input and out streams
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        MultiThreadDialogue dialogue = new MultiThreadDialogue("client", s, dos);

        // readMessage thread
        Thread readMessage = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        // read the message sent to this client
                        String receivedMsg = dis.readUTF();
                        dialogue.appendNewMsg(receivedMsg + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        readMessage.start();
    }
}
