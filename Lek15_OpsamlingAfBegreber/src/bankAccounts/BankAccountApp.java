package bankAccounts;

import java.util.Scanner;

public class BankAccountApp {
    public static void main(String[] args) {

        Scanner inputScan = new Scanner(System.in);
        BankAccount[] accounts = createAccounts(10);

        boolean continueBanking = true;

        while (continueBanking) {
            System.out.println("\nEnter an id: ");
            int id = inputScan.nextInt();

            // Validate the id
            while (id < 0 || id >= accounts.length) {
                System.out.println("Invalid id. Please enter a valid id: ");
                id = inputScan.nextInt();
            }

            // Get the current account based on id
            BankAccount currentAccount = accounts[id];

            int choice;
            do {
                // Display the main menu
                mainMenu();
                choice = inputScan.nextInt();

                switch (choice) {
                    case 1:
                        // Check balance
                        System.out.println("The balance is: $" + currentAccount.getBalance());
                        break;

                    case 2:
                        // Withdraw money
                        boolean validWithdraw = false;
                        while (!validWithdraw) {
                            System.out.println("Enter an amount to withdraw: ");
                            double amountWithdraw = inputScan.nextDouble();

                            if (amountWithdraw <= currentAccount.getBalance() && amountWithdraw > 0) {
                                currentAccount.withdraw(amountWithdraw);
                                System.out.println("Withdrawal successful. New balance: $" + currentAccount.getBalance());
                                validWithdraw = true; // Afslut løkken, når hævningen er succesfuld
                            } else {
                                System.out.println("Insufficient balance or invalid amount. Current balance: $" + currentAccount.getBalance());
                                System.out.println("Please enter a valid amount to withdraw.");
                            }
                        }
                        break;

                    case 3:
                        // Deposit money
                        boolean validDeposit = false;
                        while (!validDeposit) {
                            System.out.println("Enter an amount to deposit: ");
                            double amountDeposit = inputScan.nextDouble();

                            if (amountDeposit > 0) {
                                currentAccount.deposit(amountDeposit);
                                System.out.println("Deposit successful. New balance: $" + currentAccount.getBalance());
                                validDeposit = true; // Afslut løkken, når indsættelsen er succesfuld
                            } else {
                                System.out.println("Deposit amount needs to be positive: $" + amountDeposit);
                                System.out.println("Please enter a valid amount to deposit.");
                            }
                        }
                        break;
                    case 4:
                        // Exit menu

                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

            } while (choice != 4);  // Exit the menu only when choice is 4

            System.out.println("Would you like to perform another transaction? (yes/no)");
            String response = inputScan.next().toLowerCase();
            System.out.println("Exiting account...");

            if (response.equals("no")) {
                continueBanking = false; // End the outer loop
            }
        }
    }

    // Method to create accounts
    public static BankAccount[] createAccounts(int number) {
        BankAccount[] accounts = new BankAccount[number];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new BankAccount(100);
        }
        return accounts;
    }

    // Method to display the main menu
    public static void mainMenu() {
        System.out.println("-----------------------------");
        System.out.println("Main menu");
        System.out.println("1: check balance");
        System.out.println("2: withdraw");
        System.out.println("3: deposit");
        System.out.println("4: exit");
        System.out.println("Enter a choice: ");
        System.out.println("-----------------------------");
    }
}
