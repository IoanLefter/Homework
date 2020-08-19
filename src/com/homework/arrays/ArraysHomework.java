package com.homework.arrays;

public class ArraysHomework {
    public static void main(String[] args) {
        int d=12;
        int[] intArrayExplicit = new int[]{20, 35, -15, 7, 55, 1, -22, 99, 1992};
        int dx=(d+intArrayExplicit.length)%(intArrayExplicit.length);
        for (int i = dx; i <= dx+(intArrayExplicit.length - 1); i++) {
            if (i <= intArrayExplicit.length - 1) {
                System.out.print(intArrayExplicit[i]+" ");
            } else {
                System.out.print(intArrayExplicit[i-intArrayExplicit.length]+" ");
            }
        }
    }
}
