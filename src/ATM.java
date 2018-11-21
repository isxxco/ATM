import java.util.Scanner;

public class ATM {
	Scanner in = new Scanner(System.in);
	private BankAccount account;
	private boolean active = true;
	private boolean verified = false;
	
	/**
	 * Constructs an ATM class.
	 * 
	 * @param account the account to be linked
	 */
	public static void main(String[] args) {
		AccountHolder accInfo = new AccountHolder(123456789, "Isaac Oluwakuyide", "123456789", "ait2019");
		BankAccount bankinfo = new BankAccount(accInfo, 0.0, 0, 0000);
		ATM simpleATM = new ATM(bankinfo);
		while(simpleATM.getactive())	{
			simpleATM.menu();
		}
	}
	
	public ATM(BankAccount account) {
		this.account = account;
	}
	
	public BankAccount getaccount()	{
		return account;
	}
	
	public void setaccount(BankAccount account)	{
		this.account = account;
	}
	
	public boolean getactive()	{
		return active;
	}
	
	/////////////////////////////////// INSTANCE METHODS ///////////////////////////////////

	// TODO
	
	// to complete the ATM class, you need to provide the following functionality:
	//
	// 		- prompt the user to enter an account number and pin
	//		- validate that the accounut number and pin are valid
	//		- display a menu with available options
	//			+ deposit
	//			+ withdraw
	//			+ view balance
	//			+ exit
	//		- prompt the user to make a selection from the available menu options
	//		- respond accordingly to the user's selection
	//			+ this will involve calling methods of the BankAccount class

	
	
	public void verify()	{
		while(! verified) {
			System.out.println("Welcome!\nPlease enter your account number.");
			int inputAccountNumber = in.nextInt();
			in.nextLine();
			if	(inputAccountNumber == account.getId())	{
				System.out.println("Please enter your pin number.");
				int PinNumber = in.nextInt();
				in.nextLine();
				if	(PinNumber == account.getPin())	{
					System.out.println("Hello, " + account.getaccount().getName());
					verified = true;
				}	else	{
					System.out.println("Incorrect login information, please try again.");
				}
			}	else	{
				System.out.println("Invalid Account Number, please try again");
			}
			System.out.println("\n                              ");
		}
	}
	
	public void menu()	{
		verify();
		System.out.println("To access your Account Holder information, Press 1.\nTo access your Bank account Information, press 2.\nTo deposit funds, Press 3.\nTo Withdraw Funds, Press 4.");
		int result = in.nextInt();
		in.nextLine();
		switch (result)	{
		case 1:
			System.out.println("Account Holder Information:\n"
					+ "Name:	" + account.getaccount().getName()
					+ "\nPhone:	" + account.getaccount().getPhone() + 
					"\nAddress:	" + account.getaccount().getAddress()+
					"\nSocial Security Number" + account.getaccount().getSSN());
			break;
		case 2:
			System.out.println("Bank Information:\n"
					+ "Balance:	" + account.getBalance() + 
					"\nAccount Number:	" + account.getId());
			break;
		case 3:
			boolean status;
			do	{
				System.out.println("How much money would you like to deposit?");
				double deposit = in.nextDouble();
				status = account.deposit(deposit);
				if (status == false) {
					System.out.println("You have to deposit a positive amount of money.");
				}	else	{
					System.out.println("Successful Deposit. Your new balance is " + account.getBalance());
				}
			}while (status != true);
			break;
		case 4:
			if (account.getBalance() == 0)	{
				System.out.println("You cannot withdraw any money as you have no money in your account. Deposit first if you want to withdraw");
				break;
			}
			int withdrawstatus;
			do	{
				System.out.println("How much money would you like to withdraw?");
				int withdrawal = in.nextInt();
				in.nextLine();
				withdrawstatus = account.withdraw(withdrawal);
				if (withdrawstatus == 0)	{
					System.out.println("You do not have enough money to make this withdrawal.\n");
				}	else if (withdrawstatus == 1)	{
					System.out.println("The amount of money you withdraw has to be positive.\n");
				}	else	{
					System.out.println("Your withdrawl was successful and your new balance is " + account.getBalance());
				}
			}while (withdrawstatus != 2);
			break;
			
		case 5:
			active = false;
			in.close();
		}
	}
}


