<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transfer Info</title>
<link rel="stylesheet" href="bankstyle.css">
</head>
<body>
<div class="navbar"></div>
<div class="content">
<form action="transferAction">
<label for="accountTo">Where would you like to transfer?</label>
<select name="accountTo" id="account">
<option value="Checkings">From Savings to Checkings</option>
<option value="Savings">From Checkings to Savings</option>
</select><br>
<label for="amount">How much would you like to transfer?</label>
<input type="number" name="amount" id="amount" autocomplete="off">

<input type="submit">
</form>
</div>

</body>
</html>