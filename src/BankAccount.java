public class BankAccount {
	
	private AccountHolder account;	
	private long accountNumber;
	private double balance;
	private int id;
	private int pin;
	
	/**
	 * Constructor for BankAccount class.
	 * 
	 * @param balance
	 * @param user
	 */
	
	public BankAccount(AccountHolder account, double balance, int accountNumber, int pin) {
		this.id = accountNumber;
		this.balance = balance;
		this.account = account;
		this.pin = pin;
	}
	
	/////////////////////////////////// GETTERS AND SETTERS ///////////////////////////////////

	public AccountHolder getaccount() {
		return account;
	}
	
	public void setAccount(AccountHolder account) {
		this.account = account;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setbalance(double balance) {
		this.balance = balance;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id)	{
		this.id = id;
	}
	
	public int getPin()	{
		return pin;
	}
	
	public void setPin(int pin)	{
		this.pin = pin;
	}


	/////////////////////////////////// INSTANCE METHODS ///////////////////////////////////
	

	
	public boolean deposit(double amount) {
		if (amount <= 0) {
			return false;
		} else {
			balance = balance + amount;
			
			return true;
		}
	}
	
	public int withdraw(double amount) {
		if (amount > balance) {
			return 0;
		} else if (amount <= 0) {
			return 1;
		} else {
			balance = balance - amount;
			
			return 2;
		}
	}
}