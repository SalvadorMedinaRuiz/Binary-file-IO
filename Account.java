import java.io.Serializable;
public class Account implements Serializable{
	private long acctNum;
	private String name;
	private double balance;
	
	public Account () { //constructors have no return type, same name as class, and must initiliaze values
		acctNum= 0;
		name= "Nodbody";
		balance= 0.0;
	}
	public Account (long acctNum, String name, double balance) { // overloading a constructor by declaring diff parameters
		this.acctNum= acctNum; //this.acctNum refers to value in private values, and acctNum refers to value in overloaded constructor
		this.name= name;
		this.balance= balance;
	}
	public long getAcctNum () { // accessor method that returns the value of acctNum that any outside class can access. return type and variable inside must be same.
		return acctNum;
	}
	public String getName() { // accessor method that returns the string of name
		return name;
	}
	public double getBalance() { // accessor method that returns the value of balance
		return balance;
	}
	public void changeName(String newName) { //mutated method that changes our private name to "newName". its void because we are just changing the name, not returning it.
		this.name= newName;
	}
	public void deposit (double amount) { //mutated method that adds "amount" to our private balance. its void because we are not returning the new balance, just changing it.
		if (amount >= 0)
			this.balance += amount;
	}
	public void withdraw (double amount) { //mutated method that withdraws mount from private balance. its void cause we are changing balance not returning it
		if (amount >= 0 && balance >= amount)
			this.balance-=amount;
	}
	public String toString() {//accessor method that returns a pretty, readable balance/account num/name statement ONLY RETURN A STRING
		return "Account Number: " + this.acctNum + "\nAccount Name: " + this.name + "\nBalance = $" + balance;
	}
	public boolean equals (Account otherAcct) { // compares the private acctNum with the otherAcct that have different values with same names that is the same type
		return (this.acctNum== otherAcct.acctNum && this.name.equalsIgnoreCase(otherAcct.name) && (this.balance - otherAcct.balance < 0.01));
	}
	public void transfer(Account acct, double amount) {
		if (amount <= this.balance) {
			this.withdraw(amount);
			this.deposit(amount);
		}else
			System.out.println("Not enough money");
	}
	public static void transfer(Account fromAcct, Account toAcct, double amount) { //transfers fromAcct to toAcct
		if (amount <= fromAcct.balance) {
			fromAcct.withdraw(amount);
			toAcct.deposit(amount);
		}else
			System.out.println("Not enough money");
	}
}
