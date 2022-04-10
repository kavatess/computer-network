package com.company.thread;

import com.company.dialogue.Dialogue;

import java.awt.event.ActionEvent;
import java.io.DataOutputStream;
import java.net.Socket;

public class MultiThreadDialogue extends Dialogue {
    private final DataOutputStream dos;

    public MultiThreadDialogue(String title, Socket socket, DataOutputStream dos) {
        super(title, socket);
        this.dos = dos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(msgBox)) {
            try {
                String msg = nameBox.getText() + ": " + msgBox.getText();
                dos.writeUTF(msg);

                appendNewMsg(msg + "\n");
                clearMsgBox();
            } catch (Exception r) {
                r.printStackTrace();
            }
        }
    }
}
