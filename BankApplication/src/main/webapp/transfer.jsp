<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transfer Info</title>
</head>
<body>
<form action="transferAction">
<label for="amount">How much would you like to transfer?</label>
<input type="number" name="amount" id="amount" autocomplete="off"><br>
<label for="accountTo">Where would you like to transfer?</label>
<select name="accountTo" id="account">
<option value="Checkings">From Savings to Checkings</option>
<option value="Savings">From Checkings to Savings</option>
</select>
<input type="submit">
</form>


</body>
</html>