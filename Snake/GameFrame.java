package com.company;

import javax.swing.*;

public class GameFrame extends JFrame {

    public static GamePanel gamePanel = new GamePanel(600, 600);

    public GameFrame(int x, int y, int w, int h) {
        super();
        setBounds(x, y, w, h);
        add(gamePanel);
        setVisible(true);
    }

}
