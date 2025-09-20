package com.coding;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GitPanel extends JPanel implements ActionListener {
    int width = 400;
    int height = 400;
    Method math = new Method();
    WebCam camera = new WebCam();
    Timer timer;
    public GitPanel() {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLUE);
        timer = new Timer((int)math.fps(60), this);
        timer.start();
        camera.begin();
    }
    public void paintComponent(Graphics git) {
        git.drawImage(camera.getImage(), 0, 0, width, height, null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}