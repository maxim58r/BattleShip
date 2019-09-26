package com.company;


class CheckFreeSpace {

    boolean check(int direction, int x, int y, int decks, String[][] coordinateOnField) {
        int startX;
        int startY;
        int endX = 0;
        int endY = 0;

        startX = (x == 0) ? x : x - 1;
        if (x + decks == 9 && direction == 0) endX = x + decks;
        else if (x + decks < 9 && direction == 0) endX = x + decks/* + 1*/;
        else if (x == 9 && direction == 1) endX = x;
        else if (x < 9 && direction == 1) endX = x + 1;

        startY = (y == 0) ? y : y - 1;
        if (y + decks == 9 && direction == 1) endY = y + decks;
        else if (y + decks < 9 && direction == 1) endY = y + decks/* + 1*/;
        else if (y == 9 && direction == 0) endY = y;
        else if (y < 9 && direction == 0) endY = y + 1;


        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                if(coordinateOnField[i][j].equals("O")) {
                    return false;
                }

            }
        }
        return true;
    }
}

