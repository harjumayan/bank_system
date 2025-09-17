// src/models/BankAccount.java
package models;

import enums.BankAccountType;
import enums.Currency;

public class BankAccount {
    private String accountNumber; // 16 digits
    private double balance;
    private Currency currency;
    private BankAccountType accountType;

    public BankAccount(String accountNumber, double balance, Currency currency, BankAccountType accountType) {
        if (accountNumber.length() != 16) throw new IllegalArgumentException("Account number must be 16 digits.");
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.currency = currency;
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public BankAccountType getAccountType() {
        return accountType;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
