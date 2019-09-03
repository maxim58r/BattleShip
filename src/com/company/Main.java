package com.company;

public class Main {
    public static void main(String[] args) {
        Field field = new Field();
        field.init();
        field.setShip(4, 7);
        field.setShip(3, 8);
        field.setShip(2, 9);
        field.setShip(1, 10);
        field.viewField();

        do {
            field.shoot();
            field.viewField();
        } while ((field.notEndGame()));

    }
}