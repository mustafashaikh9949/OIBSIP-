package Level1Task3;


import java.util.Scanner;

public class ATM_INTERFACE {

	    private static int balance = 2500; // Initial balance for demonstration purposes
	    private static int userId = 112200;
	    private static int userPin = 949949;

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Authenticate the user
	        System.out.print("Enter User ID: ");
	        int enteredUserId = scanner.nextInt();
	        System.out.print("Enter PIN: ");
	        int enteredPin = scanner.nextInt();

	        if (enteredUserId == userId && enteredPin == userPin) {
	            displayMenu(scanner);
	        } else {
	            System.out.println("Authentication failed. Exiting...");
	        }
	    }

	    public static void displayMenu(Scanner scanner) {
	        while (true) {
	            System.out.println("\nATM Menu:");
	            System.out.println("1. Transactions History");
	            System.out.println("2. Withdraw");
	            System.out.println("3. Deposit");
	            System.out.println("4. Transfer");
	            System.out.println("5. Quit");

	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    displayTransactionHistory();
	                    break;
	                case 2:
	                    withdraw(scanner);
	                    break;
	                case 3:
	                    deposit(scanner);
	                    break;
	                case 4:
	                    transfer(scanner);
	                    break;
	                case 5:
	                    System.out.println("Exiting...");
	                    System.exit(0);
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }

	    public static void displayTransactionHistory() {
	        System.out.println("Transaction History: (Not implemented in this demo)");
	    }

	    public static void withdraw(Scanner scanner) {
	        System.out.print("Enter the amount to withdraw: ");
	        int amount = scanner.nextInt();
	        if (amount > 0 && amount <= balance) {
	            balance -= amount;
	            System.out.println("Withdrawal successful. New balance: " + balance);
	        } else {
	            System.out.println("Invalid amount or insufficient balance.");
	        }
	    }

	    public static void deposit(Scanner scanner) {
	        System.out.print("Enter the amount to deposit: ");
	        int amount = scanner.nextInt();
	        if (amount > 0) {
	            balance += amount;
	            System.out.println("Deposit successful. New balance: " + balance);
	        } else {
	            System.out.println("Invalid amount.");
	        }
	    }

	    public static void transfer(Scanner scanner) {
	        System.out.print("Enter the recipient's account number: ");
	        int recipientId = scanner.nextInt();
	        System.out.print("Enter the amount to transfer: ");
	        int amount = scanner.nextInt();
	        if (amount > 0 && amount <= balance) {
	            balance -= amount;
	            System.out.println("Transfer successful. New balance: " + balance);
	        } else {
	            System.out.println("Invalid amount or insufficient balance.");
	        }
	    }
	}