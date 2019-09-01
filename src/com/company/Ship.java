package com.company;

import java.util.Random;

public class Ship {
    Random random = new Random();
    final int sizeOfShip4Deck = 4;
    final int sizeOfShip3Deck = 3;
    final int sizeOfShip2Deck = 2;
    final int sizeOfShip1Deck = 1;
    final int amountOfShip4Deck = 1;
    final int amountOfShip3Deck = 2;
    final int amountOfShip2Deck = 3;
    final int amountOfShip1Deck = 4;
    final int amountAllShips = 10;
    boolean directionShip;
    int positionX;
    int positionY;


    boolean shipRandomDirection() {
        directionShip = random.nextBoolean();
        return directionShip;
    }

    void makeShip() {


    }
}