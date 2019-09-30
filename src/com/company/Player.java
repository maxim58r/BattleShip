package com.company;

import java.util.Scanner;

@SuppressWarnings("SuspiciousNameCombination")
class Player {
    private final Scanner scanner = new Scanner(System.in);

    PointToShoot shotCoordinate() {
        System.out.print("Enter coordinate shoot by x: ");
        int xCoordinate = scanner.nextInt();
        while (!(xCoordinate > 0 && xCoordinate < 11)) {
            System.out.print("Enter coordinate shoot by x: ");
            xCoordinate = scanner.nextInt();
        }

        System.out.print("Enter coordinate shoot by y: ");
        int yCoordinate = scanner.nextInt();
        while (!(yCoordinate > 0 && yCoordinate < 11)) {
            System.out.print("Enter coordinate shoot by y: ");
            yCoordinate = scanner.nextInt();
        }
        System.out.printf("You enter coordinates x: %d, y: %d\n", xCoordinate, yCoordinate);
        return new PointToShoot(xCoordinate, yCoordinate);
    }
}