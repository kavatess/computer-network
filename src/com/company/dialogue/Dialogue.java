package com.company.dialogue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;

public class Dialogue extends JFrame implements ActionListener {
    protected final Socket socket;
    protected final JTextField nameBox = new TextFieldBuilder("Nhap ten ban...", Color.pink).create();
    protected final JTextField msgBox = new TextFieldBuilder(30).create();
    protected final JTextArea msgList = new TextAreaBuilder().create();
    protected final JScrollPane scrollPane = new JScrollPane(msgList);
    protected String msgHistory = "";

    public Dialogue(String title, Socket socket) {
        this.socket = socket;
        setTitle(title);
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        add(nameBox, BorderLayout.PAGE_START);
        add(scrollPane, BorderLayout.CENTER);
        add(msgBox, BorderLayout.PAGE_END);
        msgBox.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(msgBox)) {
            try {
                String msg = nameBox.getText() + ": " + msgBox.getText();

                PrintWriter sender = new PrintWriter(socket.getOutputStream(), true);
                sender.println(msg);

                appendNewMsg(msg + "\n");
                clearMsgBox();
            } catch (Exception r) {
                r.printStackTrace();
            }
        }
    }

    public void appendNewMsg(String newMsg) {
        msgHistory += newMsg;
        msgList.setText(msgHistory);
        msgList.setVisible(false);
        msgList.setVisible(true);
    }

    public void clearMsgBox() {
        msgBox.setText("");
        msgBox.requestFocus();
    }
}
