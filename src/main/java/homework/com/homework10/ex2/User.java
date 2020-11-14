package main.java.homework.com.homework10.ex2;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class User extends PosService {
    private List<BankAccount> accounts = new ArrayList<>();


    public void addBankAccount(BankAccount account) throws ParseException {
        accounts.add(account);
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void pay(double amount, long cardNumber) throws Exception {
        for (BankAccount currentBankAccount : accounts) {
            for (Card currentCard : currentBankAccount.getCards()) {
                if (currentCard.getCardNumber() == cardNumber) {
                    if (currentCard.isCardExpired()) {
                        throw new RuntimeException("Card is expired.");
                    }
                    currentBankAccount.withdrawMoney(amount);
                    return;
                }
            }
        }
        throw new RuntimeException("Card not found.");
    }


    /*public void getAccounts() {
        System.out.println("This is the list of your accounts:");
        for (int i = 0; i <= accounts.size() - 1; i++) {
            System.out.println(accounts.get(i).getIban()+", with the following available balance: "+accounts.get(i).getBalance());
        }
    }*/


}
