<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deposit Information</title>
<link rel="stylesheet" href="bankstyle.css">
</head>
<body>
<div class="navbar"></div>
<div class="content">
<form action="depositAction">
<label for="account">What account would you like to deposit into?</label>
<select name="account" id="account">
<option value="Checkings">Checkings</option>
<option value="Savings">Savings</option>
</select><br>
<label for="amount">How much would you like to deposit?</label>
<input type="number" name="deposit" id="deposit" autocomplete ="off">
<input type="submit">
</form>
</div>
</body>
</html>