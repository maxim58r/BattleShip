package com.company;

import java.util.Random;

class Computer {
    private Random random = new Random();

    PointToShoot shotCoordinate() {
        int x = 1 + random.nextInt(10);
        int y = 1 + random.nextInt(10);

        return new PointToShoot( x, y);
    }

}