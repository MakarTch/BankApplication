package com.example.application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Transaction {
	
	private int transactionId;
	private int userId;
	private String transactionDescription;
	
	public Transaction() {
		super();
	}

	public Transaction(int transactionId, int userId, String transactionDescription) {
		super();
		this.transactionId = transactionId;
		this.userId = userId;
		this.transactionDescription = transactionDescription;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public int getUserId() {
		return userId;
	}

	public String getTransactionDescription() {
		return transactionDescription;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	@Override
	public String toString() {
		return "<tr><td>"+ transactionId + "</td><td>" + userId + "</td><td>"+ transactionDescription + "</td></tr>";
	}
	
	public String displayTransactions(int userId) throws IOException {
		String finalDisplay = "<table> <tr><th>Transaction ID</th><th>User ID</th><th>Transaction Description</th><tr>";
		List<Transaction> transactionsList = TransactionDAOClass.getTransactionsById(userId);
		for (Transaction t : transactionsList) {
			finalDisplay += t.toString();
		}
		finalDisplay += "</table>";
		return finalDisplay;
		
	}

	public static boolean initialDeposit(User user) {
		try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root", "root");
	        PreparedStatement stmt = con.prepareStatement("insert into transactions(user_id, transaction_description) values(?,?)");
	        stmt.setInt(1, user.getUserId());
	        stmt.setString(2, "Initial Deposit: $" + user.getInitialDeposit() + " deposited into Checkings Account");
			int rs = stmt.executeUpdate();
	        stmt.close();
	        con.close();
	        if (rs==1) {
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
