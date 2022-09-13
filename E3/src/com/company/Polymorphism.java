package com.company;

public class Polymorphism {
    public float add(float first, int second){
        return first + second;
    }

    public float add(float first, int second, int third){
        return this.add(first, second) + third;
    }

    public float add(float first, int second, float third){
        return this.add(first, second) + third;
    }

    public int add(int first, int second, int third, int forth){
        return (int) (this.add(first, second, third) + forth);
    }
}
