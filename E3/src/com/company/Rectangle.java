package com.company;

public class Rectangle {
    private float length;
    private float width;

    public Rectangle (){
        length = 5.2f;
        width = 8.9f;
        System.out.println("A new \"Rectangle\" class was created using constructor with assigned length of " + length + " meters and assigned width of " + width + " meters");
    }

    public float getArea(){
        return length * width;
    }
}
