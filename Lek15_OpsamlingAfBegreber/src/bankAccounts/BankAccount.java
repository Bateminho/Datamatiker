package bankAccounts;


public class BankAccount {

    private static int numberOfAccounts = 0;
    private double balance;
    private final int id;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
        id = numberOfAccounts;
        numberOfAccounts++;
    }

    public void deposit(double _amount) {

        if (_amount > 0)
            balance += _amount;
    }

    public void withdraw(double _amount) {

        if (_amount <= balance) {
            balance -= _amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }

    public static int getNumberOfAccounts() {
        return numberOfAccounts;
    }


    public String toString() {
        return ("\nYour balance is " + balance + " and has the id " + id);

    }
}
