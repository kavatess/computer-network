package com.company;

import com.company.dialogue.Dialogue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] args) {
        try
        {
            ServerSocket server = new ServerSocket(2222);
            Socket s = server.accept();
            Dialogue dialogue = new Dialogue("server", s);
            while(true)
            {
                BufferedReader inputStream = new BufferedReader(new InputStreamReader(s.getInputStream()));
                String receivedStr = null;
                while((receivedStr = inputStream.readLine()) != null)
                {
                    dialogue.appendNewMsg(receivedStr + "\n");
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
