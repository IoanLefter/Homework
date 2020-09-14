package com.homework.homework5;

import com.homework.homework4.Tema4;

import java.util.Objects;
import java.util.Scanner;

public class Tema5 {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
//      Ex2
        System.out.println(ANSI_RED + "Ex2" + ANSI_RESET);
        countPositiveNegativeZero();

//      Ex3
        System.out.println(ANSI_RED + "Ex3" + ANSI_RESET);
        System.out.println(computeSin(30, 100));

//      Ex4
        System.out.println(ANSI_RED + "Ex4" + ANSI_RESET);
        System.out.println(rangeSum(10, 15, 2));
    }

    private static void countPositiveNegativeZero() {
        String a;
        int positive = 0;
        int negative = 0;
        int zero = 0;
        double b;

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter any number. If you want to stop enter x.");
            a = scanner.next();
            if (Objects.equals(a, "x")) {
                continue;
            }
            b = Double.parseDouble(a);
            if (b > 0) {
                positive++;
            } else if (b == 0) {
                zero++;
            } else {
                negative++;
            }
        } while (!Objects.equals(a, "x"));
        System.out.println("positive numbers entered: " + positive);
        System.out.println("negative numbers entered: " + negative);
        System.out.println("zeros entered: " + zero);
    }

    private static double computeSin(int x, int accuracy) {
        int contor = 0;
        int i = 1;
        double result = 0;
        double a;
        while (contor <= accuracy) {
            a = Math.pow(x, i) / factorialOfNumber(i);
            if (contor % 2 == 1) {
                result = result + a;
            } else {
                result = result - a;
            }
            i += 2;
            contor++;

        }

        return result;


    }


    private static int factorialOfNumber(int number) {
        for (int i = 1; i <= number; i++) {
            number = number * i;
        }
        return number;
    }

    static int rangeSum(int start, int end, int divizor) {
        int suma = 0;
        int i = start;
        if (start > end || start < 0 || end < 0) {
            return -1;
        }
        while (i <= end) {

            if (Tema4.isDivisible(divizor, i)) {
                suma += i;
            }
            i++;
        }
        return suma;
    }
}
