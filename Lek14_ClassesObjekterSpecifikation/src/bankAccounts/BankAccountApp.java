package bankAccounts;

public class BankAccountApp {
    public static void main(String[] args) {

        BankAccount b1 = new BankAccount(0);
        BankAccount b2 = new BankAccount(100);
        BankAccount b3 = new BankAccount(1000);
        BankAccount b4 = new BankAccount(2000);
        BankAccount b5 = new BankAccount(3000);
        BankAccount b6 = new BankAccount(4000);
        BankAccount b7 = new BankAccount(5000);
        BankAccount b8 = new BankAccount(6000);

        System.out.println(b1);
        System.out.println(b2);

        b1.deposit(1100);
        b2.deposit(400);

        System.out.println(b1);
        System.out.println(b2);

        b1.withdraw(500);
        b2.withdraw(200);

        System.out.println();

        System.out.println(b1.getBalance());
        System.out.println(b1.getId());
        System.out.println(b2.getBalance());
        System.out.println(b2.getId());


        System.out.println(b1);
        System.out.println(b2);

        System.out.println(b3);
        System.out.println(b4);
        System.out.println(b5);
        System.out.println(b6);
        System.out.println(b7);
        System.out.println(b8);

    }
}
