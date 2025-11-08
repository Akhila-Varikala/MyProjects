package com.codegnan.ATMAPP;

public class Account 
{
	private String username;;
	private String location;
	private String accountnumber;
	private String pin;
	private double balance;
	
	public Account(String username, String location, String accountnumber, String pin, double balance) 
	{
		this.username=username;
		this.location=location;
		this.accountnumber=accountnumber;
		this.pin=pin;
		this.balance=balance;
	}
	
		

	public String getUsername()
	{
		return username;
	}
	
	public String getlocation()
	{
		return location;
	}
	
	public String getaccountnumber()
	{
		return accountnumber;
	}
	
	public String getpin()
	{
		return pin;
	}
	
	public double getbalance()
	{
		return balance;
	}
	
	public void setusername(String username)
	{
		if(username!=null )
		{
			this.username=username;
			
		}
		else
		{
			System.out.println("Invalid username");
		}
		
		
	}

	

	public void setLocation(String location) 
	{
		if(location!=null )
		{
			this.location = location;
			
		}
		else
		{
			System.out.println("Invalid location");
		}
		
	}

	public void setAccountnumber(String accountnumber) 
	{
		if(accountnumber!=null )
		{
			this.accountnumber=accountnumber;
			
			
		}
		else
		{
			System.out.println("Invalid account number");
		}
		
	}
	

	public void setPin(String pin) 
	{
		if(pin!=null && pin.trim().isEmpty())
		{
			this.pin = pin;
			
		}
		else
		{
			System.out.println("Invalid pin");
		}
		
	}

	public void setBalance(double amount) 
	{
		if(balance>0)
		{
			this.balance=amount;
		}
		else
		{
			System.out.println("Invalid balance");
		}
		
		
	}
	
}
	
