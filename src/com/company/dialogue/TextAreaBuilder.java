package com.company.dialogue;

import javax.swing.*;
import java.awt.*;

public class TextAreaBuilder {
    private Font font = new Font("Arial", Font.BOLD, 20);
    private Color color = Color.cyan;
    private boolean editable = false;

    public TextAreaBuilder() {
    }

    public TextAreaBuilder(Font font, Color color, boolean editable) {
        this.font = font;
        this.color = color;
        this.editable = editable;
    }

    public JTextArea create() {
        JTextArea content = new JTextArea();
        content.setFont(font);
        content.setBackground(color);
        content.setEditable(editable);
        return content;
    }
}
