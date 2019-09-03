package com.company;

class Field {
    private final int ROWS = 11;
    private final int COLS = 10;
    private String[][] sizeOfField = new String[ROWS][COLS];

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

    void setShip(int deck, int lenghtLimit) {
        Ship ship = new Ship();
        SetPointShip setPointShip = ship.makeShip(lenghtLimit);
        boolean direction = ship.shipRandomDirection();
        int xCoordinate = setPointShip.getX();
        int yCoordinate = setPointShip.getY();
        System.out.println(xCoordinate + " " + yCoordinate);
        System.out.println(direction);

        if (direction) {
            if ((xCoordinate >= 1 && yCoordinate >= 1) || (xCoordinate <= lenghtLimit && yCoordinate <= 10)) {
                for (int i = 0; i < deck; i++) {
                    sizeOfField[yCoordinate][xCoordinate + (i - 1)] = "O";
                }
            }
        }
        if (!direction) {
            if (xCoordinate >= 1 && yCoordinate >= 1 && xCoordinate <= 10 && yCoordinate <= lenghtLimit) {
                for (int i = 0; i < deck; i++) {
                    sizeOfField[yCoordinate + i][xCoordinate - 1] = "O";
                }
            }
        }
    }

    void shoot() {
        Player player = new Player();

        PointToShoot pointToShoot = player.shotCoordinate();
        int xCoordinate = pointToShoot.getX();
        int yCoordinate = pointToShoot.getY();

        if (sizeOfField[xCoordinate][yCoordinate - 1].equals("X")) {
            System.out.println("Already shot here");

        }
        if (sizeOfField[xCoordinate][yCoordinate - 1].equals(".")) {
            System.out.println("Not hit the ship");
            sizeOfField[xCoordinate][yCoordinate - 1] = "X";

        }
        if (sizeOfField[xCoordinate][yCoordinate - 1].equals("O")) {
            System.out.println("Hit the ship");
            sizeOfField[xCoordinate][yCoordinate - 1] = "+";

        }
    }

    boolean notEndGame() {
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLS; j++)
                if (sizeOfField[i][j].equals("O")) {
                    return true;
                }
        System.out.println("End game");
        return false;
    }
}