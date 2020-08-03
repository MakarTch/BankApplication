package com.example.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Account {
	
	private int accountId;
	private int userId;
	private String accountType;
	private int accountValue;
	
	public Account() {
		super();
	}

	public Account(int accountId, int userId, String accountType, int accountValue) {
		super();
		this.accountId = accountId;
		this.userId = userId;
		this.accountType = accountType;
		this.accountValue = accountValue;
	}

	public int getAccountId() {
		return accountId;
	}

	public int getUserId() {
		return userId;
	}

	public String getAccountType() {
		return accountType;
	}

	public int getAccountValue() {
		return accountValue;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setAccountValue(int accountValue) {
		this.accountValue = accountValue;
	}

	@Override
	public String toString() {
		return "<tr><td>" + accountId + "</td><td>" + userId + "</td><td>" + accountType + "</td><td>" + accountValue + "</td></tr>";
	}
	
	public String displayAccounts(int userId) {
		String finalDisplay = "<table> <tr><th>Account Id</th><th>User ID</th><th>Account Type</th><th>Account Value</th><tr>";
		List<Account> accountList = AccountDAOClass.getAccountsById(userId);
		for (Account a : accountList) {
			finalDisplay+= a.toString();
		}
		finalDisplay+="</table>";
		return finalDisplay;
	}

	public static void insertIntoTransactions(Object userId, String operation, String accountTo, int amount) {
		String transactionDescription = "";
		switch (operation) {
			case ("deposit"):
				transactionDescription = "Deposit: $" + amount + " into " + accountTo + " account";
				break;
			case ("withdraw"):
				transactionDescription = "Withdrawal: $" + amount + " from " + accountTo + " account";
				break;
			case ("transfer"):
				String accountFrom = (accountTo.equals("Savings") ? "Checkings" : "Savings");
				transactionDescription = "Transfer: $" + amount + " from " + accountFrom + " into " + accountTo;
				break;
		}
		
		try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root", "root");
	        Statement stmt = con.createStatement();
			int rs = stmt.executeUpdate("insert into transactions(user_id, transaction_description) values (" + userId + ", '" + transactionDescription + "')");
	        stmt.close();
	        con.close();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean deposit(Object userId, String account, int deposit, boolean transfer) {
		boolean success = false;
		try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root", "root");
	        Statement stmt = con.createStatement();
//	        System.out.println(deposit + " is deposit");
//	        System.out.println((int)userId+ " is userid");
//	        System.out.println(account+ " is account");
//	        System.out.println(AccountDAOClass.getPastBalance((int)userId, account)+ "is the method");
	        int accountValue = deposit + AccountDAOClass.getPastBalance((int)userId, account);
	        int rs = stmt.executeUpdate("update accounts set account_value=" + accountValue + " where user_id = "  +userId+" and account_type='"+account+"'");
	        stmt.close();
	        con.close();
	        success = (rs==1) ? true : false;
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if(success && !transfer) {
			insertIntoTransactions(userId, "deposit", account, deposit);
		}
		return success;
	}
	
	public static boolean withdraw(Object userId, String account, int withdrawal, boolean transfer) {
		boolean success = false;
		try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root", "root");
	        Statement stmt = con.createStatement();
	        int accountValue = AccountDAOClass.getPastBalance((int)userId, account) - withdrawal ;
	        int rs = stmt.executeUpdate("update accounts set account_value=" + accountValue + " where user_id = "  +userId+" and account_type='"+account+"'");
	        stmt.close();
	        con.close();
	        success = (rs==1) ? true : false;
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if(success  && !transfer) {
			insertIntoTransactions(userId, "withdraw", account, withdrawal);
		}
		return success;
	}
	
	public static boolean transfer(Object userId, int amount, String accountTo) {
		boolean success = false;
		String accountFrom = accountTo.equals("Savings") ? "Checkings" : "Savings";
		boolean success1 = withdraw(userId,accountFrom, amount, true);
		boolean success2 = deposit(userId,accountTo, amount, true);
		success = (success1==true && success2 == true) ? true : false;
		if(success) {
			insertIntoTransactions(userId, "transfer", accountTo, amount);
		}
		return success;
	}
	
	public static boolean createAccount(User user) {
		try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root", "root");
	        PreparedStatement stmt1 = con.prepareStatement("insert into accounts(user_id, account_type, account_value) values (?,?,?)");
	        PreparedStatement stmt2 = con.prepareStatement("insert into accounts(user_id, account_type, account_value) values (?,?,?)");
	        stmt1.setInt(1, user.getUserId());
	        stmt1.setString(2, "Savings");
	        stmt1.setInt(3, user.getInitialDeposit());
			int rs1 = stmt1.executeUpdate();
			stmt2.setInt(1, user.getUserId());
	        stmt2.setString(2, "Checkings");
	        stmt2.setInt(3, 0);
			int rs2 = stmt2.executeUpdate();
	        stmt1.close();
	        con.close();
	        if (rs1==1 && rs2==1) {
	        	return true;
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
		
	}
}
