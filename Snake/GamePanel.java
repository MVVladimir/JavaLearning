package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener, ActionListener {

    private int DIRECTION = 87; // a, w, d, s
    private static final int UNIT_SIZE = 25;
    private static int TOTAL_UNITS;
    private static int WINDOW_WIDTH;
    private static int WINDOW_HEIGHT;
    private static final int DELAY = 250;
    private static int START_POSITION;
    private static int x[];
    private static int y[];
    int snakeLength = 6;

    public GamePanel(int WINDOW_WIDTH, int WINDOW_HEIGH ) {
        super();
        setFocusable(true);
        this.WINDOW_WIDTH = WINDOW_WIDTH;
        this.WINDOW_HEIGHT = WINDOW_HEIGH;

        TOTAL_UNITS = (WINDOW_HEIGH * WINDOW_WIDTH) / UNIT_SIZE;
        START_POSITION = ((WINDOW_HEIGH / UNIT_SIZE) / 2) * UNIT_SIZE;

        x = new int[TOTAL_UNITS];
        y = new int[TOTAL_UNITS];

        for (int i = 0; i <= snakeLength; i += 1) {
            x[i] = START_POSITION;
            y[i] = START_POSITION + i * UNIT_SIZE;
        }

        addKeyListener(this);
        Timer timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < WINDOW_WIDTH/UNIT_SIZE; i += 1) {
            g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, WINDOW_HEIGHT);
            g.drawLine(0, i*UNIT_SIZE, WINDOW_WIDTH, i*UNIT_SIZE);
        }

        g.setColor(Color.green);
        g.fillRect(x[0], y[0], UNIT_SIZE, UNIT_SIZE);

        for (int i = snakeLength; i > 1; i -= 1) {
            g.setColor(new Color(60,200,10));
            g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        DIRECTION = e.getKeyCode();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    //    DIRECTION = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (DIRECTION){
            case 65:
                x[0] -= UNIT_SIZE;
                break; // left
            case 87:
                y[0] -= UNIT_SIZE;
                break; // up
            case 68:
                x[0] += UNIT_SIZE;
                break; // right
            case 83:
                y[0] += UNIT_SIZE;
                break; // down
        }

        for (int i = snakeLength; i > 0; i -= 1) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        repaint();
    }
}
