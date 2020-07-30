package com.example.application;

import java.io.IOException;
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
				+ address + "</td><td>" + contactNumber + "</td><td>" + password + "</td><td>"
				+ initialDeposit + "</td></tr>";
	}
	
	public String displayUser(int userId) throws IOException {
		String finalString="";
		User user = UserDAOClass.getUserById(userId);
		finalString += "<table border=1 style=\"border-collapse:collapse\"> <tr><th>User ID</th><th>Last Name</th><th>First Name</th><th>Address</th><th>Phone Number</th><th>Password</th><th>Initial Deposit</th></tr>";
		finalString += user.toString() + "</table>";
		return finalString;
	}
	
}
