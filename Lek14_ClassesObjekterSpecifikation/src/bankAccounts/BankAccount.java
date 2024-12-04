package bankAccounts;

public class BankAccount {
    private static int numberofAccounts = 1;
    private double balance;
    private int id;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
        id = numberofAccounts;
        numberofAccounts++;
    }

    public void deposit(double _amount) {
        balance += _amount;
    }

    public void withdraw(double _amount) {
        balance -= _amount;
    }

    public double getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }

    public static int getNumberOfAccounts() {
        return numberofAccounts;
    }

    public String toString() {
        return ("\nYour balance is " + balance + " and has the id " + id);

    }
}
