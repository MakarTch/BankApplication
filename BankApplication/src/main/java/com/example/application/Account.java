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

	public void deposit(String account, int deposit) {
		// and here is gonna be my method for updating the mysql data, gonna be same shit with withdraw
		try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root", "root");
	        Statement stmt = con.createStatement();
	        //ResultSet rs = stmt.executeUpdate("update accounts set account value = " /*gotta input past value*/ );
	        
	        stmt.close();
	        con.close();
	        User user = new User();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}
