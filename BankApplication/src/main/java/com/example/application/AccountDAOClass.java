package com.example.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOClass {
	
	public static List<Account> getAccountsById(int userId){
		try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root", "root");
	        Statement stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM accounts where user_id = " + userId);
	        List<Account> accountList = new ArrayList<Account>();
	        while(rs.next()){
		        Account a = new Account (rs.getInt("account_id"), rs.getInt("user_id"),rs.getString("account_type"), rs.getInt("account_value"));
		        accountList.add(a);
	        }
	        stmt.close();
	        con.close();
	        return accountList;
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
