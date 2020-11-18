package main.java.com.homework.homework10.ex2;

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

    public void printCardsNumbers() {
        System.out.println("Your account has the following cards attached:");
        for (int i = 0; i <= cards.size() - 1; i++) {
            System.out.println(cards.get(i).getCardNumber());
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public boolean isCardExpired(Long cardNumber) {
        boolean expired = true;
        for (int i = 0; i <= cards.size() - 1; i++) {
            if (cards.get(i).getCardNumber() != cardNumber) {
                continue;
            } else {
                expired = cards.get(i).isCardExpired();
            }
        }
        return expired;
    }

    public void addMoney(double amount) {
        balance += amount;
    }

    public void withdrawMoney (double amount) throws Exception {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Your account has been successfully debited with amount " + amount);
        } else {
            throw new Exception("Insufficient funds. You have in your account just: " + balance);
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
