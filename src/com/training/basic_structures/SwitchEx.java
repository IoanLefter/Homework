package com.lseg.basic_structures;
public class SwitchEx {

    public static void main(String[] args) {

        printDaysOfMonth("FEB");
        printDaysOfMonthWIthSwitch("FEB");
    }

    /**
     * Print nr de zile pt fiecare luna
     */
    static void printDaysOfMonth(String month) {

        if (month.equals("JAN")) {
            System.out.println(31);
            return;
        }
        if (month.equals("FEB")) {
            System.out.println(28);
            return;
        }
        if (month.equals("MAR")) {
            System.out.println(31);
            return;
        }
        if (month.equals("APR")) {
            System.out.println(30);
            return;
        }
        if (month.equals("MAY")) {
            System.out.println(31);
            return;
        }

        System.out.println("BAD month");
    }

    static void printDaysOfMonthWIthSwitch(String month){
        switch (month){ //String, int, long, boolean
            case "JAN": {
                System.out.println(31);
                break;
            }
            case "FEB":
                System.out.println(28);
                break;

            case "MAR":
                System.out.println(31);
                break;

            default:
                System.out.println("BAD month");
        }
    }
}
