package com.company;

import com.company.dialogue.Dialogue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Client {
    public static void main(String[] args) {
        try
        {
            String ip = JOptionPane.showInputDialog(null, "Nhap IP may chu...");
            Socket sB = new Socket(ip,2222);
            Dialogue dialogue = new Dialogue("client", sB);

            InputStreamReader inputStream = new InputStreamReader(sB.getInputStream());
            BufferedReader buffer = new BufferedReader(inputStream);
            String receivedStr = null;
            while((receivedStr = buffer.readLine()) != null)
            {
                dialogue.appendNewMsg(receivedStr + "\n");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
