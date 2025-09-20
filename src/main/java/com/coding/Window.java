package com.coding;

import javax.swing.*;

public class Window extends JFrame {
    public Window() {
        this.setTitle("Git");
        this.setLocation(300, 17);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new GitPanel());
        this.pack();
        this.setVisible(true);
    }
}
