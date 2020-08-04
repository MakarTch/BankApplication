<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>5 Recent Transactions</title>
<link rel="stylesheet" href="bankstyle.css">
</head>
<body>
<div class="navbar"></div>
<div class="content">
<h1>5 most recent transactions</h1>
${obj.displayTransactions(user)}<br>
<a href="accountActions">Back to menu</a>
</div>
</body>
</html>