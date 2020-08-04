package com.example.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.utility.UserDAOClass;
public class User {

	private int userId;
	private String lastName;
	private String firstName;
	private String address;
	private String contactNumber;
	private String password;
	private int initialDeposit;
	
	public User() {
		super();
	}

	public User(int userId, String lastName, String firstName, String address, String contactNumber,
			String password, int initialDeposit) {
		super();
		this.userId = userId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.contactNumber = contactNumber;
		this.password = password;
		this.initialDeposit = initialDeposit;
	}
	
	public int getUserId() {
		return userId;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getAddress() {
		return address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public String getPassword() {
		return password;
	}

	public int getInitialDeposit() {
		return initialDeposit;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setInitialDeposit(int initialDeposit) {
		this.initialDeposit = initialDeposit;
	}

	@Override
	public String toString() {
		return "<tr><td>" + userId + "</td><td>" + lastName + "</td><td>" + firstName + "</td><td>"
				+ address + "</td><td>" + contactNumber + "</td><td>" + password + "</td><td>$"
				+ initialDeposit + "</td></tr>";
	}
	
	public String displayUser(int userId) throws IOException {
		String finalString="";
		User user = UserDAOClass.getUserById(userId);
		finalString += "<table> <tr><th>User ID</th><th>Last Name</th><th>First Name</th><th>Address</th><th>Phone Number</th><th>Password</th><th>Initial Deposit</th></tr>";
		finalString += user.toString() + "</table>";
		return finalString;
	}
	
	public static boolean createUser(User user) {
		try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root", "root");
	        PreparedStatement stmt = con.prepareStatement("insert into users(last_name,first_name,address,contact_number,user_password,initial_deposit)"
					+ " values(?,?,?,?,?,?)");
	        stmt.setString(1, user.lastName);
	        stmt.setString(2, user.firstName);
	        stmt.setString(3, user.address);
	        stmt.setString(4, user.contactNumber);
	        stmt.setString(5, user.password);
	        stmt.setInt(6, user.initialDeposit);
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
	
	public User getUserById(int userId) throws IOException {
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
	
}
