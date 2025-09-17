// src/transactions/BankAccountTransaction.java
package transactions;

import enums.BankAccountType;
import exceptions.BankTransactionException;
import exceptions.InsufficientFundsException;
import models.BankAccount;

public class BankAccountTransaction implements Transaction {

    @Override
    public void deposit(double amount, Object target) {
        if (!(target instanceof BankAccount account)) {
            throw new BankTransactionException("Invalid target for bank account deposit.");
        }

        if (account.getAccountType() != BankAccountType.DEBIT) {
            throw new BankTransactionException("Can only deposit money into DEBIT bank accounts.");
        }

        if (amount <= 0) throw new BankTransactionException("Deposit amount must be positive.");
        account.setBalance(account.getBalance() + amount);
    }

    @Override
    public void withdraw(double amount, Object target) {
        if (!(target instanceof BankAccount account)) {
            throw new BankTransactionException("Invalid target for bank account withdraw.");
        }

        if (account.getAccountType() != BankAccountType.CREDIT) {
            throw new BankTransactionException("Can only withdraw money from CREDIT bank accounts.");
        }

        if (amount > account.getBalance()) {
            throw new InsufficientFundsException("Not enough balance for withdraw.");
        }

        account.setBalance(account.getBalance() - amount);
    }

    @Override
    public void transfer(double amount, Object from, Object to) {
        if (!(from instanceof BankAccount source) || !(to instanceof BankAccount target)) {
            throw new BankTransactionException("Invalid accounts for bank transfer.");
        }

        if (source.getAccountType() != BankAccountType.DEBIT || target.getAccountType() != BankAccountType.CREDIT) {
            throw new BankTransactionException("Transfer allowed only from DEBIT to CREDIT accounts.");
        }

        if (amount > source.getBalance()) {
            throw new InsufficientFundsException("Not enough balance for transfer.");
        }

        source.setBalance(source.getBalance() - amount);
        target.setBalance(target.getBalance() + amount);
    }
}
