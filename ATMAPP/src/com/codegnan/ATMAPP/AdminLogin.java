package com.codegnan.ATMAPP;
import java.util.Scanner;
public class AdminLogin 
{
	private Admin admin;
	public AdminLogin() 
	{
		this.admin = new Admin();
	}
	Scanner scr = new Scanner(System.in);
	public int adminMenu(Account[] accounts, int count) 
	{
		System.out.print("Enter Admin PIN: ");
		String pin = scr.next();
		if(admin.login(pin)) 
		{
			System.out.println(Colors.BLUE+"Logged in Successfully...!"+Colors.RESET);
			boolean adminrun = true;
			while(adminrun) {
				System.out.println("1. Add Account");
				System.out.println("2. Delete Account");
				System.out.println("3. View All Accounts");
				System.out.println("4. Logout");
				System.out.println("Choose an option (1-4): ");
				int option = scr.nextInt();
				
				switch(option) {
				case 1:
					count=admin.addAccount(accounts, count);
					break;
				case 2:
					System.out.println("Enter Account Number to delete: ");
					String accountNumber = scr.next();
					admin.deleteAccount(accounts,  count, accountNumber);
					break;
				case 3:
					admin.viewAllAccount(accounts, count);
					break;
				case 4:
					System.out.println("Logged Out Successfully..!");
					adminrun  = false;
					break;
				default:
					System.out.println("Invalid Choice. Please choose 1-4 Only.");
				}
			}
		}
		else 
		{
			System.out.println(Colors.RED+"Invalid Admin Pin..!"+Colors.RESET);
		}
		return count;
	}


}
