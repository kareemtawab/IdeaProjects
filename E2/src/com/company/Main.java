package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // ----------------------------------
        System.out.println("**ASSIGNMENT 1**");
        System.out.println("**CODE 1**");

        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println("Hello, Please input 6 numbers separated with newline:");
        for (int i = 0; i < 6; i++){
            arr.add(scan.nextInt());
        }
        System.out.println("Numbers entered are " + arr + "\nTheir sum is " + getSumOfAllElements(arr));
        System.out.println();

        // ----------------------------------
        System.out.println("**ASSIGNMENT 1**");
        System.out.println("**CODE 2**");

        System.out.println("Please enter String: ");
        String s = scan.next();
        System.out.println("String entered is \"" + s + "\"\nLength of String is " + getStringLength(s));
        System.out.println();

        // ----------------------------------
        System.out.println("**ASSIGNMENT 1**");
        System.out.println("**CODE 3**");

        String m;
        System.out.println("Please enter String: ");
        m = scan.next();
        System.out.println("String entered is \"" + m + "\"\nTheir letters are ");
        printLetters(m);
        System.out.println();

        // ----------------------------------
        System.out.println("**ASSIGNMENT 1**");
        System.out.println("**CODE 4**");

        int l = 20;
        for (int i = 20; i != 0; i--){
            for(int j = 0; j < l; j++){
                System.out.print('*');
            }
            l--;
            System.out.print('\n');
        }
    }

    private static int getSumOfAllElements(ArrayList<Integer> a){
        int result = 0;
        for (Integer integer : a) {
            result += integer;
        }
        return result;
    }

    private static int getStringLength(String a){
        return a.length();
    }

    private static void printLetters(String a){
        for(int i = 0; i < a.length(); i++){
            System.out.println(a.charAt(i));
        }
    }
}
