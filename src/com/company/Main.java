package com.company;

public class Main {
    public static void main(String[] args) {
        Field field = new Field();

        field.init();

        do {
            field.viewField();
            field.shot();
        } while (true);
    }
}