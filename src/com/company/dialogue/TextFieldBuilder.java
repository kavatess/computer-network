package com.company.dialogue;

import javax.swing.*;
import java.awt.*;

public class TextFieldBuilder {
    private String placeholder;
    private int columns;
    private Font font = new Font("Arial", Font.BOLD, 20);
    private Color color;

    public TextFieldBuilder(int columns) {
        this.columns = columns;
    }

    public TextFieldBuilder(String placeholder, Color color) {
        this.placeholder = placeholder;
        this.color = color;
    }

    public JTextField create() {
        JTextField nameBox = columns == 0
                ? new JTextField(placeholder)
                : new JTextField(placeholder, columns);
        nameBox.setFont(font);
        nameBox.setBackground(color);
        return nameBox;
    }
}
