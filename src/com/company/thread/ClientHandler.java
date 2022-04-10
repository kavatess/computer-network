package com.company.thread;

import java.io.*;
import java.net.*;

class ClientHandler implements Runnable {
    private final Socket s;
    private final String name;
    private final DataInputStream dis;
    private final DataOutputStream dos;

    // constructor
    public ClientHandler(
            Socket s,
            String name,
            DataInputStream dis,
            DataOutputStream dos
    ) {
        this.s = s;
        this.name = name;
        this.dis = dis;
        this.dos = dos;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // receive the string
                String received = dis.readUTF();
                System.out.println(received);

                for (ClientHandler client : MultiThreadServer.clientList) {
                    if (!client.name.equals(name)) {
                        client.dos.writeUTF(received);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
