package com.coding;

import javax.swing.*;

public class Window extends JFrame {
    public Window() {
        GitPanel gitPanel = new GitPanel();
        this.setTitle("Git");
        this.setLocation(300, 17);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setJMenuBar(gitPanel.menuBar);
        this.setContentPane(gitPanel);
        this.pack();
        this.setVisible(true);
    }
}
