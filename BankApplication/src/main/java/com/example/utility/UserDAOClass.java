package com.example.utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.model.User;

public class UserDAOClass {
	
	public static List<User> getAllUsers() throws IOException {
	    try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root", "root");
	        Statement stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM Users");
	        List<User> usersList = new ArrayList<User>();
	        while(rs.next()){
		        User u = new User (rs.getInt("user_id"), rs.getString("last_name"),rs.getString("first_name"), rs.getString("address"), rs.getString("contact_number"), rs.getString("user_password"), rs.getInt("initial_deposit"));
		        usersList.add(u);
	        }
	        stmt.close();
	        con.close();
	        return usersList;
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;	
	}
	public static User getUserById(int userId) throws IOException {
	    try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root", "root");
	        Statement stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM Users where user_id = " + userId);
	        while(rs.next()){
		        User u = new User (rs.getInt("user_id"), rs.getString("last_name"),rs.getString("first_name"), rs.getString("address"), rs.getString("contact_number"), rs.getString("user_password"), rs.getInt("initial_deposit"));
  			    return u;
	        }
	        stmt.close();
	        con.close();
	        User user = new User();
	        return user;
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;	
	}
	public static User getUserByContactNumber(String contactNumber) throws IOException {
	    try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root", "root");
	        Statement stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM Users where contact_number = '" + contactNumber + "'");
	        while(rs.next()){
		        User u = new User (rs.getInt("user_id"), rs.getString("last_name"),rs.getString("first_name"), rs.getString("address"), rs.getString("contact_number"), rs.getString("user_password"), rs.getInt("initial_deposit"));
		        return u;
	        }
	        stmt.close();
	        con.close();
	        User user = new User();
	        return user;
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;	
	}

	public static boolean verification(int userId, String password) throws IOException {
		String realPassword = getUserById(userId).getPassword();
		if (password.equals(realPassword)) {
			return true;
		}
		return false;
	}
	




}
