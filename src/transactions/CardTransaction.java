package transactions;
import enums.CardStatus;
import exceptions.BankTransactionException;
import exceptions.InsufficientFundsException;
import models.CardAccount;


public class CardTransaction implements Transaction{
    @Override
    public void deposit(double amount, Object target){

        if (!(target instanceof CardAccount card)) {
            throw new BankTransactionException("Invalid target for card deposit.");
        }

        if (card.getStatus() == CardStatus.BLOCKED) {
            throw new BankTransactionException("Cannot deposit money: card is blocked.");
        }

        if (amount <= 0) throw new BankTransactionException("Deposit amount must be positive.");

        card.setBalance(card.getBalance() + amount);
    }

    @Override
    public void transfer(double amount, Object from, Object to) {
        if (!(from instanceof CardAccount source) || !(to instanceof CardAccount target)) {
            throw new BankTransactionException("Invalid accounts for card transfer.");
        }

        if (source.getStatus() == CardStatus.BLOCKED) {
            throw new BankTransactionException("Cannot deposit money: card is blocked.");
        }


        if (amount > source.getBalance()) {
            throw new InsufficientFundsException("Not enough balance for transfer.");
        }

        source.setBalance(source.getBalance() - amount);
        target.setBalance(target.getBalance() + amount);
    }

    @Override
    public void withdraw(double amount, Object target) {
        if (!(target instanceof CardAccount card)) {
            throw new BankTransactionException("Invalid target for card withdraw.");
        }

        if (card.getStatus() == CardStatus.BLOCKED) {
            throw new BankTransactionException("Cannot withdraw money: card is blocked.");
        }

        if (amount > card.getBalance()) {
            throw new InsufficientFundsException("Not enough balance on card.");
        }

        card.setBalance(card.getBalance() - amount);
    }

    public void blockCard(CardAccount card) {
        card.setStatus(CardStatus.BLOCKED);
    }
}
