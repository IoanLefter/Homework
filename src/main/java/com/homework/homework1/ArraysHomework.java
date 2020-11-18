package main.java.com.homework.homework1;

public class ArraysHomework {
    public static void main(String[] args) {
        int[] intArrayExplicit = new int[]{20, 35, -15, 7, 55, 1, -22, 99, 1992};
        rotateArray(5,intArrayExplicit);
    }

    private static void rotateArray(int number_of_rotations,int[] intArrayExplicit) {
        int dx = (number_of_rotations + intArrayExplicit.length) % (intArrayExplicit.length);
        for (int i = dx; i <= dx + (intArrayExplicit.length - 1); i++) {
            if (i <= intArrayExplicit.length - 1) {
                System.out.print(intArrayExplicit[i] + " ");
            } else {
                System.out.print(intArrayExplicit[i - intArrayExplicit.length] + " ");
            }
        }
    }
}
