package com.company;

import java.util.Random;

public class Ship {
    Random random = new Random();
    boolean directionShip;

    boolean shipRandomDirection() {
        directionShip = random.nextBoolean();
        return directionShip;
    }

    SetPointShip makeShip(int limitLength) {
        int xCoordinate;
        int yCoordinate;
        xCoordinate = 1 + random.nextInt(limitLength);
        yCoordinate = 1 + random.nextInt(limitLength);

        return new SetPointShip(xCoordinate, yCoordinate);
    }

}