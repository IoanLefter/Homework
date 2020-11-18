package main.java.com.homework.homework2;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class Homework2 {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
//      Ex1_For
        System.out.println(ANSI_RED + "Ex1_For" + ANSI_RESET);
        displayNumbersEx1();

//      Ex2_For
        System.out.println(ANSI_RED + "Ex2_For" + ANSI_RESET);
        displayNumbersEx2();

//      Ex3_For
        System.out.println(ANSI_RED + "Ex3_For" + ANSI_RESET);
        displayNumbersEx3();

//      Ex4_For
        System.out.println(ANSI_RED + "Ex4_For" + ANSI_RESET);
        displayNumbersEx4();

//      Ex5_For
        System.out.println(ANSI_RED + "Ex5_For" + ANSI_RESET);
        displayNumbersEx5();

//      Ex6_For
        System.out.println(ANSI_RED + "Ex6_For" + ANSI_RESET);
        displayNumbersEx6();

//      Ex7_For
        System.out.println(ANSI_RED + "Ex7_For" + ANSI_RESET);
        primeNrFrom2ToX(1000);

//      Ex8_For
        System.out.println(ANSI_RED + "Ex8_For" + ANSI_RESET);
        int[] array_sort = new int[]{5, 66, 9, 88, 7, 45, 48, 48};
        sortList(array_sort);

//      While_exercises
        System.out.println(ANSI_RED + "While_exercises" + ANSI_RESET);

//      Ex1+2_While
        System.out.println(ANSI_RED + "Ex1+2_While" + ANSI_RESET);
        ghicesteNrRezultat();

//      Ex3_While
        System.out.println(ANSI_RED + "Ex3_While" + ANSI_RESET);
        System.out.println("Suma numerelor este: " + sumaNr());

//      Ex4_While
        System.out.println(ANSI_RED + "Ex4_While" + ANSI_RESET);
        verificaLaturiTriunghi();

//      Ex5_While
        System.out.println(ANSI_RED + "Ex5_While" + ANSI_RESET);
        testesteazaPalindrom(0);
        testesteazaPalindrom(-9);
        testesteazaPalindrom(11);
        testesteazaPalindrom(789);
        testesteazaPalindrom(-999);
        testesteazaPalindrom(-789987);
        testesteazaPalindrom(6566);
        testesteazaPalindrom(85058);

//      Ex6_While
        System.out.println(ANSI_RED + "Ex6_While" + ANSI_RESET);
        System.out.println("Gandeste-te la un numar de la 0 la 100");
        calculatorulGhicesteNr();

//      Ex7_While
        System.out.println(ANSI_RED + "Ex7_While" + ANSI_RESET);
        bancomat();

//      Ex1_SWITCH
        System.out.println(ANSI_RED + "Ex1_SWITCH" + ANSI_RESET);
        ziuaSaptamanii(6);
        ziuaSaptamanii(0);
        ziuaSaptamanii(99);
        ziuaSaptamanii(1);
    }

    private static void ghicesteNrRezultat() {
        int incercari = ghicesteNr();
        String incercarile;
        if (incercari == 1) {
            incercarile = " incercare.";
        } else {
            incercarile = " incercari.";
        }
        System.out.println("Ai ghicit din " + incercari + incercarile);
    }

    private static void displayNumbersEx6() {
        for (int i = 1; i <= 5; i++) {
            for (int n = 5; n >= i; n--) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    private static void displayNumbersEx5() {
        for (int i = 0; i <= 5; i++) {
            for (int n = 0; n <= i; n++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    private static void displayNumbersEx4() {
        int[] array4 = new int[10];
        for (int i = 9; i >= 0; i--) {
            array4[i] = 1;
            System.out.println(Arrays.toString(array4));
            array4[i] = 0;
        }
    }

    private static void displayNumbersEx3() {
        int[] array3 = new int[10];
        for (int i = 0; i < 10 - 1; i++) {
            array3[i + 1] = 1;
            System.out.println(Arrays.toString(array3));
            array3[i + 1] = 0;
        }
        System.out.println(Arrays.toString(array3));
    }

    private static void displayNumbersEx2() {
        int[] array2 = new int[10];
        for (int i = 0; i < 10; i++) {
            array2[i] = 1;
            System.out.println(Arrays.toString(array2));
            array2[i] = 0;
        }
    }

    private static void displayNumbersEx1() {
        int[] array1 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < 10; i++) {
            System.out.println(Arrays.toString(array1));
        }
    }


    //      Functions for "For" exercises
    static void primeNrFrom2ToX(int x) { //n - natural
        int[] array = new int[(x + 1) / 2];
        int ind = 0;
        for (int n = 0; n <= x; n++) {
            int i, m, flag = 0;
//        int n=1;//it is the number to be checked
            m = n / 2;
            if (n == 0 || n == 1) {
                continue;
            } else {
                for (i = 2; i <= m; i++) {
                    if (n % i == 0) {
                        flag = 1;
                        break;
                    }
                }
            }
            if (flag == 0) {
                array[ind] = n;
                ind++;
            }//end of else
        }
        int[] array_resized = new int[ind];
        for (int i = 0; i <= array_resized.length - 1; i++) {
            array_resized[i] = array[i];
        }
        System.out.println(Arrays.toString(array_resized));
    }

    static void sortList(int[] array_sort) {
        int temp;
        for (int i = 0; i <= array_sort.length - 1; i++) {
            for (int j = i + 1; j <= array_sort.length - 1; j++) {
                if (array_sort[i] > array_sort[j]) {
                    temp = array_sort[i];
                    array_sort[i] = array_sort[j];
                    array_sort[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array_sort));
    }

    //      Functions for "While" exercises
    static int ghicesteNr() {
        int x = 0;
        int incercari = 0;
        int numar_de_ghicit = 6;
        String mai_mare = "Incearca un numar mai mare.";
        String mai_mic = "Incearca un numar mai mic.";
        String ai_ghicit = "Ai ghicit!";
        String mesaj = null;
        while (x != numar_de_ghicit) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introdu un numar de la 1 la 10: ");
            x = scanner.nextInt();
            if (x < numar_de_ghicit) {
                System.out.println(mai_mare);
            } else if (x > numar_de_ghicit) {
                System.out.println(mai_mic);
            } else {
                System.out.println(ai_ghicit);
            }
            incercari++;

        }
        return incercari;
    }

    static int sumaNr() {
        int x = 2;
        int suma = 0;
        while (0 != x) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce-ti primul numar pentru care vreti sa faceti suma. (daca vreti sa va optiti apasati 0): ");
            x = scanner.nextInt();
            suma = suma + x;

        }
        return suma;
    }

    static void verificaLaturiTriunghi() {
        int a = 0;
        int b = 0;
        int c = 0;
        while (!((a + b) > c && (a + c) > b && (b + c) > a)) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce-ti un numar pentru latura a: ");
            a = scanner.nextInt();
            System.out.println("Introduce-ti un numar pentru latura b: ");
            b = scanner.nextInt();
            System.out.println("Introduce-ti un numar pentru latura c: ");
            c = scanner.nextInt();
            if (!((a + b) > c && (a + c) > b && (b + c) > a)) {
                System.out.println("Valorile introduse nu formeaza un tiunghi.");
            } else {
                System.out.println("Valorile introduse formeaza un tiunghi.");
            }
        }
    }

    static void calculatorulGhicesteNr() {
        int limita_superioara = 100;
        int limita_inferioara = 0;
        int numar_gasit = 0;
        String input_user = "x";
        while (!Objects.equals(input_user, "=")) {
            numar_gasit = ThreadLocalRandom.current().nextInt(limita_inferioara, limita_superioara);
            System.out.println("Numarul tau este " + numar_gasit + "?");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce-ti :\r\n< daca numarul cautat este mai mic decat cel afisat\r\n> daca numarul cautat este mai mare decat cel afisat\r\n= daca numarul afisat este identic cu cel cautat");
            input_user = scanner.nextLine();
            if (Objects.equals(input_user, "=")) {
                System.out.println("Numarul la care te-ai gandit este: " + numar_gasit);
                break;
            } else if (Objects.equals(input_user, ">")) {
                limita_inferioara = numar_gasit;
            } else if (Objects.equals(input_user, "<")) {
                limita_superioara = numar_gasit;
            }
            System.out.println();
        }
    }

    static void testesteazaPalindrom(int n) {

  /*      if (n == 0) {
            System.out.println("The number is 0");
            return;
        }*/
        int i = 0;
        int nr = n;
        String mesaj = ": Este palindrom";
        if (n < 0) {
            n = n * (-1);
        }

        if (n <= 9) {
            System.out.println(nr + mesaj);
            return;
        }

        List<Integer> digits = new ArrayList<>();
        while (n != 0) {
            int digit = n % 10; //% restul impartirii nr la 10
            n = n / 10;
            digits.add(digit);
        }
        while (i <= Math.ceil((digits.toArray().length) / 2.0)) {
            if (digits.toArray()[i] != digits.toArray()[digits.toArray().length - i - 1]) {
                mesaj = ": Nu este palindrom.";
                break;
            }
            i++;
        }
        System.out.println(nr + mesaj);
    }

    static void bancomat() {
        String pin_salvat = "0625";
        int nr_incercari = 1;
        while (nr_incercari <= 3) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce-ti PIN: ");
            String introduceti_pin = scanner.nextLine();
            if (Objects.equals(introduceti_pin, pin_salvat)) {
                System.out.println("PIN corect");
                return;
            } else {
                System.out.println("PIN incorect");
                System.out.println("Mai aveti " + (3 - nr_incercari) + " incercari.");
                nr_incercari++;
            }
        }
        System.out.println("Cardul este blocat deoarece ati introdus PIN gresit de 3 ori!");
    }

    //      Function for "SWITCH" exercise
    static void ziuaSaptamanii(int zi) {
        switch (zi) { //String, int, long, boolean
            case 0:
                System.out.println("Ziua " + zi + " este duminica.");
                break;
            case 1:
                System.out.println("Ziua " + zi + " este luni.");
                break;
            case 2:
                System.out.println("Ziua " + zi + " este marti.");
                break;
            case 3:
                System.out.println("Ziua " + zi + " este miercuri.");
                break;
            case 4:
                System.out.println("Ziua " + zi + " este joi.");
                break;
            case 5:
                System.out.println("Ziua " + zi + " este vineri.");
                break;
            case 6:
                System.out.println("Ziua " + zi + " este sambata.");
                break;
            default:
                System.out.println("Ziua trebuie sa fie de la 0 la 6");
        }
    }
}
