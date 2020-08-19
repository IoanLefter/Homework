package com.training.arrays_training;

public class ArraysPlay {

    public static void main(String[] args) {

        int incaOVariabile;
        int oVariabilaDeTipInt = 100;

        int[] intArrayExplicit = new int[]{20, 35, -15, 7, 55, 1, -22};

        int[] altArray = new int[intArrayExplicit.length - 1];

        //delete element at index 2
        for (int i = 0; i <= altArray.length - 1; i++) {
            if (i == 2) {
                continue;
            }
            altArray[i] = intArrayExplicit[i];
        }


        int[] intArray = new int[7];

        intArray[0] = 20;
        intArray[1] = 35;
        intArray[2] = -15;
        intArray[3] = 7;
        intArray[4] = 55;
        intArray[5] = 1;
        intArray[6] = -22;

        // i++ <==> i=i+1
        //System.out.println() operatia care printeaza ceva
        //System.out.print() operatia care printeaza ceva pe aceeasi linie
        for (int i = 0; i <= intArray.length - 1; i++) {
            //aici
            System.out.print(i);
            System.out.println(" - Elementul: " + i + " --> " + intArray[i] + ", ");
            //pana aici
        }

        int i = 0;

        while (i <= intArray.length - 1) {
            System.out.print("In while " + i);
            System.out.println(" - Elementul: " + i + " --> " + intArray[i] + ", ");
            i++;
        }


        //sa vedem daca arrayul are elementul 7

        int element = 7;

        for (int k = 0; k <= intArray.length - 1; k++) {
            if (intArray[k] == element) {
                System.out.println("L-am gasit");
                break; //1  7
            }
        }

        int deCateOriAmGasit7 = 0;
        for (int k = 0; k <= intArray.length - 1; k++) {
            if (intArray[k] == element) {
                deCateOriAmGasit7++;
            }
        }

        System.out.println("deCateOriAmGasit7 = " + deCateOriAmGasit7);

        intArray[5] = 0;

        intArray[90] = 8;
    }

}
