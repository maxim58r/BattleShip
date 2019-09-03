package com.company;

import java.util.Random;

class Ship {
    private Random random = new Random();
    private boolean directionShip;

    boolean shipRandomDirection() {
        directionShip = random.nextBoolean();
        return directionShip;
    }

    SetPointShip makeShip(int limitLenght) {
        int xCoordinate;
        int yCoordinate;
        xCoordinate = 1 + random.nextInt(limitLenght);
        yCoordinate = 1 + random.nextInt(limitLenght);

        return new SetPointShip(xCoordinate, yCoordinate);
    }
}