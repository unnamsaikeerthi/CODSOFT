import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Amount deposited successfully.");
        } else {
            System.out.println("❌ Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("❌ Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("✅ Amount withdrawn successfully.");
        }
    }

    public void checkBalance() {
        System.out.printf("💰 Current balance: ₹%.2f\n", balance);
    }
}

class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static BankAccount userAccount;

    public static void main(String[] args) {
        System.out.println("🏦 Welcome to the ATM Interface!");

        userAccount = new BankAccount(1000.00); 

        boolean running = true;

        while (running) {
            showMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1 -> handleWithdraw();
                case 2 -> handleDeposit();
                case 3 -> userAccount.checkBalance();
                case 4 -> {
                    System.out.println("👋 Thank you for using the ATM. Goodbye!");
                    running = false;
                }
                default -> System.out.println("❌ Invalid choice. Please try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n🔘 Please select an option:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("❌ Please enter a valid number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void handleWithdraw() {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = getValidAmount();
        userAccount.withdraw(amount);
    }

    private static void handleDeposit() {
        System.out.print("Enter amount to deposit: ₹");
        double amount = getValidAmount();
        userAccount.deposit(amount);
    }

    private static double getValidAmount() {
        while (!scanner.hasNextDouble()) {
            System.out.print("❌ Invalid input. Enter a valid amount: ₹");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}