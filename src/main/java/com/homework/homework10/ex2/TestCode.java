package main.java.com.homework.homework10.ex2;

import java.text.ParseException;

public class TestCode {
    public static void main(String[] args) throws ParseException {
        //Create Cards and test some methods
        System.out.println("Create Cards and test some methods");
        Card card1 = new Card(2022, 5, 2, "Name Ab", 11111111L);
        Card card2 = new Card(2022, 5, 2, "Name Ac", 2111111111111111L);
        Card card3 = new Card(2022, 5, 2, "Name Ad", 3111111111111111L);
        Card card4 = new Card(2019, 5, 2, "Name Ae", 4111111111111111L);
        Card card5 = new Card(2019, 5, 2, "Name Af", 5111111111111111L);
        System.out.println(card1.getCardNumber());
        System.out.println(card2.isCardExpired());
        System.out.println(card2.getOwnerName());
        System.out.println();

        //Create bank accounts, attach cards and test withdrawMoney
        System.out.println("Create bank accounts, attach cards and test withdrawMoney");
        BankAccount account1 = new BankAccount("RO49 AAAA 1B31 0075 9384 0000");
        BankAccount account2 = new BankAccount("RO49 AAAA 1B31 0075 9384 0001");
        BankAccount account3 = new BankAccount("RO49 AAAA 1B31 0075 9384 0002");
        BankAccount account4 = new BankAccount("RO49 AAAA 1B31 0075 9384 0003");
        account1.attachCard(card1);
        account1.attachCard(card2);
        account2.attachCard(card3);
        account3.attachCard(card4);
        account4.attachCard(card5);
        account1.printCardsNumbers();
        account1.addMoney(200);
        account2.addMoney(200);
        account3.addMoney(200);
        account4.addMoney(200);
        try {
            account1.withdrawMoney(300);
        } catch (Exception e) {
            System.out.println("Exception occurs: " + e);
        }
        try {
            account1.withdrawMoney(33.35);
        } catch (Exception e) {
            System.out.println("Exception occurs: " + e);
        }
        System.out.println(account1.getBalance());
        System.out.println();

        //Create users and assign bank accounts to them
        System.out.println("Create users and assign bank accounts to them");
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        User user4 = new User();
        user1.addBankAccount(account1);
        user2.addBankAccount(account2);
        user3.addBankAccount(account3);
        user4.addBankAccount(account4);
        System.out.println();

        //Pay with 2 cards attached at the same account of user 1
        System.out.println("Pay with 2 cards attached at the same account of user 1");
        try {
            user1.pay(10, card1.getCardNumber());
        } catch (Exception e) {
            System.out.println("Exception occurs: " + e);
        }
        System.out.println(account1.getBalance());
        try {
            user1.pay(20, card2.getCardNumber());
        } catch (Exception e) {
            System.out.println("Exception occurs: " + e);
        }
        System.out.println(account1.getBalance());
        System.out.println();

        //Pay more than available balance with 1 card attached at the account of user 2
        System.out.println("Pay more than available balance with 1 card attached at the account of user 2");
        try {
            user2.pay(210, card3.getCardNumber());
        } catch (Exception e) {
            System.out.println("Exception occurs: " + e);
        }
        System.out.println(account2.getBalance());
        System.out.println();

        //Pay with 1 card expired attached at the account of user 3
        System.out.println("Pay with 1 card expired attached at the account of user 3");
        try {
            user3.pay(10, card4.getCardNumber());
        } catch (Exception e) {
            System.out.println("Exception occurs: " + e);
        }
        System.out.println(account3.getBalance());
        System.out.println();

        //Pay with 1 card that is not owned by user 4
        System.out.println("Pay with 1 card that is not owned by user 4");
        try {
            user4.pay(10, card4.getCardNumber());
        } catch (Exception e) {
            System.out.println("Exception occurs: " + e);
        }
        System.out.println(account3.getBalance());
        System.out.println();


    }
}
