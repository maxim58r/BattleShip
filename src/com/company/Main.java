package com.company;

class Main {
    public static void main(String[] args) {
        Field field = new Field();

        field.init();
        int j = 0;
        for (int i = 4; i > 0; i--) {
            j++;
            field.setShip(i, j);
        }
        field.viewField();

        do {
            field.shoot();
            field.viewField();
        } while ((field.notEndGame()));
    }
}