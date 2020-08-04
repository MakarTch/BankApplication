<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Actions</title>
<link rel="stylesheet" href="bankstyle.css">
</head>
<body>
<div class="navbar"></div>
<div class="content">
<h1> Hello ${obj.getUserById(userId).getFirstName()}, What would you like to do?</h1>
<a href = "deposit">Make a deposit</a><br>
<a href = "withdraw">Make a withdrawal</a><br>
<a href = "transfer">Transfer funds between accounts</a><br>
<a href = "recentTransactions">Check out your 5 most recent transactions</a><br>
<a href = "displayUserInformation">Display your information</a><br>
<a href = "displayAccounts">Display account information</a><br>
<a href = "/loggingOff">Sign Out</a>

</div>

</body>
</html>