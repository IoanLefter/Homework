package com.homework.homework10.ex2;

import java.text.ParseException;

public class TestCode {
    public static void main(String[] args) throws ParseException {
        Card card=new Card(2019,5,2,"ff",21);
        Card card2=new Card(2022,5,2,"ff",2111111111111111L);
        System.out.println(card.getCardNumber());
        System.out.println();

        BankAccount account1=new BankAccount("RO49 AAAA 1B31 0075 9384 0000");
        account1.attachCard(card);
        account1.attachCard(card2);
        account1.getCards();
        account1.addMoney(200);
        account1.withdrawMoney(300);
        account1.withdrawMoney(33.35);
        System.out.println(account1.getBalance());
        System.out.println();

        User user1=new User();
        user1.addBankAccount(account1);
        user1.getAccounts();

    }
}
