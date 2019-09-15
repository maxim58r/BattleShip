package com.company;

public class Field {
    private final int ROWS = 11;
    private final int COLS = 10;
    private String[][] coordinateOnField = new String[ROWS][COLS];

    void init() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                coordinateOnField[i][j] = ".";
            }
        }
    }

    void viewField() {
        for (int i = 0; i < ROWS; i++) {
            System.out.print(i + "\t");
            for (int j = 0; j < COLS; j++) {
                if (i == 0) {
                    System.out.print(j + 1 + "\t");
                } else System.out.print(coordinateOnField[i][j] + "\t");
            }
            System.out.println();
        }
    }

    void setShip(int deck, int lengthLimit) {
        Ship ship = new Ship();
        SetPointShip setPointShip = ship.makeShip(lengthLimit);
        boolean direction = ship.shipRandomDirection();
        int xCoordinate = setPointShip.getX();
        int yCoordinate = setPointShip.getY();
        System.out.println(xCoordinate + " " + yCoordinate);
        System.out.println(direction);


        if (direction) {
            if ((xCoordinate >= 1 && yCoordinate >= 1) || (xCoordinate <= lengthLimit && yCoordinate <= 10)) {
                for (int i = 0; i < deck; i++) {
                    if (!(coordinateOnField[yCoordinate + 1][xCoordinate + (i - 1)] == "O") && !(coordinateOnField[yCoordinate - 1][xCoordinate + (i - 1)] == "O")) {
                        coordinateOnField[yCoordinate][xCoordinate + (i - 1)] = "O";
                    }
                }
            }
        }
        if (!direction) {
            if (xCoordinate >= 1 && yCoordinate >= 1 && xCoordinate <= 10 && yCoordinate <= lengthLimit) {
                for (int i = 0; i < deck; i++) {
                    if (!(coordinateOnField[yCoordinate + i][xCoordinate] == "O") && !(coordinateOnField[yCoordinate + i][xCoordinate - 2] == "O"))
                        coordinateOnField[yCoordinate + i][xCoordinate - 1] = "O";
                }
            }
        }
    }

    void shoot() {
        Player player = new Player();

        PointToShoot pointToShoot = player.shotCoordinate();
        int xCoordinate = pointToShoot.getX();
        int yCoordinate = pointToShoot.getY();

        if (coordinateOnField[xCoordinate][yCoordinate - 1].equals("X")) {
            System.out.println("Already shot here");

        }
        if (coordinateOnField[xCoordinate][yCoordinate - 1].equals(".")) {
            System.out.println("Not hit the ship");
            coordinateOnField[xCoordinate][yCoordinate - 1] = "X";

        }
        if (coordinateOnField[xCoordinate][yCoordinate - 1].equals("O")) {
            System.out.println("Hit the ship");
            coordinateOnField[xCoordinate][yCoordinate - 1] = "+";

        }
    }

    boolean notEndGame() {
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLS; j++)
                if (coordinateOnField[i][j].equals("O")) {
                    return true;
                }
        System.out.println("End game");
        return false;
    }
}