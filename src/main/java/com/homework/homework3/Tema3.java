package main.java.com.homework.homework3;

public class Tema3 {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
//      Ex1
        System.out.println(ANSI_RED + "Ex1" + ANSI_RESET);
        System.out.println(convertToKilometersPerHour(2) + " km/h");
//      Ex2
        System.out.println(ANSI_RED + "Ex2" + ANSI_RESET);
        System.out.println(shouldWakeUp(true, -1));
        System.out.println(shouldWakeUp(true, 24));
        System.out.println(shouldWakeUp(false, 3));
        System.out.println(shouldWakeUp(true, 12));
        System.out.println(shouldWakeUp(true, 3));
//      Ex3
        System.out.println(ANSI_RED + "Ex3" + ANSI_RESET);
        System.out.println(isLeapYear(-1600));
        System.out.println(isLeapYear(1600));
        System.out.println(isLeapYear(2017));
        System.out.println(isLeapYear(2000));
//      Ex4
        System.out.println(ANSI_RED + "Ex4" + ANSI_RESET);
        System.out.println(isCatPlaying(true, 10));
        System.out.println(isCatPlaying(false, 36));
        System.out.println(isCatPlaying(false, 35));
        System.out.println(isCatPlaying(true, 36));


    }


    static double convertToKilometersPerHour(double milesPerHour) {
        double kmPerHour = milesPerHour * 1.609344;
        return kmPerHour;
    }

    static boolean shouldWakeUp(boolean barking, int hour) {
        if (hour > 23 || hour < 0) {
            return false;
        } else if (barking == true && (hour <= 8 || hour >= 22)) {
            return true;
        }
        return false;
    }

    static boolean isLeapYear(int year) {
        if (year < 1 || year > 9999) {
            return false;
        } else if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }

            } else {
                return true;
            }
        } else {
            if (year % 400 == 0) {
                return true;
            } else {
                return false;
            }

        }

    }

    static boolean isCatPlaying(boolean summer, int temperature) {
        int max_temp = 35;
        if (summer == true) {
            max_temp += 10;
        }
        if (temperature >= 25 && temperature <= max_temp) {
            return true;
        }
        return false;
    }

}

