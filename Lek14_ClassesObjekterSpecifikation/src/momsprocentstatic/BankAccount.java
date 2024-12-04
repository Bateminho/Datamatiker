package momsprocentstatic;


public class BankAccount {
    private double balance;
    private int id;

    private static int antalKonti;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
        antalKonti++;
        id = antalKonti;
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public void withdraw(double amount) {
        balance -= amount;
    }
    public double getBalance() {
        return balance;
    }

    public static int getAntalKonti(){
        return antalKonti;
    }
}

