package com.coding;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GitPanel extends JPanel implements ActionListener {
    int width = 400;
    int height = 400;
    Method math = new Method();
    WebCam camera = new WebCam();
    Timer timer;
    JMenuBar menuBar = new JMenuBar();
    JMenu actions = new JMenu("Action");
    JMenuItem saveCapture = new JMenuItem("save photo");
    public GitPanel() {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLUE);
        setupEvents();
        timer = new Timer((int)math.fps(60), this);
        timer.start();
        camera.begin();
        menuBar.add(actions);
        actions.add(saveCapture);
    }
    public void setupEvents() {
        saveCapture.addActionListener((e) -> {
            JFileChooser chooser = new JFileChooser(camera.directory);
            chooser.setDialogTitle("save as");
            if(chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                camera.saveFrame(file);
            }
        });
    }
    public void paintComponent(Graphics git) {
        git.drawImage(camera.getImage(), 0, 0, width, height, null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}