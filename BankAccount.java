import java.util.ArrayList;

import java.util.List;

public class BankAccount {

private final String accountNumber;
private final String accountHolder;
private double balance;

private final List&lt;String&gt; transactions = new ArrayList&lt;&gt;();

public BankAccount(String accountNumber,
String accountHolder,
double openingBalance) {

this.accountNumber = accountNumber;
this.accountHolder = accountHolder;
this.balance = openingBalance;

transactions.add(
&quot;Account opened with balance: Rs. &quot;
+ String.format(&quot;%.2f&quot;, openingBalance));
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
if (!Double.isFinite(amount) || amount &lt;= 0) {
System.out.println(&quot;Enter a valid positive amount.&quot;);
return;
}

balance += amount;

transactions.add(
&quot;Deposited Rs. &quot; + String.format(&quot;%.2f&quot;, amount));

System.out.println(&quot;Deposit successful.&quot;);
System.out.printf(&quot;Current balance: Rs. %.2f%n&quot;, balance);
}

public void withdraw(double amount) {
if (!Double.isFinite(amount) || amount &lt;= 0) {
System.out.println(&quot;Enter a valid positive amount.&quot;);
return;
}

if (amount &gt; balance) {
System.out.println(&quot;Insufficient balance.&quot;);
return;
}

balance -= amount;

transactions.add(
&quot;Withdrawn Rs. &quot; + String.format(&quot;%.2f&quot;, amount));

System.out.println(&quot;Withdrawal successful.&quot;);
System.out.printf(&quot;Current balance: Rs. %.2f%n&quot;, balance);
}

public void displayBalance() {
System.out.println(&quot;\n--- Account Details ---&quot;);
System.out.println(&quot;Account Number: &quot; + accountNumber);
System.out.println(&quot;Account Holder: &quot; + accountHolder);
System.out.printf(&quot;Available Balance: Rs. %.2f%n&quot;, balance);
}

public void displayTransactions() {
System.out.println(&quot;\n--- Transaction History ---&quot;);

for (int i = 0; i &lt; transactions.size(); i++) {
System.out.println((i + 1) + &quot;. &quot; + transactions.get(i));
}
}
}
