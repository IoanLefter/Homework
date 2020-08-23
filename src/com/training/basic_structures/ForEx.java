package com.lseg.basic_structures;

import java.util.Arrays;

public class ForEx {


    public static void main(String[] args) {
        //void --> nu returnez nimic
        //daca returnez ceva, tb specificat in definitia functiei

        sum(10);
        int[] array = new int[]{20, 35, -15, 7, 55, 1, -22};

        int min = findMin(array);
        System.out.println("Min is: " + min);

        System.out.println(fibonacciRecursive(5));
        System.out.println(Arrays.toString(fibonacciIterative(10)));
    }

    static int findMin(int[] array) {

        int min = array[0]; //sau  Integer.MAX_VALUE;
        for (int i = 0; i <= array.length - 1; i++) {

            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }

    static void sum(int n) { //n - natural
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println("Sum of array is: " + sum);
        // return sum;
    }

    static void sumEvenNumbers(int n) { //n - natural
        int sum = 0;

        for (int i = 0; i <= n; i += 2) {
            sum += i;
        }
        System.out.println(sum);
        // return sum;
    }

    /**
     * An = An_1 + An_2
     * complexity: O(n^n)
     */
    static int fibonacciRecursive(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    /**
     fibonacciRecursive(n-1)
     fibonacciRecursive(n-2)
     .
     .
     .
     fibonacciRecursive(0)
     */

    /**
     * An_2   An_1     An
     * 0,     1,       1
     * 1,     1,       2
     * 1,     2,       3
     *
     * complexity: O(nthElement)
     */
    static int[] fibonacciIterative(int nthElement) {

        int An_2 = 0;
        int An_1 = 1;
        int An;

        int[] fibonacciArray = new int[nthElement];
        fibonacciArray[0] = An_2;
        fibonacciArray[1] = An_1;

        for (int n = 2; n <= nthElement - 1; n++) {
            An = An_1 + An_2;
            An_2 = An_1;
            An_1 = An;
            fibonacciArray[n] = An;
        }

        return fibonacciArray;
    }


}
