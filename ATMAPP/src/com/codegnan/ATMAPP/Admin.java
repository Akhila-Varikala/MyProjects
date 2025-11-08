package com.codegnan.ATMAPP;

import java.util.Scanner;

public class Admin 
{
	private static final String adminPin = "1234";

	public boolean login(String pin) 
	{
		return adminPin.equals(pin);
	}

	Scanner sc = new Scanner(System.in);

	public int addAccount(Account[] accounts, int count) 
	{
		if (count >= accounts.length) 
		{
			System.out.println(Colors.RED + "Cannot add more accounts. Limit reached" + Colors.RESET);
			return count;
		}
		System.out.print(Colors.BLUE + "Enter Username: " + Colors.RESET);
		String userName = sc.next();
		System.out.print(Colors.BLUE + "Enter Location: " + Colors.RESET);
		String location = sc.next();
		System.out.print(Colors.BLUE + "Enter Account Number: " + Colors.RESET);
		String accountNumber = sc.next();
		System.out.print(Colors.BLUE + "Enter PIN: " + Colors.RESET);
		String pin = sc.next();
		System.out.print(Colors.BLUE + "Enter Balance: " + Colors.RESET);
		double balance = sc.nextDouble();

		accounts[count] = new Account(userName, location, accountNumber, pin, balance);
		System.out.println(Colors.GREEN + "Account created Successfully..!" + Colors.RESET);
		return count + 1;
	}

	public void viewAllAccount(Account[] accounts, int count) 
	{
		if (count == 0) 
		{
			System.out.println("No Accounts");
		}
		else 
		{
			for (int i = 0; i < count; i++) 
			{
				Account acc = accounts[i];
				if (acc != null) 
				{
					System.out.println("Account Number: " + acc.getaccountnumber() + " User name: " + acc.getUsername()
							+ " Location: " + acc.getlocation() + " Balance: " + acc.getbalance());
				}
			}
		}
	}
	
	 public void deleteAccount(Account[] accounts, int count, String accountNumber) 
	 {
	    	boolean found = false;
	    	for(int i=0;i<count;i++) 
	    	{
	    		if(accounts[i].getaccountnumber().equals(accountNumber)) 
	    		{
	    			for(int j=i; j<count-1;j++) 
	    			{
	    				accounts[j]=accounts[j+1];
	    			} 
	    			accounts[count-1]=null;
	    			System.out.println(Colors.RED+"Account deleted successfully..!"+Colors.RESET);
	    			found=true;
	    			break;
	    		}
	    	}
	    	if(!found)
	    	{
	    		System.out.println("Account not found");
	    	}
	 }
}
	    	
	    	



