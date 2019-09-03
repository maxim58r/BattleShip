package com.company;

import java.util.Random;

public class Ship {
    Random random = new Random();
    boolean directionShip;
    int decks;

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