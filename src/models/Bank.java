package models;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String bankName;
    private Address address;
    private List<CardHolder> cardHolders;

    public Bank(String bankName, Address address) {
        this.bankName = bankName;
        this.address = address;
        this.cardHolders = new ArrayList<>();
    }
}
