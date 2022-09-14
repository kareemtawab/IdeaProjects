package com.company;

public class Car extends Vehicle implements SpecialVehicle{
    @Override
    void calcMinSpeed() {
        super.calcMinSpeed();
        System.out.println("Car class calcMinSpeed function called");
    }

    @Override
    void calcMaxSpeed() {
        super.calcMaxSpeed();
        System.out.println("Car class calcMaxSpeed function called");
    }

    @Override
    void brake() {
        super.brake();
        System.out.println("Car class brake function called");
    }

    @Override
    public void automaticMovement() {
        System.out.println("Interface automaticMovement function called");
    }
}