package com.homework.homework10.ex2;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class User extends PosService{
    private List<BankAccount> accounts = new ArrayList<>();


    public void addBankAccount(BankAccount account) throws ParseException {
        accounts.add(account);
    }

    public void getAccounts() {
        System.out.println("This is the list of your accounts:");
        for (int i = 0; i <= accounts.size() - 1; i++) {
            System.out.println(accounts.get(i).getIban()+", with the following available balance: "+accounts.get(i).getBalance());
        }
    }




}
