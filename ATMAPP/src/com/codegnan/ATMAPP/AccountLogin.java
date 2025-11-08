package com.codegnan.ATMAPP;
import java.util.Scanner;
public class AccountLogin 
{
	Scanner sc = new Scanner(System.in);
	public void userlogin(Account[] accounts,int count) 
	{
		int attempts = 0;
		Account user = null;
		while(attempts<3 && user == null)
		{
			System.out.println("Enter the account number");
			String accountnumber = sc.nextLine();
			System.out.println("Enter pin number");
			String pin = sc.nextLine();
			
			user = checkUserLogin(accountnumber, pin, accounts, count);

			if(user==null)
			{
				  attempts++;
		            System.out.println("INVALID LOGIN. Attempts left: " + (3-attempts));
		            if (attempts == 3) 
		            {
		                System.out.println("Maximum login attempts exceeded over");
		                return; 
		            }
		        }
		    }
		if(user!=null) {
			boolean run=true;
			while(run) {
				System.out.println("1.Deposit");
				System.out.println("2.withdraw");
				System.out.println("3.CheckBalance");
				System.out.println("4.Logout");
				System.out.println("choose(1-4)options:");
				int option=sc.nextInt();
				switch(option) {
				case 1:
					deposit(user);
					break;
				case 2:
					withdraw(user);
					break;
				case 3:
					checkbalance(user);
					break;
				case 4:
					System.out.println("LOGOUT SUCCESSFULLY:");
					run=false;
					break;
				default:
					System.out.println("INVAILD CHOICE..CHOOSE IN BETWEEN 1 TO 4 OPTIONS:");
				}
				
			}
		}else {
			System.out.println("INVAILD LOGIN....");
		}
	}


	

	
	public Account checkUserLogin(String accountNumber, String pin, Account[] accounts, int count) 
	{
		for(int i=0; i<count; i++) 
		{
			if(accounts[i].getaccountnumber().equals(accountNumber) && accounts[i].getpin().equals(pin)) 
			{
				System.out.println("Login successfully..!");
				return accounts[i];
			}
		}
		return null;
	}

	
	private void deposit(Account user) 
	{
		System.out.println("Enter amount to deposit: ");
		double amount = sc.nextDouble();
		if(amount>0) 
		{
			user.setBalance(user.getbalance()+amount);
			System.out.println("Deposited "+amount+" successfully..!");
		} 
		else 
		{
			System.out.println("Invalid amount to deposit.");
		}
	}
	
	public void withdraw(Account user)
	{
		System.out.println("Enter amount to withdraw: ");
		double amount = sc.nextDouble();
		if(amount>=0 && amount<user.getbalance()) 
		{
			user.setBalance(user.getbalance()-amount);
			System.out.println("Withdraw "+amount+" successfully..!");
		} 
		else 
		{
			System.out.println("Invalid or Insufficient balance to withdraw.");
		}

	}
	
	public void checkbalance(Account user)
	{
		System.out.println("Your Balance: "+user.getbalance());

	}
}

		
	
		
		 
	
