package com.example.application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAOClass {

	public static List<Transaction> getTransactionsById(int userId) throws IOException {
	    try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root", "root");
	        Statement stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM Transactions where user_id =" + userId + " order by transaction_id limit 5");
	        List<Transaction> transactionsList = new ArrayList<Transaction>();
	        while(rs.next()){
		        Transaction u = new Transaction (rs.getInt("transaction_id"), rs.getInt("user_id"),rs.getString("transaction_description"));
		        transactionsList.add(u);
	        }
	        stmt.close();
	        con.close();
	        return transactionsList;
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	
	
}