package com.example.application;

import java.sql.Connection;
import java.sql.DriverManager;
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
		String finalDisplay = "<table border=1 style=\"border-collapse:collapse\"> <tr><th>Account Id</th><th>User ID</th><th>Account Type</th><th>Account Value</th><tr>";
		List<Account> accountList = AccountDAOClass.getAccountsById(userId);
		for (Account a : accountList) {
			finalDisplay+= a.toString();
		}
		finalDisplay+="</table>";
		return finalDisplay;
	}

	public static boolean deposit(Object userId, String account, int deposit) {
		boolean success = false;
		try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root", "root");
	        Statement stmt = con.createStatement();
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
		return success;
	}
	
	public static boolean withdraw(Object userId, String account, int withdrawal) {
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
		return success;
	}
	
	public static boolean transfer(Object userId, int amount, String accountTo) {
		boolean success = false;
		String accountFrom = accountTo.equals("Savings") ? "Checkings" : "Savings";
		boolean success1 = withdraw(userId,accountFrom, amount);
		boolean success2 = deposit(userId,accountTo, amount);
		success = (success1==true && success2 == true) ? true : false;
		return success;
	}
	
	
}
