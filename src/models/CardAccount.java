package models;

import enums.CardStatus;
import enums.CardType;
import enums.Currency;

public class CardAccount {
    private String accountNumber; // 16 digits
    private String cvv; // 3 digits
    private String expirationDate;
    private CardType cardType;
    private double balance;
    private CardStatus status;
    private Currency currency;

    public CardAccount(String accountNumber, String cvv, String expirationDate,
                       CardType cardType, double balance, CardStatus status, Currency currency) {
        if (accountNumber.length() != 16) throw new IllegalArgumentException("Account number must be 16 digits.");
        if (cvv.length() != 3) throw new IllegalArgumentException("CVV must be 3 digits.");
        this.accountNumber = accountNumber;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
        this.cardType = cardType;
        this.balance = balance;
        this.status = status;
        this.currency = currency;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getCvv() { return cvv; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
    public CardStatus getStatus() { return status; }
    public void setStatus(CardStatus status) { this.status = status; }
}
