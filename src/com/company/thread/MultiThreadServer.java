package com.company.thread;

import com.company.thread.ClientHandler;

import java.io.*;
import java.util.*;
import java.net.*;

// Server class
public class MultiThreadServer {

    // Vector to store active clients
    static Vector<ClientHandler> clientList = new Vector<>();

    // counter for clients
    static int i = 0;

    public static void main(String[] args) throws IOException {
        // server is listening on port 2222
        ServerSocket server = new ServerSocket(2222);

        Socket s;

        // running infinite loop for getting
        // client request
        while (true) {
            // Accept the incoming request
            s = server.accept();

            System.out.println("New client request received : " + s);

            // obtain input and output streams
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            System.out.println("Creating a new handler for this client...");

            // Create a new handler object for handling this request.
            ClientHandler client = new ClientHandler(s, "client " + i, dis, dos);

            // Create a new Thread with this object.
            Thread t = new Thread(client);

            System.out.println("Adding this client to active client list");

            // add this client to active clients list
            clientList.add(client);

            // start the thread.
            t.start();

            // increment i for new client.
            // i is used for naming only, and can be replaced
            // by any naming scheme
            i++;
        }
    }
}
