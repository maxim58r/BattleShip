package com.company.View;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    JPanel jPanel = new JPanel();
    JButton[][] buttons = new JButton[10][10];

    public void init() {
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("BattleShips");

        jPanel.setLayout(new GridLayout(10, 10));

        int SIZE_FIELD = 10;
        for (int i = 0; i < SIZE_FIELD; i++) {
            for (int j = 0; j < SIZE_FIELD; j++) {
                JButton jButton = new JButton();
                jButton.setBackground(Color.GRAY);
                buttons[j][i] = jButton;
                jPanel.add(jButton);

                int finalJ = j;
                int finalI = i;
                jButton.addActionListener(actionEvent -> {
                    String buttonText = actionEvent.getActionCommand();
                    System.out.printf("Button: %s, x: %d, y: %d\n", buttonText, finalJ, finalI);

                });
            }
        }

        add(jPanel);
        setVisible(true);
    }
}
