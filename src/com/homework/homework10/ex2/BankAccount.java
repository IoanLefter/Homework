package com.homework.homework10.ex2;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String iban;
    private double balance;
    private List<Card> cards = new ArrayList<>();


    public BankAccount(String iban) {
        this.iban = iban;
        this.balance = 0.0;
    }


    public void attachCard(Card card) throws ParseException {
        cards.add(card);
    }

    public void getCards() {
        System.out.println("Your account has the following cards attached:");
        for (int i = 0; i <= cards.size() - 1; i++) {
            System.out.println(cards.get(i).getCardNumber());
        }
    }

    public void addMoney(double amount) {
        balance += amount;
    }

    public void withdrawMoney(double amount) {
        try{
            if (balance >= amount) {
                balance -= amount;
            } else {
                throw new RuntimeException("Insufficient funds. You have in your account just: " + balance);
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Double getBalance() {
        return balance;
    }
}
