package com.company;

public class Bike extends Vehicle {
    @Override
    void calcMinSpeed() {
        super.calcMinSpeed();
        System.out.println("Bike class calcMinSpeed function called");
    }

    @Override
    void calcMaxSpeed() {
        super.calcMaxSpeed();
        System.out.println("Bike class calcMaxSpeed function called");
    }

    @Override
    void brake() {
        super.brake();
        System.out.println("Bike class brake function called");
    }
}
