package com.codegnan.ATMAPP;
import java.util.Scanner;
public class Main 
{
	private static final Account[] accounts = new Account[100];
	static int count =0;
	private static Scanner scr;


	public static void main(String[] args) 
	{
		Scanner scr = new Scanner(System.in);
		AdminLogin adminLogin = new AdminLogin();
		AccountLogin accountLogin = new AccountLogin();
		accounts[count++]=new Account("Akki","Hyderabad","1876","1234",2000.00);
		
		boolean value = true;
		while(value) {
			System.out.println("ATM Application: ");
			System.out.println("1. ADMIN LOGIN:");
			System.out.println("2. ACCOUNT LOGIN:");
			System.out.println("3. EXIT...");
			System.out.println("Choose an option(1-3): ");
			
			int option = scr.nextInt();
			
			switch(option) {
			case 1:
				count = adminLogin.adminMenu(accounts, count);
				break;
			case 2:
				accountLogin.userlogin(accounts, count);
				break;
			case 3:
				System.out.println("THANK YOU...Visit Again..!");
				value = false;
				break;
			default:
				System.out.println("Invalid choice. Please choose 1-3 only");
			}
		}
		scr.close();
		
		
	
	}

}
