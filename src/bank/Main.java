package bank;

import java.util.Scanner;

public class Main {

public static void main(String[] args) {

Scanner sc = new Scanner(System.in);

System.out.println("================================");
System.out.println(" BANK ACCOUNT MANAGEMENT SYSTEM");
System.out.println("================================");

System.out.print("Enter account holder name: ");
String name = sc.nextLine().trim();

if (name.isEmpty()) {
System.out.println("Name cannot be empty.");
sc.close();
return;
}

System.out.print("Enter opening balance (Rs.): ");

double openingBalance;

try {
openingBalance = Double.parseDouble(sc.nextLine().trim());

if (!Double.isFinite(openingBalance)
|| openingBalance < 0) {
System.out.println(
"Opening balance must be zero or greater.");
sc.close();

return;
}
} catch (NumberFormatException e) {
System.out.println("Please enter a valid amount.");
sc.close();
return;
}

// Simple demo account number
String accountNumber = "BA1001";

BankAccount account =
new BankAccount(accountNumber, name, openingBalance);

System.out.println("\nAccount created successfully!");
System.out.println("Your account number: " + accountNumber);

int choice = 0;

while (choice != 6) {
System.out.println("\n========== MAIN MENU ==========");
System.out.println("1. Deposit Money");
System.out.println("2. Withdraw Money");
System.out.println("3. Check Balance");
System.out.println("4. View Transaction History");
System.out.println("5. Account Details");
System.out.println("6. Exit");
System.out.println("===============================");

System.out.print("Enter your choice: ");
String input = sc.nextLine().trim();

try {
choice = Integer.parseInt(input);
} catch (NumberFormatException e) {
System.out.println("Please enter a number from 1 to 6.");
continue;
}

switch (choice) {
case 1:
System.out.print("Enter deposit amount (Rs.): ");
processAmount(sc, account, true);
break;

case 2:
System.out.print("Enter withdrawal amount (Rs.): ");
processAmount(sc, account, false);
break;

case 3:
account.displayBalance();
break;

case 4:
account.displayTransactions();
break;

case 5:
account.displayBalance();
break;

case 6:
System.out.println(
"Thank you for using Bank Account Management.");
break;

default:
System.out.println(
"Invalid choice. Please select 1 to 6.");
}
}

sc.close();
}

private static void processAmount(
Scanner sc, BankAccount account, boolean isDeposit) {

try {
double amount = Double.parseDouble(sc.nextLine().trim());

if (isDeposit) {
account.deposit(amount);
} else {
account.withdraw(amount);
}

} catch (NumberFormatException e) {
System.out.println("Please enter a valid numeric amount.");
}
}
}
