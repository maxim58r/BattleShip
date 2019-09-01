package com.company;

import java.util.Scanner;

public class Field {
    //    Scanner scanner = new Scanner(System.in);
    final int ROWS = 11;
    final int COLS = 10;
    String[][] sizeOfField = new String[ROWS][COLS];
    Player player = new Player();

    void init() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                sizeOfField[i][j] = ".";
            }
        }
    }

    void viewField() {
        for (int i = 0; i < ROWS; i++) {
            System.out.print(i + "\t");
            for (int j = 0; j < COLS; j++) {
                if (i == 0) {
                    System.out.print(j + 1 + "\t");
                } else System.out.print(sizeOfField[i][j] + "\t");
            }
            System.out.println();
        }
    }

    void shot() {

        PointToShoot pointToShoot = player.shotCoordinate();
        int xCoordinate = pointToShoot.getX();
        int yCoordinate = pointToShoot.getY();

        sizeOfField[xCoordinate][yCoordinate - 1] = "X";
    }
}

