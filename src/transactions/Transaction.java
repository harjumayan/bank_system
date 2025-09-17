package transactions;

public interface Transaction {
    void deposit(double amount, Object target);
    void withdraw(double amount, Object target);
    void transfer(double amount, Object from, Object to);
}
