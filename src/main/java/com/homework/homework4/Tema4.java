package main.java.com.homework.homework4;

public class Tema4 {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
//      Ex1
        System.out.println(ANSI_RED + "Ex1" + ANSI_RESET);
        System.out.println(rangeSum(10, 15, 2));

//      Ex2
        System.out.println(ANSI_RED + "Ex2" + ANSI_RESET);
        int[] numbers = new int[]{2, 3, -2, -4, 1, 99, 100};
        System.out.println(rangeSumArray(2, numbers));

//      Ex3
        System.out.println(ANSI_RED + "Ex3" + ANSI_RESET);
        convertFromSeconds(59);

//      Ex4
        System.out.println(ANSI_RED + "Ex4" + ANSI_RESET);
        System.out.println(canPack(1, 0, 4));
        System.out.println(canPack(1, 0, 5));
        System.out.println(canPack(0, 5, 4));
        System.out.println(canPack(2, 2, 11));
        System.out.println(canPack(-3, 2, 12));


    }

    static int rangeSum(int start, int end, int divizor) {
        int suma = 0;
        if (start > end || start < 0 || end < 0) {
            return -1;
        }
        for (int i = start; i <= end; i++) {

            if (isDivisible(divizor, i)) {
                suma += i;
            }
        }
        return suma;
    }

    static int rangeSumArray(int divizor, int[] numbers) {
        int suma = 0;
        for (int i : numbers) {
            if (isDivisible(divizor, i)) {
                suma += i;
            }
        }
        return suma;
    }

    public static boolean isDivisible(int divizor, int i) {
        boolean divizibil = false;
        if (i < 0) {
            return false;
        }
        if (i % divizor == 0) {
            divizibil = true;
        }
        return divizibil;
    }

    public static void convertFromSeconds(int numberOfSeconds) {
        int hours = numberOfSeconds / 3600;
        int minutes = (numberOfSeconds % 3600) / 60;
        int seconds = (numberOfSeconds % 3600) % 60;
        System.out.println("H" + hours + "-M" + minutes + "-S" + seconds);
    }

    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        }
        int countBig = 0;
        int countSmall;
        if (bigCount != 0) {
            countBig = goal / 5;
            countSmall = goal % 5;
        } else {
            countSmall = goal;
        }

        if (countBig == bigCount && smallCount >= countSmall) {
            return true;
        }
        return false;
    }
}
