package models;

import java.util.ArrayList;
import java.util.List;

public class CardHolder {
    private String passportNumber;
    private String fullName;
    private Address address;
    private List<CardAccount> cards;
    private BankAccount bankAccount;

    public CardHolder(String passportNumber, String fullName, Address address, BankAccount bankAccount) {
        this.passportNumber = passportNumber;
        this.fullName = fullName;
        this.address = address;
        this.bankAccount = bankAccount;
        this.cards = new ArrayList<>();
    }

    public void addCard(CardAccount card) {
        cards.add(card);
    }

    @Override
    public String toString() {
        return fullName + " (" + passportNumber + "), Address: " + address.toString();
    }
}
