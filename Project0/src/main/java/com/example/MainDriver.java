package com.example;

import java.util.Scanner;

import DAO.BankAccountDAOImpl;
import DAO.BankAccountDetailsDAOImpl;
import DAO.DbConnection;
import DAO.UserDAOImpl;
import users.BankAccountDetailsModel;
import users.BankAccountModel;
import users.UserModel;

public class MainDriver {
	
	
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[]args) {
		
		
		 appStart();

	}
	
	
	public static void appStart()
	{
		
		System.out.println("Welcome to our Bank !!");
		System.out.println("Please select your user Type");
		
		System.out.println("1. Admin");
		System.out.println("2. Employee");
		System.out.println("3. Customer");
		System.out.println("4. Exit");
		
		int userType = scanner.nextInt();
		
		switch (userType)
		{
		case 1:
			AdminFrontEnd();
			break;
			
		case 2:
			EmployeeFrontEnd();
			break;
			
		case 3:
			customerFrontEnd();
			break;
			
			default:
				break;
		}
		
		
		
		
	}
	
	
	public static void customerFrontEnd()
	{
		
		System.out.println("---------- Customer Portal ----------");
		System.out.println("What would you like to do?");
		
		System.out.println("1. Register a new customer account");
		System.out.println("2. Login to an existing customer account");
		System.out.println("3. Go Back");
		System.out.println("4. Exit");
		
		int customerChoice = scanner.nextInt();
		
		switch(customerChoice)
		{
		
		case 1: 
			registerUser('c');
			break;
			
		case 2:
			System.out.println("---------- Login Customer ----------");
			scanner.nextLine();
			System.out.println("Please enter your username:");
			String username = scanner.nextLine();
			System.out.println("Please enter your password:");
			String password = scanner.nextLine();
			
			
			
			DbConnection dbConnection = new DbConnection();
			UserDAOImpl cDAO = new UserDAOImpl(dbConnection);
			UserModel user= cDAO.getByUserNameAndType(username, "c");
			
			System.out.println(user.getPassword());
			
			if(user.getPassword().equals(password))
			{
				System.out.println("Login Successful");
				customerBankAccountApplicationFrontEnd(user.getUser_id());
			}
			
			else
			{
				System.out.println("Login Unsuccesful");
			}
			break;
			
		case 3:
			appStart();
			break;
		}
		
		
	}
	
	
	
	
	public static void customerBankAccountApplicationFrontEnd(int customer_id)
	{
	
		BankAccountModel customerBankAccount;

		
		DbConnection dbConnection = new DbConnection();
		BankAccountDAOImpl bankDAO = new BankAccountDAOImpl(dbConnection);
		
		System.out.println("---------- Customer Bank Account Application ----------");
		System.out.println("What would you like to do?");
		
		System.out.println("1. Apply for an individual Bank account");
		System.out.println("2. Apply for a joint Bank account");
		System.out.println("3. Login to an existing Bank account");
		System.out.println("4. Go Back");
		System.out.println("5. Exit");
		
		int customerBankAccountChoice = scanner.nextInt();
		
		switch (customerBankAccountChoice)
		{
		case 1:
			
		
			System.out.println("--------------- Individual Account creation------------");
			scanner.nextLine();
			System.out.println("Your account is being created !!");
			
			scanner.nextLine();
			String accountType = "Individual";
			int user_id = customer_id;
			String state = "Pending";
			customerBankAccount = new BankAccountModel(0, accountType, user_id, state);
				
			bankDAO.insert(customerBankAccount);
			System.out.println("Your account has been created !!");
			
			break;
			
		case 2:
			break;
			
		case 3:
			//System.out.print(customer_id);
			BankAccountModel bankAccount = bankDAO.getById(customer_id);
			if (bankAccount.getState().equals("Approved"))
			{
				accountDetails(customer_id, bankDAO.getById(customer_id).getAccountNumber());
				
			}
			
			else
			{
				System.out.println("Your account is still in pending state\n");
				customerBankAccountApplicationFrontEnd(customer_id);
			}
			
			break;
			
		case 4:
			break;
		}
		
	}
	
	
	public static void accountDetails(int userId, int accountNumber)
	{
		double amount =0.0;
		BankAccountDetailsModel accountDetails =null;
		
		DbConnection dbConnection = new DbConnection();
		BankAccountDetailsDAOImpl bankAccountDetails = new BankAccountDetailsDAOImpl(dbConnection);
		
		System.out.println("---------- Account Details ----------");
		System.out.println("What would you like to do?");
		
		System.out.println("1. Deposit");
		System.out.println("2. Withdraw");
		System.out.println("3. Check Balance");
		System.out.println("4. Go Back");
		System.out.println("5. Exit");
		
		
		int accountDetailsChoice = scanner.nextInt();
		
		
		switch (accountDetailsChoice)
		{
		
		case 1:
			
			System.out.println("Please enter the amount to deposit");
			
			amount = scanner.nextDouble();
			
			accountDetails = new BankAccountDetailsModel(accountNumber, userId, amount, "Deposit");
			
			bankAccountDetails.deposit(accountDetails);
			
			System.out.println("Amount has been deposited to your account");
			
			break;
			
		case 2:
			
			System.out.println("Please enter the amount to Withdraw");
			
			amount = scanner.nextDouble();
			
			accountDetails = new BankAccountDetailsModel(accountNumber, userId, amount, "Withdraw");
			
			bankAccountDetails.withdraw(accountDetails);
			
			System.out.println("Amount has been withdrawn from your account");
			
			
			break;

		case 3:
			
			System.out.println("Your current balance is = $"+ bankAccountDetails.checkBalance(accountNumber));
			break;
			
		case 4:
			break;

			
		case 5:
			break;
			
	    default:
			break;
		
		}
		
	}
	
	
	public static void EmployeeFrontEnd()
	{
		System.out.println("---------- Employee Portal ----------");
		System.out.println("What would you like to do?");
		
		System.out.println("1. Register a new employee account");
		System.out.println("2. Login to an existing employee account");
		System.out.println("3. Go Back");
		System.out.println("4. Exit");
		
		int employeeChoice = scanner.nextInt();
		
		switch(employeeChoice)
		{
		
		case 1: 
			registerUser('e');
			break;
			
		case 2:
			System.out.println("---------- Login ----------");
			break;
			
		case 3:
			appStart();
			break;
		}
		
		
	}
	
	
	public static void AdminFrontEnd()
	{
		System.out.println("---------- Admin Portal ----------");
		System.out.println("What would you like to do?");
		
		System.out.println("1. Register a new admin account");
		System.out.println("2. Login to an existing user account");
		System.out.println("3. Go Back");
		System.out.println("4. Exit");
		
		int customerChoice = scanner.nextInt();
		
		switch(customerChoice)
		{
		
		case 1: 
			registerUser('a');
			break;
			
		case 2:
			System.out.println("---------- Login ----------");
			scanner.nextLine();
			System.out.println("Please enter your username:");
			String username = scanner.nextLine();
			System.out.println("Please enter your password:");
			String password = scanner.nextLine();
			
			DbConnection dbConnection = new DbConnection();
			UserDAOImpl cDAO = new UserDAOImpl(dbConnection);
			UserModel user= cDAO.getByUserNameAndType(username, "a");
			
			System.out.println(user.getPassword());
			
			if(user.getPassword().equals(password))
			{
				System.out.println("Login Successful");
				adminBankAccountFrontEnd();
			}
			
			else
			{
				System.out.println("Login Unsuccesful");
			}
			
			break;
			
		case 3:
			appStart();
			break;
		}
		
		
	}
	
	
	public static void adminBankAccountFrontEnd()
	{
		System.out.println("---------- Admin Bank Account ----------");
		System.out.println("What would you like to do?");
		
		System.out.println("1. View Customer's information");
		System.out.println("2. Approve Customer's account");
		System.out.println("3. Decline Customer's account");
		System.out.println("4. Edit Customer's account");
		System.out.println("5. Delete Customer's account");
		System.out.println("6. Exit");
		
		int adminBankAccountChoice  = scanner.nextInt();
		int accountNumber=0;
		DbConnection dbConnection = null;
		BankAccountDAOImpl bankDAO = null;
		BankAccountModel bankAccount = null;
		
		switch (adminBankAccountChoice)
		{
		case 1:
			
			System.out.println("Please enter customer account number");
			accountNumber = scanner.nextInt();
			
			dbConnection = new DbConnection();
			bankDAO = new BankAccountDAOImpl(dbConnection);
			
			bankAccount = bankDAO.getAccountByNumber(accountNumber);
			
			System.out.println(bankAccount.toString());
			break;
			
		case 2:
			
			System.out.println("Please enter customer account number");
			accountNumber = scanner.nextInt();
			
			dbConnection = new DbConnection();
			bankDAO = new BankAccountDAOImpl(dbConnection);
			
		    bankDAO.approveAccount(accountNumber);
		    System.out.println("Your account has been approved");
		

			break;
			
		case 3:
			break;
			
		case 4:
			break;
			
		case 5:
			break;
			
		case 6:
			break;
			
		}
		
	}
	
	public static void registerUser(char userType)
	{
		
		DbConnection dbConnection = new DbConnection();
		Scanner conScan = new Scanner(System.in);
		System.out.println("Enter id");
		int userID=conScan.nextInt();
		
		System.out.println("Enter your first name");
		String firstName=conScan.next();
		System.out.println("Enter your last name");
		String lastName=conScan.next();
		System.out.println("Enter your userName");
		String userName=conScan.next();
		System.out.println("Enter your password");
		String password=conScan.next();
		
		UserModel user = null;
		
		switch (userType)
		{
			
			case 'c':
				user = new UserModel(userID, firstName, lastName, userName, password, "c");
				break;
				
			case 'e':
				user = new UserModel(userID, firstName, lastName, userName, password, "e");
				break;
				
			case 'a':
				user = new UserModel(userID, firstName, lastName, userName, password, "a");
				break;
				
			default:
				break;
		}
		
		
		UserDAOImpl cDAO = new UserDAOImpl(dbConnection);
		cDAO.insert(user);

		conScan.close();
		
		
	}
	
	public static void loginUser()
	{
		
	}

}
