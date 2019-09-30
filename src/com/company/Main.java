package com.company;

class Main {
    public static void main(String[] args) {
        Field field = new Field();
        field.init();
        field.setShip(4, 1);
        field.setShip(3, 2);
        field.setShip(2, 3);
        field.setShip(1, 4);
        field.viewField();

        do {
            field.shoot();
            field.viewField();
        } while ((field.notEndGame()));
    }
}