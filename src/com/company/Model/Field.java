package com.company.Model;

import java.util.Random;

class Field {
    private final Random random = new Random();
    private final int SIZE = 10;
    private final String[][] coordinateOnField = new String[SIZE][SIZE];

    void init() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                coordinateOnField[j][i] = ".";
            }
        }
    }

    void viewField() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(coordinateOnField[j][i] + "\t");
            }
            System.out.println();
        }
    }

    void setShip(int decks, int countShip) {

        while (countShip > 0) {
            int direction = random.nextInt(2);

            int xCoordinate;
            int yCoordinate;
            if (direction == 0) {
                xCoordinate = random.nextInt(SIZE - decks);
                yCoordinate = random.nextInt(SIZE);
            } else {
                xCoordinate = random.nextInt(SIZE);
                yCoordinate = random.nextInt(SIZE - decks);
            }

            System.out.println(xCoordinate + " " + yCoordinate);
            System.out.println(direction == 0 ? "horizontal" : "vertical");

            CheckFreeSpaceForShip checkFreeSpaceForShip = new CheckFreeSpaceForShip();
            if (checkFreeSpaceForShip.check(direction, xCoordinate, yCoordinate, decks, coordinateOnField)) {
                for (int i = 0; i < decks; i++) {
                    coordinateOnField[xCoordinate][yCoordinate] = "O";

                    switch (direction) {
                        case 0:/*horizontal*/
                            xCoordinate++;
                            break;
                        case 1:/*vertical*/
                            yCoordinate++;
                            break;
                    }
                }
                countShip--;
            }
        }
    }

    void shoot() {
        shootPlayer();
        shootComputer();
    }

    private void shootPlayer() {
        Player player = new Player();
        String name = "Player";
        PointToShoot pointToShootPlayer = player.shotCoordinate();
        int y = pointToShootPlayer.getX();
        int x = pointToShootPlayer.getY();

        coordinateForShoot(y, x, name);
    }

    private void shootComputer() {
        Computer computer = new Computer();
        String name = "Computer";

        PointToShoot pointToShootComputer = computer.shotCoordinate();
        int xComp = pointToShootComputer.getX();
        int yComp = pointToShootComputer.getX();

        coordinateForShoot(yComp, xComp, name);
    }

    private void coordinateForShoot(int y, int x, String name) {
        if (coordinateOnField[x - 1][y - 1].equals("X")) {
            System.out.println("Already shot here " + name);
        }
        if (coordinateOnField[x - 1][y - 1].equals(".")) {
            System.out.println("Not hit the ship " + name);
            if (name.equals("Computer")) {
                coordinateOnField[x - 1][y - 1] = "V";
            } else {
                coordinateOnField[x - 1][y - 1] = "X";
            }
        }
        if (coordinateOnField[x - 1][y - 1].equals("O")) {
            System.out.println("Hit the ship " + name);
            if (name.equals("Computer")) {
                coordinateOnField[x - 1][y - 1] = "o";
            } else {
                coordinateOnField[x - 1][y - 1] = "+";
            }
        }
    }

    boolean notEndGame() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (coordinateOnField[j][i].equals("O")) {
                    return true;
                }
        System.out.println("End game");
        return false;
    }
}