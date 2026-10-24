package bank;

import java.util.ArrayList;

import java.util.List;

public class BankAccount {

private final String accountNumber;
private final String accountHolder;
private double balance;

private final List<String> transactions = new ArrayList<>();

public BankAccount(String accountNumber,
String accountHolder,
double openingBalance) {

this.accountNumber = accountNumber;
this.accountHolder = accountHolder;
this.balance = openingBalance;

transactions.add(
"Account opened with balance: Rs. "
+ String.format("%.2f", openingBalance));
}

public String getAccountNumber() {
return accountNumber;
}

public String getAccountHolder() {
return accountHolder;
}

public double getBalance() {
return balance;
}

public void deposit(double amount) {
if (!Double.isFinite(amount) || amount <= 0) {
System.out.println("Enter a valid positive amount.");
return;
}

balance += amount;

transactions.add(
"Deposited Rs. " + String.format("%.2f", amount));

System.out.println("Deposit successful.");
System.out.printf("Current balance: Rs. %.2f%n", balance);
}

public void withdraw(double amount) {
if (!Double.isFinite(amount) || amount <= 0) {
System.out.println("Enter a valid positive amount.");
return;
}

if (amount > balance) {
System.out.println("Insufficient balance.");
return;
}

balance -= amount;

transactions.add(
"Withdrawn Rs. " + String.format("%.2f", amount));

System.out.println("Withdrawal successful.");
System.out.printf("Current balance: Rs. %.2f%n", balance);
}

public void displayBalance() {
System.out.println("\n--- Account Details ---");
System.out.println("Account Number: " + accountNumber);
System.out.println("Account Holder: " + accountHolder);
System.out.printf("Available Balance: Rs. %.2f%n", balance);
}

public void displayTransactions() {
System.out.println("\n--- Transaction History ---");

for (int i = 0; i < transactions.size(); i++) {
System.out.println((i + 1) + ". " + transactions.get(i));
}
}
}
