<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="bankstyle.css">
</head>
<body>
<div class="navbar"></div>
<div class="content">
<form action="withdrawAction">
<label for="account">What account would you like to withdraw from?</label>
<select name="account" id="account">
<option value="Checkings">Checkings</option>
<option value="Savings">Savings</option>
</select><br>
<label for="amount">How much would you like to withdraw?</label>
<input type="number" name="withdraw" id="withdraw" autocomplete ="off"><!-- Im gonna have to make some type of restriction for this -->
<input type="submit">
</form>
</div>
</body>
</html>