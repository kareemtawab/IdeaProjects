package com.company;

public class Main {

    public static void main(String[] args) {
        // ----------------------------------
        System.out.println("**ASSIGNMENT 3**");
        System.out.println("**CODE 1**");

        Customer c1 = new Customer();
        System.out.println("New \"Customer\" class was created with the fields ‘id’, ‘name’, ‘address’ and ‘isSpecial’ members");
        System.out.println();
        //c1.display();

        // ----------------------------------
        System.out.println("**ASSIGNMENT 3**");
        System.out.println("**CODE 2**");

        c1.setId(4);
        c1.setName("Kareem");
        c1.setAddress("Cairo");
        c1.setIsSpecial(true);
        c1.display();

        // ----------------------------------
        System.out.println("**ASSIGNMENT 3**");
        System.out.println("**CODE 3**");

        int a, b, c, d;
        float m, n, o;
        a = 23;
        b = 54;
        c = 17;
        d = 87;
        m = 23.2f;
        n = 54.5f;
        o = 17.9f;

        Polymorphism p = new Polymorphism();

        System.out.println("Four functions made named \"add\" using Polymorphism");
        System.out.println("First adder function result = " + p.add(m, a));
        System.out.println("Second adder function result = " + p.add(n, b, c));
        System.out.println("Third adder function result = " + p.add(o, d, m));
        System.out.println("Fourth adder function result = " + p.add(a, b, c, d));
        System.out.println();

       // ----------------------------------
        System.out.println("**ASSIGNMENT 3**");
        System.out.println("**CODE 4**");

        Rectangle r = new Rectangle();
        System.out.println("Area of rectangle is " + r.getArea());
    }
}
