import java.util.Scanner;

public class Main {

public static void main(String[] args) {

Scanner sc = new Scanner(System.in);

System.out.println(&quot;================================&quot;);
System.out.println(&quot; BANK ACCOUNT MANAGEMENT SYSTEM&quot;);
System.out.println(&quot;================================&quot;);

System.out.print(&quot;Enter account holder name: &quot;);
String name = sc.nextLine().trim();

if (name.isEmpty()) {
System.out.println(&quot;Name cannot be empty.&quot;);
sc.close();
return;
}

System.out.print(&quot;Enter opening balance (Rs.): &quot;);

double openingBalance;

try {
openingBalance = Double.parseDouble(sc.nextLine().trim());

if (!Double.isFinite(openingBalance)
|| openingBalance &lt; 0) {
System.out.println(
&quot;Opening balance must be zero or greater.&quot;);
sc.close();

return;
}
} catch (NumberFormatException e) {
System.out.println(&quot;Please enter a valid amount.&quot;);
sc.close();
return;
}

// Simple demo account number
String accountNumber = &quot;BA1001&quot;;

BankAccount account =
new BankAccount(accountNumber, name, openingBalance);

System.out.println(&quot;\nAccount created successfully!&quot;);
System.out.println(&quot;Your account number: &quot; + accountNumber);

int choice = 0;

while (choice != 6) {
System.out.println(&quot;\n========== MAIN MENU ==========&quot;);
System.out.println(&quot;1. Deposit Money&quot;);
System.out.println(&quot;2. Withdraw Money&quot;);
System.out.println(&quot;3. Check Balance&quot;);
System.out.println(&quot;4. View Transaction History&quot;);
System.out.println(&quot;5. Account Details&quot;);
System.out.println(&quot;6. Exit&quot;);
System.out.println(&quot;===============================&quot;);

System.out.print(&quot;Enter your choice: &quot;);
String input = sc.nextLine().trim();

try {
choice = Integer.parseInt(input);
} catch (NumberFormatException e) {
System.out.println(&quot;Please enter a number from 1 to 6.&quot;);
continue;
}

switch (choice) {
case 1:
System.out.print(&quot;Enter deposit amount (Rs.): &quot;);
processAmount(sc, account, true);
break;

case 2:
System.out.print(&quot;Enter withdrawal amount (Rs.): &quot;);
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
&quot;Thank you for using Bank Account Management.&quot;);
break;

default:
System.out.println(
&quot;Invalid choice. Please select 1 to 6.&quot;);
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
System.out.println(&quot;Please enter a valid numeric amount.&quot;);
}
}
}
