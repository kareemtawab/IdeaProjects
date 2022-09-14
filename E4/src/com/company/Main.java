package com.company;

public class Main {

    public static void main(String[] args) {
        // ----------------------------------
        System.out.println("**ASSIGNMENT 4**");
        System.out.println("**CODE 1**");

        Car koenigsegg = new Car();
        Bike trek = new Bike();

        koenigsegg.calcMinSpeed();
        koenigsegg.calcMaxSpeed();
        koenigsegg.brake();

        trek.calcMinSpeed();
        trek.calcMaxSpeed();
        trek.brake();

        System.out.println();

        // ----------------------------------
        System.out.println("**ASSIGNMENT 4**");
        System.out.println("**CODE 2**");

        koenigsegg.automaticMovement();
    }
}
