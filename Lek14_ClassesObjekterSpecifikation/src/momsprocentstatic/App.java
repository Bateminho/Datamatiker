package momsprocentstatic;

public class App {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount(3333);
        BankAccount b2 = new BankAccount(22);
        BankAccount b3 = new BankAccount(45);
        BankAccount b4 = new BankAccount(10);

        System.out.println(BankAccount.getAntalKonti());

    }
}
