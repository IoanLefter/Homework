package main.java.homework.com.homework10.ex2;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;

public class Card {
    private LocalDate expirationDate;
    private String ownerName;
    private long cardNumber;
    private LocalDate currentDate = LocalDate.now();


    public Card(int yearExpiration, int monthExpiration, int dayExpiration, String ownerName, long cardNumber) throws ParseException {
        setExpirationDate(yearExpiration, monthExpiration, dayExpiration);
        this.ownerName = ownerName;
        setCardNumber(cardNumber);
    }


    public void setExpirationDate(int year, int month, int day) throws ParseException {
        expirationDate = LocalDate.of(year, month, day);
        int valid = 0;
        do {
            try {
                /*if (expirationDate.isBefore(currentDate)) {
                    throw new RuntimeException("Enter a date greater than today.");
                } else {*/
                    this.expirationDate = LocalDate.of(year, month, day);
                    valid = 1;
                //}
            } catch (Exception e) {
                System.out.println(e);
                Scanner console = new Scanner(System.in);
                System.out.println("Enter year");
                year = console.nextInt();
                System.out.println("Enter month");
                month = console.nextInt();
                System.out.println("Enter day");
                day = console.nextInt();
                expirationDate = LocalDate.of(year, month, day);
            }
        } while (valid == 0);
    }

    public void setCardNumber(long cardNumber) {
        int valid = 0;
        do {
            int length = String.valueOf(cardNumber).length();
            try {
                if (length != 16) {
                    throw new RuntimeException("Card number must have 16 digits.");
                } else {
                    this.cardNumber = cardNumber;
                    valid = 1;
                }
            } catch (Exception e) {
                System.out.println(e);
                Scanner console = new Scanner(System.in);
                System.out.println("Enter 16 digits card number");
                cardNumber = console.nextLong();

            }
        } while (valid == 0);
        this.cardNumber = cardNumber;
    }


    public boolean isCardExpired(){
        return getExpirationDate().isBefore(getCurrentDate());
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public long getCardNumber() {
        return cardNumber;
    }

}
