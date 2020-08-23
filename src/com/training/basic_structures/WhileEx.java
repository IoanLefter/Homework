package com.lseg.basic_structures;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WhileEx {

    public static void main(String[] args) {
        // 91289172
        System.out.println(7 / 2); //3
        System.out.println(7 / 2.0); //3.5
        System.out.println(91289172 / 10); //9128917
        printNumberDigits(91289172);

        int[] array = new int[]{20, 35, -15, 7, 55, 1, -22};
        int min = findMin(array);
        System.out.println("min = " + min);
    }

    static void printNumberDigits(int n) {

        if (n == 0) {
            System.out.println("The number is 0");
            return;
        }

        if (n < 0) {
            n = n * (-1);
        }
        int[] array = new int[10];
        List<Integer> digits = new ArrayList<>();
        int count = 0;

        while (n != 0) {
            int digit = n % 10; //% restul impartirii nr la 10
            n = n / 10;
            digits.add(digit);
            array[9 - count] = digit;
            count++;
        }
        System.out.println(Arrays.toString(array));
        System.out.println(digits);
    }

    /**
     * conversie la while
     * int min = array[0]; //sau  Integer.MAX_VALUE;
     * for (int i = 0; i <= array.length - 1; i++) {
     *
     * if (array[i] < min) {
     * min = array[i];
     * }
     * }
     */
    static int findMin(int[] array) {

        int min = array[0]; //sau  Integer.MAX_VALUE;
        int length = array.length - 1;
        while (length != 0) {

            if (array[length] < min) {
                min = array[length];
            }

            length--;
        }
        return min;
    }
}
