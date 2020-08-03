<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Accounts</title>
<link rel="stylesheet" href="bankstyle.css">
</head>
<body>
<div class="navbar"></div>
<div class="content">
<h1>Account Information</h1>
<p> Two accounts (Savings and Checkings)  are automatically generated when you create an account.<br> Your initial deposit goes into your Savings Account.</p>
${obj.displayAccounts(user) }
</div>
</body>
</html>