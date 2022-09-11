package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // ----------------------------------
        // greet user
        System.out.println("**ASSIGNMENT 1**");
        System.out.println("**CODE 1**");
        System.out.println("Hello\nKareem\n");

        // ----------------------------------
        System.out.println("**ASSIGNMENT 1**");
        System.out.println("**CODE 2**");
        System.out.println("Hello, Please enter first number for multiplication:");
        Scanner getNumData = new Scanner(System.in);

        // input first number
        int firstNumber;
        firstNumber = getNumData.nextInt();

        // input second number
        System.out.println("OK, Please enter second number for multiplication:");
        int secondNumber;
        secondNumber = getNumData.nextInt();

        // multiply
        int result = firstNumber * secondNumber;
        System.out.println("Result is " + result + "\n");

        // ----------------------------------
        System.out.println("**ASSIGNMENT 1**");
        System.out.println("**CODE 3**");
        int m = 0;
        for (int i = 0; i < 20; i++){
            for(int j = 0; j < m; j++){
                System.out.print('*');
            }
            m++;
            System.out.print('\n');
        }
    }
}
