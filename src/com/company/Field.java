package com.company;

public class Field {
    final int ROWS = 11;
    final int COLS = 10;
    String[][] sizeOfField = new String[ROWS][COLS];

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

    void shoot() {
        Player player = new Player();

        PointToShoot pointToShoot = player.shotCoordinate();
        int xCoordinate = pointToShoot.getX();
        int yCoordinate = pointToShoot.getY();

        if (sizeOfField[xCoordinate][yCoordinate - 1] == "X") {
            System.out.println("Already shot here");

        }
        if (sizeOfField[xCoordinate][yCoordinate - 1] == ".") {
            System.out.println("Not hit the ship");
            sizeOfField[xCoordinate][yCoordinate - 1] = "X";

        }
        if (sizeOfField[xCoordinate][yCoordinate - 1] == "O") {
            System.out.println("Hit the ship");
            sizeOfField[xCoordinate][yCoordinate - 1] = "X";

        }
    }

    void endGame() {
    }
}