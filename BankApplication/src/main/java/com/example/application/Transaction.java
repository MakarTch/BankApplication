package com.example.application;

import java.io.IOException;
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
		String finalDisplay = "<table border=1 style=\"border-collapse:collapse\"> <tr><th>Transaction ID</th><th>User ID</th><th>Transaction Description</th><tr>";
		List<Transaction> transactionsList = TransactionDAOClass.getTransactionsById(userId);
		for (Transaction t : transactionsList) {
			finalDisplay += t.toString();
		}
		finalDisplay += "</table>";
		return finalDisplay;
		
	}
	
}
